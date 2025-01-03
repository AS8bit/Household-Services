package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDTO;
import com.app.dto.ResponseDTO;
import com.app.dto.ServiceProviderDTO;
import com.app.exception.AppException;
import com.app.pojos.Admin;
import com.app.pojos.ServiceProvider;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController 
{
	@Autowired
	private IAdminService adminServices;
	
	@GetMapping("/AllVendors")
	public ResponseEntity<?> getAllVendors(){
		List<ServiceProviderDTO> li =null;
		li = adminServices.getAllServiceProviders();
		
		if(li.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
	@PostMapping("/AddVendor")
	public ResponseEntity<?> addServiceProvider(@RequestBody ServiceProvider vendor) throws AppException
	{
		try {
			ServiceProviderDTO isRegistered = adminServices.saveServiceProvider(vendor);
			if(isRegistered!= null)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				throw new AppException("Invalid Registration Of Service Provider!!!");
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/AllCustomers")
	public ResponseEntity<?> getAllCustomers()
	{
		List<CustomerDTO> li = null;
		li = adminServices.getAllCustomers();
		
		if(li.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(li,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> getUserDetails(@RequestBody Admin ad)
	{
		System.out.println("in get user dtls " + ad.getEmail()+ad.getPassword());
		try
		{
			return ResponseEntity.ok(new ResponseDTO<>(adminServices.getAdminDetails(ad.getEmail(), ad.getPassword())));
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(new ResponseDTO<>("Invalid email and password"), HttpStatus.NOT_FOUND);
		}
	}
	
	
}
