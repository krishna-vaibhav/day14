package com.app.service;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.app.pojos.Customer;

@ManagedBean(name = "cust_service", eager = true)
@ApplicationScoped
public class CustomerService {
	private HashMap<Integer, Customer> custs;

	public CustomerService() {
		System.out.println("in service constr");
	}

	@PostConstruct
	public void init() {
		custs = new HashMap<>();
		custs.put(150, new Customer(150, "abc#123", 10000));
		custs.put(200, new Customer(200, "def#123", 12000));
	}

	public Customer validateCustomer(int id, String pass) {
		if (custs.containsKey(id)) {
			Customer c = custs.get(id);
			if (c.getPass().equals(pass))
				return c;
		}
		return null;
	}

}
