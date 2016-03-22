/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain.industry;

import lombok.Data;

/**
 * 行业信息类，仅用作测试Mock领域对象数据用 Industry Class, used to mock the domain object for Industry Service.
 * 
 * @author suwei
 *
 */
@Data
public class Industry {
    /**
     * The code of Industry.
     */
    String code;

    /**
     * The name of Industry
     */
    String name;

    /**
     * The industry level that represent the depth to the root.
     */
    int level;

    /**
     * Direct parent industry.
     */
    Industry parent;

    /**
     * If the ancestor of current industry have include the input.
     * 
     * @param another
     * @return true if the input industry instance is the ancestor of the current industry instance, false if not.
     */
    public boolean ancestorInclude(Industry another) {
        return false;
    }

    /**
     * Whether the industry can be created.
     * 
     * @param industry
     * @return true if can create, false if not.
     */
    public static boolean canCreate(Industry industry) {
        return false;
    }

    /**
     * Whether the industry instance can be updated.
     * 
     * @param industry
     * @return true if can update. false if not.
     */
    public static boolean canUpdate(Industry industry) {
        return false;
    }

    /**
     * default constructor, means construct a root industry category.
     */
    public Industry() {
        this(null);
    }

    /**
     * Construct an instance which parent industry is the input parent instance.
     * @param parent the parent industry.
     */
    public Industry(Industry parent) {
        this.parent = parent;
    }
}
