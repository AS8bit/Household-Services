package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminRepo;
import com.app.dao.ICustomerDao;
import com.app.dao.IServiceProviderDao;
import com.app.dto.AdminDTO;
import com.app.dto.CustomerDTO;
import com.app.dto.ServiceProviderDTO;
import com.app.exception.AppException;
import com.app.pojos.Admin;
import com.app.pojos.ServiceProvider;

@Service
@Transactional
public class AdminImpl implements IAdminService
{
	@Autowired
	IAdminRepo adminrepo;
	
	@Autowired
	IServiceProviderDao serviceProvider;
	
	@Autowired
	ICustomerDao customer;
	
	@Override
	public AdminDTO getAdminDetails(String email, String password) throws Exception
	{
		Admin a = adminrepo.findByemail(email);
		AdminDTO aDto = null;
		if(a!=null)
		{
			if(a.getPassword().equals(password))
			{
				aDto = new AdminDTO();
				BeanUtils.copyProperties(a, aDto, "password");
			}
			else
				throw new AppException("Invalid Details!");
		}
		else
			throw new AppException("Invalid Details!");
		return aDto;
	}

	@Override
	public List<ServiceProviderDTO> getAllServiceProviders() {
		List<ServiceProviderDTO> list = new ArrayList<>();
		serviceProvider.findAll().forEach(s -> {
			ServiceProviderDTO dto = new ServiceProviderDTO();
			BeanUtils.copyProperties(s, dto);
			list.add(dto);
		});
		return list;
	}

	private boolean validateRegistrationData(ServiceProvider vendor) throws AppException
	{

		if( 	vendor.getFirstName() != null && vendor.getLastName() != null &&
				vendor.getServiceType() != null && vendor.getServiceCost() != null &&
				vendor.getEmail() != null && vendor.getContactNo() != null &&
				vendor.getExperience() != null && vendor.getRating() != null	)
		{
			String regExEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			boolean isValidEmail = vendor.getEmail().matches(regExEmail);
			
			String regExContact = "(0/91)?[7-9][0-9]{9}";
			boolean isValidContact = vendor.getContactNo().matches(regExContact);
			
			if( !isValidEmail )
				throw new AppException("Enter valid Email Address");
			
			if( !isValidContact )
				throw new AppException("Enter valid Contact Number");
		}
		else
		{
			throw new AppException("Fields can not be empty");
		}
		
		return true;
	}
	
	@Override
	public ServiceProviderDTO saveServiceProvider(ServiceProvider vendor) throws AppException {
		if(validateRegistrationData(vendor))
		{
			ServiceProvider persistnceser = serviceProvider.save(vendor);
			
			ServiceProviderDTO serdto = new ServiceProviderDTO();
			BeanUtils.copyProperties(persistnceser, serdto);
			return serdto;
		}
		
		throw new AppException("Invalid Vendor data !!!");
		
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> list = new ArrayList<>();
		customer.findAll().forEach(c -> {
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(c, dto);
			list.add(dto);
		});
		return list;
	}

}
