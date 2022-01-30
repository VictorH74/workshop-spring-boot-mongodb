package com.myproject.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.workshopmongo.domain.Postagem;
import com.myproject.workshopmongo.services.PostagemService;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemResource {
	
	@Autowired
	private PostagemService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Postagem> encontrarPorId(@PathVariable String id){
		
		Postagem obj = service.encontrarPorId(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
}
