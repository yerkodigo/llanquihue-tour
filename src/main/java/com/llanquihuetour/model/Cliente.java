package com.llanquihuetour.model;

import com.llanquihuetour.exceptions.RutException;

/**
 * Modela un cliente con nombre, RUT, correo y edad
 */
public class Cliente extends Persona implements IRegistrable {

    public Cliente(String nombre, String rut, String correo, int edad) throws RutException {
        super(nombre, rut, correo, edad);
    }

    public Cliente(String nombre, String rut, String correo, int edad, Direccion direccion) throws RutException {
        super(nombre, rut, correo, edad, direccion);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + this.getNombre() + '\'' +
                ", rut='" + this.getRut() + '\'' +
                ", correo='" + this.getCorreo() + '\'' +
                ", edad=" + this.getEdad() +
                ", direccion=" + this.getDireccionTexto() +
                '}';
    }

    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.getNombre() + ", RUT: " + this.getRut() + ", Correo: " + this.getCorreo() + ", Edad: " + this.getEdad() + ", Dirección: " + this.getDireccionTexto();
    }

    private String getDireccionTexto() {
        return this.getDireccion() != null ? this.getDireccion().toString() : "Sin dirección";
    }
}
