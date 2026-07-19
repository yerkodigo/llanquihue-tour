package com.llanquihuetour.model;

import com.llanquihuetour.exceptions.RutException;

public class Rut {
    private Integer numero;
    private String dv;

    public Rut(Integer numero, String dv) throws RutException {
        if (!esRutValido(numero, dv)) {
            throw new RutException("RUT inválido: " + numero + "-" + dv);
        }
        this.numero = numero;
        this.dv = dv;
    }

    private boolean esRutValido(Integer numero, String dv) {
        if (numero == null || numero <= 0 || dv == null || dv.isEmpty()) {
            return false;
        }
        return dv.equalsIgnoreCase(calcularDv(numero));
    }

    private String calcularDv(int numero) {
        int suma = 0;
        int multiplicador = 2;

        while (numero > 0) {
            suma += (numero % 10) * multiplicador;
            numero /= 10;
            multiplicador = multiplicador == 7 ? 2 : multiplicador + 1;
        }

        int resto = 11 - (suma % 11);

        if (resto == 11) {
            return "0";
        } else if (resto == 10) {
            return "K";
        } else {
            return String.valueOf(resto);
        }
    }

    public static Rut parse(String rutTexto) throws RutException {
        if (rutTexto == null) {
            throw new IllegalArgumentException("RUT inválido: no puede ser nulo");
        }

        String[] partes = rutTexto.trim().split("-");
        if (partes.length != 2) {
            throw new IllegalArgumentException("RUT inválido: formato esperado numero-dv");
        }

        try {
            Integer numero = Integer.valueOf(partes[0]);
            return new Rut(numero, partes[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("RUT inválido: el número debe ser numérico");
        }
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDv() {
        return dv;
    }

    @Override
    public String toString() {
        return numero + "-" + dv;
    }
}
