package com.app.managed_beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="stud")
public class Student {
	private String firstName,lastName,pass,country,language;
	private List<String> chosenTechno;
	public Student() {
		System.out.println("stud constr");
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPass() {
		System.out.println("get "+pass);
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
		System.out.println("set "+pass);
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getChosenTechno() {
		return chosenTechno;
	}
	public void setChosenTechno(List<String> chosenTechno) {
		this.chosenTechno = chosenTechno;
	}
	
	
	
	
	

}
