/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.exception;

public class GaeaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常码与异常信息的分割符
	 */
	private static final String  DEFAULT_SPLITTER=":";

	/**
	 * 异常代码
	 */
	private String code;
	
	/**
	 * 异常信息
	 */
	private String msg;
	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	
	/**
     * @param message 异常信息
     * @param code	  异常码
     */
    public GaeaException(String code,String message) {
        super(code+DEFAULT_SPLITTER+message);
        this.code= code;
        this.msg =message;
    }
	
    /**
     * @param message 异常信息
     * @param code    异常码
     * @param cause
     */
    public GaeaException(String code,String message,Throwable cause) {
        super(code+DEFAULT_SPLITTER+message, cause);
        this.code= code;
        this.msg =message;
    }
}
