package com.myproject.workshopmongo.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Instant momento;
	private String titulo;
	private String corpo;
	
	private Usuario autor;
	
	private Set<Comentario> comentarios = new HashSet<>();
	
	public Postagem(){
	}

	public Postagem(String id, Instant momento, String titulo, String corpo) {
		super();
		this.id = id;
		this.momento = momento;
		this.titulo = titulo;
		this.corpo = corpo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
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
		Postagem other = (Postagem) obj;
		return Objects.equals(id, other.id);
	}
	
}
