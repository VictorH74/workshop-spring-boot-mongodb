package com.myproject.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myproject.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice // CLASSE LISTENNER / CONTEM METODOS QUE RETORNA UM ERRO DE ACORDO COM AS EXCEPTIONS DECLARADAS
public class ResourceExceptionHandler {

	// RETORNAR UM "StandardError" DA EXCEPTION "ObjectNotFoundException"
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		// PARA O STATUS DO OBJ "err"
		HttpStatus status = HttpStatus.NOT_FOUND; // -> RETORNA CÓDIGO: 404 (ELEMENTO NAO ENCONTRADO)
		
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		// System.currentTimeMillis() -> PEGA O INSTANT ATUAL DO SISTEMA
		
		return ResponseEntity.status(status).body(err);
	}
}
