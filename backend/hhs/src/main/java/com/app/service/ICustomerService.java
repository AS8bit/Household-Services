package com.app.service;

import com.app.dto.CustomerDTO;
import com.app.exception.AppException;
import com.app.pojos.Customer;

public interface ICustomerService 
{
	Customer registerCustomer(Customer cust) throws AppException;
	
	Customer forgetPassword(Customer cust) throws AppException;

	public Customer save(Customer cust);
	
	public Customer checkEmail(String email);

	CustomerDTO findCustomerByID(int id);
	
	CustomerDTO authenticateCustomer(String email,String password) throws AppException;
}
