package com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        System.out.println("Lista de libros registrados:");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo());
        }
    }

    public void buscarLibroPorTitulo(String titulo) {
        List<Libro> libros = libroRepository.findByTitulo(titulo);
        System.out.println("Lista de libros con título '" + titulo + "':");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo());
        }
    }

    public void listarLibrosPorIdioma(String idioma) {
        List<Libro> libros = libroRepository.findByIdioma(idioma);
        System.out.println("Lista de libros en idioma '" + idioma + "':");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo());
        }
    }
}