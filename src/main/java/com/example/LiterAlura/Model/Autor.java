package com.example.LiterAlura.Model;

public class Autor {
    private String nombre_autor;
    private int anio_de_nacimiento;
    private int anio_de_fallecimiento;

    public Autor() {
    }

    public Autor(String nombre_autor, int anio_de_nacimiento, int anio_de_fallecimiento) {
        this.nombre_autor = nombre_autor;
        this.anio_de_nacimiento = anio_de_nacimiento;
        this.anio_de_fallecimiento = anio_de_fallecimiento;
    }

    public String HistorialAutores(){
        return "DatosLibros{" + "\n" +
                "nombre='" + nombre_autor + "\n" +
                "nacimiento=" + anio_de_nacimiento  + "\n"+
                "fallecimiento=" + anio_de_fallecimiento  + "\n"+
                '}';
    }
}
