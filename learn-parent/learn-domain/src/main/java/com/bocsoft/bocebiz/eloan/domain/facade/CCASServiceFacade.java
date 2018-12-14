/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.facade;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;
import com.bocsoft.bocebiz.eloan.domain.model.contract.Contract;
import com.bocsoft.bocebiz.eloan.domain.model.contract.SignContractTran;

public interface CCASServiceFacade {
    /**
     * 根据贷款申请信息，异步查询--另起线程发起查询,失败能记录，并能重新发起，（数据库建表和spring任务？）
     * facade不抛异常，所有内部异常自己处理，因为没人接
     *
     * @param aApplication
     */
    public void queryCustomerDecisionInfo(LoanApplication aApplication);

    public void approveLoanLimit(LoanApplication preCalculatedApplication);

    public Contract queryContractInfo(String transactionNo);

    public SignContractTran signContract(SignContractTran contractToSign);
}
