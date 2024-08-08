package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> 
{
	
}
