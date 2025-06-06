package com.example.LiterAlura;


import com.example.LiterAlura.Model.DatosLibros;
import com.example.LiterAlura.Model.ResultadoDatos;
import com.example.LiterAlura.Service.ConsultaApi;
import com.example.LiterAlura.Service.ConversorDatos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LiterAluraApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(LiterAluraApplication.class, args);
		ConsultaApi consulta = new ConsultaApi();
		String json = consulta.llamadaApi();
		System.out.println(json);

		ConversorDatos conversor = new ConversorDatos();

		conversor.obtenerDatos(json, ResultadoDatos.class);
		for (DatosLibros Libros : ResultadoDatos.resultado){
			System.out.println();
		}

    }
}
