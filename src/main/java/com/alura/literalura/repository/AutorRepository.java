package com.alura.literalura.repository;


import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Método para buscar un autor por nombre
    Autor findByNombre(String nombre);

    // Método que utiliza una consulta JPQL para buscar autores vivos en un determinado año
    // Se incluyen autores con año de defunción 0 (indicando que aún están vivos)
    // o con año de defunción posterior o igual al año proporcionado
    @Query("SELECT a FROM Autor a WHERE a.anoNacimiento <= :year AND (a.anoFallecimiento = 0 OR a.anoFallecimiento >= :year)")
    List<Autor> buscarAutorVivoPorAnio(int year);

}


