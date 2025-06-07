package com.example.LiterAlura.Service;

import com.example.LiterAlura.Model.ListaDeLibros;

public interface IconversorDatos {
   <T> T obtenerDatos(String json, Class<T> tipoClase);
}
