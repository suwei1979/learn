/**
 * Project Name:eloan-domain-application
 * File Name:WarnItem.java
 * Package Name:com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision
 * Date:2015年6月27日下午3:52:39
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import lombok.Data;


/**
 * ClassName:WarnItem <br/>
 * Function: 预警信息. <br/>
 * Date:     2015年6月27日 下午3:52:39 <br/>
 * @author   st-wg-lbw5833
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Data
public class WarnItem {
    private String warnMonth;//预警月份
    private String warnLevelSys;//预警等级（系统）
    private String warnLevelMan;//预警等级（人工）
}

