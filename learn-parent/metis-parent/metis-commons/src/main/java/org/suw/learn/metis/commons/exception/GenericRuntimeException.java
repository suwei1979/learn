package org.suw.learn.metis.commons.exception;

import org.suw.learn.gaea.exception.GaeaRuntimeException;
import org.suw.learn.metis.commons.utils.MessageUtils;

/**
 * Base Runtime Exception for project To extends GaeaRuntimeException
 */
public class GenericRuntimeException extends GaeaRuntimeException {

	private static final long serialVersionUID = 9137543079642316295L;

	/**
	 * Default Constructor
	 *
	 * @param code
	 *            Error Code, which corresponds with messages properties key
	 *            value eg. The messages properties contains the key-value pair
	 *            {system.illegalArg=illeage arguments!} when create an
	 *            exception with code equal to "system.illegalArg", exception
	 *            will return "illeage arguments!" when exception.getMessage()
	 *            invoked.
	 * @param args
	 *            Arguments to replace the placeholders in the message.
	 * @param cause
	 *            exception cause
	 */
	public GenericRuntimeException(final String code, final Object[] args, Throwable cause) {
		super(code, MessageUtils.getMessage(code, args), cause);
	}

	public GenericRuntimeException(final String code, final Object[] args) {
		super(code, MessageUtils.getMessage(code, args));
	}

	/**
	 * Default Constructor with error code
	 *
	 * @param code
	 *            Error Code
	 */
	public GenericRuntimeException(final String code) {
		this(code, null, null);
	}

	/**
	 * Default Constructor with error code and cause
	 *
	 * @param code
	 *            Error Code
	 * @param cause
	 *            Exception Cause
	 */
	public GenericRuntimeException(final String code, Throwable cause) {
		this(code, null, cause);
	}

	@Override
	public String toString() {
		return String.valueOf(this.getClass()) + '{' + "code=" + getCode() + ", message=" + getMessage() + '}';
	}
}
