package com.app.contacts.service;

import java.util.Collection;
import java.util.List;

import com.app.contacts.model.ContactPOJO;

public interface ContactService {
	ContactPOJO registerContact(ContactPOJO c);// i/p --no id , o/p --valid --id
												// generated

	ContactPOJO validateContact(ContactPOJO c);// i/p ---email & pass, o/p ---
												// complete details including id
	List<ContactPOJO> viewAllContacts();
	ContactPOJO updateAddress(ContactPOJO c);
	ContactPOJO unsubscribeContact(int id);
}
