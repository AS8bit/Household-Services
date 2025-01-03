package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.SystemLog;

public interface ISystemLogDao extends JpaRepository<SystemLog,Integer> {

	List<SystemLog> findByCustId(int custId);


}
