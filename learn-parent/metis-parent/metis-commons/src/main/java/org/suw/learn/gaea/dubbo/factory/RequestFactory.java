package org.suw.learn.gaea.dubbo.factory;

import java.io.Serializable;
import java.util.UUID;

import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.log.GaeaLogUtil;

/**
 * 提供了所有DUBBO调用时需要提供的入口参数对象的工厂类
 * 
 * @author 陈伟
 * @date 2014/3/6
 * @param <T>
 * 
 *            使用方法
 * 
 *            调用该工厂类的静态方法 getRequest 来获取一个Request对象。
 * 
 *            例1： Request<String> request =
 *            RequestFactory.createRequest("request data");
 * 
 *            例2： HashMap<String,Object> map = new HashMap<String,Object>();
 *            map.put("first","success"); map.put("second","failure");
 *            map.put("third","quit"); Request<HashMap<String,Object>> request =
 *            RequestFactory.createRequest(map);
 * 
 */
public class RequestFactory<T> implements Request<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3385144010822957963L;

	/**
	 * 请求数据对象
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
	 * 私有构造方法
	 */
	private RequestFactory() {
	}

	/**
	 * 获取一个Request对象。
	 * 
	 * @param data
	 *            请求的业务数据对象
	 * @return Request对象
	 */
	public static <T> Request<T> createRequest(T data) {
		RequestFactory<T> request = new RequestFactory<T>();
		request.setRequestData(data);
		request.interactionUUId = GaeaLogUtil.getIntetractionUUID();

		if (request.interactionUUId == null) {
			String newUUID = UUID.randomUUID().toString()
					.replaceAll("-", "");
			GaeaLogUtil.registerInteractionUUID(newUUID);
			request.interactionUUId = newUUID;
		}

		return request;
	}

	@Override
	public T getRequestData() {
		return data;
	}

	@Override
	public void setRequestData(T data) {
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
	
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
