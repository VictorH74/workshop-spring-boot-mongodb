package com.myproject.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.myproject.workshopmongo.domain.Postagem;
import com.myproject.workshopmongo.domain.Usuario;
import com.myproject.workshopmongo.dto.AutorDTO;
import com.myproject.workshopmongo.repositories.PostagemRepository;
import com.myproject.workshopmongo.repositories.UsuarioRepository;

@Configuration
public class Instanciation implements CommandLineRunner {

	@Autowired
	UsuarioRepository uRepository;
	
	@Autowired
	PostagemRepository pRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		stf.setTimeZone(TimeZone.getTimeZone("GMT")); // FORMATO OARA HORARIO DE LONDRES
		
		uRepository.deleteAll();
		pRepository.deleteAll();
		
		Usuario u1 = new Usuario(null, "Victor Almeida", "victorh.almeida7@gmail.com");
		Usuario u2 = new Usuario(null, "Gabrielly Silva", "gaby77@gmail.com");
		Usuario u3 = new Usuario(null, "Samuel Jackson", "sam.jackson89@gmail.com");
		Usuario u4 = new Usuario(null, "Nicolas Tesla", "mr.tesla_elbrabo@gmail.com");
		
		Postagem post1 = new Postagem(null, stf.parse("21/08/2021"), "Partiu viagem", "Vou viajar para SP. Abraços!", new AutorDTO(u1));
		Postagem post2 = new Postagem(null, stf.parse("27/10/2021"), "Bom dia", "Acorder feliz hoje!", new AutorDTO(u2));
		
		uRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		pRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
