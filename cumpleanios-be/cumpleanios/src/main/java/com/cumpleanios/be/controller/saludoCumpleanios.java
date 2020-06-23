package com.cumpleanios.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cumpleanios.be.model.Usuario;
import com.cumpleanios.be.service.CumpleaniosService;

@RestController
@RequestMapping(value = "/cumpleanios/")
public class saludoCumpleanios {

	@Autowired
	CumpleaniosService cumpleaniosService;

	@CrossOrigin("*")
	@PostMapping(value = "/get/saludo/")
	public ResponseEntity<Usuario> getSaludoCumpleanios(@RequestBody Usuario usuario) {
		Usuario usuarioProcess = cumpleaniosService.getSaludoCumpleanios(usuario);
		return new ResponseEntity<>(usuarioProcess, HttpStatus.OK);
	}
}
