package com.app.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "hello")
@SessionScoped
public class HelloBean {
	private List<String> names;
	private String message;
	private String imageName;

	public HelloBean() {
		names = Arrays.asList("aa", "bb", "cc");
		message = "Hello JSF";
	}

	public List<String> getNames() {
		return names;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getSayHello()
	{
		return message+" @ "+new Date();
	}

	public String getImageName() {
		return "purpleflowers.png";
	}
	
}
