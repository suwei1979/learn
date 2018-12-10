/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.mdm.knowledgelevel;

import org.suw.learn.pattern.mdm.Entity;

public class ConnectionRule {
	private EntityType allowedParent;
	private EntityType allowedChild;

	public ConnectionRule(EntityType parent, EntityType child) {
		this.allowedParent = parent;
		this.allowedChild = child;
	}

	public boolean isValid(Entity fromEntity, Entity toEntity) {
		return (fromEntity.getType().equals(allowedParent) && toEntity.getType().equals(allowedChild));
	}

}
