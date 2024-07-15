<h1> Challenge LiterAlura </h1>

# Objetivo:
Crear un sistema de Catálogo de Libros que permita a los usuarios interactuar mediante texto 
en la consola, ofreciendo al menos cinco formas diferentes de interacción. 
Los usuarios podrán buscar libros utilizando una API de nombre "Gutendex".

Nuestro menú contiene:

    1. Buscar libro por título
    2. Listar libros registrados"
    3. Listar autores registrados
    4. Listar autores vivos en un determinado año
    5. Listar libros por idioma
    6. Salir

<h2>Requisitos: </h2>

:sparkles: Java JDK -> versión 17 en adelante

:sparkles: Maven -> versión 4 en adelante 

:sparkles: Spring -> versión 3.2.3 

:sparkles: PostreSQL -> versión 16 en adelante

:sparkles: IDE -> IntelliJ

Configura tu proyecto en Spring Initializr(start.spring.io):

Java-> versión 17 en adelante 
Maven-> Por defecto Spring Initializr utiliza la versión 4 (última actualización: 10 de julio de 2024)
Spring Boot -> versión 3.2.3
Proyecto en JAR

❗ # No olvides agregar las dependencias:
Spring Data JPA
Postgres Driver

# También trabajaremos con:

-> Cliente para Solicitudes (HttpClient)

-> Construyendo la Solicitud (HttpRequest)

-> Construyendo la Respuesta (HttpResponse)

# Pasos esenciales para la ejecución de ✨Literalura✨:
    Configuración del Ambiente Java;

    - Creación del Proyecto;

    - Consumo de la API;

    - Análisis de la Respuesta JSON;

    - Inserción y consulta en la base de datos;

    - Exibición de resultados a los usuarios;

:computer: Capturas de pantalla de la ejecución: 

Menú de opciones:
<img width="1329" alt="MenuOp" src="https://github.com/user-attachments/assets/c56088fc-3376-478e-a2a0-ecd2c09a1341">

Opción 1:

<img width="1017" alt="op1" src="https://github.com/user-attachments/assets/a8294a34-1595-49cb-ba99-c2eaa7bcdc4f">

Opción 2:

<img width="1017" alt="op2" src="https://github.com/user-attachments/assets/563939d7-f500-4841-9142-086e89ff3e78">

Opción 3:

<img width="1017" alt="op3" src="https://github.com/user-attachments/assets/008f373c-cfef-4cf2-ad29-a2e9e922eaa5">

Opción 4:

<img width="1017" alt="op4" src="https://github.com/user-attachments/assets/902356c8-4df2-49b1-b256-1926adf5ca45">

Opción 5:

<img width="1017" alt="op5" src="https://github.com/user-attachments/assets/41f24130-12f7-474c-b23a-3dcce5540bc9">

Opción 5 también muestra la cantidad de libros en el idioma elegido:

<img width="1017" alt="opc5cant" src="https://github.com/user-attachments/assets/f368e1df-9a71-4bbc-bb9d-b2f375417867">

Opción 6 (salir):

<img width="1017" alt="salir" src="https://github.com/user-attachments/assets/867311fe-9d00-4501-b137-935405b6088c">


Si el usuario digita una opción que no existe en el menú:

<img width="1017" alt="opinval" src="https://github.com/user-attachments/assets/b561a238-c2d7-41c1-9d60-fb739d07a243">

Si el usuario digita un libro que ya se registró en la BD:

<img width="1017" alt="existente" src="https://github.com/user-attachments/assets/3d766961-add2-4864-adaf-7e68ad3f9b2b">

Si el usuario escribe un libro que no se encuentra en el catálogo de Gutendex:

<img width="1017" alt="noengutendx" src="https://github.com/user-attachments/assets/59aec6b9-92ae-4e92-8ec5-dd4404533ac4">

# Autor: Melani Lopez 


  
