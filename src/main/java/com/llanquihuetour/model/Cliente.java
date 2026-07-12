package com.llanquihuetour.model;

/**
 * Modela un cliente con nombre, RUT, correo y edad
 */
public class Cliente implements Registrable {
    private String nombre;
    private String rut;
    private String correo;
    private int edad;

    public Cliente() {
    }

    public Cliente(String nombre, String rut, String correo,  int edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.nombre + ", RUT: " + this.rut + ", Correo: " + this.correo + ", Edad: " + this.edad;
    }
}
