/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi.impl;

/**
 * @author sw0876
 */
public interface ExtensionProcessFactory {
    /**
     * 获取扩展流程
     *
     * @param processName
     *
     * @return
     */
    public ExtensionProcess load(String processName);

}


