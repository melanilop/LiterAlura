package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResults {
    @JsonAlias("results")
    private List<CaractLibro> libros;

    public List<CaractLibro> getLibros() {
        return libros;
    }

    public void setLibros(List<CaractLibro> libros) {
        this.libros = libros;
    }
}

