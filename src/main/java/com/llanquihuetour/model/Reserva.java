package com.llanquihuetour.model;

import java.time.LocalDate;

/**
 *  Modela una reserva. Tiene composición con Tour y Cliente
 */
public class Reserva {
    private Cliente cliente;
    private Tour tour;
    private LocalDate fechaReserva;

    public Reserva() {
    }

    public Reserva(Cliente cliente, Tour tour, LocalDate fechaReserva) {
        this.cliente = cliente;
        this.tour = tour;
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", tour=" + tour +
                ", fechaReserva=" + fechaReserva +
                '}';
    }
}
