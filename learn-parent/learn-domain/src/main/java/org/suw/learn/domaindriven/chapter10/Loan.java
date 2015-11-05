package org.suw.learn.domaindriven.chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Loan {
	private Map<Company, Share> shares;
	private SharePie sharePie;
	
	public void applyDrawDown(SharePie drawDownShares) {
		setSharePie(sharePie.plus(drawDownShares));
	}
	
	public Map<Company, Share> distributePrincipalPayment(double paymentAmount) {
		Map<Company, Share> paymentShares = new HashMap<Company, Share>();
		Map<Company, Share> loanShares = getShares();
		double total = getAmount();
		for (Company owner : loanShares.keySet()) {
			double initialLoanShareAmount = getShareAmount(owner);
			double paymentShareAmount = initialLoanShareAmount / total * paymentAmount;
			Share paymentShare = new Share(owner, paymentAmount);
			paymentShares.put(owner, paymentShare);
			
			double newLoanShareAmount = initialLoanShareAmount - paymentShareAmount;
			Share newLoanShare = new Share(owner, newLoanShareAmount);
			loanShares.put(owner,  newLoanShare);
			loanShares.put(owner, newLoanShare);
		}
		return paymentShares;
	}

	public void applyPrincipalPaymentShares(Map<Company, Share> paymentShares) {
		Map<Company, Share> loanShares = getShares();
		for (Company lender : loanShares.keySet()) {
			Share paymentShare = paymentShares.get(lender);
			Share loanShare = loanShares.get(lender);
			double newLoanShareAmount = loanShare.getAmount() - paymentShare.getAmount();
			Share newLoanShare = new Share(lender, newLoanShareAmount);
			loanShares.put(lender, newLoanShare);
		}
	}
	
	public Map<Company, Share> calculatePrincipalPaymentShares(double paymentAmount) {
		Map<Company, Share> paymentShares = new HashMap<Company, Share>();
		Map<Company, Share> loanShares = getShares();
		double total = getAmount();
		for (Company lender : loanShares.keySet()) {
			Share loanShare = loanShares.get(lender);
			double paymentShareAmount = loanShare.getAmount() / total * paymentAmount;
			
			Share paymentShare = new Share(lender, paymentShareAmount);
			paymentShares.put(lender, paymentShare);
		}
		return paymentShares;
	}
	
	public double getAmount() {
		Map<Company, Share> loanShares = getShares();
		double total = 0.0;
		Set<Company> keySet = loanShares.keySet();
		for (Company c : keySet) {
			Share loanShare = loanShares.get(c);
			total = total + loanShare.getAmount();
		}
		return total;
	}
	
	private double getShareAmount(Company owner) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
