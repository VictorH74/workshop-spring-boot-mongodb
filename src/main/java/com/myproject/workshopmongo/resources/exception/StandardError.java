package com.myproject.workshopmongo.resources.exception;

import java.io.Serializable;


// CLASSE QUE SERVE COMO UM FORMATO PADRAO DE ERRO QUE TERA SEUS ATRIBUTOS DEFINIDOS NAS EXCEPTIONS
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long momento;
	private Integer status;
	private String erro;
	private String messagem;
	private String caminho;
	
	public StandardError() {
	}

	public StandardError(Long momento, Integer status, String erro, String messagem, String caminho) {
		super();
		this.momento = momento;
		this.status = status;
		this.erro = erro;
		this.messagem = messagem;
		this.caminho = caminho;
	}

	public Long getMomento() {
		return momento;
	}

	public void setMomento(Long momento) {
		this.momento = momento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
}
