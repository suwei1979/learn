package org.suw.learn.gaea.dubbo;


/**
 * 所有DUBBO调用时需要提供的入口参数对象接口
 * 
 * @author 陈伟
 * @date   2014/3/6
 */
public interface Request<T>{
		
	/**
	 * 设置请求数据
	 * @param data 请求数据对象
	 */
	public void setRequestData(T data);
	/**
	 * 获取请求数据
	 * @return 请求数据对象
	 */
	public T getRequestData();
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
}
