package com.springbootclienteapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.springbootclienteapp.models.entity.Ciudad;

public interface CiudadRepository extends CrudRepository<Ciudad, Long> {
	
}
