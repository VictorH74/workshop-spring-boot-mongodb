package com.myproject.workshopmongo.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String texto;
	private Instant momento;
	
	private Postagem postagem;
	
	private Usuario autor;
	
	public Comentario() {
	}

	public Comentario(String id, String texto, Instant momento) {
		super();
		this.id = id;
		this.texto = texto;
		this.momento = momento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
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
		Comentario other = (Comentario) obj;
		return Objects.equals(id, other.id);
	}
	
}
