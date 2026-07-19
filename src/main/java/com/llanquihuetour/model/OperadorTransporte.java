package com.llanquihuetour.model;

import com.llanquihuetour.exceptions.RutException;

public class OperadorTransporte extends Persona implements IRegistrable {
    private String tipoVehiculo;

    public OperadorTransporte(String nombre, String rut, String correo, int edad, String tipoVehiculo) throws RutException {
        super(nombre, rut, correo, edad);
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return "OperadorTransporte{" +
                "nombre='" + this.getNombre() + '\'' +
                ", rut='" + this.getRut() + '\'' +
                ", correo='" + this.getCorreo() + '\'' +
                ", edad=" + this.getEdad() +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                '}';
    }

    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.getNombre() + ", RUT: " + this.getRut() + ", Correo: " + this.getCorreo() + ", Edad: " + this.getEdad() + ", Vehículo: " + tipoVehiculo;
    }
}
