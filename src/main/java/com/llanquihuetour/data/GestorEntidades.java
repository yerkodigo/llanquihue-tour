package com.llanquihuetour.data;

import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.ExcursionCultural;
import com.llanquihuetour.model.PaseoLacustre;
import com.llanquihuetour.model.Registrable;
import com.llanquihuetour.model.RutaGastronomica;
import com.llanquihuetour.model.ServicioTuristico;
import com.llanquihuetour.model.Tour;

import java.util.ArrayList;

public class GestorEntidades {

    public static ArrayList<Registrable> cargarEntidades() {
        ArrayList<Registrable> entidades = new ArrayList<>();

        entidades.add(new RutaGastronomica("Ruta del Queso", 7, 3));
        entidades.add(new PaseoLacustre("La isla", 3, "Bote"));
        entidades.add(new ExcursionCultural("La iglesia", 7, "Parroquia San Jose"));
        entidades.add(new Cliente("Juan Pérez", "12345678-9", "juan@correo.cl", 30));
        entidades.add(new Tour("Tour Volcán Osorno", "aventura", 5, 35000));

        return entidades;
    }

    public static void mostrarResumenEntidades(ArrayList<Registrable> entidades) {
        for (Registrable entidad : entidades) {
            System.out.println(entidad.mostrarResumen());

            if (entidad instanceof ServicioTuristico servicio) {
                System.out.println("   -> Servicio turístico con duración de " + servicio.getDuracionHoras() + " horas");
            } else if (entidad instanceof Cliente cliente) {
                System.out.println("   -> Cliente registrado con " + cliente.getEdad() + " años");
            } else if (entidad instanceof Tour tour) {
                System.out.println("   -> Tour con precio $" + tour.getPrecio());
            }
        }
    }
}
