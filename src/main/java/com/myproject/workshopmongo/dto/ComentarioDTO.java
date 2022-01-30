package com.myproject.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Date momento;
	private AutorDTO autor;
	
	public ComentarioDTO () {
	}

	public ComentarioDTO(String texto, Date momento, AutorDTO autor) {
		super();
		this.texto = texto;
		this.momento = momento;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
}
