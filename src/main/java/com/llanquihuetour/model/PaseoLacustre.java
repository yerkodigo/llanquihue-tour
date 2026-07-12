package com.llanquihuetour.model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String mostrarInformacion() {
        return "PaseoLacustre. " +
                "nombre: " + getNombre() +
                ", duracionHoras: " + getDuracionHoras() +
                ", tipoEmbarcacion: '" + tipoEmbarcacion + "'";
    }

    @Override
    public String toString() {
        return "PaseoLacustre. " +
                "tipoEmbarcacion: '" + tipoEmbarcacion + '\'' +
                ", " + super.toString();
    }

    @Override
    public String mostrarResumen() {
        return "Paseo Lacustre: " + getNombre() + " en " + tipoEmbarcacion + " (" + getDuracionHoras() + " horas)";
    }
}
