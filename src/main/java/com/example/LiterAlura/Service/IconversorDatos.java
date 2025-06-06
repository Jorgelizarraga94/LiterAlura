package com.example.LiterAlura.Service;

import com.example.LiterAlura.Model.DatosLibros;
import com.example.LiterAlura.Model.ResultadoDatos;

public interface IconversorDatos {
   <T> T obtenerDatos(String json, Class<T> clase);
}
