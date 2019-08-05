package com.app.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
//@SessionScoped
public class Customer implements Serializable {
	private Integer id;
	private String pass;
	private double balance;
	public Customer() {
		System.out.println("cust constr");
	}
	
	public Customer(Integer id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}

	public Integer getId() {
		System.out.println("get id");
		return id;
	}
	public void setId(Integer id) {
		System.out.println("set id");
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pass=" + pass + ", balance=" + balance
				+ "]";
	}
	

}
