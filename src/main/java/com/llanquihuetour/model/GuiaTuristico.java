package com.llanquihuetour.model;

import com.llanquihuetour.exceptions.RutException;

public class GuiaTuristico extends Persona implements IRegistrable {
    private String idioma;

    public GuiaTuristico(String nombre, String rut, String correo, int edad, String idioma) throws RutException {
        super(nombre, rut, correo, edad);
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "GuiaTuristico{" +
                "nombre='" + this.getNombre() + '\'' +
                ", rut='" + this.getRut() + '\'' +
                ", correo='" + this.getCorreo() + '\'' +
                ", edad=" + this.getEdad() +
                ", idioma='" + idioma + '\'' +
                '}';
    }

    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.getNombre() + ", RUT: " + this.getRut() + ", Correo: " + this.getCorreo() + ", Edad: " + this.getEdad() + ", Idioma: " + idioma;
    }
}
