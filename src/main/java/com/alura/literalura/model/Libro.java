package com.alura.literalura.model;

import jakarta.persistence.*;


@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Autor autor;

    private String idioma;
    private int descargas;


    // Constructor vacío necesario para JPA
    public Libro() {
    }

    // Constructor con parámetros para crear un Libro desde CaractLibro y Autor
    public Libro(CaractLibro datosLibro, Autor autor) {
        this.titulo = datosLibro.titulo();
        this.autor = autor;
        // Aquí se asume que se tomará el primer idioma de la lista de idiomas
        this.idioma = datosLibro.idiomas().isEmpty() ? "" : datosLibro.idiomas().get(0);
        this.descargas = datosLibro.descargas();
    }

    // Métodos de acceso

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}
