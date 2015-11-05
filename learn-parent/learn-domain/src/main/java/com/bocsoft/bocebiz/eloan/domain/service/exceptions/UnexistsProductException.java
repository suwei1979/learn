package com.bocsoft.bocebiz.eloan.domain.service.exceptions;

public class UnexistsProductException extends RuntimeException {

	private static final long serialVersionUID = -5663597042535622164L;


	public UnexistsProductException(String messageKey) {
		super(messageKey);
	}
}
