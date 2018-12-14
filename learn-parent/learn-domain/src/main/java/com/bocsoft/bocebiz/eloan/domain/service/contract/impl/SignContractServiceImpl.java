/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.contract.impl;

import com.bocsoft.bocebiz.eloan.domain.facade.CCASServiceFacade;
import com.bocsoft.bocebiz.eloan.domain.model.contract.Contract;
import com.bocsoft.bocebiz.eloan.domain.model.contract.ContractTemplate;
import com.bocsoft.bocebiz.eloan.domain.model.contract.SignContractTran;
import com.bocsoft.bocebiz.eloan.domain.service.contract.SignContractService;
import com.bocsoft.bocebiz.eloan.domain.service.spi.annotation.MainProcessConfiguration;

@MainProcessConfiguration(routeTable = "signContractRouteTable", proxyedInterfaces = {SignContractService.class})
public class SignContractServiceImpl implements SignContractService {
    CCASServiceFacade ccasServiceFacade;
    CMSServiceFacade cmsServiceFacade;
    SignContrantTranRepository signContrantTranRepository;

    @Override
    public SignContractTran initContract(String transactionNo) {
        Contract contract = ccasServiceFacade.queryContractInfo(transactionNo);
        ContractTemplate template = cmsServiceFacade.queryContract(contract.getTemplate().getTemplateId());
        contract.setTemplate(template);
        SignContractTran transaction = new SignContractTran(contract);
        return transaction;
    }

    @Override
    public SignContractTran signContract(SignContractTran contractToSign) {
        contractToSign.signContract();//记状态
        SignContractTran tranSigned = ccasServiceFacade.signContract(contractToSign);
        tranSigned.signContract();//变状态
        return signContrantTranRepository.store(tranSigned);
    }

}

//OCLoan里真正签合同的交易Srv，调起init()，将返回的SignContractTran 添加上还款卡号（APP会传来）
//组成完整的SignContractTran，调起sign()
