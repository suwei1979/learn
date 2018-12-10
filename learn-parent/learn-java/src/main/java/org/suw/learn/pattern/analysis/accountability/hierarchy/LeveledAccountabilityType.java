/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.hierarchy;

import org.suw.learn.pattern.analysis.accountability.knowledgelevel.PartyType;
import org.suw.learn.pattern.analysis.accountability.simple.AccountabilityType;
import org.suw.learn.pattern.analysis.accountability.simple.Party;

public class LeveledAccountabilityType extends AccountabilityType {
    private PartyType[] levels;

    public LeveledAccountabilityType(String name) {
        super(name);
    }

    public void setLevels(PartyType[] arg) {
        levels = arg;
    }

    protected boolean areValidPartyTypes(Party parent, Party child) {
        for (int i = 0; i < levels.length; i++) {
            if (parent.getType().equals(levels[i])) {
                return (child.getType().equals(levels[i + 1]));
            }
        }
        return false;
    }
}