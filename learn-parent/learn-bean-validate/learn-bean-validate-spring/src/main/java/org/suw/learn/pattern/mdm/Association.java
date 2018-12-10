/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.pattern.mdm;

import org.suw.learn.pattern.mdm.knowledgelevel.AssociationType;

public class Association {
	private Entity fromEntity;
	private Entity toEntity;
	private AssociationType type;

	public Association(Entity fromEntity, Entity child, AssociationType type) {
		super();
		this.fromEntity = fromEntity;
//		fromEntity.friendAddChildAssociation(this);
		this.toEntity = child;
//		child.friendAddParentAssociation(this);
		this.type = type;
	}

	public Entity getParent() {
		return fromEntity;
	}

	public Entity getChild() {
		return toEntity;
	}

	public AssociationType getType() {
		return type;
	}

	public static Association create(Entity parent, Entity child, AssociationType supervision) {
		if (!canCreate(parent, child, supervision)) 
			throw new IllegalArgumentException("Invalid Accountability");
		return new Association(parent, child, supervision);
		
	}

	private static boolean canCreate(Entity parent, Entity child, AssociationType type) {
		if (parent.equals(child))
			return false;
//		if (parent.ancestorsInclude(child, type)) {
//			return false;
//		}
		return type.canCreateAssociation(parent, child);
	}

}
