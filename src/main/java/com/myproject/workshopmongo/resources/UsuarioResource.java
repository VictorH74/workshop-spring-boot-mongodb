package com.myproject.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDto){
		
		Usuario obj = service.fromDTO(objDto);
		
		obj = service.inserir(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		// ....build() -> ALTERAÇÃO SEM RETORNAR NADA
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable String id, @RequestBody UsuarioDTO objDto){
		
		Usuario obj = service.fromDTO(objDto);
		
		obj.setId(id);// GARANTIR QUE O OBJ VAI TER O ID DA REQUESTBODY
		obj = service.atualizar(obj);
		
		return ResponseEntity.noContent().build();
		// ....build() -> ALTERAÇÃO SEM RETORNAR NADA
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable String id){
		
		service.deletarPorId(id);
		
		return ResponseEntity.noContent().build();
		// ".noContent()" -> CÓDIGO (204) PARA OPERAÇÃO QUE NÃO RETORNA NADA
	}
	
}
