/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.service.spi;

public class MainProcessExecutionException extends RuntimeException {

	public MainProcessExecutionException(String msg, Throwable cause) {
		super(msg);
	}

	public MainProcessExecutionException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -624043542756431764L;

}
