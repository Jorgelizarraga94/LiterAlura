package com.example.LiterAlura;


import com.example.LiterAlura.Model.DatosLibros;
import com.example.LiterAlura.Model.ListaDeLibros;
import com.example.LiterAlura.Principal.Principal;
import com.example.LiterAlura.Service.ConsultaApi;
import com.example.LiterAlura.Service.ConversorDatos;
import com.example.LiterAlura.Service.IconversorDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LiterAluraApplication implements CommandLineRunner {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(LiterAluraApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();
	}
}
