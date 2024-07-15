package com.alura.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final AutorService autorService;
	private final LibroService libroService;

	public LiteraluraApplication(AutorService autorService, LibroService libroService) {
		this.autorService = autorService;
		this.libroService = libroService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("*****///// BIENVENIDO *****/////");
			System.out.println("1. Buscar libro por título");
			System.out.println("2. Listar libros registrados");
			System.out.println("3. Listar autores registrados");
			System.out.println("4. Listar autores vivos en un determinado año");
			System.out.println("5. Listar libros por idioma");
			System.out.println("6. Salir");

			System.out.print("\nPor favor, digite una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
				case 1:
					System.out.print("Ingrese el título del libro: ");
					scanner.nextLine(); // Consumir el salto de línea pendiente
					String titulo = scanner.nextLine();
					libroService.buscarLibroPorTitulo(titulo);
					break;
				case 2:
					libroService.listarLibrosRegistrados();
					break;
				case 3:
					autorService.listarAutoresRegistrados();
					break;
				case 4:
					System.out.print("Ingrese el año: ");
					int anio = scanner.nextInt();
					autorService.listarAutoresVivosEnUnAnio(anio);
					break;
				case 5:
					System.out.print("Ingrese el idioma: ");
					scanner.nextLine(); // Consumir el salto de línea pendiente
					String idioma = scanner.nextLine();
					libroService.listarLibrosPorIdioma(idioma);
					break;
				case 6:
					System.out.println("¡Adiós!");
					break;
				default:
					System.out.println("Opción inválida");
			}
		} while (opcion != 6);

		scanner.close();
	}
}
