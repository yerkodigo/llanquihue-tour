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

LlanquihueTourApp es una aplicación desarrollada en Java para la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos. El sistema permite gestionar clientes, guías turísticos, operadores de transporte, proveedores de alojamiento y tours, cargando los datos desde archivos `.txt` y permitiendo registrar nuevos clientes, listar cada tipo de entidad y filtrar clientes por edad, todo mediante una interfaz gráfica basada en `JOptionPane`.

El proyecto aplica principios de Programación Orientada a Objetos como encapsulamiento, composición, **herencia**, **interfaces** y **polimorfismo**, además de una organización modular en paquetes funcionales.

---

## Paquetes y clases implementadas

```plaintext
src/main/java/com/llanquihuetour/
├── model/
│   ├── IRegistrable.java        # Interfaz; define el contrato mostrarResumen()
│   ├── Persona.java             # Clase base: nombre, Rut, correo, edad y Direccion (opcional)
│   ├── Rut.java                 # Encapsula número + dígito verificador; valida con RutException
│   ├── Direccion.java           # calle, número, comuna, ciudad, código postal (compuesta en Persona)
│   ├── Cliente.java             # extends Persona, implements IRegistrable
│   ├── GuiaTuristico.java       # extends Persona, implements IRegistrable; agrega idioma
│   ├── OperadorTransporte.java  # extends Persona, implements IRegistrable; agrega tipoVehiculo
│   ├── ProveedorAlojamiento.java # extends Persona, implements IRegistrable; agrega nombreAlojamiento
│   └── Tour.java                # implements IRegistrable; nombre, tipo, duracionHoras, precio
├── exceptions/
│   └── RutException.java        # Excepción personalizada para RUTs con formato o dígito verificador inválido
├── data/
│   └── GestorCargasTxt.java     # Carga los .txt de resources, arma un ArrayList<IRegistrable> único y expone filtros por tipo
└── ui/
    └── Main.java                # Punto de entrada; menú gráfico con JOptionPane

src/main/resources/
├── alojamientos.txt   # nombre;rut;correo;edad;nombreAlojamiento
├── clientes.txt        # nombre;rut;correo;edad;calle;numero;comuna;ciudad;codigoPostal (la dirección es opcional)
├── guias.txt            # nombre;rut;correo;edad;idioma
├── operadores.txt       # nombre;rut;correo;edad;tipoVehiculo
└── tours.txt             # nombre;tipo;duracionHoras;precio
```

### Jerarquía de herencia — Persona

`Persona` es la clase base con los atributos comunes a toda persona del sistema. Cada subclase agrega su propio atributo específico y sobreescribe `toString()` y `mostrarResumen()`.

```
Persona
 ├── Cliente               → (sin atributos adicionales)
 ├── GuiaTuristico          → idioma: String
 ├── OperadorTransporte     → tipoVehiculo: String
 └── ProveedorAlojamiento   → nombreAlojamiento: String
```

### Composición — Persona, Rut y Direccion

`Persona` se compone de un `Rut` (validado al construirse, lanza `RutException` si el dígito verificador no corresponde) y, opcionalmente, de una `Direccion`. Si el archivo `.txt` de origen no trae los campos de dirección, el `Cliente` se crea igualmente con `direccion = null`, y se muestra como "Sin dirección" en los listados.

### Interfaz `IRegistrable` y polimorfismo

`IRegistrable` define el contrato `mostrarResumen()`. La implementan `Cliente`, `GuiaTuristico`, `OperadorTransporte`, `ProveedorAlojamiento` y `Tour`, clases sin relación de herencia directa entre sí (salvo las 4 primeras que comparten `Persona`), lo que permite tratarlas de forma polimórfica en una misma colección `List<IRegistrable>`.

`GestorCargasTxt` mantiene internamente un único `ArrayList<IRegistrable>` con todas las entidades cargadas, y expone métodos que lo recorren con **pattern matching para `instanceof`** (`registrable instanceof Cliente cliente`) para filtrar por tipo real de objeto.

### Interfaz gráfica (GUI)

`Main.java` levanta un menú con `JOptionPane` que permite:
- **Registrar Cliente**: ingresa los datos por cuadros de diálogo; si el RUT es inválido, muestra el error y vuelve a pedir los datos sin salir al menú principal.
- **Listar Proveedores de alojamiento / Clientes / Guías / Operadores**: muestra el resumen (`mostrarResumen()`) de cada entidad de ese tipo.
- El listado de **Clientes** incluye además un panel con botones "Filtrar menores de edad" y "Mostrar todos los clientes", que recalculan el contenido del listado sin cerrar el diálogo.
- **Listar todos los registros**: muestra todas las entidades cargadas, sin importar su tipo.

Los clientes registrados desde la GUI se agregan a la misma colección que alimenta los `.txt`, por lo que aparecen inmediatamente en los listados.

---

## Archivos de datos

Todos los archivos están en `src/main/resources/`, en formato CSV separado por `;`, con un máximo de 5 registros de prueba cada uno.

**tours.txt**
```
nombre;tipo;duracionHoras;precio
Ruta del Salmón y el Volcán;gastronómico;6;45000
```

**clientes.txt** (la dirección es opcional; si falta, el cliente se carga con `direccion = null`)
```
nombre;rut;correo;edad;calle;numero;comuna;ciudad;codigoPostal
Camila Soto Reyes;15678234-3;camila.soto@correo.cl;28;Calle Bulnes;245;Llanquihue;Llanquihue;5610000
```

**guias.txt**
```
nombre;rut;correo;edad;idioma
Pedro Alarcón Vásquez;17345678-6;pedro.alarcon@llanquihuetour.cl;41;Español
```

**operadores.txt**
```
nombre;rut;correo;edad;tipoVehiculo
Luis Barría Cárdenas;16543210-K;luis.barria@llanquihuetour.cl;48;Minibús
```

**alojamientos.txt**
```
nombre;rut;correo;edad;nombreAlojamiento
Marcela Torres Uribe;15987654-3;marcela.torres@llanquihuetour.cl;50;Hostal Volcán Osorno
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
**Fecha de entrega:** 19/07/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | EFT Evaluación Final Transversal - Semana 9
