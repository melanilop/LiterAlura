package com.alura.literalura;


import com.alura.literalura.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/contarLibrosPorIdioma")
    public long contarLibrosPorIdioma(@RequestParam String idioma) {
        return libroService.contarLibrosPorIdioma(idioma);
    }
}
