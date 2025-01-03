package com.app.service;

import java.util.List;

import com.app.dto.AdminDTO;
import com.app.dto.CustomerDTO;
import com.app.dto.ServiceProviderDTO;
import com.app.exception.AppException;
import com.app.pojos.ServiceProvider;

public interface IAdminService 
{
	AdminDTO getAdminDetails(String email,String password) throws Exception;

	List<ServiceProviderDTO> getAllServiceProviders();

	ServiceProviderDTO saveServiceProvider(ServiceProvider vendor) throws AppException;

	List<CustomerDTO> getAllCustomers(); 
	
}
