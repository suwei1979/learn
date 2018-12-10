/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.precredit;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import com.bocsoft.bocebiz.eloan.domain.model.application.Person;

@Data
public class PreCredit {

	@Setter(AccessLevel.NONE)
	private String customerNo;
	private Person customer;

	private Date preCreditTime;
	private PreLimit preLimit;

	public PreCredit(String customerNo) {
		this.customerNo = customerNo;
	}

}
