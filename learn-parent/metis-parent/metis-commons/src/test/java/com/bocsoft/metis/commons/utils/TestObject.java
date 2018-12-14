package com.bocsoft.metis.commons.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by zion on 11/6/14.
 */
@Data
@AllArgsConstructor
public class TestObject {
    private String name;
    private String value;
    private String property;
    private int no;

    public TestObject() {
    }
}
