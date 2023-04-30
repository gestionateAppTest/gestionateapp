package com.gestionate.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionate.api.dto.UsuarioDTO;
import com.gestionate.api.entities.Usuario;
import com.gestionate.api.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository; 

	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuario) {
		
		Usuario usuarioEntidad = usuario.obtenerDeDTO(usuario);
		Usuario usuarioNuevo = usuarioRepository.save(usuarioEntidad);
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO = usuarioDTO.obtenerDeEntidad(usuarioNuevo);	
		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> obtenerTodosUsuarios() {
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		return listaUsuarios.stream().map(usuario -> usuarioDTO.obtenerDeEntidad(usuario)).collect(Collectors.toList());
	}
	

	

}
