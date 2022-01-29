package com.myproject.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.workshopmongo.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	//@GetMapping -> Mesma função da annotation abaixo
	@RequestMapping(method = RequestMethod.GET) //-> Indicar que esse metodo sera o EndPoint do caminho "/usuarios"
	public ResponseEntity<List<Usuario>> listarTodos(){
		
		Usuario u1 = new Usuario("1", "Victor Almeida", "victorh.almeida7@gmail.com");
		Usuario u2 = new Usuario("2", "Thamirez West", "thammy99@gmail.com");
		
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(u1, u2));
		
		return ResponseEntity.ok().body(list);
	}
}
