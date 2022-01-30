package com.myproject.workshopmongo.services;

import java.util.Date;
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
	
	public List<Postagem> encontrarPorTitulo(String texto){
		return repository.encontrarPorTitulo(texto);
		// "...gnoreCase() -> FAZ COM QUE O TEXTO BUSQUE UM TEXTO INDEPENDENTE DE LETRAS MAIUSCULAS OU MINUSCULAS
	}
	
	public List<Postagem> encontrarPor(String texto, Date dataMin, Date dataMax){
		dataMax = new Date(dataMax.getTime() + 24 * 60 * 60 * 1000); //PEGAR AS 24 HORAS DO DIA
		
		return repository.encontrarPor(texto, dataMin, dataMax);
	}
	
	public Postagem inserir(Postagem obj) {
		return repository.insert(obj);
	}
}
