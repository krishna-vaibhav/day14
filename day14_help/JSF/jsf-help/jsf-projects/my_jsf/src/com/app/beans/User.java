package com.app.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean //default scope = request
public class User {
	private String name;
	//Form of setter based D.I -- injecting other adr bean ref. MUST supply setter.
	@ManagedProperty(value="#{address}")
	private Address adr;
	public User() {
		System.out.println("in user constr");//First called
	}
	@PostConstruct
	public void init() //Third @postconstruct
	{
		System.out.println("in user init "+adr);
	}
	@PreDestroy
	public void destroy() //called at end : rendering response
	{
		System.out.println("in user destroy "+adr);
	}
	public String registerMe()
	{
		System.out.println("in register me ");
		return "registered";
	}
	public String getName() {
		System.out.println("in get nm");
		return name;
	}
	public void setName(String name) {
		System.out.println("set name");
		this.name = name;
	}
	public Address getAdr() {
		System.out.println("get adr");
		return adr;
	}
	public void setAdr(Address adr) { //second : D.I via setter
		System.out.println("set adr");
		this.adr = adr;
	}
	

}
