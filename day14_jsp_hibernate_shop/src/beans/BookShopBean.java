package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import dao.BookShopDaoImpl;
import pojos.Book;
import pojos.Customer;

public class BookShopBean {
	// props -- clnt' conv state
	private String email, pass;
	private String category;
	private int[] bkId;
	// dao
	private BookShopDaoImpl dao;
	// validated customer details
	private Customer validCust;
	// store user's cart
	private ArrayList<Integer> shoppingCart;
	// status mesg
	private String status;
	// total cart value
	private double total;

	// constr
	public BookShopBean() throws Exception {// TODO Auto-generated constructor
											// stub
		// dao inst
		dao = new BookShopDaoImpl();
		System.out.println("jb constr");
	}

	// s/g
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("in set email");
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		System.out.println("in set pass");
		this.pass = pass;
	}

	public BookShopDaoImpl getDao() {
		return dao;
	}

	public void setDao(BookShopDaoImpl dao) {
		this.dao = dao;
	}

	public Customer getValidCust() {
		return validCust;
	}

	public void setValidCust(Customer validCust) {
		this.validCust = validCust;
	}

	public String getStatus() {
		return status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int[] getBkId() {
		return bkId;
	}

	public void setBkId(int[] bkId) {
		System.out.println("in set bkid");
		this.bkId = bkId;
	}

	public double getTotal() {
		return total;
	}

	public ArrayList<Integer> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ArrayList<Integer> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// B.L method --for customer validation
	// rets navigational outcome --dynamic
	public String validateCustomer() throws Exception {
		System.out.println("in jb : validate");
		try {
			validCust = dao.validateCustomer(email, pass);
		} catch (NoResultException e) {
			System.out.println("no results " + e);
			status = "Invalid Login , Pls retry";
			return "login";
		}

		// valid login
		status = "Login Successful!!!!!";
		System.out.println("valid login...");
		// create an empty cart
		shoppingCart = new ArrayList<>();
		return "category";
	}

	public List<String> fetchCategories() throws Exception {
		return dao.getAllCategories();
	}

	// B.L method to ret selected bks by chosen category
	public List<Book> getBooks() throws Exception {
		return dao.getBoookByCategory(category);
	}

	// B.L to populate the cart
	public String populateCart() throws Exception {
		System.out.println("in jb : populate cart");
		for (int id : bkId)
			shoppingCart.add(id);// auto boxing
		System.out.println("cart " + shoppingCart);
		return "category";
	}

	// B.L to fetch cart details
	public List<Book> fetchCartDetails() throws Exception {
		// create empty AL <Book>
		List<Book> bks = null;
		total = 0;

		// invoke dao's method to get bk details directly in form of List<Book>

		bks = dao.getBooksById(shoppingCart);
		for (Book b : bks)
			total += b.getPrice();

		return bks;
	}

}
