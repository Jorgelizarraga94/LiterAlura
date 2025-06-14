package com.example.LiterAlura;

import com.example.LiterAlura.Principal.Principal;
import com.example.LiterAlura.Repository.ILibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private ILibrosRepository librosRepository;
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(LiterAluraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(librosRepository);
		principal.mostrarMenu();
	}
}
