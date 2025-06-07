package com.example.LiterAlura.Principal;

import com.example.LiterAlura.Model.ListaDeLibros;
import com.example.LiterAlura.Service.ConsultaApi;
import com.example.LiterAlura.Service.ConversorDatos;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsultaApi consumoApi = new ConsultaApi();
    private final String URL_BASE = "http://gutendex.com/books/?page=";
    private final String FIN_URL = "&search=";
    private ConversorDatos conversor = new ConversorDatos();

    public void mostrarMenu() throws IOException, InterruptedException {
        int opcion = -1;
        while(opcion != 0){
            var menu = """
                    1 - Buscar Libro
                    
                    
                    0 - salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1: busquedaPorTitulo();
                    break;
                case 2:
                    System.out.println("cerrando app");
            }
        }

    }

    public void busquedaPorTitulo() throws IOException, InterruptedException {
        System.out.println("Escriba el titulo del libro");
        Scanner teclado = new Scanner(System.in);
        String nombreAutor = teclado.nextLine();
        /*for (int i = 1; i < 9; i++) {*/
            String json = consumoApi.busquedaPorAutor(URL_BASE + FIN_URL + nombreAutor.replace(" ", "%20"));
        System.out.println(json);
            var datos = conversor.obtenerDatos(json, ListaDeLibros.class);
            for (int j = 0; j < datos.getLibros().size(); j++) {
                System.out.println(datos.getLibros().get(j).toString());
            }
        /*}*/
    }
}
