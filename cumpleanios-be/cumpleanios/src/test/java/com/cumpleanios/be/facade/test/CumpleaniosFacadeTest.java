package com.cumpleanios.be.facade.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cumpleanios.be.business.CumpleaniosBusiness;
import com.cumpleanios.be.facade.CumpleaniosFacade;
import com.cumpleanios.be.model.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class CumpleaniosFacadeTest {

	@InjectMocks
	private CumpleaniosFacade cumpleaniosFacade;
	
	@Mock
	CumpleaniosBusiness cumpleaniosBusiness;
	
	
	@Test
	public void getSaludoCumpleaniosFacade_TodoslosCmapos_notNull() {
		Boolean validacion = Boolean.TRUE;
		Usuario usuario = new Usuario();
		usuario.setNombres("oscar");
		usuario.setApellido("perez");
		usuario.setNacimiento("10-06-1984");
		Mockito.when(cumpleaniosBusiness.validacionCamposMinimos(usuario)).thenReturn(validacion);
		Mockito.when(cumpleaniosBusiness.getMayuscula(usuario)).thenReturn(usuario);
		Mockito.when(cumpleaniosBusiness.getEdad(usuario)).thenReturn(usuario);
		Mockito.when(cumpleaniosBusiness.getPoema(usuario)).thenReturn(usuario);
		Mockito.when(cumpleaniosBusiness.getFecha(usuario)).thenReturn(usuario);
		
		Usuario usuarioResponse = cumpleaniosFacade.getSaludoCumpleanios(usuario);
		assertNotNull(usuarioResponse);		
	}
	
	@Test
	public void getSaludoCumpleaniosFacade_SoloCampoNombre_null() {
		Boolean validacion = Boolean.FALSE;
		Usuario usuario = new Usuario();
		usuario.setNombres("oscar");
		
		Mockito.when(cumpleaniosBusiness.validacionCamposMinimos(usuario)).thenReturn(validacion);
		Mockito.when(cumpleaniosBusiness.getMayuscula(usuario)).thenReturn(usuario);
		Mockito.when(cumpleaniosBusiness.getEdad(usuario)).thenReturn(usuario);
		Mockito.when(cumpleaniosBusiness.getPoema(usuario)).thenReturn(usuario);
		Mockito.when(cumpleaniosBusiness.getFecha(usuario)).thenReturn(usuario);
		
		Usuario usuarioResponse = cumpleaniosFacade.getSaludoCumpleanios(usuario);
		assertNull(usuarioResponse);		
	}
	
}
