/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.java.generics;

import javax.xml.bind.annotation.XmlInlineBinaryData;

import lombok.Data;

/**
 * @author suwei
 *
 */
@Data
public class ResovleGenericsType<E> {
    E genericType;
    /**
     * 
     */
    public ResovleGenericsType(E genericTypeParm) {
        genericType = genericTypeParm
    }

    public static void main(String[] args) {
        
    }
}
