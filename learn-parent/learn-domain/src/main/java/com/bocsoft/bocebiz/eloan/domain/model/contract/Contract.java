package com.bocsoft.bocebiz.eloan.domain.model.contract;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Contract {
	@Setter(AccessLevel.NONE)
	private String contractId;//授信合同编号
	private ContractTemplate template;//合同文本模板内容

	public Contract(String contractNo) {
		super();
		this.contractId = contractNo;
	}

//	public Contract(String contractNo, ContractTemplate template) {
//		super();
//		this.contractNo = contractNo;
//	}

}
