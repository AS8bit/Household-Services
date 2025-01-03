package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.AdminDTO;
import com.app.dto.CustomerDTO;
import com.app.dto.ServiceProviderDTO;
import com.app.exception.AppException;
import com.app.pojos.Customer;
import com.app.pojos.ServiceProvider;

public interface IAdminService 
{
	AdminDTO getAdminDetails(String email,String password) throws Exception;

	List<ServiceProviderDTO> getAllServiceProviders();

	ServiceProviderDTO saveServiceProvider(ServiceProvider vendor) throws AppException;

	List<CustomerDTO> getAllCustomers();

	Optional<Customer> findCustById(int id);

	Optional<ServiceProvider> findById(int id);

	String deleteServiceProviderByID(int id) throws AppException;
	
	String deleteCustomerByID(int id) throws AppException;
	
	ServiceProviderDTO updateServiceProvider(int id,ServiceProviderDTO ser) throws AppException;
	
}
