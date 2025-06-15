package com.example.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @JsonAlias("title") private String titulo;
    @Transient @JsonAlias("authors") private List<Map<String, Object>> autor;
    @Transient @JsonAlias("languages") private List<String> lenguaje;
    private String nombreAutor;
    private Integer anioDeNacimiento;
    private Integer anioDeFallecimiento;
    private String idioma;
    @JsonAlias("download_count") private int cantidadDeDescargas;


    
    public Libros() {
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void procesarDatos() {
        if (autor != null && !autor.isEmpty()) {
            Object nombre = autor.get(0).get("name");
            Object anioNacimiento = autor.get(0).get("birth_year");
            Object anioFallecimiento = autor.get(0).get("death_year");

            this.nombreAutor = nombre != null ? nombre.toString() : "Desconocido";
            this.anioDeNacimiento = (int) anioNacimiento;
            this.anioDeFallecimiento = (int) anioFallecimiento;
        }

        if (lenguaje != null && !lenguaje.isEmpty()) {
            this.idioma = lenguaje.get(0);
        }
    }

    /*public long getId() {
        return idBd;
    }

    public void setId(Long id) {
        this.idBd = id;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Map<String, Object>> getAutor() {
        return autor;
    }

    public void setAutor(List<Map<String, Object>> autor) {
        this.autor = autor;
    }

    public List<String> getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(List<String> lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public Integer getAnioDeNacimiento() {
        return anioDeNacimiento;
    }

    public Integer getAnioDeFallecimiento() {
        return anioDeFallecimiento;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(int cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }

    public void setAnioDeNacimiento(int anioDeNacimiento) {
        this.anioDeNacimiento = anioDeNacimiento;
    }

    public void setAnioDeFallecimiento(int anioDeFallecimiento) {
        this.anioDeFallecimiento = anioDeFallecimiento;
    }

    @Override
    public String toString() {
        return "DatosLibros{" + "\n" +
                "titulo='" + titulo + "\n" +
                "autor=" + nombreAutor  + "\n"+
                "lenguaje=" + idioma  + "\n" +
                "cantidad De Descargas=" + cantidadDeDescargas + "\n" +
                '}';
    }


}

