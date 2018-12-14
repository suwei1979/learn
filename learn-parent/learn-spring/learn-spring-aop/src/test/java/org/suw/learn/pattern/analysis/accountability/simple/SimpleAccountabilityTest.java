/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.simple;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SimpleAccountabilityTest {
    //名为监督的Accountability Type
    private AccountabilityType supervision = new AccountabilityType("Supervises");
    //名为任命的Accountability Type
    private AccountabilityType appointment = new AccountabilityType("Appointment");
    private Party mark = new Party("mark");
    private Party tom = new Party("Tom");
    private Party stMarys = new Party("St. Mary's");

    @Before
    public void setUp() {
        new Accountability(stMarys, mark, appointment);
        new Accountability(stMarys, tom, appointment);
    }

    @Test
    public void testSimple() {
        assertTrue(stMarys.getChildren().contains(mark));
        assertTrue(mark.getParents().contains(stMarys));
    }

    @Test
    public void testParents() {
        Accountability.create(tom, mark, supervision);
        assertTrue(mark.getParents().contains(stMarys));
        assertTrue(mark.getParents(appointment).contains(stMarys));
        assertTrue(mark.getParents(supervision).contains(tom));
        assertEquals(2, mark.getParents().size());
        assertEquals(1, mark.getParents(appointment).size());
        assertEquals(1, mark.getParents(supervision).size());
    }

    @Test
    public void testCycle() {
        Accountability.create(mark, tom, supervision);
        try {
            Accountability.create(tom, mark, supervision);
            fail("created accountability with cycle");
        } catch (IllegalArgumentException e) {

        }
        assertTrue(!mark.getParents().contains(tom)); //just be sure!
        AccountabilityType modelMentor = new AccountabilityType("modeMentor");
        Accountability.create(tom, mark, modelMentor); // okay to create with different type
        assertTrue(!mark.getParents().contains(tom)); //now okay

    }
}
