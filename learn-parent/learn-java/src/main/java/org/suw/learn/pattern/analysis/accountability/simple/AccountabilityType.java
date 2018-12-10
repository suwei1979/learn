/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.simple;

public class AccountabilityType {
    private String name;
    private boolean isHierarchic = false;

    public AccountabilityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHierarchic() {
        return isHierarchic;
    }

    public void setHierarchic(boolean isHierarchic) {
        this.isHierarchic = isHierarchic;
    }

    boolean canCreateAccountability(Party parent, Party child) {
        if (isHierarchic && child.getParents(this).size() != 0)
            return false;
        return areValidPartyTypes(parent, child);
    }

    protected boolean areValidPartyTypes(Party parent, Party child) {
        return true;
    }
}
