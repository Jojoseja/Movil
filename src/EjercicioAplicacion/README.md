# Ejercicio Gestión Juegos de Mesa

## Requisitos de la Aplicacion

1. Registrar varios juegos de mesa con los siguientes datos:
   - Título
   - Autor
   - Número mínimo de jugadores
   - Número máximo de jugadores
   - Duración media en minutos
   - Tipo de juego

2. Distinguir entre juegos de Cartas y juegos de Tablero
   - Cartas: Número de cartas
   - Tablero: Tamaño del tablero

3. Mostrar un menú con las siguientes opciones
   - Alta de juego
   - Listado de juegos
   - Búsqueda por título
   - Salida del programa

4. Los datos se deben validar, no aceptar datos vacíos

5. Guardar la colección en un archivo TXT LEGIBLE y cargarla al iniciar el programa

6. Usar colecciones dinámicas (ArrayList) para almacenar juegos

7. Implementar herencia, encapsulación y polimorfismo
    - Clase abstracta **JuegoMesa**
    - Subclases: **JuegoCartas** y **JuegoTablero**
    - Método getDescripcion() sobreescrito

8. Usar un enum TipoJuego en lugar ede cadenas sueltas

9. Seguir principios SOLID en el diseño de clases

## Clases
- JuegoMesa (abstract)
  - JuegoCartas
  - JuegoTablero