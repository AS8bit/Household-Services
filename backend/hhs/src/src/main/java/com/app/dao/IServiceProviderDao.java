package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.ServiceProviderDTO;
import com.app.pojos.ServiceProvider;

public interface IServiceProviderDao extends JpaRepository<ServiceProvider, Integer> {

	
	

	
}
