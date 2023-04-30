package com.gestionate.api.services;

import java.util.List;

import com.gestionate.api.dto.UsuarioDTO;

public interface UsuarioService {

	public UsuarioDTO crearUsuario( UsuarioDTO usuario);
	
	public List<UsuarioDTO> obtenerTodosUsuarios();
	
}
