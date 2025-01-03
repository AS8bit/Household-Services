package com.app.service;

import java.util.List;

import com.app.pojos.ServiceProvider;

public interface IServiceProviderService {

	List<ServiceProvider> findByServiceType(String serviceType) throws Exception;

	ServiceProvider findById(int vid);
	
}
