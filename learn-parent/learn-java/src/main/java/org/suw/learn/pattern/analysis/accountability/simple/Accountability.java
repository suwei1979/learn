/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.simple;

public class Accountability {
    private Party parent;
    private Party child;
    private AccountabilityType type;

    public Accountability(Party parent, Party child, AccountabilityType type) {
        super();
        this.parent = parent;
        parent.friendAddChildAccountability(this);
        this.child = child;
        child.friendAddParentAccountability(this);
        this.type = type;
    }

    public static Accountability create(Party parent, Party child, AccountabilityType supervision) {
        if (!canCreate(parent, child, supervision)) {
            throw new IllegalArgumentException("Invalid Accountability");
        }
        return new Accountability(parent, child, supervision);

    }

    private static boolean canCreate(Party parent, Party child, AccountabilityType type) {
        if (parent.equals(child)) {
            return false;
        }
        if (parent.ancestorsInclude(child, type)) {
            return false;
        }
        return type.canCreateAccountability(parent, child);
    }

    public Party getParent() {
        return parent;
    }

    public Party getChild() {
        return child;
    }

    public AccountabilityType getType() {
        return type;
    }

}
