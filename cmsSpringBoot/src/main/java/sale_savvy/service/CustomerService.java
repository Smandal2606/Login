package sale_savvy.service;

import sale_savvy.entity.Customer;

public interface CustomerService {
	boolean validate(Customer cus);
	String addUser(Customer cus);

}
