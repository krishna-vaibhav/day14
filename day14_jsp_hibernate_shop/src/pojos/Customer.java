package pojos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="my_customers")
public class Customer {
	private Integer id;
	private double regAmount;
	private String email,name,pass;
	private Date regDate;
	private String role;
	public Customer() {
		System.out.println("in cust constr");
	}
	public Customer(int id, double regAmount, String email, String name, String pass, Date regDate, String role) {
		super();
		this.id = id;
		this.regAmount = regAmount;
		this.email = email;
		this.name = name;
		this.pass = pass;
		this.regDate = regDate;
		this.role = role;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="deposit_amt")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name="reg_date")
	@Temporal(TemporalType.DATE)
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", regAmount=" + regAmount + ", email=" + email + ", name=" + name + ", pass="
				+ pass + ", regDate=" + regDate + ", role=" + role + "]";
	}
	
	

}
