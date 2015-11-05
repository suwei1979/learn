package com.bocsoft.bocebiz.eloan.domain.service.precredit;

import java.util.List;

import com.bocsoft.bocebiz.eloan.domain.model.precredit.PreCredit;
import com.bocsoft.bocebiz.eloan.domain.repository.PreCreditRepository;

public class PreCreditServiceImpl implements PreCreditService {

	private PreCreditRepository preCreditRepostory;
	@Override
	public PreCredit init(String customerNo) {
		PreCredit tran = new PreCredit(customerNo);
		return tran;
	}

	/**
	 * 批量导入
	 * @param trans
	 */
	@Override
	public void bookNewBatch(List<PreCredit> trans) {

	}

	@Override
	public void finish() {

	}

}
