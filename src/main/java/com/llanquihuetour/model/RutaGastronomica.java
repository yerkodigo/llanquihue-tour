package com.llanquihuetour.model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public String toString() {
        return "RutaGastronomica. " +
                "numeroDeParadas: " + numeroDeParadas +
                ", " + super.toString();
    }
}
