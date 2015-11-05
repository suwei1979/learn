package com.bocsoft.bocebiz.eloan.domain.repository;

import java.util.Date;

import com.bocsoft.bocebiz.eloan.domain.model.application.Person;
import com.bocsoft.bocebiz.eloan.domain.model.precredit.PreLimit;

/**
 * Created by li10 on 15-6-12.
 */
public interface PreCreditRepository {

    PreLimit findPreLimit(Person person);

    Date findPreCreditTime(Person person);
}
