package dao;

import java.util.List;

import pojos.Book;
import pojos.Customer;

public interface BookShopDao {
	Customer validateCustomer(String email, String password) ;

	List<String> getAllCategories() ;

	List<Book> getBoookByCategory(String category) ;

	List<Book> getBooksById(List<Integer> cart) ;

}
