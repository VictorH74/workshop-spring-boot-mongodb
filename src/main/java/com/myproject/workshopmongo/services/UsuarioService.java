package com.myproject.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.dto.UsuarioDTO;
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
	
	public Usuario inserir(Usuario obj) {
		return repository.insert(obj);
	}
	
	public Usuario atualizar(Usuario obj) {
		Usuario newObj = encontrarPorId(obj.getId());
		
		atualizarDados(newObj, obj);
		
		return repository.save(newObj);
		
	}
	
	private void atualizarDados(Usuario newObj, Usuario obj) {

		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	public void deletarPorId(String id) {
		encontrarPorId(id);
		repository.deleteById(id);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
