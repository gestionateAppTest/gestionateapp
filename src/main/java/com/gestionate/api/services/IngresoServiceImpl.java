package com.gestionate.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.gestionate.api.utils.Logs;

@Service
public class IngresoServiceImpl implements IngresoService{
	
	private static final String NOMBRE_CLASE = IngresoServiceImpl.class.getName();
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IngresosRepository ingresoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public IngresoDTO crearIngreso(long usuarioId, IngresoDTO ingresoDTO) {
		
		String nombreMetodo = "crearIngreso";
		
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", " + ingresoDTO.getDescripcion(), "init");
		Ingresos ingreso = modelMapper.map(ingresoDTO, Ingresos.class);
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", usuarioId));
		ingreso.setUsuario(usuario);		
		Ingresos IngresoRespuesta = ingresoRepository.save(ingreso);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", " + ingresoDTO.getDescripcion(), "Creado con exito: " + IngresoRespuesta.getId());
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", " + ingresoDTO.getDescripcion(), "end");
		return modelMapper.map(IngresoRespuesta, IngresoDTO.class);
	}

	@Override
	public List<IngresoDTO> obtenerIngresoPorUsuarioId(long usuarioId) {
		
		String nombreMetodo = "obtenerIngresoPorUsuarioId";
		
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId, "init");
		List<Ingresos> listaIngresos = ingresoRepository.findByUsuarioId(usuarioId);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId, "Resultado lista: "+ (listaIngresos != null ? listaIngresos.size() : listaIngresos));
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId, "end");
		return listaIngresos.stream().map(ingreso -> modelMapper.map(ingreso, IngresoDTO.class)).collect(Collectors.toList());
	}

	@Override
	public IngresoDTO obtenerIngresoPorId(long usuarioId, long ingresoId) {
		
		String nombreMetodo = "obtenerIngresoPorId";
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId, "init");
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", usuarioId));
		
		Ingresos ingreso = ingresoRepository.findById(ingresoId).orElseThrow(() -> new ResourceNotFoundExcepcion("Ingreso", "id", ingresoId));
		
		if (ingreso.getUsuario().getId() != usuario.getId()) {
			throw new GestionateAppException(HttpStatus.BAD_REQUEST , "El comentario no pertenece a la publicacion");
		}
		
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId, "IngresoId: " + ingreso.getId());
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId, "end");
		return modelMapper.map(ingreso, IngresoDTO.class);
	}

	@Override
	public IngresoDTO actualizarIngreso(long usuarioId, long ingresoId, IngresoDTO ingreso) {
		
		String nombreMetodo = "actualizarIngreso";
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId + ", Descripcion: " + ingreso.getDescripcion(), "init");
		
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", usuarioId));
		
		Ingresos ingresoEntidad = ingresoRepository.findById(ingresoId).orElseThrow(() -> new ResourceNotFoundExcepcion("Ingreso", "id", ingresoId));
		
		if (ingresoEntidad.getUsuario().getId() != usuario.getId()) {
			throw new GestionateAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
		}
		
		ingresoEntidad.setCantidad(ingreso.getCantidad());
		ingresoEntidad.setFecha_ingreso(ingreso.getFecha_ingreso());
		ingresoEntidad.setDescripcion(ingreso.getDescripcion());
		
		Ingresos ingresoActualizado = ingresoRepository.save(ingresoEntidad);
		
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId + ", Descripcion: " + ingreso.getDescripcion(), "Ingreso Actualizado con exito: " + ingresoId);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId + ", Descripcion: " + ingreso.getDescripcion(), "end");
		return modelMapper.map(ingresoActualizado, IngresoDTO.class);
	}

	@Override
	public void eliminarIngreso(long usuarioId, long ingresoId) {
		
		
		String nombreMetodo = "eliminarIngreso";
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId, "init");
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExcepcion("Usuario", "id", usuarioId));
		
		Ingresos ingreso = ingresoRepository.findById(ingresoId).orElseThrow(() -> new ResourceNotFoundExcepcion("Ingreso", "id", ingresoId));
		
		if (ingreso.getUsuario().getId() != usuario.getId()) {
			throw new GestionateAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
		}
		
		ingresoRepository.delete(ingreso);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId, "Eliminado con exito: " + ingresoId);
		Logs.logInfo(NOMBRE_CLASE, nombreMetodo, "usuarioId: " + usuarioId + ", usuarioId: " + ingresoId, "end");
		
	}

}
