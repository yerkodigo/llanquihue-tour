package com.llanquihuetour.model;

/**
 * Modela un cliente con nombre, RUT, correo y edad
 */
public class Cliente {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
}
