/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.dubbo;

import com.alibaba.dubbo.rpc.*;

import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.dubbo.factory.ResponseFactory;
import org.suw.learn.gaea.exception.GaeaExceptionConst;
import org.suw.learn.gaea.exception.GaeaRuntimeException;
import org.suw.learn.gaea.log.AppIMsgFormat;
import org.suw.learn.gaea.log.FunIMsgFormat;
import org.suw.learn.gaea.log.GaeaLogUtil;

/**
 * Service Provider Filter A filter to log a. app uuid implicitly[info] b. rpc
 * invocation arguments[debug]
 */
public class DubboProviderFilter implements Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(DubboProviderFilter.class);

	/**
	 * Dubbo Provider Filter method.
	 * 
	 * @param invoker
	 *            invoker
	 * @param invocation
	 *            invocation
	 * @return If there are no exceptions during the invocation, return the
	 *         result method invoke() produced; otherwise, return a fail
	 *         response containing error code and error message.
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

		RpcContext context = RpcContext.getContext();
		GaeaLogUtil.registerProcessID(UUID.randomUUID().toString()
				.replace("-", ""));
		GaeaLogUtil.registerInteractionUUID(request.getInteractionUUId());

		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("Service Name: {}"), invocation.getMethodName());
		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("Local Address: {}"), context
				.getLocalAddressString());
		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("Remote Address: {}"), context
				.getRemoteAddressString());
		appLogRequestReceiving(request);

		Result result = new RpcResult();
		try {
			result = invoker.invoke(invocation);
		
			Object retObj = result.getValue();
			if(retObj != null && retObj instanceof ResponseFactory) {
				ResponseFactory<?> responseFactory = (ResponseFactory<?>) retObj;
				responseFactory.setProductId(System.getProperty(GaeaLogUtil.GAEA_PRODUCT_NAME));
				responseFactory.setModuleId(System.getProperty(GaeaLogUtil.GAEA_MODULE_NAME));
				responseFactory.setNodeId(System.getProperty(GaeaLogUtil.GAEA_NODE_NAME));
				responseFactory.setInteractionUUId(request.getInteractionUUId());
			}
			
			/**
			 * If exception is the subclass of the base exception, that is the
			 * customized exceptions, then fail response will get the error code and
			 * message; otherwise, get the exception class name for error code.
			 */
			if (result.hasException()) {
				Throwable exception = result.getException();
				logger.error(
						FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat(),
						new Object[] { exception.getClass().getName(),
								exception.getMessage(), exception });
				String errCode;
				if (exception instanceof GaeaRuntimeException) {
					GaeaRuntimeException gaeaRuntimeException = (GaeaRuntimeException) exception;
					errCode = gaeaRuntimeException.getCode();
				} else {
					errCode = exception.getClass().getName();
				}
				Response<?> response = ResponseFactory.getFailResponse(errCode,
						exception.getMessage(), request);
				result = new RpcResult(response);
			}
			
			return result;
		} catch (RpcException e) {
			logger.error(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat(), e
					.getClass().getName(), e.getMessage());
			Response<?> response = ResponseFactory.getFailResponse(e.getClass()
					.getName(), e.getMessage(), request);
			result = new RpcResult(response); 
			return result;
		} finally {
			appLogResponseSending((Response<?>) result.getValue());
		}		
	}

	private void appLogRequestReceiving(Request<?> request) {
		logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(),
				new Object[] { request.getInteractionUUId(),
						AppIMsgFormat.ITR_UUID_OLD,
						AppIMsgFormat.ITR_READ_ACTION, request.getProductId(),
						request.getModuleId(), request.getNodeId(),
						AppIMsgFormat.ITR_ACTION_SUCC,
						GaeaExceptionConst.NORMAL_RETCODE });
	}

	private void appLogResponseSending(Response<?> response) {
		if (Objects.equals(response.getResponseCode(),
				GaeaExceptionConst.NORMAL_RETCODE)) {
			logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(), new Object[] {
					response.getInteractionUUId(), AppIMsgFormat.ITR_UUID_OLD,
					AppIMsgFormat.ITR_WRITE_ACTION, response.getProductId(),
					response.getModuleId(), response.getNodeId(),
					AppIMsgFormat.ITR_ACTION_SUCC,
					GaeaExceptionConst.NORMAL_RETCODE });
		} else {
			logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(), new Object[] {
					response.getInteractionUUId(), AppIMsgFormat.ITR_UUID_OLD,
					AppIMsgFormat.ITR_WRITE_ACTION, response.getProductId(),
					response.getModuleId(), response.getNodeId(),
					AppIMsgFormat.ITR_ACTION_FAIL, response.getResponseCode() });
		}
	}
}