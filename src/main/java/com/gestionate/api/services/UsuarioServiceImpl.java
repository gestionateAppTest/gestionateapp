package com.gestionate.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionate.api.dto.UsuarioDTO;
import com.gestionate.api.entities.Usuario;
import com.gestionate.api.exceptions.ResourceNotFoundExcepcion;
import com.gestionate.api.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository; 

	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuario) {
		
		Usuario usuarioEntidad = usuario.obtenerDeDTO(usuario);
		Usuario usuarioNuevo = usuarioRepository.save(usuarioEntidad);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioNuevo);	
		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> obtenerTodosUsuarios() {
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		return listaUsuarios.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO obtenerUsuarioById(long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", id));
		return new UsuarioDTO(usuario);
	}

	@Override
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuario, long id) {
		Usuario usuarioEntidad = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", id));
		
		usuarioEntidad.setUsername(usuario.getUsername());
		usuarioEntidad.setEmail(usuario.getEmail());
		usuarioEntidad.setPassword(usuario.getPassword());
		usuarioEntidad.setNombre(usuario.getNombre());
		usuarioEntidad.setApellido1(usuario.getApellido1());
		usuarioEntidad.setApellido2(usuario.getApellido2());
		usuarioEntidad.setActivo(usuario.getActivo());
		usuarioEntidad.setF_baja(usuario.getF_baja());
		usuarioEntidad.setF_ult_inicio_sesion(usuario.getF_ult_inicio_sesion());
		
		Usuario usuarioAtualizado = usuarioRepository.save(usuarioEntidad);
		
		return new UsuarioDTO(usuarioAtualizado);
	}

	@Override
	public void eliminarUsuario(long id) {
		Usuario usuarioEntidad = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", id));
		usuarioRepository.delete(usuarioEntidad);
		
	}
	

	

}
