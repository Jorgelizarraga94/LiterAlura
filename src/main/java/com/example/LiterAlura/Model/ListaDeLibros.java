package com.example.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaDeLibros {
    @JsonAlias("results") private List<DatosLibros> libros;

    public List<DatosLibros> getLibros() {
        return libros;
    }

    public void setLibros(List<DatosLibros> libros) {
        this.libros = libros;
    }
}
