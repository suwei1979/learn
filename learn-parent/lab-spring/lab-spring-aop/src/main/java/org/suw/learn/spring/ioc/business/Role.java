/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.ioc.business;

/**
 * @author Administrator
 * @hibernate.class table="ROLE"
 */
public class Role {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String description;

    private Long oid;

    private String roleId;

    private String roleName;

    private Integer version;

    public Role() {
    }

    /**
     * @hibernate.property column=DESCRIPTION length="128"
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @hibernate.id column="OID" unsaved-value="null"
     * generator-class="identity"
     */
    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;

    }

    /**
     * @hibernate.property column="ROLE_ID" length="4"
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId The roleId to set.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @hibernate.property column="ROLE_NAME" length="128"
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName The roleName to set.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @hibernate.version column="VERSION"
     */
    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void save() {
        // TODO Auto-generated provider stub
    }

    public void retrieve() {
        // TODO Auto-generated provider stub

    }

    public void delete() {
        // TODO Auto-generated provider stub

    }

}
