package com.cumpleanios.be.model;

import java.io.Serializable;

/**
 * @author operezro
 *
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 6125588406580953113L;

	private String nombres;
	private String apellido;
	private String nacimiento;
	private String edad;
	private String diasCumpleanios;
	private String poema;
	private String fecha;
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getDiasCumpleanios() {
		return diasCumpleanios;
	}
	public void setDiasCumpleanios(String diasCumpleanios) {
		this.diasCumpleanios = diasCumpleanios;
	}
	public String getPoema() {
		return poema;
	}
	public void setPoema(String poema) {
		this.poema = poema;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
