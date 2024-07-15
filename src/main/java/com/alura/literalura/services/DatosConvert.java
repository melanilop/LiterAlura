package com.alura.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Clase que implementa la interfaz IConvierteDatos para convertir JSON a objetos Java
public class DatosConvert extends DatosConverter {

    // Instancia final de ObjectMapper para mapear JSON a objetos Java
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T JsonToClass(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir JSON a clase " + clase.getSimpleName(), e);
        }
    }
}


