package org.suw.learn.pattern.mdm.knowledgelevel;

import org.suw.learn.pattern.mdm.Entity;

public abstract class AssociationType {
    private String name;
    private boolean isHierarchic = false;

    public AssociationType(String name) {
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

    public boolean canCreateAssociation(Entity parent, Entity child) {
//        if (isHierarchic && child.getParents(this).size() != 0)
//            return false;
        return areValidPartyTypes(parent, child);
    }

    protected abstract boolean areValidPartyTypes(Entity parent, Entity child);
//    protected boolean areValidPartyTypes(Entity parent, Entity child) {
//        return true;
//    }
}
