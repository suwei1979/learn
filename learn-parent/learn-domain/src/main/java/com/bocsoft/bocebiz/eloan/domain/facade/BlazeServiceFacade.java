package com.bocsoft.bocebiz.eloan.domain.facade;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;

public interface BlazeServiceFacade {

	/**
	 * 
	 * @param applicationSaved
	 * @return
	 */
	LoanApplication preCalculateLimit(LoanApplication applicationSaved);

}
