package org.suw.learn.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.suw.learn.validate.beanvalidate.constraints.ZipCode;

@Component
public class Item {
	@NotNull(message="validate.notnull.item.message")
	private String name;
	private int price;
	
	@NotNull
	@ZipCode(countryCode = "CN")
	private String zipCode;
	
	@ZipCode(countryCode = "US")
	private String zipCode2;
	
	public String getName() {
		return name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
