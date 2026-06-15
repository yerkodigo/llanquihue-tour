![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# ☕ Actividad Formativa 3: Construyendo una lista de objetos desde archivo.

---

## 👤 Autor del proyecto
- **Nombre completo:** Yerko Cortes Baeza.
- **Sección:** I_003A.
- **Carrera:** Analista Programador Computacional.
- **Sede:** Online

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Actividad Formativa 3 de la asignatura Programación Orientada a Objetos I. Se trata de una aplicación de consola que lee un archivo de texto (`tours.txt`) para construir una lista de objetos `Tour` en memoria. Una vez cargada la lista, el sistema la recorre para mostrar todos los tours disponibles y aplica filtros para obtener subconjuntos según criterios específicos: tours económicos (precio menor a $40.000) y tours de tipo gastronómico.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/main/java/com/llanquihuetour/
├── ui/
│   └── Main.java             # Punto de entrada de la aplicación (método main)
├── data/
│   └── GestorDatos.java      # Lee tours.txt y construye la lista de Tour
└── model/
    └── Tour.java             # Clase que modela un tour con nombre, tipo, duración y precio

📁 src/main/resources/
└── tours.txt                 # Archivo de datos con los tours en formato CSV (;)
```

---

## 🗂️ Formato del archivo de datos

Cada línea de `tours.txt` representa un tour con el siguiente formato separado por `;`:

```
nombre;tipo;duracionHoras;precio
```

**Ejemplo:**
```
Ruta del Salmón y el Volcán;gastronómico;6;45000
Navegación Lacustre Llanquihue;lacustre;4;32000
```

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/yerkodigo/llanquihue-tour.git
```

2. Abre el proyecto en IntelliJ IDEA.

3. Ejecuta el archivo `Main.java` desde el paquete `ui`.

4. Visualiza en consola la lista completa de tours, los tours económicos y los tours gastronómicos.

---

**Repositorio GitHub:** https://github.com/yerkodigo/llanquihue-tour
<br>
**Fecha de entrega:** 15/06/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Formativa 3
