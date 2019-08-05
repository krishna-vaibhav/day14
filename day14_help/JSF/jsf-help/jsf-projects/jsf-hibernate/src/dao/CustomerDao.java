package dao;

import java.util.List;

import pojos.Customer;

public interface CustomerDao {
	List<Customer> listCustomers();
	Customer validateCustomer(String em,String pass);
	Customer registerCustomer(Customer cust);
	Customer loadCustomer(int id);
}
