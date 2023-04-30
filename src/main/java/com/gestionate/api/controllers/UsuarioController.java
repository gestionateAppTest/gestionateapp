package com.gestionate.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionate.api.dto.UsuarioDTO;
import com.gestionate.api.services.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuario){
		return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
	};
	
	@GetMapping
	public List<UsuarioDTO> obtenerTodosUsuarios(){
		return usuarioService.obtenerTodosUsuarios();
	}

}
