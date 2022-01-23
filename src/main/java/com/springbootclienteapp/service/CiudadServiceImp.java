package com.springbootclienteapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootclienteapp.models.entity.Ciudad;
import com.springbootclienteapp.repository.CiudadRepository;

@Service
public class CiudadServiceImp implements ICiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> listaCiudades() {
		return (List<Ciudad>) ciudadRepository.findAll();
	}

}
