/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import javax.validation.constraints.NotNull;

import org.suw.learn.validate.beanvalidate.constraints.Email;
import org.suw.learn.validate.beanvalidate.constraints.ZipCode;


@SuppressWarnings("unused")
public class Customer {
	private String name;
	private String customerId;
	public Customer(String customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}
	
	@Email(message = "email must has a regular format")
	@NotNull(message = "email can't be null")
	private String email;
	
	@ZipCode(countryCode = "CN")
	private String zipCode;
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
