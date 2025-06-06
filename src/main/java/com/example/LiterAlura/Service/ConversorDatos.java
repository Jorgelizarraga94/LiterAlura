package com.example.LiterAlura.Service;

import com.example.LiterAlura.Model.DatosLibros;
import com.example.LiterAlura.Model.ResultadoDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.LiterAlura.Model.ResultadoDatos.resultado;

public class ConversorDatos implements IconversorDatos{
    public ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al deserializar JSON", e);
        }
    }
}
