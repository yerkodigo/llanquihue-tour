package com.llanquihuetour.model;

/**
 * Tour que el cliente compra como Ruta gastronómica, excursión, etc. Incluyendo caracteristicas del tour como tipo, la duración y el precio.
 */
public class Tour {
    private String nombre;
    private String tipo;
    private int duracionHoras;
    private double precio;

    public Tour() {}

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

    /**
     * Método encargado de recibir la línea de registro Tour desde archivo y manipularlo para poder crear la instancia y retornarla.
     *
     * @param linea
     * @return
     */
    public static Tour parsearLinea(String linea) {
//    • Separe los datos con .split(";")
        String[] tour = linea.split(";");

        try {
            if (tour.length == 4) {
//                • Cree objetos con estos datos
                return new Tour(tour[0], tour[1], Integer.parseInt(tour[2]), Double.parseDouble(tour[3]));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método encargado de entregar un toString más formateado y entendible en consola.
     *
     * @return
     */
    public String showInConsole() {
        return "Tour '" + nombre + "' - " +
                "Valor: $" + precio + " - " +
                "Tipo: " + tipo + " - " +
                "Duración: " + duracionHoras + "hrs";
    }
}
