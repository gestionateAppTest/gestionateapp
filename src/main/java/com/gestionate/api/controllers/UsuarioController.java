package com.gestionate.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public List<UsuarioDTO> obtenerTodosUsuarios(){
		return usuarioService.obtenerTodosUsuarios();
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuario){
		return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> obtenerUsuarioById(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(usuarioService.obtenerUsuarioById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable(name = "id") long id ){
		UsuarioDTO usuarioRespuesta = usuarioService.actualizarUsuario(usuarioDTO, id);
		return new ResponseEntity<>(usuarioRespuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "id") long id){
		usuarioService.eliminarUsuario(id);
		return new ResponseEntity<>("Usuario Eliminado con exito",HttpStatus.OK);
	}
}
