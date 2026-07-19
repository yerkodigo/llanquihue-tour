package com.llanquihuetour.model;

/**
 * Tour que el cliente compra como Ruta gastronómica, excursión, etc. Incluyendo caracteristicas del tour como tipo, la duración y el precio.
 */
public class Tour implements IRegistrable {
    private String nombre;
    private String tipo;
    private int duracionHoras;
    private double precio;

    public Tour(String nombre, String tipo, int duracionHoras, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }


    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.nombre + ", Tipo: " + this.tipo + ", Duración: " + this.duracionHoras + "hrs, Precio: $" + this.precio;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracionHoras=" + duracionHoras +
                ", precio=" + precio +
                '}';
    }
}
