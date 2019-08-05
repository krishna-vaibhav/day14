package dao;

import java.util.List;
import org.hibernate.*;
import static utils.HibernateUtils.*;

import pojos.Book;
import pojos.Customer;

public class BookShopDaoImpl implements BookShopDao {

	@Override
	public Customer validateCustomer(String email1, String password1) {
		Customer c = null;
		String jpql = "select c from Customer c where c.email = :em and c.pass = :pa";
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.createQuery(jpql, Customer.class).setParameter("em", email1).setParameter("pa", password1)
					.getSingleResult();
			// c --- PERSISTENT
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return c;
	}

	@Override
	public List<String> getAllCategories() {
		List<String> l1 = null;
		String jpql = "select distinct b.category from Book b";
		// hs
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, String.class).getResultList();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public List<Book> getBoookByCategory(String category123) {
		String jpql = "select new Book(bookId,title,author,price) from Book b where b.category=:cat1";
		List<Book> l1 = null;
		// hs
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Book.class).setParameter("cat1", category123).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public List<Book> getBooksById(List<Integer> cart) {
		List<Book> l1 = null;
		String jpql = "select new Book(bookId,title,author,price) from Book b where b.bookId in (:ids)";
		// hs
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Book.class).
					setParameterList("ids", cart).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

}
