/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi;

import org.springframework.stereotype.Component;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ExtensionProcessConfiguration;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ProcessExecutionPolicy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("testExtensionProcess")
@ExtensionProcessConfiguration(executionPolicy = ProcessExecutionPolicy.ASYCHRONIZED)
public class TestExtensionProcess {
    public LoanApplication initApplication(String platformSeqNo, String productCode) {
        log.info("extension process");
        return null;
    }

}
