package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ResponseDTO;
import com.app.exception.AppException;
import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController
{
	@Autowired
	ICustomerService icust;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerWithCustomer(@RequestBody Customer customer) throws AppException
	{
		try 
		{
			Customer cust = icust.registerCustomer(customer);
			if(cust != null)
				return new ResponseEntity<>(HttpStatus.OK);
			else 
				throw new AppException("Invalid Customer Registration Data!!");
		} 
		catch (RuntimeException e) 
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<?> forgetUserPassword(@RequestBody Customer cust)
	{
		System.out.println(cust);
		try 
		{
			Customer validateuser=icust.forgetPassword(cust);
			validateuser.setPassword(cust.getPassword());
			icust.save(validateuser);
			return new ResponseEntity<>(validateuser,HttpStatus.OK);
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(new ResponseDTO<>("Invalid email and password"), HttpStatus.NOT_FOUND);
		}
	}
}
