/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain.industry;

import lombok.Data;

/**
 * 行业信息类，仅用作测试Mock领域对象数据用
 * @author suwei
 *
 */
@Data
public class Industry {
    String code;
    String name;
    int level;

    Industry parent;

    public boolean ancestorInclude(Industry another) {
        return false;
    }

    public static boolean canCreate(Industry trade) {
        return false;
    }

    public static boolean canUpdate(Industry trade) {
        return false;
    }

    public Industry() {
        this(null);
    }

    /**
     * @param parent
     */
    public Industry(Industry parent) {
        this.parent = parent;
    }
}
