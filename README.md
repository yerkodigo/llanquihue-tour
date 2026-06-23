![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# LlanquihueTourApp

---

## Autor del proyecto
- **Nombre completo:** Yerko Cortes Baeza
- **Sección:** I_003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## Descripción general del sistema

LlanquihueTourApp es una aplicación de consola desarrollada en Java para la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos. El sistema permite gestionar tours, clientes y reservas mediante la carga de datos desde archivos externos, aplicando operaciones de recorrido, filtrado y visualización por consola.

El proyecto aplica principios de Programación Orientada a Objetos como encapsulamiento, composición entre clases y organización modular en paquetes funcionales.

---

## Paquetes y clases implementadas

```plaintext
src/main/java/com/llanquihuetour/
├── model/
│   ├── Tour.java        # Modela un tour con nombre, tipo, duración y precio
│   ├── Cliente.java     # Modela un cliente con nombre, RUT, correo y edad
│   └── Reserva.java     # Modela una reserva; tiene composición con Tour y Cliente
├── data/
│   └── GestorDatos.java # Carga datos desde archivos externos y gestiona colecciones
└── ui/
    └── Main.java        # Punto de entrada; orquesta la carga, filtrado y visualización

src/main/resources/
├── tours.txt            # Datos de tours en formato CSV separado por ;
└── clientes.xlsx        # Datos de clientes en formato Excel (.xlsx)
```

### Relaciones entre clases

`Reserva` aplica **composición** con `Tour` y `Cliente`: una reserva contiene una instancia de cada una, reflejando que un cliente reserva un tour específico.

```
Reserva
 ├── cliente: Cliente
 └── tour: Tour
```

---

## Archivos de datos

**tours.txt** — formato CSV separado por `;`:
```
nombre;tipo;duracionHoras;precio
Ruta del Salmón y el Volcán;gastronómico;6;45000
Navegación Lacustre Llanquihue;lacustre;4;32000
```

**clientes.xlsx** — archivo Excel con columnas:
```
nombre | rut | correo | edad
```

---

## Instrucciones para ejecutar el proyecto

### Opción 1 — Desde IntelliJ IDEA

1. Clona el repositorio:
```bash
git clone https://github.com/yerkodigo/llanquihue-tour.git
```
2. Abre el proyecto en IntelliJ IDEA.
3. Ejecuta la clase `Main.java` ubicada en el paquete `ui`.

### Opción 2 — Desde el archivo JAR

En la carpeta `target/` se incluye el JAR ejecutable con todas las dependencias:

```bash
java -jar LlanquhueTourApp-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

**Repositorio GitHub:** https://github.com/yerkodigo/llanquihue-tour
<br>
**Fecha de entrega:** 22/06/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa Semana 5
