package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IServiceProviderDao;
import com.app.pojos.ServiceProvider;

@Service
@Transactional
public class IServiceProviderServiceImpl implements IServiceProviderService{

	
	@Autowired
	IServiceProviderDao spdao;
	
	
	@Override
	public List<ServiceProvider> findByServiceType(String serviceType) throws Exception {
		// TODO Auto-generated method stub
		return spdao.findByServiceType(serviceType);
	}


	@Override
	public ServiceProvider findById(int vendId) {
		// TODO Auto-generated method stub
		return spdao.findById(vendId).get();
	}

	
}
