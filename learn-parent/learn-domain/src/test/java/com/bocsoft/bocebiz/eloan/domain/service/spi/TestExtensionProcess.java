package com.bocsoft.bocebiz.eloan.domain.service.spi;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ExtensionProcessConfiguration;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.ProcessExecutionPolicy;

@Slf4j
@Component("testExtensionProcess")
@ExtensionProcessConfiguration(executionPolicy=ProcessExecutionPolicy.ASYCHRONIZED)
public class TestExtensionProcess {
	public LoanApplication initApplication(String platformSeqNo, String productCode) {
		log.info("extension process");
		return null;
	}

}
