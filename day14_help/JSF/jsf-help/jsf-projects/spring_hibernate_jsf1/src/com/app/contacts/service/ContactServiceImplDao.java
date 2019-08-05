package com.app.contacts.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.contacts.dao.ContactDAO;
import com.app.contacts.model.ContactPOJO;

@Service("contact_service_dao")
@Transactional//tell SC to auto manage txs-- tx scope will begin auto ---
//service layer method is invoked --- by controller -- tx will be committed if-- 
//service method doesnt throw any un-chked exc ---default 
public class ContactServiceImplDao implements ContactService {
	@Autowired
	private ContactDAO dao;
	public ContactServiceImplDao() {
		System.out.println("in dao based service constr...");
	}

	@Override
//	@Transactional(timeout=100)
	public ContactPOJO registerContact(ContactPOJO c) {
		
		return dao.registerContact(c);
	}

	@Override
	@Transactional(readOnly=true)
	public ContactPOJO validateContact(ContactPOJO c) {
		
		return dao.validateContact(c);
	}

	@Transactional(readOnly=true)
	@Override
	public List<ContactPOJO> viewAllContacts() {
		List<ContactPOJO> c=dao.viewAllContacts();
		System.out.println("in service "+c);
		return c;
	}

	@Override
	public ContactPOJO updateAddress(ContactPOJO c) {
		
		return dao.updateAddress(c);
	}

	@Override
	public ContactPOJO unsubscribeContact(int id) {
		
		return dao.unsubscribeContact(id);
	}
	
	
	

}
