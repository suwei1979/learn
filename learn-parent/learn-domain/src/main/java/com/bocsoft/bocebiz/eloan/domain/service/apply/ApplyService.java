/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.apply;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;
import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.ExtensionProcess;

public interface ApplyService {

    public LoanApplication initApplication(String platformSeqNo, String productCode);

    /**
     * 贷款额度申请
     * Step2. 登记新增的贷款申请
     * 登记融资申请 登记额度申请的时候，会同时创建额度信息，并触发融资申请簿记事件，触发融资申请簿记事件的接口参见{@link ExtensionProcess} <br/>
     * 需要订阅融资申请 <br>
     *
     * @param newApplication
     *
     * @return
     *
     * @throws BusinessException
     */
    public LoanApplication bookNewApplication(LoanApplication newApplication);

    /**
     * 额度试算
     *
     * @param customerDecision
     */
    public void preCaculateLimit(CustomerDecisionInfo customerDecision);

    /**
     * 贷款申请通过（由CCAS通知或根据产品策略，一旦向CCAS发送申请后则认为已通过）
     * 说明：申请一旦通过，额度将变为已激活状态。
     *
     * @param approvedApplication TODO
     */
    public void finishApplication(LoanApplication approvedApplication);
}
