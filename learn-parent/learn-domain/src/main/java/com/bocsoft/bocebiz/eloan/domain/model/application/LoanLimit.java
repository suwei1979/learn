package com.bocsoft.bocebiz.eloan.domain.model.application;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import lombok.Data;

@Data
public class LoanLimit {
	public enum State {
		Intialized ("Intialized","额度初始化") {
			@Override
			public State precalculate(LoanLimit context) {
				return Inactive;
			}
			
		},
		
		Inactive("Inactive","额度未激活") {
			@Override
			public State activate(LoanLimit context) {
				return Active;
			}
			
		},
		
		Active("Active", "额度已激活") {
			@Override
			public State expire(LoanLimit context) {
				return Expired;
			}
			
		},
		
		Expired("Expired", "额度已过期") ,
		
		Overdue("Overdue", "超期未申请");

		String value,desc;
		State(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}
		public  State precalculate(LoanLimit context) {
			throw new UnsupportedOperationException("Unsupported state transformation under state: " + desc());
		}

		public State activate(LoanLimit context) {
			throw new UnsupportedOperationException("Unsupported state transformation under state: " + desc());
		}

		public State expire(LoanLimit context) {
			throw new UnsupportedOperationException("Unsupported state transformation under state: " + desc());
		}
		
		public String toString() {
			return value;
		}
		public String desc() {
			return desc;
		}
	}
	private final String platformSeqNo;
	private BigDecimal amount;
	private int period;
	private Currency currency;
	private String usage;
	private State state;
	private Rate rate;
	private String limNo;
	private Date creditUpdateTime; 
	
	public LoanLimit(String platformSeqNo) {
		this.platformSeqNo = platformSeqNo;
		state = State.Intialized;
	}
	
	public LoanLimit(String platformSeqNo,String statue) {
        this.platformSeqNo = platformSeqNo;
        state = State.valueOf(statue);
    }
	
	public void precalculate() {
		state = state.precalculate(this);
	}
	
	public void activate() {
		state = state.activate(this);
	}
	
	public void expire() {
		state = state.expire(this);
	}
	public State getState() {
		return state;
	}
	
}

