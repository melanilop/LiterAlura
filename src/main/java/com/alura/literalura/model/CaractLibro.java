package com.alura.literalura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CaractLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<CaractAutor> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") int descargas
) {}
