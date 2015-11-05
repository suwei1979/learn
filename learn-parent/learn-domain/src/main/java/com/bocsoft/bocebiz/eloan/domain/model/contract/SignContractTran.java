package com.bocsoft.bocebiz.eloan.domain.model.contract;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class SignContractTran {
	@Setter(AccessLevel.NONE)
	private String transactionNo;//指平台流水号
	private Contract contract;
	private Account repayAccount;//还款账号

	public SignContractTran(Contract contract) {
		super();
		this.contract = contract;
	}

	public void signContract() {
	}
//	public SignContractTran(String transactionNo, String contractNo) {
//		super();
//		this.transactionNo = transactionNo;
//		this.contract = new Contract(contractNo);
//		//instantiate contract template
//	}
	
}
