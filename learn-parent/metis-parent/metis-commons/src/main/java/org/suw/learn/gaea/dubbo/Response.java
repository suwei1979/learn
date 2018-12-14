package org.suw.learn.gaea.dubbo;


/**
 * 所有DUBBO调用时需要返回的对象接口
 * 
 * @author 陈伟
 * @date   2014/3/6
 */
public interface Response<T>{
	
	/**
	 * 设置返回数据
	 * @param data	返回数据对象
	 */
	public void setResponseData(T data);
	/**
	 * 获取返回数据
	 * @return	返回数据对象
	 */
	public T getResponseData();
	/**
	 * 获取产品ID
	 * @return　产品ID
	 */
	public String getProductId();
	/**
	 * 获取模块ID
	 * @return 模块ID
	 */
	public String getModuleId();
	/**
	 * 获取节点ID
	 * @return 节点ID
	 */
	public String getNodeId();
	/**
	 * 获取交互序列号
	 * @return 交互序列号
	 */
	public String getInteractionUUId();
	/**
	 * 获取返回码
	 * @return 返回码
	 */
	public String getResponseCode();
	
	/**
	 * 获取返回信息
	 * @return 返回信息
	 */
	public String getResponseMessage();
	
}
