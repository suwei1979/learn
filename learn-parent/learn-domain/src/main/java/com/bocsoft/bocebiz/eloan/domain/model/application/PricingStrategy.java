package com.bocsoft.bocebiz.eloan.domain.model.application;

/**
 * 
 * @author sw0876
 *
 */
public interface PricingStrategy {

	/**
	 * Code example for implementations: <br>
	 * <code>
	 *  public Rate getPrice() {  <br>
	 *  	Rate result = this.getBranch().getRate();<br> 
	 *  	if (result != null) { <br>
	 *  		result = this.getProductType().getBaseRate(); <br> 
	 *  	} <br> 
	 *  	return result; <br> 
	 *  }<br> 
	 *  </code>
	 * @param loanApplication 
	 * 
	 * 
	 * 
	 * @return
	 */
	public Rate getPrice(LoanApplication loanApplication);

}