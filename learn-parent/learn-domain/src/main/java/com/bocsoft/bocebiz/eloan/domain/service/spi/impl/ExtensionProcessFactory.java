package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;



/**
 * 
 * @author sw0876
 *
 */
public interface ExtensionProcessFactory {
	/**
	 * 获取扩展流程
	 * @param processName
	 * @return
	 */
	public ExtensionProcess load(String processName);

}


