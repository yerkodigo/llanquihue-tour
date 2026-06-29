package com.llanquihuetour.data;

import com.llanquihuetour.model.ExcursionCultural;
import com.llanquihuetour.model.PaseoLacustre;
import com.llanquihuetour.model.RutaGastronomica;
import com.llanquihuetour.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {
    public static List<ServicioTuristico> pruebaDeInstancias() {
        List<ServicioTuristico> lista = new ArrayList<>();

        RutaGastronomica ruta1 = new RutaGastronomica("Ruta del Queso", 7, 3);
        RutaGastronomica ruta2 = new RutaGastronomica("Ruta del Mar", 4, 1);

        lista.add(ruta1);
        lista.add(ruta2);

        PaseoLacustre paseo1 = new PaseoLacustre("La isla", 3, "Bote");
        PaseoLacustre paseo2 = new PaseoLacustre("Playa los Cisnes", 2, "Lancha");

        lista.add(paseo1);
        lista.add(paseo2);

        ExcursionCultural excursion1 = new ExcursionCultural("La iglesia", 7, "Parroquia San Jose");
        ExcursionCultural excursion2 = new ExcursionCultural("Atardecer en el Muelle", 2, "Muelle Llanquihue");

        lista.add(excursion1);
        lista.add(excursion2);

        return lista;
    }
}
