/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.apply.impl;

import com.bocsoft.bocebiz.eloan.domain.facade.BlazeServiceFacade;
import com.bocsoft.bocebiz.eloan.domain.facade.CCASServiceFacade;
import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;
import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplicationFactory;
import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;
import com.bocsoft.bocebiz.eloan.domain.repository.LoanApplicationRepository;
import com.bocsoft.bocebiz.eloan.domain.service.apply.ApplyService;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.MainProcessConfiguration;

/**
 * @author sw0876
 *
 */
@MainProcessConfiguration(routeTable="applicationRouteTable", proxyedInterfaces = {ApplyService.class})
public class ApplyServiceImpl implements ApplyService {
	private LoanApplicationRepository loanApplicationRepository;
	private CCASServiceFacade ccasServiceFacade;
	private BlazeServiceFacade blazeServiceFacade;
	private LoanApplicationFactory loanApplicationFactory;

	@Override
	public LoanApplication initApplication(String platformSeqNo, String productCode) {
		LoanApplication newApplication = loanApplicationFactory.createNewApplication(platformSeqNo, productCode);
		return newApplication;
	}

	/**
	 * 贷款额度申请 Step2. 登记新增的贷款申请
	 * 
	 */
	@Override
	public LoanApplication bookNewApplication(LoanApplication newApplication) {

		// 1.登记客户决策信息
		newApplication.book();
		LoanApplication applicationSaved = loanApplicationRepository.store(newApplication);
		ccasServiceFacade.queryCustomerDecisionInfo(newApplication);
		return applicationSaved;
	}

	@Override
	public void preCaculateLimit(CustomerDecisionInfo customerDecision) {

		LoanApplication restoredApplication = loanApplicationRepository.rebuild(customerDecision.getPlatformSeqNo(),customerDecision.getProductCode());

		restoredApplication.attach(customerDecision);
		// 分配叙做机构
		restoredApplication.assignOperationBranch();
		// 定价
		restoredApplication.pricing();
		LoanApplication preCalculatedApplication = blazeServiceFacade.preCalculateLimit(restoredApplication);

		preCalculatedApplication.approve();
		loanApplicationRepository.update(preCalculatedApplication);
		ccasServiceFacade.approveLoanLimit(preCalculatedApplication);
	}

	/**
	 * 结束申请流程，贷款申请状态：{@code LoanApplication.State.APPROVED}
	 */
	@Override
	public void finishApplication(final LoanApplication approvedApplication) {
		approvedApplication.finish();
		loanApplicationRepository.update(approvedApplication);
	}
}
