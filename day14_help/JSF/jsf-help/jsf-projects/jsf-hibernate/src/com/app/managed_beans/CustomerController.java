package com.app.managed_beans;

import javax.faces.bean.ManagedBean;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import pojos.Customer;

@ManagedBean(name = "cust_controller")
public class CustomerController {
	private Customer cust = new Customer(), validCust;
	private String status;
	private CustomerDao service = new CustomerDaoImpl();

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Customer getValidCust() {
		return validCust;
	}

	public String validateCustomer() {
		status = "Login Failed, pls retry";

		System.out.println("in validate b.l " + cust);
		try {
			validCust = service.validateCustomer(cust.getEmail(),
					cust.getPassword());
			if (validCust != null) {
				status = "Successful Login.";
				return "valid";
			}
		} catch (Exception e) {
			System.out.println(e);
			status = status.concat(" reason " + e.getCause().getMessage());
		}

		return "login";
	}

	public String registerCustomer() {
		status = "Registration Failed, pls retry";

		System.out.println("in reg  b.l " + cust);
		try {
			validCust = service.registerCustomer(cust);
			if (validCust != null) {
				status = "Successful Registration";
				// return "valid"; --via def forward
				// PRG
				return "display_customer1?faces-redirect=true&includeViewParams=true";
			}
		} catch (Exception e) {
			System.out.println(e);
			status = status.concat(" reason " + e.getCause().getMessage());
		}

		return "register";
	}

	public void loadCustomer() {
		validCust = service.loadCustomer(cust.getId());
	}

	public String getStatus() {
		return status;
	}

}
