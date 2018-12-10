/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package test.spring.ioc.business;

/**
 * @hibernate.class table="USERS"
 */
public class User {

	private String address;

	private String mobile;

	private Long oid;

	private String password;

	private String phone;

	private String userId;

	private String userName;

	private Integer version;

	public User() {

	}

	/**
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @hibernate.property column="MOBILE" length="11" unsaved-value="null"
	 * 
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @hibernate.id column="OID" unsaved-value="null"
	 *               generator-class="uuid.string"
	 */
	public Long getOid() {
		return oid;
	}

	/**
	 * @hibernate.property column="PASSWORD" length="8" not-null="true"
	 *                     update="false"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @hibernate.property column="PHONE: length="8"
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @hibernate.property column="USER_ID" length="8" not-null="true"
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @hibernate.property column="USER_NAME" length="15" not-null="true"
	 *                     update="false"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @hibernate.version column="VERSION"
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param address
	 *            The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
