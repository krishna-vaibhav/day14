package com.app.beans;

import java.util.Date;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "test")
public class TestBean {
	private Date joinDate;

	public TestBean() {
		
			joinDate = new Date();
		
	}

	public Date getJoinDate() {
		return joinDate;
	}

}
