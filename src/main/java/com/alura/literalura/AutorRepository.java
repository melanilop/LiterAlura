package com.alura.literalura;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByAnoFallecimientoIsNullOrAnoFallecimientoGreaterThan(int anio);
}
