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

import com.gestionate.api.dto.IngresoDTO;
import com.gestionate.api.services.IngresoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class IngresoController {

	private static final String RUTA = "/usuario/{usuarioId}/ingresos";

	@Autowired
	private IngresoService ingresoService;

	@GetMapping(RUTA)
	public List<IngresoDTO> obtenerIngresosPorUsuarioId(@PathVariable(value = "usuarioId") long id) {
		return ingresoService.obtenerIngresoPorUsuarioId(id);
	}

	@GetMapping(RUTA + "/{ingresoId}")
	public ResponseEntity<IngresoDTO> obtenerIngresosPorId(
			@PathVariable(value = "usuarioId") long usuarioId,
			@PathVariable(value = "ingresoId") long ingresoId) {
		
		IngresoDTO ingreso = ingresoService.obtenerIngresoPorId(usuarioId, ingresoId);
		return new ResponseEntity<>(ingreso, HttpStatus.OK);
	}

	@PostMapping(RUTA)
	public ResponseEntity<IngresoDTO> guardarIngreso(
			@Valid
			@PathVariable(value = "usuarioId") long id,
			@RequestBody IngresoDTO ingresoDTO) {
		
		return new ResponseEntity<>(ingresoService.crearIngreso(id, ingresoDTO), HttpStatus.CREATED);
	}

	@PutMapping(RUTA + "/{ingresoId}")
	public ResponseEntity<IngresoDTO> actualizarIngresosPorId(
			@Valid
			@PathVariable(value = "usuarioId") long usuarioId,
			@PathVariable(value = "ingresoId") long ingresoId,
			@RequestBody IngresoDTO ingresoDTO) {
		
		IngresoDTO ingreso = ingresoService.actualizarIngreso(usuarioId, ingresoId, ingresoDTO);
		return new ResponseEntity<>(ingreso, HttpStatus.OK);
	}
	
	@DeleteMapping(RUTA + "/{ingresoId}")
	public ResponseEntity<String> eliminarIngreso(
			@PathVariable(value = "usuarioId") long usuarioId,
			@PathVariable(value = "ingresoId") long ingresoId){
		
		ingresoService.eliminarIngreso(usuarioId, ingresoId);
		return new ResponseEntity<>("Ingreso eliminado con exito", HttpStatus.OK);
	}

}
