package com.example.LiterAlura.Repository;
import com.example.LiterAlura.Model.Autor;
import com.example.LiterAlura.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibrosRepository extends JpaRepository<Libros, Long>{
    //En caso de utilizar MySql, en vez de utilizar public, reemplace por literalura.
    @Query(value = "SELECT * FROM public.libros",nativeQuery = true)
    List<Libros> librosRegistrados();

    @Query(value = "SELECT nombre_autor,anio_de_nacimiento,anio_de_fallecimiento FROM public.libros" , nativeQuery = true)
    List<Autor> AutoresRegistrados();

    @Query(value = "SELECT nombre_autor,anio_de_nacimiento,anio_de_fallecimiento FROM public.libros WHERE anio_de_fallecimiento <:anio", nativeQuery = true)
    List<Autor> AutoresMayoresA(@Param("anio")int anio);

    @Query(value = "SELECT * FROM public.libros WHERE idioma=:siglas", nativeQuery = true)
    List<Libros> LibrosPorIdioma(@Param("siglas") String siglas);
}


