/**
 * Project Name:eloan-domain-application
 * File Name:TransLoanItem.java
 * Package Name:com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision
 * Date:2015年6月27日下午3:48:53
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import lombok.Data;
/**
 * ClassName:TransLoanItem <br/>
 * Function: 在途贷款. <br/>
 * Date:     2015年6月27日 下午3:48:53 <br/>
 * @author   st-wg-lbw5833
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Data
public class TransLoanItem {
    private String transitAmount;//在途申请金额
    private String transPrdCodeCCAS;//在途申请产品码（CCAS）
}

