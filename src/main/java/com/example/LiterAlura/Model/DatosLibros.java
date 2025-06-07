package com.example.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Object> autor,
        @JsonAlias("languages") List<Object> lenguaje,
        @JsonAlias("download_count") int cantidadDeDescargas
        ) {
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public List<Object> autor() {
        return autor;
    }

    @Override
    public List<Object> lenguaje() {
        return lenguaje;
    }

    @Override
    public int cantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    @Override
    public String toString() {
        return "DatosLibros{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.get(0) +
                ", lenguaje=" + lenguaje.get(0) +
                ", cantidad De Descargas=" + cantidadDeDescargas +
                '}';
    }
}
