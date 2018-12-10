/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.pattern.analysis.orghierarchy;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public class Organization {
	
	private Currency accountingCurrency;

	private String name;

	private Organization parent;


	public Organization(String name, Organization parent) {
		assertValidParent(parent);
		this.name = name;
		this.parent = parent;
		register();
	}

	protected void assertValidParent(Organization argParent) {
		if (argParent != null) {
			assert !argParent.getAncestors().contains(this);
		}
	}

	public Currency getAccountingCurrency() {
		if (accountingCurrency != null) {
			return accountingCurrency;
		} else {
			if (parent != null) {
				return parent.getAccountingCurrency();
			} else {
				throw new UndefinedAccountingCurrencyException();
			}
		}
	}

	public Set<Organization> getAncestors() {
		Set<Organization> result = new HashSet<Organization>();
		if (parent != null) {
			result.add(parent);
			result.addAll(parent.getAncestors());
		}
		return result;
	}

	public Set<Organization> getChildren() {
		HashSet<Organization> result = new HashSet<Organization>();
		for (Organization child : OrganizationRegistry.values()) {
			if (child.getParent() != null && child.getParent().equals(this)) {
				result.add(child);
			}
		}
		return result;
	}

	public Set<Organization> getDescendents() {
		Set<Organization> result = new HashSet<Organization>();
		result.addAll(this.getChildren());
		for (Organization child : this.getChildren()) {
			result.addAll(child.getChildren());
		}
		return result;
	}

	public String getName() {
		return name;
	}
	
	public Organization getParent() {
		return this.parent;
	}

	public Set<Organization> getSiblings() {
		Set<Organization> result = new HashSet<Organization>();
		result.addAll(this.getParent().getChildren());
		result.remove(this);
		return result;
	}

	void register() {
		OrganizationRegistry.put(this);
	}

	public void setAccountingCurrency(Currency accountingCurrency) {
		assert false : (accountingCurrency == null && getParent() == null);  
		this.accountingCurrency = accountingCurrency;
	}
}
