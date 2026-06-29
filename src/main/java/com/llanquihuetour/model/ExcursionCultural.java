package com.llanquihuetour.model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String toString() {
        return "ExcursionCultural{" +
                "lugarHistorico='" + lugarHistorico + '\'' +
                "} " + super.toString();
    }
}
