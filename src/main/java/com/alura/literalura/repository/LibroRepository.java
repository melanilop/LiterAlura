package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

        long countByTitulo(String titulo);

        long countByIdiomaIsNotNull();


    // Consulta JPQL para buscar libros por idioma (insensible a mayúsculas y minúsculas)
    @Query("SELECT l FROM Libro l WHERE LOWER(l.idioma) = LOWER(:idioma)")
    List<Libro> buscarLibrosPorIdioma(@Param("idioma") String idioma);

    // Métodos para contar libros por idioma
    long countByIdioma(String idioma);

    // Consulta JPQL para contar libros por idioma
    @Query("SELECT COUNT(l) FROM Libro l WHERE LOWER(l.idioma) = LOWER(:idioma)")
    Long contarLibrosPorIdioma(@Param("idioma") String idioma);


    // Consultas opcionales
    // Método para buscar libros por título que contengan una cierta palabra clave
    List<Libro> findByTituloContainingIgnoreCase(String palabraClave);
}



