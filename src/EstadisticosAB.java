
package calculadora_estadistica;

//Clse estadísticos.

import java.util.ArrayList;

public class Estadisticos {
    
    //Atributos
    private int numDatos;
    private int[] datos;
    
    //Constructor.
    public Estadisticos(int[] arr, int dim) {
        
        numDatos = dim;
        
        datos = new int[numDatos];
        
        for(int i = 0; i < numDatos; i++)
            datos[i] = arr[i];
        
        ordenar();
        
    }
    
    //Agregamos esta nueva clase.
    public Estadisticos(ArrayList<Integer> arr) {
        numDatos = arr.size();
        
        datos = new int[numDatos];
        
        for(int i = 0; i < numDatos; i++)
            datos[i] = arr.get(i);
        
        ordenar();
    }
    
    //Métodos privados
    private void ordenar() {
        
        //Método burbuja
        int siguiente;
        
        for(int i = 0; i < numDatos - 1; i++) {
            for(int j = 0; j < numDatos - 1 - i; j++) {
                if(datos[j] > datos[j + 1]) {
                    siguiente = datos[j + 1];
                    datos[j + 1] = datos[j];
                    datos[j] = siguiente;
                }
            }
        }
        
    }
    
    private int sumar() {
        int suma = 0;
        
        for(int i = 0; i < numDatos; i++)
            suma+=datos[i];
        
        return suma;
    }
    
    //Métodos públicos.
    public int getNumDatos() {
        return numDatos;
    }

    public int[] getDatos() {
        return datos;
    }
    
    public int minimo() {
        ordenar();
        
        return datos[0];
    }
    
    public int maximo() {
        ordenar();
        
        return datos[numDatos - 1];
    }
    
    public int rango() {
        return maximo() - minimo();
    }
    
    public double cuartil_1() {
        int i, c1;
        
        i = numDatos / 4;
        
        if(numDatos % 4 == 0)
            c1 = (datos[i] + datos[i - 1]) / 2;
        else 
            c1 = datos[i];
        
        return c1;
    }
    
    public double cuartil_2() {    //Mediana.
        int i, me;
        
        i = numDatos / 2;
        
        if(numDatos % 2 == 0)
            me = (datos[i] + datos[i - 1]) / 2;
        else
            me = datos[i];
        
        return me;
    }
    
    public double cuartil_3() {
        int i, c3;
        
        i = 3 * numDatos / 4;
        
        if(3 * numDatos % 4 == 0)
            c3 = (datos[i] + datos[i - 1]) / 2;
        else
            c3 = datos[i];
        
        return c3;
    }
    
    public double ric() {
        return cuartil_3() - cuartil_1();
    }
    
    public double media() {
        return sumar() / numDatos;
    }
    
    public double varianza() {
        int suma = 0;
        
        for(int i = 0; i < numDatos; i++)
            suma+=Math.pow(datos[i] - media(), 2);
        
        return suma / (numDatos - 1);
    }
    
    public double desvStd() {
        return Math.sqrt( varianza() );
    }
    
    public double coefVar() {
        return desvStd() / media();
    }
    
    @Override
    public String toString() {
        String lista = "";
        
        for(int i = 0; i < numDatos; i++)
            lista+=datos[i] + " ";
        
        return lista;
    }
}
