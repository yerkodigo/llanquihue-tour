package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorCargasTxt;
import com.llanquihuetour.exceptions.RutException;
import com.llanquihuetour.model.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

// NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
// import com.llanquihuetour.data.GestorDatos;
// import com.llanquihuetour.data.GestorServicios;
// import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        iniciarInterfazGrafica();
    }

    private static void getListadoProveedoresAlojamiento(GestorCargasTxt gestorCargasTxt) {
        List<IRegistrable> proveedoresAlojamiento = gestorCargasTxt.getAlojamientos();

        if (proveedoresAlojamiento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aún no hay proveedores de alojamiento registrados.");
            return;
        }

        StringBuilder listado = new StringBuilder();
        for (IRegistrable registrable : proveedoresAlojamiento) {
            listado.append(registrable.mostrarResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString(), "Proveedores de alojamiento", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void getListadoClientes(GestorCargasTxt gestorCargasTxt) {
        List<IRegistrable> clientes = gestorCargasTxt.getClientes();

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aún no hay clientes registrados.");
            return;
        }

        JTextArea textArea = new JTextArea(15, 60);
        textArea.setEditable(false);
        textArea.setText(construirListadoClientes(clientes));

        JButton botonFiltrar = new JButton("Filtrar menores de edad");
        JButton botonTodos = new JButton("Mostrar todos los clientes");

        botonFiltrar.addActionListener(e -> {
            List<IRegistrable> menoresDeEdad = new ArrayList<>();
            for (IRegistrable registrable : clientes) {
                if (registrable instanceof Cliente cliente && cliente.getEdad() < 18) {
                    menoresDeEdad.add(registrable);
                }
            }
            textArea.setText(construirListadoClientes(menoresDeEdad));
        });

        botonTodos.addActionListener(e -> {
            textArea.setText(construirListadoClientes(clientes));
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonFiltrar);
        panelBotones.add(botonTodos);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, panel, "Clientes", JOptionPane.PLAIN_MESSAGE);
    }

    private static String construirListadoClientes(List<IRegistrable> clientes) {
        if (clientes.isEmpty()) {
            return "No hay clientes que coincidan.";
        }

        StringBuilder listado = new StringBuilder();
        for (IRegistrable registrable : clientes) {
            listado.append(registrable.mostrarResumen()).append("\n");
        }
        return listado.toString();
    }

    private static void getListadoGuias(GestorCargasTxt gestorCargasTxt) {
        List<IRegistrable> guias = gestorCargasTxt.getGuias();

        if (guias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aún no hay guías registrados.");
            return;
        }

        StringBuilder listado = new StringBuilder();
        for (IRegistrable registrable : guias) {
            listado.append(registrable.mostrarResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString(), "Guías turísticos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void getListadoOperadores(GestorCargasTxt gestorCargasTxt) {
        List<IRegistrable> operadores = gestorCargasTxt.getOperadores();

        if (operadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aún no hay operadores de transporte registrados.");
            return;
        }

        StringBuilder listado = new StringBuilder();
        for (IRegistrable registrable : operadores) {
            listado.append(registrable.mostrarResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString(), "Operadores de transporte", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void iniciarInterfazGrafica() {
        GestorCargasTxt gestorCargasTxt = new GestorCargasTxt();

        String[] opciones = {
                "Registrar Cliente",
                "Listar Proveedores de alojamiento",
                "Listar Clientes",
                "Listar Guías",
                "Listar Operadores",
                "Listar todos los registros",
                "Salir"
        };
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
                case 0 -> registrarCliente(gestorCargasTxt);
                case 1 -> getListadoProveedoresAlojamiento(gestorCargasTxt);
                case 2 -> getListadoClientes(gestorCargasTxt);
                case 3 -> getListadoGuias(gestorCargasTxt);
                case 4 -> getListadoOperadores(gestorCargasTxt);
                case 5 -> mostrarTodosLosRegistros(gestorCargasTxt);
                default -> { }
            }
        } while (opcion != 6 && opcion != JOptionPane.CLOSED_OPTION);
    }

    private static void mostrarTodosLosRegistros(GestorCargasTxt gestorCargasTxt) {
        List<IRegistrable> todosLosRegistros = gestorCargasTxt.getAll();

        if (todosLosRegistros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aún no hay guías registrados.");
            return;
        }

        StringBuilder listado = new StringBuilder();
        for (IRegistrable registrable : todosLosRegistros) {
            listado.append(registrable.mostrarResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString(), "Guías turísticos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void registrarCliente(GestorCargasTxt gestorCargasTxt) {
        while (true) {
            String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
            if (nombre == null) return;

            String rut = JOptionPane.showInputDialog("RUT del cliente:");
            String correo = JOptionPane.showInputDialog("Correo del cliente:");
            String edadTexto = JOptionPane.showInputDialog("Edad del cliente:");

            try {
                int edad = Integer.parseInt(edadTexto);
                Cliente cliente = new Cliente(nombre, rut, correo, edad);
                gestorCargasTxt.agregarRegistrable(cliente);
                JOptionPane.showMessageDialog(null, "Cliente registrado:\n" + cliente.mostrarResumen());
                return;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La edad ingresada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (RutException | IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
    // private static void registrarTour(List<IRegistrable> entidades) {
    //     String nombre = JOptionPane.showInputDialog("Nombre del tour:");
    //     if (nombre == null) return;
    //
    //     String tipo = JOptionPane.showInputDialog("Tipo del tour (ej: gastronómico, aventura):");
    //     String duracionTexto = JOptionPane.showInputDialog("Duración en horas:");
    //     String precioTexto = JOptionPane.showInputDialog("Precio del tour:");
    //
    //     try {
    //         int duracionHoras = Integer.parseInt(duracionTexto);
    //         double precio = Double.parseDouble(precioTexto);
    //         Tour tour = new Tour(nombre, tipo, duracionHoras, precio);
    //         entidades.add(tour);
    //         JOptionPane.showMessageDialog(null, "Tour registrado:\n" + tour.mostrarResumen());
    //     } catch (NumberFormatException e) {
    //         JOptionPane.showMessageDialog(null, "La duración o el precio ingresados no son válidos.", "Error", JOptionPane.ERROR_MESSAGE);
    //     }
    // }

    // NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
    // private static void mostrarResumenEntidades(List<IRegistrable> entidades) {
    //     if (entidades.isEmpty()) {
    //         JOptionPane.showMessageDialog(null, "Aún no hay entidades registradas.");
    //         return;
    //     }
    //
    //     StringBuilder resumen = new StringBuilder();
    //     for (IRegistrable entidad : entidades) {
    //         resumen.append(entidad.mostrarResumen()).append("\n");
    //     }
    //
    //     JOptionPane.showMessageDialog(null, resumen.toString(), "Resumen de entidades", JOptionPane.INFORMATION_MESSAGE);
    // }

    // NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
    // private static void visualizacionDeClientes() {
    //     GestorDatos gestor = new GestorDatos();
    //
    //     gestor.cargarDesdeExcel("/clientes.xlsx");
    //
    //     System.out.println("*******************************************");
    //     System.out.println("Todos los clientes:");
    //     System.out.println("*******************************************");
    //     gestor.listarClientes();
    //     System.out.println("\n");
    //
    //     int edad = 18;
    //     System.out.println("*******************************************");
    //     System.out.println("Clientes mayores de " + edad + " años:");
    //     System.out.println("*******************************************");
    //     for (Cliente cliente : gestor.filtrarEdadMayor(edad)) {
    //         System.out.println("Cliente: " + cliente.getNombre() + " con rut: " + cliente.getRut() + " tiene " + cliente.getEdad() + " años.");
    //     }
    //     System.out.println("\n");
    // }

    // NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
    // private static void mostrarListaTours() {
    //     try {
    //         GestorDatos gestor = new GestorDatos();
    //         List<Tour> listaTours = gestor.buildToursFromFile();
    //         if (!listaTours.isEmpty()) {
    //             System.out.println("*********************");
    //             System.out.println("Lista de Tours: ");
    //             System.out.println("*********************");
    // //        1. Muestra todos los elementos de la colección (recorrido)
    //             listaTours.forEach(tour -> {
    //                 System.out.println(tour.showInConsole());
    //             });
    //             System.out.println("\n");
    //         }
    //         //        2. Filtra según una condición (por ejemplo, producción > 1000, tipo == "gastronómico", stock > 0)
    //         List<Tour> filtradoEconomicos = listaTours.stream().filter(tour -> tour.getPrecio() < 40000).toList();
    //         List<Tour> filtradoGastronomicos = listaTours.stream().filter(tour -> "gastronómico".equalsIgnoreCase(tour.getTipo().trim())).toList();
    //
    //         //        3. Imprime los resultados filtrados
    //         System.out.println("*********************");
    //         System.out.println("Tours Económicos: ");
    //         System.out.println("*********************");
    //         for (Tour tour : filtradoEconomicos) {
    //             System.out.println(tour.showInConsole());
    //         }
    //         System.out.println("\n");
    //
    //         System.out.println("*********************");
    //         System.out.println("Tours Gastronómicos: ");
    //         System.out.println("*********************");
    //         for (Tour tour : filtradoGastronomicos) {
    //             System.out.println(tour.showInConsole());
    //         }
    //
    //     } catch (FileNotFoundException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    // NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
    // private static void verListaServicios() {
    //     List<ServicioTuristico> servicios = GestorServicios.cargaDeServiciosTuristicos();
    //
    //     for (ServicioTuristico servicio : servicios) {
    //         System.out.println(servicio.mostrarInformacion());
    //     }
    // }
}
