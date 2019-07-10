/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.analysis.accountability.hierarchy;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.suw.learn.pattern.analysis.accountability.hierarchy.LeveledAccountabilityType;
import org.suw.learn.pattern.analysis.accountability.knowledgelevel.PartyType;
import org.suw.learn.pattern.analysis.accountability.simple.Accountability;
import org.suw.learn.pattern.analysis.accountability.simple.Party;

public class LeveledTester {
    private PartyType nation = new PartyType("nation");
    private PartyType state = new PartyType("state");
    private PartyType county = new PartyType("county");
    private PartyType city = new PartyType("city");
    private Party usa, ma, nh, middlesex, melrose;
    private LeveledAccountabilityType region = new LeveledAccountabilityType("region");

    //	public LevelledTester(String name) {
    //		super(name);
    //	}

    @Before
    public void setUp() {
        PartyType[] levels = {nation, state, county, city};
        usa = new Party("usa", nation);
        ma = new Party("ma", state);
        nh = new Party("nh", state);
        middlesex = new Party("usa", county);
        melrose = new Party("usa", city);
        region.setLevels(levels);
        Accountability.create(usa, ma, region);
        Accountability.create(usa, nh, region);
        Accountability.create(ma, middlesex, region);
        Accountability.create(middlesex, melrose, region);
    }

    @Test
    public void testLevels() {
        assert (melrose.ancestorsInclude(ma, region));
    }

    @Test
    public void testReversedLevels() {
        try {
            Accountability.create(ma, usa, region);
            fail();
        } catch (Exception ignore) {
        }
    }

    @Test
    public void testSameLevels() {
        try {
            Accountability.create(ma, nh, region);
            fail();
        } catch (Exception ignore) {
        }
    }

    @Test
    public void testSkipLevels() {
        try {
            Accountability.create(ma, melrose, region);
            fail();
        } catch (Exception ignore) {
        }
    }
}
