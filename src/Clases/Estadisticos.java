package Clases;

// Importamos la biblioteca `Arrays` para hacer los sort de manera eficiente
import java.util.Arrays;

/**
 *
 * @author Victoria Darina Basurto
 * @author Alejandro Bermudez
 * @author Alfredo Nader
 */

public class Estadisticos {
    private int[] datos;
    private int numDatos;
    
    public Estadisticos(int[] arr, int dim) {
        datos = arr;
        ordenar();
        numDatos = Math.min(datos.length, dim);
    }
    
    private void ordenar() {
        Arrays.sort(datos); // Método `sort()` de `Arrays`
    }
    
    private int sumar() {
        int suma = 0;
        for (int dato : datos) {
            suma += dato;
        }
        return suma;
    }
    
    public int getNumDatos() {
        return numDatos;
    }
    
    public int[] getDatos() {
        return datos;
    }
    
    public int minimo() {
        return datos[0];
    }
    
    public int maximo() {
        return datos[numDatos - 1];
    }
    
    public int rango() {
        return maximo() - minimo();
    }
    
    public double cuartil_1() {
        int i = (int) numDatos / 4; /* 25/100 = 1/4 */
        if (numDatos % 4 == 0) {
            return (datos[i] + datos[i - 1]) / 2.;
        } else {
            return datos[i];
        }
    }
    
    public double cuartil_2() {
        int i = (int) numDatos / 2; /* 50/100 = 1/2 */
        if (numDatos % 4 == 0) {
            return (datos[i] + datos[i - 1]) / 2.;
        } else {
            return datos[i];
        }
    }
    
    public double cuartil_3() {
        int i = (int) 3 * numDatos / 4; /* 75/100 = 3/4 */
        if (numDatos % 4 == 0) {
            return (datos[i] + datos[i - 1]) / 2.;
        } else {
            return datos[i];
        }
    }
    
    public double ric() {
        return cuartil_3() - cuartil_1();
    }
    
    public double media() {
        return (double) sumar() / numDatos;
    }
    
    public double varianza() {
        double numerador = 0;
        double media = media();
        for (int i = 0; i < numDatos; i++) 
            numerador += Math.pow(datos[i] - media, 2);
        return numerador / (numDatos - 1);
    }
    
    public double desvStd() {
        return Math.sqrt(varianza());
    }
    
    public double coefVar() {
        return desvStd() / media();
    }
    
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < numDatos; i++) {
            if (i == numDatos - 1) resultado += datos[i];
            else resultado += datos[i] + " ";
        }
        return resultado;
    }
}
