package org.suw.learn.gaea.dubbo.factory;

import java.io.Serializable;

import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.exception.GaeaExceptionConst;
import org.suw.learn.gaea.log.GaeaLogUtil;

/**
 * 提供了所有DUBBO调用时需要返回的对象接口的工厂类
 * 
 * @author 陈伟
 * @date 2014/3/6
 * 
 *       使用方法，使用该类的静态工厂方法来获取一个Response对象。
 * 
 *       例：
 * 
 *       HashMap<String,Object> map = new HashMap<String,Object>();
 *       map.put("first","success"); map.put("second","failure");
 *       map.put("third","quit"); Request<String> request =
 *       RequestFactory.createRequest("request data"); Response<String> response
 *       = ResponseFactory.createResponse(map,request);
 * 
 */
public class ResponseFactory<T> implements Response<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4463043763250317580L;

	/**
	 * 返回数据对象
	 */
	protected T data;
	/**
	 * 产品ID
	 */
	protected String productId;
	/**
	 * 模块ID
	 */
	protected String moduleId;
	/**
	 * 节点ID
	 */
	protected String nodeId;
	/**
	 * 交互序列号
	 */
	protected String interactionUUId;

	/**
	 * 返回码
	 */
	protected String responseCode;

	/**
	 * 返回信息
	 */
	protected String responseMessage;

	/**
	 * 私有化缺省构造方法
	 */
	private ResponseFactory() {
	}

	/**
	 * 获取一个Response对象，并将系统参数一并传递给该参数
	 * 
	 * @param data
	 *            需要返回的业务实体数据
	 * @param request
	 *            业务请求对象
	 * @return 构造好的Response对象
	 */
	public static <T, E> Response<T> getResponse(T data, Request<E> request) {
		return getResponse(data, request.getInteractionUUId(),
				GaeaExceptionConst.NORMAL_RETCODE, null);
	}

	/**
	 * 获取一个失败返回，并将系统参数一并传递给该参数
	 * 
	 * @param failCode
	 *            失败返回码
	 * @param failMsg
	 *            失败返回信息
	 * @param request
	 *            业务请求对象
	 * @return 构造好的Response对象
	 */
	public static <T, E> Response<T> getFailResponse(String failCode,
			String failMsg, Request<E> request) {
		return getResponse(null, request.getInteractionUUId(), failCode,
				failMsg);
	}

	/**
	 * 获取一个失败返回，并将系统参数及返回数据一并传递给该参数
	 * 
	 * @param failCode
	 *            失败返回码
	 * @param failMsg
	 *            失败返回信息
	 * @param data
	 *            需要返回的业务实体数据
	 * @param request
	 *            业务请求对象
	 * @return 构造好的Response对象
	 */
	public static <T, E> Response<T> getFailResponse(String failCode,
			String failMsg, T data, Request<E> request) {
		return getResponse(data, request.getInteractionUUId(), failCode,
				failMsg);
	}

	private static <T, E> Response<T> getResponse(T data, String uuid,
			String retCode, String failMsg) {
		ResponseFactory<T> response = new ResponseFactory<T>();
		response.interactionUUId = uuid;
		
		response.setResponseData(data);
		response.responseCode = retCode;
		response.responseMessage = failMsg;

		return response;
	}

	@Override
	public T getResponseData() {
		return data;
	}

	@Override
	public void setResponseData(T data) {
		this.data = data;
	}

	@Override
	public String getInteractionUUId() {
		return this.interactionUUId;
	}

	@Override
	public String getModuleId() {
		return this.moduleId;
	}

	@Override
	public String getNodeId() {
		return this.nodeId;
	}

	@Override
	public String getProductId() {
		return this.productId;
	}

	@Override
	public String getResponseCode() {
		return this.responseCode;
	}

	@Override
	public String getResponseMessage() {
		return this.responseMessage;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public void setInteractionUUId(String interactionUUId) {
		this.interactionUUId = interactionUUId;
	}
}
