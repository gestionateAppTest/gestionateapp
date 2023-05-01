package com.gestionate.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionate.api.entities.Ingresos;

public interface IngresosRepository extends JpaRepository<Ingresos, Long> {

	List<Ingresos> findByUsuarioId(long usuarioId);
	
}
