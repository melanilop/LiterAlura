package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// La anotación @JsonIgnoreProperties se usa para ignorar propiedades desconocidas en la deserialización JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public record CaractAutor(
        // La anotación @JsonAlias permite mapear diferentes nombres de campo en JSON al nombre del atributo en Java
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int anoNacimiento,
        @JsonAlias("death_year") int anoFallecimiento

) {

}
