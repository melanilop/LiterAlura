package com.alura.literalura;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarAutoresRegistrados() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosEnUnAnio(int anio) {
        return autorRepository.findByAnoFallecimientoIsNullOrAnoFallecimientoGreaterThan(anio);
    }
}
