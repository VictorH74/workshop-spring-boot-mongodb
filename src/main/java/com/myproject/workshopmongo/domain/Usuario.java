package com.myproject.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection="") para definir um nome da coleção manualmente
@Document
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private String email;
	
	@DBRef(lazy = true)//-> INDICAR QUE UM ATRIBUTO ESTA REFERENCIANDO OUTRA COLEÇAO DO MONGODB
	private List<Postagem> postagens = new ArrayList<>(); // REFERENCIAS PARA AS POSTAGENS DO USUARIO ATRAVÉS DE Postagem.id EM LISTA
	//(lazy = true)-> GARANTIR QUE AS POSTAGENS SO VAO SER CARREGADOS APENAS FOREM CONSULTADOS NA COLEÇAO
	
	public Usuario() {
	}

	public Usuario(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}
	
	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
}
