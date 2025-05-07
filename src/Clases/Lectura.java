package Clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Prueba de lectura de datos
 * con una línea. Se muestra la media y la media ± la desviación estándar. 
 * El usuario elige ver los datos de una, dos o tres columnas.
 * 
 * @author Victoria Darina Basurto
 * @author Alejandro Bermudez
 * @author Alfredo Nader
 */

public class Lectura {
     public static void main(String[] args) {
        List<Integer> col1 = new ArrayList<>();
        List<Integer> col2 = new ArrayList<>();
        List<Integer> col3 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue; // Ignora líneas vacías

                if (primeraLinea) {
                    primeraLinea = false; // Saltar encabezado
                    continue;
                }

                String[] columnas = linea.split(",");
                if (columnas.length != 3) {
                    System.out.println("Línea inválida: " + linea);
                    continue;
                }

                try {
                    col1.add(Integer.valueOf(columnas[0].trim()));
                    col2.add(Integer.valueOf(columnas[1].trim()));
                    col3.add(Integer.valueOf(columnas[2].trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Error en conversión de números: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }

        // Imprimir resultados
        System.out.println("Columna 1: " + col1);
        System.out.println("Columna 2: " + col2);
        System.out.println("Columna 3: " + col3);
    }
}