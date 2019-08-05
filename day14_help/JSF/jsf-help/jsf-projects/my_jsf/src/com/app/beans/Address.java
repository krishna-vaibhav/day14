package com.app.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean

public class Address {
	private String country;

	public String getCountry() {
		System.out.println("get co");
		return country;
	}

	public void setCountry(String country) {
		System.out.println("set co");
		this.country = country;
	}
	

}
