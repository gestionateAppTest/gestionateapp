package com.gestionate.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gestionate.api.dto.IngresoDTO;
import com.gestionate.api.entities.Ingresos;
import com.gestionate.api.entities.Usuario;
import com.gestionate.api.exceptions.GestionateAppException;
import com.gestionate.api.exceptions.ResourceNotFoundExcepcion;
import com.gestionate.api.repository.IngresosRepository;
import com.gestionate.api.repository.UsuarioRepository;

@Service
public class IngresoServiceImpl implements IngresoService{
	
	@Autowired
	private IngresosRepository ingresoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public IngresoDTO crearIngreso(long usuarioId, IngresoDTO ingresoDTO) {
		Ingresos ingreso = ingresoDTO.obtenerDeDTO(ingresoDTO);
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", usuarioId));
		ingreso.setUsuario(usuario);		
		Ingresos IngresoRespuesta = ingresoRepository.save(ingreso);
		return new IngresoDTO(IngresoRespuesta);
	}

	@Override
	public List<IngresoDTO> obtenerIngresoPorUsuarioId(long usuarioId) {
		List<Ingresos> listaIngresos = ingresoRepository.findByUsuarioId(usuarioId);
		return listaIngresos.stream().map(ingreso -> new IngresoDTO(ingreso)).collect(Collectors.toList());
	}

	@Override
	public IngresoDTO obtenerIngresoPorId(long usuarioId, long ingresoId) {
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", usuarioId));
		
		Ingresos ingreso = ingresoRepository.findById(ingresoId).orElseThrow(() -> new ResourceNotFoundExcepcion("Ingreso", "id", ingresoId));
		
		if (ingreso.getUsuario().getId() != usuario.getId()) {
			throw new GestionateAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
		}
		
		return new IngresoDTO(ingreso);
	}

}
