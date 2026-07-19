package com.llanquihuetour.model;

import com.llanquihuetour.exceptions.RutException;

public class Persona {
    private String nombre;
    private Rut rut;
    private String correo;
    private int edad;
    private Direccion direccion;

    public Persona() {}

    public Persona(String nombre, String rut, String correo, int edad) throws RutException {
        this.nombre = nombre;
        this.rut = Rut.parse(rut);
        this.correo = correo;
        this.edad = edad;
    }

    public Persona(String nombre, String rut, String correo, int edad, Direccion direccion) throws RutException {
        this.nombre = nombre;
        this.rut = Rut.parse(rut);
        this.correo = correo;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(String rut) throws RutException {
        this.rut = Rut.parse(rut);
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", direccion=" + direccion +
                '}';
    }
}
