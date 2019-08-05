package com.app.contacts.dao;

import java.util.Collection;
import java.util.List;

import com.app.contacts.model.ContactPOJO;

public interface ContactDAO {
	ContactPOJO registerContact(ContactPOJO c);

	ContactPOJO validateContact(ContactPOJO c);

	List<ContactPOJO> viewAllContacts();
	
	ContactPOJO updateAddress(ContactPOJO c);
	
	ContactPOJO unsubscribeContact(int id);
	
	ContactPOJO getDetails(int id);
	

}
