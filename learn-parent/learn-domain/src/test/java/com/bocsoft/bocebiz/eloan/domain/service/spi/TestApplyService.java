package com.bocsoft.bocebiz.eloan.domain.service.spi;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;
import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;
import com.bocsoft.bocebiz.eloan.domain.service.apply.ApplyService;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.GeneralProcessConfiguration;

@Slf4j
@Service("testApplyService")
@GeneralProcessConfiguration(routeTable="testRouteTable", proxyedInterfaces = {ApplyService.class})
public class TestApplyService implements ApplyService {

	@Override
	public LoanApplication initApplication(String platformSeqNo, String productCode) {
		log.info("main process");
		return null;
	}

	@Override
	public LoanApplication bookNewApplication(LoanApplication newApplication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preCaculateLimit(CustomerDecisionInfo customerDecision) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishApplication(LoanApplication approvedApplication) {
		// TODO Auto-generated method stub

	}

}
