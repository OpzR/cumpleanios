package com.cumpleanios.be.business;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumpleanios.be.model.Poema;
import com.cumpleanios.be.model.Usuario;
import com.cumpleanios.be.rest.call.PoemaRestCall;

@Service
public class CumpleaniosBusiness {

	@Autowired
	PoemaRestCall poemaRestCall;

	public Usuario getEdad(Usuario usuario) {

		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate hoy = LocalDate.now();
		LocalDate fechaNacimiento = LocalDate.parse(usuario.getNacimiento(), formatoFecha);
		LocalDate proximoCumpleanios = fechaNacimiento.withYear(hoy.getYear());

		if (proximoCumpleanios.isBefore(hoy) || proximoCumpleanios.isEqual(hoy)) {
			proximoCumpleanios = proximoCumpleanios.plusYears(1);
		}

		Period periodo = Period.between(fechaNacimiento, LocalDate.now());
		long totalDias = ChronoUnit.DAYS.between(hoy, proximoCumpleanios);

		usuario.setEdad(Integer.toString(periodo.getYears()));
		usuario.setDiasCumpleanios(Integer.toString((int) totalDias));

		return usuario;
	}

	public Usuario getPoema(Usuario usuario) {
		if (usuario.getDiasCumpleanios().equalsIgnoreCase("365")) {
			Random random = new Random();
			List<Poema> poemas = poemaRestCall.getPoemas();
			Poema poema = poemas.get(random.nextInt(poemas.size()));
			usuario.setPoema(poema.getContent().replace("\n", ""));
		} else {
			usuario.setPoema("Te faltan: " + usuario.getDiasCumpleanios() + " días para tu cumpleaños.");
		}
		return usuario;
	}

	public Usuario getMayuscula(Usuario usuario) {
		usuario.setNombres(usuario.getNombres().toUpperCase());
		usuario.setApellido(usuario.getApellido().toUpperCase());
		return usuario;
	}

	public Usuario getFecha(Usuario usuario) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(usuario.getNacimiento(), formatoFecha);
		usuario.setFecha(fechaNacimiento.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		return usuario;
	}

	public boolean validacionCamposMinimos(Usuario usuario) {
		boolean validacion = false;
		if (null != usuario.getNombres() && null != usuario.getApellido() && null != usuario.getNacimiento()) {
			validacion = true;
		} else {
			validacion = false;
		}
		return validacion;
	}

}
