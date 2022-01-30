package com.myproject.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.workshopmongo.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String>{
	// DOCUMENTAÇAO "docs.mongodb.com/manual/reference/operator/query/"
	
	//	  ("{ 'CAMPO PELO QUAL EFETUAR A BUSCA': { $regex: EXPRESSAO REGULAR/PARAMETRO, 'OPTION'}}")
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")// "?0" POSIÇAO DO PARAMETRO A SER USADO EX.: ...(0, 1, 2,...) / 'i' IGNORAR LETRAS MAIUSCULAS E MINUSCULAS
	List<Postagem> encontrarPorTitulo(String texto); //-> METODO PERSONALIZADO COM QUERY OPERATORS DO MONGODB

	List<Postagem> findByTituloIgnoreCase(String titulo); //-> QUERY METHOD DO MONGODB
	
	@Query("{ $and: [ {momento: {$gte: ?1} }, { momento: { $lte: ?2} }, { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Postagem> encontrarPor(String texto, Date dataMin, Date dataMax);
}
