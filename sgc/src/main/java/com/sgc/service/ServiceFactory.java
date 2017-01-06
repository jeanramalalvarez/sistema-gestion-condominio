package com.sgc.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

@Named
public class ServiceFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@Inject
	public SeguridadService seguridadService;
	
	@Inject
	public ConfiguracionService configuracionService;

}
