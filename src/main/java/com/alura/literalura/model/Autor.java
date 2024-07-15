package com.alura.literalura.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido; // Nueva propiedad para el apellido

    private int anoNacimiento;
    private int anoFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    // Constructor vacío necesario para JPA
    public Autor() {
    }

    // Constructor con parámetros para crear un Autor desde CaractAutor
    public Autor(CaractAutor caractAutor) {
        this.nombre = caractAutor.nombre(); // Aquí se llama al método getter 'nombre()'
        this.apellido = ""; // Asigna el apellido según el dato recibido
        this.anoNacimiento = caractAutor.anoNacimiento(); // Aquí se llama al método getter 'anoNacimiento()'
        this.anoFallecimiento = caractAutor.anoFallecimiento(); // Aquí se llama al método getter 'anoFallecimiento()'

    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public int getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public void setAnoFallecimiento(int anoFallecimiento) {
        this.anoFallecimiento = anoFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    // Sobreescribimos el método toString() para mostrar la información de manera estructurada
    @Override
    public String toString() {
        String librosTitulos = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));

        return "Autor: " + nombre + " " + apellido + "\n" +
                "Año de nacimiento: " + anoNacimiento + "\n" +
                "Año de fallecimiento: " + anoFallecimiento + "\n" +
                "Libros: " + librosTitulos + "\n";
    }
}
