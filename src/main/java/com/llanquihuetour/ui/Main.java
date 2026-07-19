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
            JOptionPane.showMessageDialog(null, "Aún no hay registros.");
            return;
        }

        StringBuilder listado = new StringBuilder();
        for (IRegistrable registrable : todosLosRegistros) {
            listado.append(registrable.mostrarResumen()).append("\n");
        }

        JOptionPane.showMessageDialog(null, listado.toString(), "Todos los registros", JOptionPane.INFORMATION_MESSAGE);
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
}
