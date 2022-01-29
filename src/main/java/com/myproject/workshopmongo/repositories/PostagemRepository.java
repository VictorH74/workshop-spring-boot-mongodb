package com.myproject.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myproject.workshopmongo.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String>{

}
