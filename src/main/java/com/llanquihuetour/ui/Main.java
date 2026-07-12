package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorDatos;
import com.llanquihuetour.data.GestorEntidades;
import com.llanquihuetour.data.GestorServicios;
import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.Registrable;
import com.llanquihuetour.model.ServicioTuristico;
import com.llanquihuetour.model.Tour;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        mostrarListaTours();
        // Encargo de semana 05
//        visualizacionDeClientes();

        // Semana 06
//        List<ServicioTuristico> instancias = GestorServicios.pruebaDeInstancias();
//        if (!instancias.isEmpty()) {
//            System.out.println("*******************************************");
//            System.out.println("Semana 06 - Instancias: ");
//            System.out.println("*******************************************");
//            instancias.forEach(e -> {
//                System.out.println(e.toString());
//            });
//        }

        // Semana 07
//        System.out.println("*******************************************");
//        System.out.println("Semana 07: ");
//        System.out.println("*******************************************");
//        verListaServicios();

        // Semana 08
        iniciarInterfazGrafica();

        // Paso 2
        ArrayList<Registrable> entidades = GestorEntidades.cargarEntidades();
        GestorEntidades.mostrarResumenEntidades(entidades);
    }

    private static void iniciarInterfazGrafica() {
        List<Registrable> entidades = new ArrayList<>();
        String[] opciones = {"Registrar Cliente", "Registrar Tour", "Mostrar Resumen", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Llanquihue Tour App",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0 -> registrarCliente(entidades);
                case 1 -> registrarTour(entidades);
                case 2 -> mostrarResumenEntidades(entidades);
                default -> { }
            }
        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }

    private static void registrarCliente(List<Registrable> entidades) {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        if (nombre == null) return;

        String rut = JOptionPane.showInputDialog("RUT del cliente:");
        String correo = JOptionPane.showInputDialog("Correo del cliente:");
        String edadTexto = JOptionPane.showInputDialog("Edad del cliente:");

        try {
            int edad = Integer.parseInt(edadTexto);
            Cliente cliente = new Cliente(nombre, rut, correo, edad);
            entidades.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente registrado:\n" + cliente.mostrarResumen());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void registrarTour(List<Registrable> entidades) {
        String nombre = JOptionPane.showInputDialog("Nombre del tour:");
        if (nombre == null) return;

        String tipo = JOptionPane.showInputDialog("Tipo del tour (ej: gastronómico, aventura):");
        String duracionTexto = JOptionPane.showInputDialog("Duración en horas:");
        String precioTexto = JOptionPane.showInputDialog("Precio del tour:");

        try {
            int duracionHoras = Integer.parseInt(duracionTexto);
            double precio = Double.parseDouble(precioTexto);
            Tour tour = new Tour(nombre, tipo, duracionHoras, precio);
            entidades.add(tour);
            JOptionPane.showMessageDialog(null, "Tour registrado:\n" + tour.mostrarResumen());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La duración o el precio ingresados no son válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarResumenEntidades(List<Registrable> entidades) {
        if (entidades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aún no hay entidades registradas.");
            return;
        }

        StringBuilder resumen = new StringBuilder();
        for (Registrable entidad : entidades) {
            resumen.append(entidad.mostrarResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, resumen.toString(), "Resumen de entidades", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void visualizacionDeClientes() {
        GestorDatos gestor = new GestorDatos();

        gestor.cargarDesdeExcel("/clientes.xlsx");

        System.out.println("*******************************************");
        System.out.println("Todos los clientes:");
        System.out.println("*******************************************");
        gestor.listarClientes();
        System.out.println("\n");

        int edad = 18;
        System.out.println("*******************************************");
        System.out.println("Clientes mayores de " + edad + " años:");
        System.out.println("*******************************************");
        for (Cliente cliente : gestor.filtrarEdadMayor(edad)) {
            System.out.println("Cliente: " + cliente.getNombre() + " con rut: " + cliente.getRut() + " tiene " + cliente.getEdad() + " años.");
        }
        System.out.println("\n");
    }

    private static void mostrarListaTours() {
        try {
            GestorDatos gestor = new GestorDatos();
            List<Tour> listaTours = gestor.buildToursFromFile();
            if (!listaTours.isEmpty()) {
                System.out.println("*********************");
                System.out.println("Lista de Tours: ");
                System.out.println("*********************");
    //        1. Muestra todos los elementos de la colección (recorrido)
                listaTours.forEach(tour -> {
                    System.out.println(tour.showInConsole());
                });
                System.out.println("\n");
            }
            //        2. Filtra según una condición (por ejemplo, producción > 1000, tipo == "gastronómico", stock > 0)
            List<Tour> filtradoEconomicos = listaTours.stream().filter(tour -> tour.getPrecio() < 40000).toList();
            List<Tour> filtradoGastronomicos = listaTours.stream().filter(tour -> "gastronómico".equalsIgnoreCase(tour.getTipo().trim())).toList();

            //        3. Imprime los resultados filtrados
            System.out.println("*********************");
            System.out.println("Tours Económicos: ");
            System.out.println("*********************");
            for (Tour tour : filtradoEconomicos) {
                System.out.println(tour.showInConsole());
            }
            System.out.println("\n");

            System.out.println("*********************");
            System.out.println("Tours Gastronómicos: ");
            System.out.println("*********************");
            for (Tour tour : filtradoGastronomicos) {
                System.out.println(tour.showInConsole());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void verListaServicios() {
        List<ServicioTuristico> servicios = GestorServicios.cargaDeServiciosTuristicos();

        for (ServicioTuristico servicio : servicios) {
            System.out.println(servicio.mostrarInformacion());
        }
    }
}
