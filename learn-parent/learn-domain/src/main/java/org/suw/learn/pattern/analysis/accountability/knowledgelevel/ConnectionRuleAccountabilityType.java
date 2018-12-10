/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.accountability.knowledgelevel;

import java.util.HashSet;
import java.util.Set;

import org.suw.learn.pattern.analysis.accountability.simple.AccountabilityType;
import org.suw.learn.pattern.analysis.accountability.simple.Party;

public class ConnectionRuleAccountabilityType extends AccountabilityType {
	Set<ConnectionRule> connectionRules = new HashSet<ConnectionRule>();

	public ConnectionRuleAccountabilityType(String name) {
		super(name);
	}

	public void addConnectionRule(PartyType parent, PartyType child) {
		connectionRules.add(new ConnectionRule(parent, child));
	}

	protected boolean areValidPartyTypes(Party parent, Party child) {
		for (ConnectionRule eachRule : connectionRules) {
			if (eachRule.isValid(parent, child))
				return true;
		}
		return false;
	}
}
