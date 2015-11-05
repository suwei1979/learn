package com.bocsoft.bocebiz.eloan.domain.service.precredit;

import java.util.List;

import com.bocsoft.bocebiz.eloan.domain.model.precredit.PreCredit;

public interface PreCreditService {
	
	public PreCredit init(String customerNo);
	public void bookNewBatch(List<PreCredit> tran);
	public void finish();
}
