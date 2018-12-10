/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.ioc.business;

/**
 * @hibernate.class table="ROLE"
 * 
 * @author Administrator
 * 
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
	 * @hibernate.id column="OID" unsaved-value="null"
	 *               generator-class="identity"
	 */
	public Long getOid() {
		return this.oid;
	}

	/**
	 * @hibernate.property column="ROLE_ID" length="4"
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @hibernate.property column="ROLE_NAME" length="128"
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @hibernate.version column="VERSION"
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * @param description
	 *            The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void setOid(Long oid) {
		this.oid = oid;

	}

	/**
	 * @param roleId
	 *            The roleId to set.
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @param roleName
	 *            The roleName to set.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
