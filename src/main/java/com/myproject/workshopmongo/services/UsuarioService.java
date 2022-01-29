package com.myproject.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.repositories.UsuarioRepository;
import com.myproject.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	public List<Usuario> listarTodos(){
		return repository.findAll();
	}
	
	public Usuario encontrarPorId(String id) {
		Optional<Usuario> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
	}
}
