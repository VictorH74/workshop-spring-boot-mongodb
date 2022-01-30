package com.myproject.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.workshopmongo.domain.Postagem;
import com.myproject.workshopmongo.repositories.PostagemRepository;
import com.myproject.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostagemService {

	@Autowired
	PostagemRepository repository;
	
	public List<Postagem> listarTodos(){
		return repository.findAll();
	}
	
	public Postagem encontrarPorId(String id) {
		Optional<Postagem> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public Postagem inserir(Postagem obj) {
		return repository.insert(obj);
	}

}
