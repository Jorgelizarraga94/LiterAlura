package com.example.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoDatos() {
    public static List<DatosLibros> resultado;
}
