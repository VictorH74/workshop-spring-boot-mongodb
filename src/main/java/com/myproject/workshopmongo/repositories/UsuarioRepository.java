package com.myproject.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myproject.workshopmongo.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
