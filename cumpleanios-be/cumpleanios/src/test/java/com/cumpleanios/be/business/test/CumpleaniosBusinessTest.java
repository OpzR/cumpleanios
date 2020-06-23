package com.cumpleanios.be.business.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cumpleanios.be.business.CumpleaniosBusiness;
import com.cumpleanios.be.model.Poema;
import com.cumpleanios.be.model.Usuario;
import com.cumpleanios.be.rest.call.PoemaRestCall;

@RunWith(MockitoJUnitRunner.class)
public class CumpleaniosBusinessTest {

	@InjectMocks
	private CumpleaniosBusiness cumpleaniosBusiness;
	
	@Mock
	PoemaRestCall poemaRestCall;

	@Test
	public void getEdad_ConFechaNacimiento_ReturnUsuarioDistintNull() {	
		Usuario usuario = new Usuario();
		usuario.setNacimiento("10-06-1984");		
		Usuario usarioGetEdad = cumpleaniosBusiness.getEdad(usuario);
		assertNotNull(usarioGetEdad);
	}
	
	@Test
	public void getEdad_ConFechaNacimiento_ReturnEdad36Anios() {	
		
		Usuario usuario = new Usuario();
		usuario.setNacimiento("10-06-1984");
		
		Usuario usuario36 = new Usuario();
		usuario36.setEdad("36");
		usuario36.setNacimiento("10-06-1984");
		usuario36.setDiasCumpleanios("353");		
		Usuario usarioGetEdad = cumpleaniosBusiness.getEdad(usuario);		
		assertEquals(usarioGetEdad.getEdad(), usuario36.getEdad());
		
	}
	
	@Test
	public void getMayuscula_NombresEnMayuscula() {	
		Usuario usuario = new Usuario();
		usuario.setApellido("perez");
		usuario.setNombres("oscar");
		Usuario usarioGetEdad = cumpleaniosBusiness.getMayuscula(usuario);	
		assertEquals(usarioGetEdad.getApellido().equals("PEREZ"), usarioGetEdad.getNombres().equals("OSCAR"));	
	}
	
	@Test	
	public void getFecha_FormateoFecha_ddmmyy() {
		String fechaEsperada = "10-06-84";		
		Usuario usuario = new Usuario();
		usuario.setNacimiento("10-06-1984");	
		Usuario usarioGetEdad = cumpleaniosBusiness.getFecha(usuario);	
		assertEquals(usarioGetEdad.getFecha(), fechaEsperada);
	}	
	
	@Test
	public void getPoema_diaCumpleanios_esperoPoema() {		
		List<Poema> poemas = new ArrayList<>();
		Poema poema = new Poema();
		poema.setContent("feliz cumpleanios amigo");
		poemas.add(poema);
		Usuario usuario = new Usuario();
		usuario.setDiasCumpleanios("365");
		Mockito.when(poemaRestCall.getPoemas()).thenReturn(poemas);
		
		
		Usuario usuarioPoema = cumpleaniosBusiness.getPoema(usuario);	
		
		assertNotEquals("Te faltan:", usuarioPoema.getPoema().contains("Te faltan:"));
	}
	
	@Test
	public void getPoema_diaCumpleanios_noEsperoPoema() {	
		List<Poema> poemas = new ArrayList<>();
		Poema poema = new Poema();
		poema.setContent("feliz cumpleanios amigo");
		poemas.add(poema);
		Usuario usuario = new Usuario();
		usuario.setDiasCumpleanios("364");
		Mockito.when(poemaRestCall.getPoemas()).thenReturn(poemas);
		
		
		Usuario usuarioPoema = cumpleaniosBusiness.getPoema(usuario);	
		
		assertNotEquals("Te faltan:", usuarioPoema.getPoema().contains("Te faltan:"));
		
	}
	
	@Test
	public void validacionCamposMinimos_todosLosCampos_returnTrue() {
		Usuario usuario = new Usuario();
		usuario.setNombres("oscar");
		usuario.setApellido("perez");
		usuario.setNacimiento("10-06-1984");
		Boolean validacion = cumpleaniosBusiness.validacionCamposMinimos(usuario);
		assertTrue(validacion);
		
	}
	
	@Test
	public void validacionCamposMinimos_soloCampoNombre_returnFalse() {
		Usuario usuario = new Usuario();
		usuario.setNombres("oscar");		
		Boolean validacion = cumpleaniosBusiness.validacionCamposMinimos(usuario);
		assertFalse(validacion);		
	}
	
	@Test
	public void validacionCamposMinimos_soloCampoApellido_returnFalse() {
		Usuario usuario = new Usuario();
		usuario.setApellido("perez");	
		Boolean validacion = cumpleaniosBusiness.validacionCamposMinimos(usuario);
		assertFalse(validacion);		
	}
	
	@Test
	public void validacionCamposMinimos_soloCampoNacimiento_returnFalse() {
		Usuario usuario = new Usuario();
		usuario.setNacimiento("10-06-1984");
		Boolean validacion = cumpleaniosBusiness.validacionCamposMinimos(usuario);
		assertFalse(validacion);		
	}
	
}
