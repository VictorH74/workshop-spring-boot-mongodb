package com.myproject.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	public List<Usuario> listarTodos(){
		return repository.findAll();
	}
}
