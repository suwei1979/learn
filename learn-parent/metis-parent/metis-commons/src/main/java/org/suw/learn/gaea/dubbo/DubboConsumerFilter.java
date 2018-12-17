/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.dubbo;

import com.alibaba.dubbo.rpc.*;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.dubbo.factory.RequestFactory;
import org.suw.learn.gaea.dubbo.factory.ResponseFactory;
import org.suw.learn.gaea.exception.GaeaExceptionConst;
import org.suw.learn.gaea.log.AppIMsgFormat;
import org.suw.learn.gaea.log.FunIMsgFormat;
import org.suw.learn.gaea.log.GaeaLogUtil;

/**
 * Service Consumer Filter A filter to log a. app uuid implicitly[info] b. rpc
 * invocation arguments[debug]
 */
public class DubboConsumerFilter implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(DubboConsumerFilter.class);

	/**
	 * Dubbo Consumer Filter Method.
	 * 
	 * @param invoker
	 *            invoker
	 * @param invocation
	 *            invocation
	 * @return result
	 */
	public final Result invoke(final Invoker<?> invoker,
			final Invocation invocation) {

		if (!(invocation.getArguments()[0] instanceof Request)) {
			logger.warn(
					"Interface [{}] is not compatible with the existing protocol!",
					invocation.getMethodName());
			return invoker.invoke(invocation);
		}

		final Request<?> request = (Request<?>) invocation.getArguments()[0];
		RequestFactory<?> factory = (RequestFactory) request;
		factory.setProductId(System.getProperty(GaeaLogUtil.GAEA_PRODUCT_NAME));
		factory.setModuleId(System.getProperty(GaeaLogUtil.GAEA_MODULE_NAME));
		factory.setNodeId(System.getProperty(GaeaLogUtil.GAEA_NODE_NAME));
		
		RpcContext context = RpcContext.getContext();

		GaeaLogUtil.registerInteractionUUID(request.getInteractionUUId());
		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("Service Name: {}"), invoker.getInterface());
		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("Local Address: {}"), context
				.getLocalAddressString());
		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("Remote Address: {}"), context
				.getRemoteAddressString());
		
		appLogRequestSending(request);

		/**
		 * Process of invocation
		 */
		Result result = new RpcResult();
		try {
			result = invoker.invoke(invocation);
			return result;
		} catch (RpcException e) {
			logger.error(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat(), e
					.getClass().getName(), e.getMessage());
			Response<?> response = ResponseFactory.getFailResponse(e.getClass()
					.getName(), e.getMessage(), request);
			result = new RpcResult(response);
			return result;
		} finally {
			appLogResponseReceiving((Response<?>) result.getValue());
		}
	}

	private void appLogRequestSending(Request<?> request) {
		logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(),
				new Object[]{request.getInteractionUUId(), AppIMsgFormat.ITR_UUID_NEW,
				AppIMsgFormat.ITR_WRITE_ACTION, request.getProductId(),
				request.getModuleId(), request.getNodeId(),
				AppIMsgFormat.ITR_ACTION_SUCC, GaeaExceptionConst.NORMAL_RETCODE});
	}
	
	private void appLogResponseReceiving(Response<?> response) {
		if (Objects.equals(response.getResponseCode(), GaeaExceptionConst.NORMAL_RETCODE)) {
			logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(),
					new Object[]{response.getInteractionUUId(), AppIMsgFormat.ITR_UUID_OLD,
					AppIMsgFormat.ITR_READ_ACTION, response.getProductId(),
					response.getModuleId(), response.getNodeId(),
					AppIMsgFormat.ITR_ACTION_SUCC, GaeaExceptionConst.NORMAL_RETCODE});
		} else {
			logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(),
					new Object[]{response.getInteractionUUId(), AppIMsgFormat.ITR_UUID_OLD,
					AppIMsgFormat.ITR_READ_ACTION, response.getProductId(),
					response.getModuleId(), response.getNodeId(),
					AppIMsgFormat.ITR_ACTION_FAIL, response.getResponseCode()});
		}
	}
}