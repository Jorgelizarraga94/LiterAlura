package com.example.LiterAlura.Repository;
import com.example.LiterAlura.Model.Autor;
import com.example.LiterAlura.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibrosRepository extends JpaRepository<Libros, Long>{
    @Query(value = "SELECT * FROM literalura.libros",nativeQuery = true)
    List<Libros> librosRegistrados();

    @Query(value = "SELECT nombre_autor,anio_de_nacimiento,anio_de_fallecimiento FROM literalura.libros;" , nativeQuery = true)
    List<Autor> AutoresRegistrados();

    @Query(value = "SELECT nombre_autor,anio_de_nacimiento,anio_de_fallecimiento FROM literalura.libros WHERE anio_de_fallecimiento <:anio", nativeQuery = true)
    List<Autor> AutoresMayoresA(@Param("anio")int anio);

    @Query(value = "SELECT * FROM literalura.libros WHERE idioma=:siglas", nativeQuery = true)
    List<Libros> LibrosPorIdioma(@Param("siglas") String siglas);
}


