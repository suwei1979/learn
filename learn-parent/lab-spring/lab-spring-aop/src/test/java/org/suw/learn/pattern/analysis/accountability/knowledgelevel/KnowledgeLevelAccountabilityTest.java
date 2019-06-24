/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.knowledgelevel;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.suw.learn.pattern.analysis.accountability.simple.Accountability;
import org.suw.learn.pattern.analysis.accountability.simple.Party;

public class KnowledgeLevelAccountabilityTest {
    private PartyType hospital = new PartyType("Hospital");
    private PartyType doctor = new PartyType("Doctor");
    private PartyType patient = new PartyType("Patient");
    private PartyType consultant = new PartyType("Consultant");
    private ConnectionRuleAccountabilityType appointment = new ConnectionRuleAccountabilityType("Appointment");
    private ConnectionRuleAccountabilityType supervision = new ConnectionRuleAccountabilityType("Supervises");
    private Party mark;
    private Party tom;
    private Party stMarys;

    @Before
    public void setUp() {
        appointment.addConnectionRule(hospital, doctor);
        appointment.addConnectionRule(hospital, consultant);
        supervision.addConnectionRule(doctor, doctor);
        supervision.addConnectionRule(consultant, doctor);
        supervision.addConnectionRule(consultant, consultant);
        mark = new Party("mark", consultant);
        tom = new Party("tom", consultant);
        stMarys = new Party("St Mary's", hospital);
    }

    @Test
    public void testNoConnectionRule() {
        try {
            Accountability.create(mark, stMarys, appointment);
            fail("created accountability without connection rule");
        } catch (Exception ignore) {
        }
        assertTrue(!stMarys.getParents().contains(mark)); // am I paranoid?
    }
}
