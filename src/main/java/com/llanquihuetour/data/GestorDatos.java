package com.llanquihuetour.data;

import com.llanquihuetour.model.Tour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GestorDatos {
    private static final String NOMBRE_ARCHIVO_TOURS = "/tours.txt";

    public GestorDatos() {}

    public List<Tour> buildToursFromFile() throws FileNotFoundException {
        List<Tour> tours = new ArrayList<>();
//    • Lea el archivo línea por línea
        try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_TOURS)))) {
            if(!sc.hasNextLine()) {
                System.out.println("No hay registros para gestionar.");
                throw new FileNotFoundException("No hay registros para gestionar.");
            }

            while(sc.hasNextLine()) {
                String linea = sc.nextLine();
                Tour tour = Tour.parsearLinea(linea);

                if(tour != null) {
            //    • Los almacene en un ArrayList
                    tours.add(tour);
                }
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
      return tours;
    };
}
