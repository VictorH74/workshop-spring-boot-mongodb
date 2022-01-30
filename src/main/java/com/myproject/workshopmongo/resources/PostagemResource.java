package com.myproject.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.workshopmongo.domain.Postagem;
import com.myproject.workshopmongo.resources.util.URL;
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
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Postagem>> encontrarPorTitulo(@RequestParam(value="texto", defaultValue="") String texto){
		//@RequestParm -> INDICAR QUE O CRITERIO DE BUSCA PASSADO COMO PARAMETRO DESSE METODO
		// VAI SER UM PARAMETRO DA URL (...?texto=TEXTO)
		//(value="texto") -> IDENTIFICAR O NOME DO PARAMETRO
		//(defaultValue="") -> CASO O PARAMETRO(texto) NÃO FOR INFORMADO, DEFINIR VALOR PARA VAZIO("")
		
		texto = URL.decodificarParametro(texto);
		
		List<Postagem> list = service.encontrarPorTitulo(texto);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Postagem>> encontrarPor(
			@RequestParam(value="texto", defaultValue="") String texto, 
			@RequestParam(value="dataMin", defaultValue="") String dataMin,
			@RequestParam(value="dataMax", defaultValue="") String dataMax){
		
		texto = URL.decodificarParametro(texto);
		Date Min = URL.converterData(dataMin, new Date(0L));
		Date Max = URL.converterData(dataMax, new Date());
		
		List<Postagem> list = service.encontrarPor(texto, Min, Max);
		
		return ResponseEntity.ok().body(list);
	}
	
	
}
