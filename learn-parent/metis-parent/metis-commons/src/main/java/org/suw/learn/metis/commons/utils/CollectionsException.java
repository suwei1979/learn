package org.suw.learn.metis.commons.utils;

import org.suw.learn.metis.commons.exception.UtilityException;

/**
 * Collection Exception extends BaseException
 * It will be initiated and threw when CollectionUtils has exception;
 * Convert checked exception IllegalAccessException | InvocationTargetException | NoSuchMethodException
 * to unchecked exception.
 */
public class CollectionsException extends UtilityException {
    private static final long serialVersionUID = 8745436986158889150L;

    public CollectionsException(String code, Object[] args, Throwable cause) {
        super(code, args, cause);
    }

    public CollectionsException(String code) {
        super(code);
    }

    public CollectionsException(String code, Throwable cause) {
        super(code, cause);
    }
}
