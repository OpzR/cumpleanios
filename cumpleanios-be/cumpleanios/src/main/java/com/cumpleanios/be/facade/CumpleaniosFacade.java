package com.cumpleanios.be.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumpleanios.be.business.CumpleaniosBusiness;
import com.cumpleanios.be.model.Usuario;

@Service
public class CumpleaniosFacade {
	
	@Autowired
	CumpleaniosBusiness cumpleaniosBusiness;

	public Usuario getSaludoCumpleanios(Usuario usuario) {
		boolean procesarCumpleanios = cumpleaniosBusiness.validacionCamposMinimos(usuario);
		if (procesarCumpleanios) {
		usuario = cumpleaniosBusiness.getMayuscula(usuario);
		usuario = cumpleaniosBusiness.getEdad(usuario);
		usuario = cumpleaniosBusiness.getPoema(usuario);
		usuario = cumpleaniosBusiness.getFecha(usuario);
		}else {
			usuario = null;
		}
		return usuario;
	}
}
