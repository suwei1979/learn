/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.dubbo;

import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.dubbo.factory.ResponseFactory;
import org.suw.learn.gaea.exception.GaeaException;
import org.suw.learn.gaea.exception.GaeaExceptionConst;
import org.suw.learn.gaea.exception.GaeaRuntimeException;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;

/**
 * 公共自有异常Filter
 * 
 * @author Administrator
 * 
 */
@Deprecated
public class DubboServiceInvokeExceptionFilter implements Filter {

	@SuppressWarnings("unchecked")
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		Result result = null;
		Request<?> request = null;
		try {
			request = (Request<?>) invocation.getArguments()[0];
			result = invoker.invoke(invocation);
			if (result.hasException()) {
				Throwable exception = result.getException();

				if (exception instanceof GaeaException) {
					GaeaException e = (GaeaException) exception;
					Response<?> response = ResponseFactory.getFailResponse(
							e.getCode(), e.getMsg(), request);
					return new RpcResult(response);
				} else if (exception instanceof GaeaRuntimeException) {
					GaeaRuntimeException e = (GaeaRuntimeException) exception;
					Response<?> response = ResponseFactory.getFailResponse(
							e.getCode(), e.getMsg(), request);
					return new RpcResult(response);
				} else {
					Response<?> response = ResponseFactory.getFailResponse(
							GaeaExceptionConst.NOAPPEXCEPTION_RETCODE,
							exception.getMessage(), request);
					return new RpcResult(response);
				}
			}
		} catch (Exception e) {
			Response<?> response = ResponseFactory.getFailResponse(
					GaeaExceptionConst.NOAPPEXCEPTION_RETCODE, e.getMessage(),
					request);
			return new RpcResult(response);
		}
		return result;
	}
}
