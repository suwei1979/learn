/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.repository;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;

public interface LoanApplicationRepository {

	LoanApplication store(LoanApplication loanApplication);
	boolean exist(String platformSeqNo);
	void updateStatus(String platformSeqNo);
	LoanApplication rebuild(String platformSeqNo, String productCode);
	LoanApplication update(LoanApplication loanApplication);

}
