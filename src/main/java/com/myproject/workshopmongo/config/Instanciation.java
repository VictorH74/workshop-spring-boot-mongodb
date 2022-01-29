package com.myproject.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.repositories.UsuarioRepository;

@Configuration
public class Instanciation implements CommandLineRunner {

	@Autowired
	UsuarioRepository uRepository;
	
	@Override
	public void run(String... args) throws Exception {
		uRepository.deleteAll();
		
		Usuario u1 = new Usuario(null, "Victor Almeida", "victorh.almeida7@gmail.com");
		Usuario u2 = new Usuario(null, "Gabrielly Silva", "gaby77@gmail.com");
		Usuario u3 = new Usuario(null, "Samuel Jackson", "sam.jackson89@gmail.com");
		Usuario u4 = new Usuario(null, "Nicolas Tesla", "mr.tesla_elbrabo@gmail.com");
		
		uRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
	}

}
