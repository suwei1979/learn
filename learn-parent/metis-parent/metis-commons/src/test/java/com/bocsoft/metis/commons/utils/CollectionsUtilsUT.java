/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.metis.commons.utils;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.suw.learn.metis.commons.utils.CollectionsException;
import org.suw.learn.metis.commons.utils.CollectionsUtils;

/**
 * Created by zion on 11/6/14.
 */
public class CollectionsUtilsUT {

    private static List<TestObject> testObjects;

    @BeforeClass
    public static void newTestData() {
        testObjects = new ArrayList<>();
        testObjects.add(new TestObject("1", "1", "1", 1));
        testObjects.add(new TestObject("2", "2", "2", 2));
        testObjects.add(new TestObject("3", "3", "3", 3));
    }

    @Test
    public void extract2Map() {
        Map<String, String> result = CollectionsUtils.extractToMap(testObjects, "name", String.class, "property", String.class);
        assertThat(result).hasSize(3);
        assertThat(result.keySet()).contains("1", "2", "3");
        assertThat(result.values()).contains("1", "2", "3");
    }

    @Test(expected = ClassCastException.class)
    public void extract2MapWithValueIntTypeThrowException() {
        Map<String, String> result = CollectionsUtils.extractToMap(testObjects, "name", String.class, "no", String.class);
        assertThat(result).hasSize(3);
        assertThat(result.keySet()).contains("1", "2", "3");
        assertThat(result.values()).contains("1", "2", "3");
    }

    @Test(expected = CollectionsException.class)
    public void extract2MapThrowExceptionWhenPropertyNotMatch() {
        Map<String, String> result = CollectionsUtils.extractToMap(testObjects, "name", String.class, "propery", String.class);
        assertThat(result).hasSize(0);
    }

    @Test
    public void extract2ListWithIntProperty() {
        List<Integer> result = CollectionsUtils.extractToList(testObjects, "no", Integer.class);
        assertThat(result).hasSize(3);
        assertThat(result).contains(1, 2, 3);
    }
}