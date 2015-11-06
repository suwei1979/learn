package com.bocsoft.bocebiz.eloan.domain.model.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.suw.learn.metis.commons.exception.BusinessException;

import com.bocsoft.bocebiz.eloan.domain.repository.LoanApplicationRepository;
import com.bocsoft.bocebiz.eloan.domain.repository.LoanLimitRepository;
import com.bocsoft.bocebiz.eloan.domain.repository.ProductRepository;
import com.bocsoft.bocebiz.eloan.domain.service.apply.PartyFactoryLoader;
import com.bocsoft.bocebiz.eloan.domain.service.apply.impl.SpringPartyFactoryLoader;
import com.bocsoft.bocebiz.eloan.domain.service.exceptions.DuplicatedApplicationException;
import com.bocsoft.bocebiz.eloan.domain.service.exceptions.UnexistsProductException;

public class LoanApplicationFactory {
    private final ProductRepository productRepository;
    private final LoanApplicationRepository loanApplicationRepository;
    private PartyFactoryLoader partyFactoryLoader;

    @Autowired
    public LoanApplicationFactory(ProductRepository productRepo,
            LoanApplicationRepository loanApplicationRepo,
            LoanLimitRepository loanLimitRepo) {
        this.productRepository = productRepo;
        this.loanApplicationRepository = loanApplicationRepo;
        this.partyFactoryLoader = new SpringPartyFactoryLoader();

    }

    /**
     * Document example
     * 
     * @param platformSeqNo
     * @param productCode
     *            产品码，必须在系统中存在，否则将抛出UnexistsProductException
     * @return
     * @throws BusinessException
     */
    public LoanApplication createNewApplication(String platformSeqNo, String productCode) {
        //是否进行此检查，是一个需要架构师决策的问题。可以在此处检查，也可以不在此处检查，待数据库抛出异常后发现主键重复异常，再封装后转抛。
        //无论怎样，这都是一个公共的处理标准，我们甚至可以通过接口和切面将此部分工作抽取出来。
        if (loanApplicationRepository.exist(platformSeqNo))
            throw new DuplicatedApplicationException("");
        ProductType productType = productRepository.findByProductCode(productCode);
        if (productType == null) {
            throw new UnexistsProductException("");
        }
        PartyType applicantType = productType.getPartyType();
        Party applicant = partyFactoryLoader.getPartyFactory(applicantType.getName()).create();

        LoanLimit loanLimit = new LoanLimit(platformSeqNo);
        
        LoanApplication loanApplication = new LoanApplication(platformSeqNo, productType, applicant, loanLimit);

        return loanApplication;
    } 
}
