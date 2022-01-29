package com.myproject.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	//@GetMapping -> Mesma função da annotation abaixo
	@RequestMapping(method = RequestMethod.GET) //-> Indicar que esse metodo sera o EndPoint do caminho "/usuarios"
	public ResponseEntity<List<Usuario>> listarTodos(){

		return ResponseEntity.ok().body(service.listarTodos());
	}
}
