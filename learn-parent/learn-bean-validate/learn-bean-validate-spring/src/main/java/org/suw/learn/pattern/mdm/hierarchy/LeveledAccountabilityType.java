package org.suw.learn.pattern.mdm.hierarchy;

import org.suw.learn.pattern.mdm.Entity;
import org.suw.learn.pattern.mdm.knowledgelevel.AssociationType;
import org.suw.learn.pattern.mdm.knowledgelevel.EntityType;

public class LeveledAccountabilityType extends AssociationType {
	private EntityType[] levels;

	public LeveledAccountabilityType(String name) {
		super(name);
	}

	public void setLevels(EntityType[] arg) {
		levels = arg;
	}

	protected boolean areValidPartyTypes(Entity parent, Entity child) {
		for (int i = 0; i < levels.length; i++) {
			if (parent.getType().equals(levels[i]))
				return (child.getType().equals(levels[i + 1]));
		}
		return false;
	}
}