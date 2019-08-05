package com.app.managed_beans;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.app.contacts.model.ContactPOJO;
import com.app.contacts.service.ContactService;

@Component("cust")
//@ManagedBean//(name="cust")
@Scope("session")
//@ViewScoped
public class CustomerController {
	@Autowired
	@Qualifier("contact_service_dao")
	private ContactService service;
	// @Autowired
	private ContactPOJO contact=new ContactPOJO();
	private List<ContactPOJO> contacts;
	public CustomerController() {
		System.out.println("!!!!!!in cust controller constr!!!!!!!!!");
	}

	/*@PostConstruct
	public void init() {
		System.out
				.println("in init cust controller" + service + "  " + contact);
		contact = new ContactPOJO();
	}*/

	public String viewContacts() {
		System.out.println("in view contacts....: controller "+contact);

		// System.out.println(c);
		contacts = service.viewAllContacts();/*
											 * Arrays.asList(new
											 * ContactPOJO(),new ContactPOJO());
											 */
		return "index1";
		// return null;
	}

	public String registerContact() {
		System.out.println("in reg contacts....: controller " + contact);
		// contact.setRegDate(new Date());
		ContactPOJO con = service.registerContact(contact);
		//MUST clear contact
		 contact=new ContactPOJO();
		System.out.println(con);
		// contacts=service.viewAllContacts();
		// redirect
		return "index1?faces-redirect=true";// "user_registered";
	}

	public String deleteContact(int id) {
//		int id=1;
		System.out.println("in del contacts controller " +contact);
		service.unsubscribeContact(id);
		System.out.println("in del contacts controller " +contact);
		return "index1?faces-redirect=true";// "user_registered";
	}

	public ContactPOJO getContact() {
		return contact;
	}

	public void setContact(ContactPOJO contact) {
		this.contact = contact;
	}

	public List<ContactPOJO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactPOJO> contacts) {
		this.contacts = contacts;
	}
}
