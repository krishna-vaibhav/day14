package managed_beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@ManagedBean(name ="bank")
@SessionScoped
public class BankController {
	@ManagedProperty(value = "#{cust_service}")
	private CustomerService service;
	@ManagedProperty(value = "#{customer}")
	private Customer custModel;
	private Customer validCust;

	// B.L method
	public String validateUser() {
		validCust = service.validateCustomer(custModel.getId(),
				custModel.getPass());
		return "result";
	}

	public CustomerService getService() {
		return service;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}

	public Customer getCustModel() {
		return custModel;
	}

	public void setCustModel(Customer custModel) {
		this.custModel = custModel;
	}

	public Customer getValidCust() {
		return validCust;
	}

	public void setValidCust(Customer validCust) {
		this.validCust = validCust;
	}

}
