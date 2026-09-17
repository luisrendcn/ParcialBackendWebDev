package com.ejemplo.usuarios.service;

import org.springframework.stereotype.Service;

import com.ejemplo.usuarios.model.Usuario;
import com.ejemplo.usuarios.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow();
	}

	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);
	}

}