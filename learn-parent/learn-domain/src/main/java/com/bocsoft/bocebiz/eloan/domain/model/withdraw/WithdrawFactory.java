package com.bocsoft.bocebiz.eloan.domain.model.withdraw;


/**
 * Created by li10 on 15-6-25.
 */
public class WithdrawFactory {

    public Withdraw createWithdraw (String loanApplicationId, String productCode) {

        Withdraw aNewWithdraw = new Withdraw();
        aNewWithdraw.setState(Withdraw.State.Initialized);
        aNewWithdraw.setLoanApplicationId(loanApplicationId);
        aNewWithdraw.setProductCode(productCode);
        return aNewWithdraw;
    }
}
