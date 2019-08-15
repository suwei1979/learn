/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model.withdraw;

import com.bocsoft.bocebiz.eloan.domain.model.PersonId;

import lombok.Data;

/**
 * Created by li10 on 15-6-17.
 */
@Data
public class Withdraw {

    /**
     * 通知涉及的字段, 都是非必输
     */
    //放款金额
    String actAmt;
    //贷款到期日
    String actExpDt;
    //放款日期
    String actAdvDt;
    //年利率
    String inRate;
    //年服务费率
    String feeRate;
    //贷款账号
    String actno;
    //产品码
    private String productCode;
    //提款申请编号，唯一确定一笔提款申请
    private String advAppNo;
    //用户三要素
    private PersonId personId;
    //额度id通常用交易流水号代表咯？
    private String loanApplicationId;
    //channo,pos贷使用，接口中有，但和对象关系不明确,待定
    private String channo;
    private State state;
    /**
     * 申请涉及的字段有：
     */
    //申请提款金额
    private String advAmt;
    //申请提款期限
    private String term;
    //申请提款期限单位
    private String termUnit;
    //还款方式
    private String repayType;
    //提款利率
    private String withdrawRate;
    //贷款用途
    private String loanUse;
    //放款账户
    private String advAccount;
    //放款账户是否借记卡
    private String isDebCard;

    public Withdraw inactive(Withdraw withdraw) {

        if (withdraw.getState().equals(State.Initialized)) {
            withdraw.setState(State.Inactive);
        }
        return withdraw;
    }

    public Withdraw unactivated(Withdraw withdraw) {

        if (withdraw.getState().equals(State.Inactive)) {
            withdraw.setState(State.Unactivated);
        }
        return withdraw;
    }

    public Withdraw active(Withdraw withdraw) {

        if (withdraw.getState().equals(State.Inactive)) {
            withdraw.setState(State.Active);
        }
        return withdraw;
    }

    public Withdraw close(Withdraw withdraw) {

        if (withdraw.getState().equals(State.Active)) {
            withdraw.setState(State.Close);
        }
        return withdraw;
    }

    //提款状态:初始化，未激活,已激活/已拒绝,还款结清
    public enum State {

        Initialized("Initialized", "初始化"),

        Inactive("Inactive", "未激活"),

        Unactivated("Unactivated", "已拒绝,"),

        Active("Active", "已激活"),

        Close("Close", "结清");

        String value, desc;

        State(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

    }

}
