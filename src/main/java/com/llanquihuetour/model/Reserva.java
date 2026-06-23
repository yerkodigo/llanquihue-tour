package com.llanquihuetour.model;

import java.time.LocalDate;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
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
