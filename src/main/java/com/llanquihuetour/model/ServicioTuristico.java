package com.llanquihuetour.model;

public class ServicioTuristico implements Registrable {
    private String nombre;
    private int duracionHoras;

    public ServicioTuristico() {}

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public String mostrarInformacion() {
        return "Nombre: " + this.nombre + ", Duración Horas: " + this.duracionHoras;
    }

    @Override
    public String toString() {
        return "ServicioTuristico: " + "nombre: '" + nombre + '\'' + ", duracionHoras: " + duracionHoras;
    }

    @Override
    public String mostrarResumen() {
        return "Nombre: " + this.nombre + ", Duración Horas: " + this.duracionHoras;
    }
}
