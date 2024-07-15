package com.alura.literalura.principal;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.services.ConsumoApi;
import com.alura.literalura.services.DatosConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Principal implements CommandLineRunner {

    private final AutorRepository autorRepo;
    private final LibroRepository libroRepo;
    private final ConsumoApi consumoApi;
    private final DatosConvert convierteDatos;
    private final Scanner teclado;

    private Set<String> titulosRegistrados;

    @Autowired
    public Principal(LibroRepository libroRepo, AutorRepository autorRepo) {
        this.libroRepo = libroRepo;
        this.autorRepo = autorRepo;
        this.consumoApi = new ConsumoApi();
        this.convierteDatos = new DatosConvert();
        this.teclado = new Scanner(System.in);
        this.titulosRegistrados = new HashSet<>();
    }

    @Override
    public void run(String... args) {
        muestraMenu();
    }

    public void muestraMenu() {
        int opcion = -1;
        do {
            try {
                System.out.println("\n***** BIENVENIDO A LITERALURA ***** ");
                System.out.println("1. Buscar libro por título");
                System.out.println("2. Listar libros registrados" );
                System.out.println("3. Listar autores registrados");
                System.out.println("4. Listar autores vivos en un determinado año");
                System.out.println("5. Listar libros por idioma");
                System.out.println("6. Salir");
                System.out.println("**************************************");

                System.out.println("Por favor, elija una opción: ");

                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        buscarYRegistrarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistradosBD();
                        break;
                    case 3:
                        listarAutoresRegistradosBD();
                        break;
                    case 4:
                        buscarAutoresVivosPorAnio();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 6:
                        System.out.println("Saliendo de la aplicación... Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresar una opción válida.");
                teclado.nextLine(); // Limpiar el buffer de entrada
            }
        } while (opcion != 6);
        // Asegurarnos de que el programa termine después de salir del bucle
        System.exit(0);

    }


    private void buscarYRegistrarLibroPorTitulo() {
        boolean encontrado = false;
        do {
            try {
                System.out.println("Ingrese el título del libro que desea buscar:");
                String titulo = teclado.nextLine();

                if (titulo.isEmpty()) {
                    System.out.println("Error: El título no puede estar vacío.");
                    continue; // Volver a pedir el título
                }

                if (titulosRegistrados.contains(titulo)) {
                    System.out.println("El libro '" + titulo + "' ya ha sido registrado previamente.");
                    return; // Salir del método sin hacer más
                }

                String url = "https://gutendex.com/books/?search=" + titulo;
                String jsonRespuesta = consumoApi.obtenerDatosApi(url);

                JsonResults resultados = convierteDatos.JsonToClass(jsonRespuesta, JsonResults.class);

                if (resultados != null && !resultados.getLibros().isEmpty()) {
                    CaractLibro caractLibro = resultados.getLibros().get(0);

                    Libro libro = new Libro(caractLibro, convertirCaractAutor(caractLibro.autores().get(0)));

                    libroRepo.save(libro);

                    mostrarLibro(libro);

                    titulosRegistrados.add(titulo);

                    encontrado = true;
                } else {
                    System.out.println("No se encontró ningún libro con ese título. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error al procesar la solicitud. Intente nuevamente.");
                teclado.nextLine(); // Limpiar el buffer de entrada
            }
        } while (!encontrado);
    }

    private Autor convertirCaractAutor(CaractAutor caractAutor) {
        Autor autor = new Autor(caractAutor);

        Autor autorExistente = autorRepo.findByNombre(autor.getNombre());
        if (autorExistente == null) {
            autorRepo.save(autor);
            return autor;
        } else {
            return autorExistente;
        }
    }

    private void listarLibrosRegistradosBD() {
        List<Libro> libros = libroRepo.findAll();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("Listado de libros registrados:");
            libros.forEach(this::mostrarLibro);
        }
    }

    private void listarAutoresRegistradosBD() {
        List<Autor> autores = autorRepo.findAll();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos.");
        } else {
            System.out.println("Listado de autores registrados:");
            autores.forEach(this::mostrarDetallesAutor);
        }
    }

    private void mostrarDetallesAutor(Autor autor) {
        System.out.println("\n*--------AUTOR------*");
        System.out.println("Autor: " + obtenerNombreAutor(autor));
        System.out.println("Fecha de nacimiento: " + autor.getAnoNacimiento());
        System.out.println("Fecha de fallecimiento: " + autor.getAnoFallecimiento());
        System.out.println("Libros: " + obtenerTitulosLibros(autor.getLibros()));
        System.out.println("*-------------------*");
    }

    private String obtenerNombreAutor(Autor autor) {
        if (autor.getApellido() != null && !autor.getApellido().isEmpty()) {
            return autor.getApellido() + ", " + autor.getNombre();
        } else {
            return autor.getNombre();
        }
    }



    private void buscarAutoresVivosPorAnio() {
        System.out.println("Ingrese el año para buscar autores vivos:");
        int year = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer de entrada

        List<Autor> autores = autorRepo.buscarAutorVivoPorAnio(year);

        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año " + year);
        } else {
            System.out.println("Autores vivos en el año " + year + ":");
            autores.forEach(this::mostrarAutor);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma para buscar los libros:");
        System.out.println("es - Español");
        System.out.println("en - Inglés");
        System.out.println("fr - Francés");
        System.out.println("pt - Portugués");

        String idioma = teclado.nextLine();

        List<Libro> libros = libroRepo.buscarLibrosPorIdioma(idioma);

        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros en el idioma seleccionado.");
        } else {
            System.out.println("Libros en idioma " + idioma + ":");
            libros.forEach(this::mostrarLibro);
        }

        mostrarEstadisticasLibrosPorIdioma(idioma);
    }

    private void mostrarEstadisticasLibrosPorIdioma(String idioma) {
        long cantidadLibros = libroRepo.countByIdioma(idioma);
        System.out.println("Cantidad de libros en idioma " + idioma + ": " + cantidadLibros);
    }

    private void mostrarLibro(Libro libro) {
        System.out.println("*\n--------LIBRO--------*");
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + obtenerNombreAutor(libro.getAutor()));
        System.out.println("Idioma: " + libro.getIdioma());
        System.out.println("Número de descargas: " + libro.getDescargas());
        System.out.println("*---------------------*");
    }

    private void mostrarAutor(Autor autor) {
        System.out.println("*\n--------AUTOR--------*");
        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Fecha de nacimiento: " + autor.getAnoNacimiento());
        System.out.println("Fecha de fallecimiento: " + autor.getAnoFallecimiento());
        System.out.println("Libros: " + obtenerTitulosLibros(autor.getLibros()));
        System.out.println("-----------------------");
    }


    private String obtenerTitulosLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            return "No hay libros registrados para este autor.";
        } else {
            return libros.stream()
                    .map(Libro::getTitulo)
                    .collect(Collectors.joining(", "));
        }
    }
}
