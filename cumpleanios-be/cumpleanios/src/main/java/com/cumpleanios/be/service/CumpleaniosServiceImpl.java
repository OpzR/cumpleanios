package com.cumpleanios.be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumpleanios.be.facade.CumpleaniosFacade;
import com.cumpleanios.be.model.Usuario;

@Service
public class CumpleaniosServiceImpl implements CumpleaniosService{
	
	@Autowired
	CumpleaniosFacade cumpleaniosFacade;

	@Override
	public Usuario getSaludoCumpleanios(Usuario usuario) {		
		return cumpleaniosFacade.getSaludoCumpleanios(usuario);
	}
	
}
