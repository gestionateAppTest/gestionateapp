package com.gestionate.api.services;

import java.util.List;

import com.gestionate.api.dto.UsuarioDTO;

public interface UsuarioService {

	public UsuarioDTO crearUsuario( UsuarioDTO usuario);
	
	public List<UsuarioDTO> obtenerTodosUsuarios();
	
	public UsuarioDTO obtenerUsuarioById(long id);
	
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuario, long id);
	
	public void eliminarUsuario(long id);
	
}
