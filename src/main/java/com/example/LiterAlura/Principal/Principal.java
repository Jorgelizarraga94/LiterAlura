package com.example.LiterAlura.Principal;
import com.example.LiterAlura.Model.Autor;
import com.example.LiterAlura.Model.Libros;
import com.example.LiterAlura.Model.ListaDeLibros;
import com.example.LiterAlura.Repository.ILibrosRepository;
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
    private ILibrosRepository librosRepositorio;

    public Principal(ILibrosRepository librosRepository) {
        this.librosRepositorio = librosRepository;
    }

    public void mostrarMenu() throws IOException, InterruptedException {
        int opcion = -1;
        while(opcion != 0){
            var menu = """
                    1 - Buscar Libro
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1: busquedaPorTitulo();
                    break;
                case 2: HistorialLibrosRegistrados();
                    break;
                case 3: HistorialAutoresRegistrados();
                    break;
                case 4: AutoresVivosEnDeterminadoAnio();
                    break;
                case 5: LibrosPorIdioma();
            }
        }
    }

    public void busquedaPorTitulo() throws IOException, InterruptedException {
        System.out.println("Escriba el titulo del libro");
        Scanner teclado = new Scanner(System.in);
        String nombreAutor = teclado.nextLine();
        boolean libroNoExistente = false;

        String json = consumoApi.busquedaPorAutor(URL_BASE + FIN_URL + nombreAutor.replace(" ", "%20"));
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, ListaDeLibros.class);

        if(librosRepositorio.librosRegistrados().isEmpty()){
            datos.getLibros().get(0).procesarDatos();
            librosRepositorio.save(datos.getLibros().get(0));
        }else{
            for (Libros libro : librosRepositorio.librosRegistrados()){
                if(libro.getTitulo().equals(datos.getLibros().get(0).getTitulo())){
                    libroNoExistente = false;
                    break;
                }
                else{
                    libroNoExistente = true;
                }
            }
        }
        if(libroNoExistente && datos.getLibros().get(0).getAnioDeNacimiento() != null && datos.getLibros().get(0).getAnioDeFallecimiento() != null){
            librosRepositorio.save(datos.getLibros().get(0));
            System.out.println(datos.getLibros().get(0).toString());
        }
        else{
            System.out.println("No se puede cargar el libro por que algun campo es nulo");
        }

    }

    private void HistorialLibrosRegistrados() {
        for (Libros historialLibro : librosRepositorio.librosRegistrados()) {
            System.out.println(historialLibro.toString());
        }
    }

    private void HistorialAutoresRegistrados(){
        for(Autor historialAutores : librosRepositorio.AutoresRegistrados()){
            System.out.println(historialAutores.HistorialAutores());
        }
    }
    private void AutoresVivosEnDeterminadoAnio(){
        System.out.println("Ingrese un determinado año: ");
        Scanner scanner = new Scanner(System.in);
        int anio = scanner.nextInt();
        for (Autor autor : librosRepositorio.AutoresMayoresA(anio)){
            System.out.println(autor.HistorialAutores());
        }
    }
    private void LibrosPorIdioma(){
        System.out.println("Ingrese las siglas del idioma: -en : English , -es : Español");
        Scanner scanner = new Scanner(System.in);
        String siglas = scanner.nextLine();
        for (Libros libro : librosRepositorio.LibrosPorIdioma(siglas)){
            System.out.println(libro.toString());
        }
    }
}
