package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorDatos;
import com.llanquihuetour.data.GestorServicios;
import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.ServicioTuristico;
import com.llanquihuetour.model.Tour;

import java.io.FileNotFoundException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        mostrarListaTours();
        // Encargo de semana 05
//        visualizacionDeClientes();

        List<ServicioTuristico> instancias = GestorServicios.pruebaDeInstancias();

        if (!instancias.isEmpty()) {
            System.out.println("*******************************************");
            System.out.println("Semana 06 - Instancias: ");
            System.out.println("*******************************************");
            instancias.forEach(e -> {
                System.out.println(e.toString());
            });
        }
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
}
