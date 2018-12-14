package org.suw.learn.metis.commons.exception;

/**
 * Created by zion on 6/3/15.
 */
public class BusinessException extends GenericRuntimeException {
    private static final long serialVersionUID = -3299959938012004142L;

    public BusinessException(String code, Object[] args, Throwable cause) {
        super(code, args, cause);
    }

    public BusinessException(String code) {
        super(code);
    }

    public BusinessException(String code, Throwable cause) {
        super(code, cause);
    }

    public BusinessException(String code, Object[] args) {
        super(code, args);
    }
}
