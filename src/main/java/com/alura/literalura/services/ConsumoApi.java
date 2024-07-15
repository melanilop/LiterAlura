
package com.alura.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Clase que contiene el método para consultar a la Api y obtener el json
public class ConsumoApi {

    // Método para consultar a la API y obtener el JSON de respuesta
    public String obtenerDatosApi(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            // Manejo genérico de excepciones. Aquí podrías considerar un manejo más específico.
            throw new RuntimeException("Error al obtener datos de la API: " + e.getMessage(), e);
        }
    }
}

