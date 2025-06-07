package com.example.LiterAlura.Service;

import com.example.LiterAlura.Model.ListaDeLibros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class ConversorDatos implements IconversorDatos{

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
