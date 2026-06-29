package com.llanquihuetour.model;

public class ServicioTuristico {
    private String nombre;
    private int duracionHoras;

    public ServicioTuristico() {}

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return "ServicioTuristico: " + "nombre: '" + nombre + '\'' + ", duracionHoras: " + duracionHoras;
    }
}
