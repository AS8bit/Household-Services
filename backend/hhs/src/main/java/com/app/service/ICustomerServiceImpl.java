package com.app.service;

import org.springframework.beans.BeanUtils;
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

	@Override
	public CustomerDTO findCustomerByID(int id) 
	{
		Customer cust;
		try {
			cust = icustdao.findById(id).orElseThrow(() -> new AppException("invalid customer id"));
			CustomerDTO custdto =new CustomerDTO();
			BeanUtils.copyProperties(cust, custdto, "password");
			return custdto;
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public CustomerDTO authenticateCustomer(String email, String password) throws AppException 
	{
		
		Customer isAvailable = null;
		CustomerDTO cdto = null;
		if(email != null && password != null)
			isAvailable = icustdao.findByEmailAndPassword(email,password);
		else
			throw new AppException("Credentials can't be Empty!!!");
		
		if(isAvailable !=null)
		{
			if(isAvailable.getPassword().equals(password)) 
			{
				cdto=new CustomerDTO();
				BeanUtils.copyProperties(isAvailable, cdto, "password");
			}
			else 
			{
				throw new AppException("invalid details");
			}
		}
		else 
		{
			throw new AppException("No Such Customer Exist");
		}
		return cdto;
	}
}
