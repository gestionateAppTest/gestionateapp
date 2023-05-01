package com.gestionate.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionate.api.dto.UsuarioDTO;
import com.gestionate.api.entities.Usuario;
import com.gestionate.api.exceptions.ResourceNotFoundExcepcion;
import com.gestionate.api.repository.UsuarioRepository;
import com.gestionate.api.utils.Logs;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private static final String NOMBRE_CLASE = UsuarioServiceImpl.class.getName();
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UsuarioRepository usuarioRepository; 

	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuario) {
		
		String nombreMetodo = "crearUsuario";
		
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, usuario.getUsername(), "init");
		Usuario usuarioEntidad = modelMapper.map(usuario, Usuario.class);
		Usuario usuarioNuevo = usuarioRepository.save(usuarioEntidad);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, usuario.getUsername(), "Usuario creado correctamente");
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, usuario.getUsername(), "end");
		return modelMapper.map(usuarioNuevo, UsuarioDTO.class);
	}

	@Override
	public List<UsuarioDTO> obtenerTodosUsuarios() {
		String nombreMetodo = "obtenerTodosUsuarios";
		
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, null, "init");
		List<Usuario> listaUsuarios = usuarioRepository.findAll();
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, null, "Resultado lista: "+ (listaUsuarios != null ? listaUsuarios.size() : listaUsuarios));
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, null, "end");
		return listaUsuarios.stream().map(usuario -> modelMapper.map(usuario, UsuarioDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO obtenerUsuarioById(long id) {
		
		String nombreMetodo = "obtenerUsuarioById";
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "init");
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", id));
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "Id: " + (usuario != null ? usuario.getId() : usuario));
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "end");
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	@Override
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuario, long id) {
		
		String nombreMetodo = "actualizarUsuario";
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "init");
		Usuario usuarioEntidad = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", id));
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "Id: " + (usuario != null ? usuario.getId() : usuario));
		
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
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "Usuario actualizado con exito: " + usuarioAtualizado.getId());
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "end");
		return modelMapper.map(usuarioAtualizado, UsuarioDTO.class);
	}

	@Override
	public void eliminarUsuario(long id) {
		
		String nombreMetodo = "eliminarUsuario";
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "init");
		Usuario usuarioEntidad = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", id));
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "Id: " + (usuarioEntidad != null ? usuarioEntidad.getId() : usuarioEntidad));
		usuarioRepository.delete(usuarioEntidad);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "Usuario eliminado con exito: " + usuarioEntidad.getId());
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, id, "end");
	}
	

	

}
