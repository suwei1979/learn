/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */

package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import lombok.Data;

/**
 * ClassName:LimitItem <br/>
 * Function: 额度信息. <br/>
 * Date:     2015年6月27日 下午3:47:37 <br/>
 *
 * @author st-wg-lbw5833
 * @see
 * @since JDK 1.6
 */
@Data
public class LimitItem {
    private String CCASPrdCode;//产品码（CCAS）
    private String limitNo;//额度号
    private String limitAmt;//额度金额
    private String availLimit;//可用额度
    private String limitStatus;//额度状态，核心D-1的数据:05-有效,20-冻结,10-已取消,40-已失效
}

