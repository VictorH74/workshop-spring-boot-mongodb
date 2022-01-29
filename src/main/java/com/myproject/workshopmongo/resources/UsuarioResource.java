package com.myproject.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.dto.UsuarioDTO;
import com.myproject.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	//@GetMapping -> Mesma função da annotation abaixo
	@RequestMapping(method = RequestMethod.GET) //-> Indicar que esse metodo sera o EndPoint do caminho "/usuarios"
	public ResponseEntity<List<UsuarioDTO>> listarTodos(){
		
		List<UsuarioDTO> list = service.listarTodos().stream().map(x -> new UsuarioDTO(x))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> encontrarPorId(@PathVariable String id){
		
		Usuario obj = service.encontrarPorId(id);
		
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
}
