/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.ddd.chapter10;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class SharePie {
    private Map<Company, Share> shares = new HashMap<Company, Share>();

    public SharePie prorated(double amount) {
        SharePie proration = new SharePie();
        double basis = getAmount();
        for (Company owner : shares.keySet()) {
            double shareAmount = getShareAmount(owner);
            double proratedAmount = shareAmount / basis * amount;
            proration.add(owner, proratedAmount);
        }
        return proration;
    }

    public SharePie plus(SharePie other) {
        // similar to implementation of minus();
        return null;
    }

    public SharePie minus(SharePie other) {
        SharePie result = new SharePie();
        Set<Company> owners = new HashSet<Company>();
        owners.addAll(getOwners());
        owners.addAll(other.getOwners());
        for (Company owner : owners) {
            double resultShareAmount = getShareAmount(owner) - other.getShareAmount(owner);
            result.add(owner, resultShareAmount);

        }
        return result;
    }

    public void add(Company owner, double resultShareAmount) {
        shares.put(owner, new Share(owner, resultShareAmount));

    }

    public double getShareAmount(Company owner) {
        return shares.get(owner).getAmount();
    }

    public Collection<? extends Company> getOwners() {
        return shares.keySet();
    }

    public double getAmount() {
        double total = 0.0;
        for (Company owner : shares.keySet()) {
            Share loanShare = shares.get(owner);
            total = total + loanShare.getAmount();
        }
        return total;
    }

}

