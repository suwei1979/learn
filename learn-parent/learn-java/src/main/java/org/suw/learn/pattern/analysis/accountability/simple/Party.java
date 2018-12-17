/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.simple;

import java.util.HashSet;
import java.util.Set;

import org.suw.learn.pattern.analysis.accountability.knowledgelevel.PartyType;

public class Party {
    private Set<Accountability> parentAccountabilities = new HashSet<Accountability>();
    private Set<Accountability> childAccountabilities = new HashSet<Accountability>();
    private String name;
    private PartyType type;

    public Party(String name, PartyType type) {
        this.name = name;
        this.type = type;
    }

    public Party(String name) {
        this.name = name;
    }

    public PartyType getType() {
        return type;
    }

    void friendAddChildAccountability(Accountability arg) {
        childAccountabilities.add(arg);
    }

    void friendAddParentAccountability(Accountability arg) {
        parentAccountabilities.add(arg);
    }

    public String getName() {
        return name;
    }

    public Set<Party> getParents() {
        Set<Party> result = new HashSet<Party>();
        for (Accountability accountability : parentAccountabilities) {
            result.add(accountability.getParent());
        }
        return result;
    }

    public Set<Party> getParents(AccountabilityType accountabilityType) {
        Set<Party> result = new HashSet<Party>();
        for (Accountability eachAccountability : parentAccountabilities) {
            if (eachAccountability.getType().equals(accountabilityType)) {
                result.add(eachAccountability.getParent());
            }
        }
        return result;
    }

    public Set<Party> getChildren() {
        Set<Party> result = new HashSet<Party>();
        for (Accountability accountability : childAccountabilities) {
            result.add(accountability.getChild());
        }
        return result;

    }

    public boolean ancestorsInclude(Party party, AccountabilityType type) {
        Set<Party> typedParentAccountabilities = getParents(type);
        for (Party parent : typedParentAccountabilities) {
            if (parent.equals(party)) {
                return true;
            }
            if (parent.ancestorsInclude(party, type)) {
                return true;
            }
        }
        return false;
    }

}
