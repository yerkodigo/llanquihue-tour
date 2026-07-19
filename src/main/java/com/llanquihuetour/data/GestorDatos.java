package com.llanquihuetour.data;

// NO USADO EN EL FLUJO ACTUAL DEL MODAL (Main.iniciarInterfazGrafica) — evaluar eliminar o integrar.
// Reemplazado por GestorCargasTxt, que carga clientes desde clientes.txt en vez de clientes.xlsx.
// import com.llanquihuetour.model.Cliente;
// import com.llanquihuetour.model.Tour;
// import org.apache.poi.ss.usermodel.DataFormatter;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.util.*;
//
// public class GestorDatos {
//     private static final String NOMBRE_ARCHIVO_TOURS = "/tours.txt";
//     private List<Cliente> clientes = new ArrayList<>();
//
//     public GestorDatos() {}
//
//     public List<Tour> buildToursFromFile() throws FileNotFoundException {
//         List<Tour> tours = new ArrayList<>();
// //    • Lea el archivo línea por línea
//         try(Scanner sc = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(NOMBRE_ARCHIVO_TOURS)))) {
//             if(!sc.hasNextLine()) {
//                 System.out.println("No hay registros para gestionar.");
//                 throw new FileNotFoundException("No hay registros para gestionar.");
//             }
//
//             while(sc.hasNextLine()) {
//                 String linea = sc.nextLine();
//                 Tour tour = Tour.parsearLinea(linea);
//
//                 if(tour != null) {
//             //    • Los almacene en un ArrayList
//                     tours.add(tour);
//                 }
//             }
//
//         } catch (FileNotFoundException e) {
//             throw new FileNotFoundException(e.getMessage());
//         }
//       return tours;
//     };
//
//     public void listarClientes() {
//         for(Cliente c : clientes) {
//             System.out.println("Nombre: " + c.getNombre() + " - Rut: " + c.getRut() + " - Edad: " + c.getEdad());
//         }
//     }
//
//     public void cargarDesdeExcel(String ruta) {
//         try (var is = getClass().getResourceAsStream(ruta);
//              XSSFWorkbook libroExcel = new XSSFWorkbook(is)) {
//             XSSFSheet libroSheet = libroExcel.getSheetAt(0);
//
//             // Use DataFormatter de POI para evitar problemas de numeros en celdas del excel. Asi son siempre string
//             DataFormatter formatter = new DataFormatter();
//
//             for (int i = 1; i <= libroSheet.getLastRowNum(); i++) {
//                 var row = libroSheet.getRow(i);
//                 String nombre =  formatter.formatCellValue(row.getCell(0));
//
//                 // Limpieza de rut
//                 String rutSinFormatear = formatter.formatCellValue(row.getCell(1));
//                 String rutLimpio = rutSinFormatear.trim().replace(".", "").replace("-", "");
//                 String rutSinDV = rutLimpio.substring(0, rutLimpio.length() -1);
//                 String dv = rutLimpio.substring(rutSinDV.length());
//                 String rut = rutSinDV + "-" + dv;
//
//                 String correo = formatter.formatCellValue(row.getCell(2));
//                 int edad = Integer.parseInt(formatter.formatCellValue(row.getCell(3)));
//                 cargarAListaClientes(new Cliente(nombre, rut, correo, edad));
//             }
//             libroExcel.close();
//         } catch (Exception e) {
//             System.out.println("Error al cargar archivo de datos. Error: " + e.getMessage());
//         }
//     }
//
//     private void cargarAListaClientes(Cliente cliente) {
//         clientes.add(cliente);
//     }
//
//     public List<Cliente> filtrarEdadMayor(int edad) {
//         List<Cliente> filtrados = new ArrayList<>();
//         for(Cliente c : clientes) {
//             if (c.getEdad() > edad) {
//                 filtrados.add(c);
//             }
//         }
//         return filtrados;
//     }
// }
