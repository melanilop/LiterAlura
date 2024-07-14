package com.alura.literalura.principalprueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static List<String> libros = new ArrayList<>();

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.iniciar();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    agregarLibro(scanner);
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    System.out.println("¡Vuelva pronto a literalura!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("+++++/+++++/+++++/+++++/+++++/+++++");
        System.out.println("+ + + BIENVENIDO A LITERALURA + + +");
        System.out.println("+++++/+++++/+++++/+++++/+++++/+++++");


        System.out.println("Menú:");
        System.out.println("1. Buscar libros por título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Listar autores vivos en un determinado año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("6. Salir");
        System.out.print("Por favor, elija una opción: ");
    }

    private void agregarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String libro = scanner.nextLine();
        libros.add(libro);
        System.out.println("Libro agregado con éxito!");
    }

    private void mostrarLibros() {
        System.out.println("Libros:");
        for (String libro : libros) {
            System.out.println(libro);
        }
    }
}

