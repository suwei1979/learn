/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.knowledgelevel;

import org.suw.learn.pattern.analysis.accountability.simple.Party;

public class ConnectionRule {
	private PartyType allowedParent;
	private PartyType allowedChild;

	public ConnectionRule(PartyType parent, PartyType child) {
		this.allowedParent = parent;
		this.allowedChild = child;
	}

	public boolean isValid(Party parent, Party child) {
		return (parent.getType().equals(allowedParent) && child.getType().equals(allowedChild));
	}

}
