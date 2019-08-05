package com.app.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.app.model.Customer;

@ManagedBean
// @SessionScoped
public class BankController {
	@ManagedProperty(value = "#{customer}")
	private Customer cust;
	@ManagedProperty(value = "#{cust_service}")
	private CustomerServiceBean service;
	private Customer validCust;

	private String mesg;

	public BankController() {
		System.out.println("in bank constr");
	}

	public Customer getCust() {
		System.out.println("in get cust");
		return cust;
	}

	public void setCust(Customer cust) {
		System.out.println("in set cust");
		this.cust = cust;
	}

	public CustomerServiceBean getService() {
		return service;
	}

	public void setService(CustomerServiceBean service) {
		this.service = service;
	}

	public String check() {
		System.out.println("in check " + cust);
		validCust = service.verifyCustomer(cust);
/*		System.out.println("in check "
				+ FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap());
*/		if (validCust != null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("valid_cust", validCust);
			return "success";
		}
		return "login_failed";
	}

	public void test(ActionEvent e) {
		System.out.println("Event Source " + e.getComponent());
	}

	public String show() {
		System.out.println("in show");
		return "test_listener";
	}

	public String logout() {
		System.out.println("in log out "
				+ FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap());
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		//System.out.println("bef logout valid cust info ");
		return "/index.xhtml?faces-redirect=true";
	}

	public Customer getValidCust() {
		return validCust;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

}
