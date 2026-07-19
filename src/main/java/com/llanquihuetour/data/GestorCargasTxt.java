package com.llanquihuetour.data;

import com.llanquihuetour.exceptions.RutException;
import com.llanquihuetour.model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GestorCargasTxt {
    private static final String NOMBRE_ARCHIVO_ALOJAMIENTOS = "/alojamientos.txt";
    private static final String NOMBRE_ARCHIVO_CLIENTES = "/clientes.txt";
    private static final String NOMBRE_ARCHIVO_GUIAS = "/guias.txt";
    private static final String NOMBRE_ARCHIVO_OPERADORES = "/operadores.txt";
    private static final String NOMBRE_ARCHIVO_TOURS = "/tours.txt";
    private List<IRegistrable> todos = new ArrayList<>();

    public GestorCargasTxt() {
        this.cargarTodosLosArchivos();
    }

    private List<IRegistrable> buildAlojamientosFromFile() throws FileNotFoundException {
        List<IRegistrable> alojamientos = new ArrayList<>();

        try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_ALOJAMIENTOS)))) {
            if(!sc.hasNextLine()) {
                System.out.println("No hay registros para gestionar.");
                throw new FileNotFoundException("No hay registros para gestionar.");
            }

            while(sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 5) {
                    try {
                        IRegistrable alojamiento = new ProveedorAlojamiento(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), partes[4]);
                        alojamientos.add(alojamiento);
                    } catch (RutException e) {
                        System.out.println("Error al cargar alojamiento. Error: " + e.getMessage());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        return alojamientos;
    };

    private List<IRegistrable> buildClientesFromFile() throws FileNotFoundException {
        List<IRegistrable> clientes = new ArrayList<>();

        try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_CLIENTES)))) {
            if(!sc.hasNextLine()) {
                System.out.println("No hay registros para gestionar.");
                throw new FileNotFoundException("No hay registros para gestionar.");
            }

            while(sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 9) {
                    try {
                        Direccion direccion = new Direccion(partes[4], partes[5], partes[6], partes[7], partes[8]);
                        IRegistrable cliente = new Cliente(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), direccion);
                        clientes.add(cliente);
                    } catch (RutException e) {
                        System.out.println("Error al cargar cliente. Error: " + e.getMessage());
                    }
                } else if (partes.length == 4) {
                    try {
                        IRegistrable cliente = new Cliente(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]));
                        clientes.add(cliente);
                    } catch (RutException e) {
                        System.out.println("Error al cargar cliente. Error: " + e.getMessage());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        return clientes;
    };

    private List<IRegistrable> buildGuiasFromFile() throws FileNotFoundException {
        List<IRegistrable> guias = new ArrayList<>();

        try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_GUIAS)))) {
            if(!sc.hasNextLine()) {
                System.out.println("No hay registros para gestionar.");
                throw new FileNotFoundException("No hay registros para gestionar.");
            }

            while(sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 5) {
                    try {
                        IRegistrable guia = new GuiaTuristico(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), partes[4]);
                        guias.add(guia);
                    } catch (RutException e) {
                        System.out.println("Error al cargar guia. Error: " + e.getMessage());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        return guias;
    };

    private List<IRegistrable> buildOperadoresFromFile() throws FileNotFoundException {
        List<IRegistrable> operadores = new ArrayList<>();

        try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_OPERADORES)))) {
            if(!sc.hasNextLine()) {
                System.out.println("No hay registros para gestionar.");
                throw new FileNotFoundException("No hay registros para gestionar.");
            }

            while(sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 5) {
                    try {
                        IRegistrable operador = new OperadorTransporte(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), partes[4]);
                        operadores.add(operador);
                    } catch (RutException e) {
                        System.out.println("Error al cargar operador. Error: " + e.getMessage());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        return operadores;
    };

    private List<IRegistrable> buildToursFromFile() throws FileNotFoundException {
        List<IRegistrable> tours = new ArrayList<>();

        try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_TOURS)))) {
            if(!sc.hasNextLine()) {
                System.out.println("No hay registros para gestionar.");
                throw new FileNotFoundException("No hay registros para gestionar.");
            }

            while(sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");

                if (partes.length == 4) {
                    try {
                        IRegistrable tour = new Tour(partes[0], partes[1], Integer.parseInt(partes[2]), Double.parseDouble(partes[3]));
                        tours.add(tour);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al cargar tour. Error: " + e.getMessage());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        return tours;
    };

    private void cargarTodosLosArchivos() {
        try {
            todos.addAll(buildAlojamientosFromFile());
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar alojamientos. Error: " + e.getMessage());
        }

        try {
            todos.addAll(buildClientesFromFile());
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar clientes. Error: " + e.getMessage());
        }

        try {
            todos.addAll(buildGuiasFromFile());
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar guias. Error: " + e.getMessage());
        }

        try {
            todos.addAll(buildOperadoresFromFile());
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar operadores. Error: " + e.getMessage());
        }

        try {
            todos.addAll(buildToursFromFile());
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar tours. Error: " + e.getMessage());
        }
    }

    public List<IRegistrable> getAll() {
        return todos;
    }

    public void agregarRegistrable(IRegistrable registrable) {
        todos.add(registrable);
    }

    public List<IRegistrable> getAlojamientos() {
        List<IRegistrable> alojamientos = new ArrayList<>();
        for (IRegistrable registrable : todos) {
            if(registrable instanceof ProveedorAlojamiento) {
                alojamientos.add(registrable);
            }
        }
        return alojamientos;
    }

    public List<IRegistrable> getClientes() {
        List<IRegistrable> clientes = new ArrayList<>();
        for (IRegistrable registrable : todos) {
            if(registrable instanceof Cliente) {
                clientes.add(registrable);
            }
        }
        return clientes;
    }

    public List<IRegistrable> getGuias() {
        List<IRegistrable> guias = new ArrayList<>();
        for (IRegistrable registrable : todos) {
            if(registrable instanceof GuiaTuristico) {
                guias.add(registrable);
            }
        }
        return guias;
    }

    public List<IRegistrable> getOperadores() {
        List<IRegistrable> operadores = new ArrayList<>();
        for (IRegistrable registrable : todos) {
            if(registrable instanceof OperadorTransporte) {
                operadores.add(registrable);
            }
        }
        return operadores;
    }
}
