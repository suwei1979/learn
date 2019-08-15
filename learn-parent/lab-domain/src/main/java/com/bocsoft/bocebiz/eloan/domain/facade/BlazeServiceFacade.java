/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.facade;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication;

public interface BlazeServiceFacade {

    /**
     * @param applicationSaved
     *
     * @return
     */
    LoanApplication preCalculateLimit(LoanApplication applicationSaved);

}
