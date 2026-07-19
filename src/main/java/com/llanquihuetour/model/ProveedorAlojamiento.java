package com.llanquihuetour.model;

import com.llanquihuetour.exceptions.RutException;

public class ProveedorAlojamiento extends Persona implements IRegistrable {
    private String nombreAlojamiento;

    public ProveedorAlojamiento(String nombre, String rut, String correo, int edad, String nombreAlojamiento) throws RutException {
        super(nombre, rut, correo, edad);
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    @Override
    public String toString() {
        return "ProveedorAlojamiento{" +
                "nombre='" + this.getNombre() + '\'' +
                ", rut='" + this.getRut() + '\'' +
                ", correo='" + this.getCorreo() + '\'' +
                ", edad=" + this.getEdad() +
                ", nombreAlojamiento='" + nombreAlojamiento + '\'' +
                '}';
    }

    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.getNombre() + ", RUT: " + this.getRut() + ", Correo: " + this.getCorreo() + ", Edad: " + this.getEdad() + ", Alojamiento: " + nombreAlojamiento;
    }
}
