package com.gestionate.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionate.api.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
