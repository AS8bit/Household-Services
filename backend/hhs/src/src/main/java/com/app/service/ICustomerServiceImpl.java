package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.dto.CustomerDTO;
import com.app.exception.AppException;
import com.app.pojos.Customer;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService 
{
	@Autowired
	ICustomerDao icustdao;

	@Override
	public Customer registerCustomer(Customer cust) throws AppException
	{
		if(cust != null)
			return icustdao.save(cust);
		else
			throw new AppException("Invalid data Submitted For Customer registration !!!");
	}

	@Override
	public Customer forgetPassword(Customer cust) throws AppException 
	{	
		return icustdao.findByContactNo(cust.getContactNo());

	}

	@Override
	public Customer save(Customer cust) 
	{		
		return icustdao.save(cust);
	}

	@Override
	public Customer checkEmail(String email) {
		Customer validuser=icustdao.findByEmail(email);
		return validuser;
	}

	public Customer restPass(Customer c, String password) {
		System.out.println("inside userservice");
		System.out.println(c);
		c.setPassword(password);
		Customer persistentUser=icustdao.save(c);
		return persistentUser;

	}

	
}
