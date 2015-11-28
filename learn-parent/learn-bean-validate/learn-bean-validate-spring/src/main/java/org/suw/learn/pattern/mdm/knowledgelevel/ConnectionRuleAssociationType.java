package org.suw.learn.pattern.mdm.knowledgelevel;

import java.util.HashSet;
import java.util.Set;

import org.suw.learn.pattern.mdm.Entity;

public class ConnectionRuleAssociationType extends AssociationType {
	Set<ConnectionRule> connectionRules = new HashSet<ConnectionRule>();

	public ConnectionRuleAssociationType(String name) {
		super(name);
	}

	public void addConnectionRule(EntityType parent, EntityType child) {
		connectionRules.add(new ConnectionRule(parent, child));
	}

	protected boolean areValidPartyTypes(Entity parent, Entity child) {
		for (ConnectionRule eachRule : connectionRules) {
			if (eachRule.isValid(parent, child))
				return true;
		}
		return false;
	}
}
