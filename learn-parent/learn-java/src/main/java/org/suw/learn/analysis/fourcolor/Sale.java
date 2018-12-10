/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.analysis.fourcolor;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @author suwei
 * @archetype moment-interval
 */
@Data
public class Sale {

    private int number;
    private Date date;

    public BigDecimal calcTotal() {
        return BigDecimal.valueOf(0);
    }
}
