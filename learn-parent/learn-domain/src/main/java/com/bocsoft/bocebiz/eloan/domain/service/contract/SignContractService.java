/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.contract;

import com.bocsoft.bocebiz.eloan.domain.model.contract.SignContractTran;

/**
 * 合同模块相关处理流程
 *
 * @author sw0876
 */
public interface SignContractService {
    SignContractTran initContract(String contractNo);

    SignContractTran signContract(SignContractTran contractToSign);
}
