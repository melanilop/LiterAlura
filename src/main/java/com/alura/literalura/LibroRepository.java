package com.alura.literalura;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByTitulo(String titulo);
    List<Libro> findByIdioma(String idioma);
}
