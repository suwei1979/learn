/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.repository;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanLimit;

public interface LoanLimitRepository {

	LoanLimit nextLimitId();

}
