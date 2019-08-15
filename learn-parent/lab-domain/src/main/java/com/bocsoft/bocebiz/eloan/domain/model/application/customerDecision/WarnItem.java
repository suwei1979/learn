/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */

package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import lombok.Data;

/**
 * ClassName:WarnItem <br/>
 * Function: 预警信息. <br/>
 * Date:     2015年6月27日 下午3:52:39 <br/>
 *
 * @author st-wg-lbw5833
 * @see
 * @since JDK 1.6
 */
@Data
public class WarnItem {
    private String warnMonth;//预警月份
    private String warnLevelSys;//预警等级（系统）
    private String warnLevelMan;//预警等级（人工）
}

