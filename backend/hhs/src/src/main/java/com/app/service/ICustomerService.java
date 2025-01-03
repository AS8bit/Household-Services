package com.app.service;

import com.app.exception.AppException;
import com.app.pojos.Customer;

public interface ICustomerService 
{
	Customer registerCustomer(Customer cust) throws AppException;
	
	Customer forgetPassword(Customer cust) throws AppException;

	public Customer save(Customer cust);
	
	public Customer checkEmail(String email);


}
