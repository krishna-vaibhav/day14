package dao;

import java.util.List;

import org.hibernate.*;

import pojos.Customer;
import static utils.HibernateUtils.*;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> listCustomers() {
		List<Customer> l1 = null;
		Session hs = getFactory().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery("select c from Customer c").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public Customer validateCustomer(String em, String pass) {
		Customer cust = null;
		Session hs = getFactory().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			cust = (Customer) hs
					.createQuery(
							"select c from Customer c where c.email = :em and c.password = :pass")
					.setParameter("em", em).setParameter("pass", pass)
					.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return cust;

	}
	@Override
	public Customer registerCustomer(Customer cust) {
		
		Session hs = getFactory().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			hs.persist(cust);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return cust;
	}

	@Override
	public Customer loadCustomer(int id) {
		Session hs = getFactory().getCurrentSession();
		Customer cust=null;
		Transaction tx = hs.beginTransaction();
		try {
			cust=(Customer)hs.get(Customer.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return cust;
	}
	


}
