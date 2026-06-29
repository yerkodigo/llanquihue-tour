package com.llanquihuetour.model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return "PaseoLacustre. " +
                "tipoEmbarcacion: '" + tipoEmbarcacion + '\'' +
                ", " + super.toString();
    }
}
