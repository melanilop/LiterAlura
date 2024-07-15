package com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/autores")
    public List<Autor> listarAutoresRegistrados() {
        return autorService.listarAutoresRegistrados();
    }

    @GetMapping("/autores/vivos/{anio}")
    public List<Autor> listarAutoresVivosEnUnAnio(@PathVariable int anio) {
        return autorService.listarAutoresVivosEnUnAnio(anio);
    }
}
