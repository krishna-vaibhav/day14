package com.app.beans;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.app.model.Customer;

@ApplicationScoped
@ManagedBean(name="cust_service",eager=true)
public class CustomerServiceBean {
	private HashMap<Integer,Customer> custs;
	@PostConstruct
	public void init()
	{
		System.out.println("in service init");
		custs=new HashMap<>();
		custs.put(123, new Customer(123, "abc#123", 10000));
		custs.put(200, new Customer(200, "def#123", 20000));
	}
	public Customer verifyCustomer(Customer c)
	{
		int id=c.getId();
		if (custs.containsKey(id))
			if(custs.get(id).getPass().equals(c.getPass()))
				return custs.get(id);
		return null;
	}
	
	

}
