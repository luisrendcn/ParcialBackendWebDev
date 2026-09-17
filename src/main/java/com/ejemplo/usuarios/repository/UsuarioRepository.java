package com.ejemplo.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}