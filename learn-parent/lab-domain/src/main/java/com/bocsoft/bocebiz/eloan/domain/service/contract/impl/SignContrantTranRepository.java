/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.contract.impl;

import com.bocsoft.bocebiz.eloan.domain.model.contract.SignContractTran;

public interface SignContrantTranRepository {

    SignContractTran store(SignContractTran contractToSign);

}
