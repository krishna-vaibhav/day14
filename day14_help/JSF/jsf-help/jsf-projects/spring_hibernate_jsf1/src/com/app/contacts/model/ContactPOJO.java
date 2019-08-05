package com.app.contacts.model;

import java.util.Date;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "dac2_contacts")
public class ContactPOJO {

	private Integer id;
	private String email;

	private String password;
	private double regAmount;
	private Date regDate;

	private String role;
	private Address addr;

	public ContactPOJO() {
		System.out.println("contact pojo constr");
		email = "valid email";
		regAmount = 500;
	}

	public ContactPOJO(String email, String password, double regAmount,
			Date regDate, String role) {
		super();
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	@Column(length = 20, unique = true)
	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Id
	@SequenceGenerator(name = "my_gen", sequenceName = "my_seq")
	@GeneratedValue(generator = "my_gen")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10)
	public String getRole() {
		System.out.println("in get role");
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// one--one --uni-directional
	@OneToOne(cascade = CascadeType.ALL)
	// mandatory
	@JoinColumn(name = "addr_id")
	// optional
	public Address getAddr() {
	//	System.out.println("in get adr");
		return addr;
	}

	public void setAddr(Address addr) {
//		System.out.println("in set adr");
		this.addr = addr;
	}

	@Override
	public String toString() {
		String adrInfo = addr == null ? "" : addr.toString();

		return "Contact Details id=" + id + ", email=" + email + ", password="
				+ password + ", regAmount=" + regAmount + ", regDate="
				+ regDate + ", role=" + role + " " + adrInfo;
	}

}
