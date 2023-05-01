package com.gestionate.api.services;

import java.util.List;

import com.gestionate.api.dto.IngresoDTO;

public interface IngresoService {

	public IngresoDTO crearIngreso(long usuarioId, IngresoDTO ingresoDTO);
	
	public List<IngresoDTO> obtenerIngresoPorUsuarioId(long usuarioId);
	
	public IngresoDTO obtenerIngresoPorId(long usuarioId, long ingresoId);
	
	public IngresoDTO actualizarIngreso(long usuarioId,long ingresoId, IngresoDTO ingreso);
	
	public void eliminarIngreso(long usuarioId,long ingresoId);
	
}
