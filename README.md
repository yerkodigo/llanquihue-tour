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

LlanquihueTourApp es una aplicación desarrollada en Java para la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos. El sistema permite gestionar servicios turísticos, clientes y tours mediante la carga de datos desde archivos externos y el registro manual desde una interfaz gráfica, aplicando operaciones de recorrido, filtrado y visualización.

El proyecto aplica principios de Programación Orientada a Objetos como encapsulamiento, composición, **herencia**, **interfaces** y **polimorfismo**, además de una organización modular en paquetes funcionales.

---

## Paquetes y clases implementadas

```plaintext
src/main/java/com/llanquihuetour/
├── model/
│   ├── Registrable.java        # Interfaz; define el contrato mostrarResumen()
│   ├── ServicioTuristico.java  # Clase base con nombre y duracionHoras; implementa Registrable
│   ├── ExcursionCultural.java  # Subclase; agrega lugarHistorico; sobreescribe mostrarInformacion() y mostrarResumen()
│   ├── PaseoLacustre.java      # Subclase; agrega tipoEmbarcacion; sobreescribe mostrarInformacion() y mostrarResumen()
│   ├── RutaGastronomica.java   # Subclase; agrega numeroDeParadas; sobreescribe mostrarInformacion() y mostrarResumen()
│   ├── Tour.java               # Modela un tour con nombre, tipo, duración y precio; implementa Registrable
│   ├── Cliente.java            # Modela un cliente con nombre, RUT, correo y edad; implementa Registrable
│   └── Reserva.java            # Modela una reserva; tiene composición con Tour y Cliente
├── data/
│   ├── GestorDatos.java        # Carga datos desde archivos externos y gestiona colecciones
│   ├── GestorServicios.java    # Crea instancias de los servicios turísticos para demostración
│   └── GestorEntidades.java    # Arma y recorre una ArrayList<Registrable> con objetos de distintas clases
└── ui/
    └── Main.java               # Punto de entrada; orquesta la carga, filtrado, visualización e interfaz gráfica

src/main/resources/
├── tours.txt            # Datos de tours en formato CSV separado por ;
└── clientes.xlsx        # Datos de clientes en formato Excel (.xlsx)
```

### Jerarquía de herencia — ServicioTuristico

`ServicioTuristico` es la clase base. Las tres subclases extienden sus atributos comunes con información específica de cada tipo de servicio. Cada subclase sobreescribe `mostrarInformacion()` accediendo directamente a los atributos del padre mediante los getters `getNombre()` y `getDuracionHoras()`.

```
ServicioTuristico
 ├── ExcursionCultural  → lugarHistorico: String
 ├── PaseoLacustre      → tipoEmbarcacion: String
 └── RutaGastronomica   → numeroDeParadas: int
```

### Relaciones entre clases — Reserva

`Reserva` aplica **composición** con `Tour` y `Cliente`: una reserva contiene una instancia de cada una, reflejando que un cliente reserva un tour específico.

```
Reserva
 ├── cliente: Cliente
 └── tour: Tour
```

### Interfaz `Registrable` y polimorfismo

`Registrable` define el contrato `mostrarResumen()`. La implementan clases sin relación de herencia entre sí, lo que permite tratarlas de forma polimórfica en una misma colección:

```
Registrable (interfaz)
 ├── ServicioTuristico  → mostrarResumen() (heredado y sobreescrito por sus 3 subclases)
 ├── Cliente            → mostrarResumen()
 └── Tour                → mostrarResumen()
```

`GestorEntidades` arma una `ArrayList<Registrable>` con objetos de estas distintas clases, la recorre con `for-each` y usa **pattern matching para `instanceof`** (`entidad instanceof Cliente cliente`) para aplicar lógica diferenciada según el tipo real de cada objeto.

### Interfaz gráfica (GUI)

`Main.java` levanta un menú simple con `JOptionPane` que permite:
- Registrar un `Cliente` o un `Tour` ingresando sus datos por cuadros de diálogo.
- Ver un resumen de todas las entidades registradas, mostrando el resultado de `mostrarResumen()` de cada una.

No hay persistencia: las entidades se mantienen en memoria mientras la aplicación está abierta.

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

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa Semana 8
