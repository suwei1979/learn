package com.bocsoft.bocebiz.eloan.domain.model.application;

import java.util.Currency;
import java.util.Locale;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import com.bocsoft.bocebiz.eloan.domain.SystemConfiguration;
import com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision.CustomerDecisionInfo;
import com.bocsoft.bocebiz.eloan.domain.model.contract.Account;

/**
 *
 * @author sw0876
 *
 */
@Data
public class LoanApplication {
	public enum State {
		// 初始化，未入库
		INITIALIZED("贷款申请初始化", "I") {
			@Override
			public State book(LoanApplication context) {
				return BOOKED;
			}
		},
		// 已入库
		BOOKED("贷款申请已入库", "B") {
			@Override
			public State attachCustomerDecisionInfo(LoanApplication context) {
				return PRECALCULATING;
			}
		},
		// 试算
		PRECALCULATING("贷款额度试算中", "C") {
			public State assignOperationBranch(LoanApplication loanApplication) {
				return PRECALCULATING;
			}
			public State pricing(LoanApplication loanApplication) {
				return PRECALCULATING;
			}
			public State approve(LoanApplication loanApplication) {
				return APPROVING;
			}
		},
		// 额度建立中
		APPROVING("贷款额度建立中", "AI"){
			public State finish(LoanApplication loanApplication) {
				return APPROVED;
			}
		},
		// 申请已完成，额度已建立
		APPROVED("贷款额度已建立", "AD");

		private String desc;
		private String value;
		State(String desc, String value) {
			this.desc = desc;
			this.value = value;
		}

		public State attachCustomerDecisionInfo(LoanApplication context) {
			throw new UnsupportedOperationException("Unsupported state transformation under state:" + desc());
		}

		public State assignOperationBranch(LoanApplication loanApplication) {
			throw new UnsupportedOperationException("Unsupported state transformation under state:" + desc());
		}

		public State book(LoanApplication loanApplication) {
			throw new UnsupportedOperationException("Unsupported state transformation under state:" + desc());
		}

		public State pricing(LoanApplication loanApplication) {
			throw new UnsupportedOperationException("Unsupported state transformation under state:" + desc());
		}

		public State approve(LoanApplication loanApplication) {
			throw new UnsupportedOperationException("Unsupported state transformation under state:" + desc());
		}

		public State finish(LoanApplication loanApplication) {
			throw new UnsupportedOperationException("Unsupported state transformation under state:" + desc());
		}
		public String desc() {
			return this.desc;
		}

		@Override
		public String toString() {
			return this.value;
		}

	}

	private SystemConfiguration systemConfiguration = new SystemConfiguration() {

        @Override
        public Currency getDefaultCurrency() {

            return Currency.getInstance(Locale.CHINA);
        }
    }; 
	protected LoanApplication(String applicationId, ProductType productType, Party applicant, LoanLimit limitInfo) {
		super();
		this.loanApplicationId = applicationId;
		this.productType = productType;
		this.applicant = applicant;
		this.limitInfo = limitInfo;
		this.currency = systemConfiguration.getDefaultCurrency();
		this.limitInfo.setCurrency(currency);
//		this.asignOperationBranchPolicy = productType.getAsignOperationBranchPolicy();
//		this.pricingStrategy = productType.getPricingStrategy();
		this.state = State.INITIALIZED;

    }


    /**
     * 计算叙做机构
     */
	public void assignOperationBranch() {
		this.branch = this.getProductType().getAsignOperationBranchPolicy().getOperationBranch(this);
		this.state = state.assignOperationBranch(this);
	}

	public void attach(CustomerDecisionInfo customerDecisionInfo) {
		this.customerDecisionInfo = customerDecisionInfo;
		this.state = state.attachCustomerDecisionInfo(this);
		this.limitInfo.precalculate();
	}

	public void pricing() {
		Rate pricing = this.getProductType().getPricingStrategy().getPrice(this);
		this.limitInfo.setRate(pricing);
		this.state = state.pricing(this);
	}

	public void approve() {
		this.state = state.approve(this);

	}
	public void finish() {
		this.state = state.finish(this);
	}
	public void book() {
		this.state = state.book(this);
	}
	// 申请人信息
	@Setter(AccessLevel.NONE)
	private Party applicant;
	// 贷款申请叙做机构
	private Branch branch;
	private Currency currency;
	// 额度信息
	@Setter(AccessLevel.NONE)
	private LoanLimit limitInfo;
	//合作平台编号
	//private String platformId;//// in platform

	//平台流水号
	@Setter(AccessLevel.NONE)
	private String loanApplicationId;

	// 平台信息
	private Platform platform;/////////
	// 试算流程的处理步骤
	// 产品类型信息
	@Setter(AccessLevel.NONE)
	private ProductType productType;
	//private String reqSysId;//// in platform
	private State state;
	//申请带有特定信息
	private String agreementNo;//协议授权的编号
	private String textNo;//协议文本编号
	private String leaveNote;//留言
	private String tranType;//交易类型，e.g.01-额度申请
	private Account repayAcctNo;//APP 送来有还款账户

	@Setter(AccessLevel.NONE)
	private CustomerDecisionInfo customerDecisionInfo;
}
