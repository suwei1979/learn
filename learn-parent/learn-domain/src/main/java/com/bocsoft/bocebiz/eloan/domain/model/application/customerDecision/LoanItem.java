/**
 * Project Name:eloan-domain-application
 * File Name:LoanItem.java
 * Package Name:com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision
 * Date:2015年6月27日下午3:45:46
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import lombok.Data;
/**
 * ClassName:LoanItem <br/>
 * Function: 贷款信息. <br/>
 * Date:     2015年6月27日 下午3:45:46 <br/>
 * @author   st-wg-lbw5833
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Data
public class LoanItem {
   private String bocsPrdCode;//产品码（核心）
   private String loanBalance;//贷款余额
   private String overdueFlag;//是否逾期，核心D-1的数据：00-未逾期，01-逾期
}

