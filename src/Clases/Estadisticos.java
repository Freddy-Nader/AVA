package Clases;

// Importamos la biblioteca `Arrays` para hacer los sort de manera eficiente
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que proporciona métodos para calcular diversas estadísticas
 * descriptivas de un conjunto de datos numéricos enteros.
 *
 * @author Victoria Darina Basurto
 * @author Alejandro Bermudez
 * @author Alfredo Nader
 */
public class Estadisticos {
    private final int numDatos;
    private final int[] datos;

    /**
     * Constructor de la clase {@code Estadisticos} que recibe un array de enteros.
     * Inicializa el número de datos y copia el array proporcionado.
     * Los datos se ordenan automáticamente al instanciar la clase.
     *
     * @param arr El array de enteros con los datos para calcular las estadísticas.
     */
    public Estadisticos(int[] arr) {
        numDatos = arr.length;
        datos = new int[numDatos];

        // Equivalente a copiar dato por dato con for extendido:
        System.arraycopy(arr, 0, datos, 0, numDatos);

        // Ordenamos todos los datos
        ordenar();
    }

    /**
     * Constructor de la clase {@code Estadisticos} que recibe un array de enteros
     * y una dimensión. Inicializa el número de datos tomando el mínimo entre 
     * la longitud del array y la dimensión proporcionada, y copia los 
     * primeros elementos del array. Los datos se ordenan automáticamente al 
     * instanciar la clase.
     * 
     * @param arr El array de enteros con los datos.
     * @param dim La dimensión máxima de los datos a considerar.
     */
    public Estadisticos(int[] arr, int dim) {
        numDatos = Math.min(arr.length, dim);
        datos = new int[numDatos];

        // Equivalente a copiar dato por dato con for extendido:
        System.arraycopy(arr, 0, datos, 0, numDatos);

        // Ordenamos todos los datos
        ordenar();
    }

    /**
     * Constructor de la clase {@code Estadisticos} que recibe una lista de enteros 
     * ({@code ArrayList}). Inicializa el número de datos y copia los elementos de 
     * la lista proporcionada. Los datos se ordenan automáticamente al 
     * instanciar la clase.
     * 
     * @param arr La lista de enteros con los datos.
     */
    public Estadisticos(ArrayList<Integer> arr) {
        numDatos = arr.size();
        datos = new int[numDatos];

        // Copiar dato por dato con for extendido:
        for (int i = 0; i < numDatos; i++)
            datos[i] = arr.get(i);

        // Ordenamos todos los datos
        ordenar();
    }

    /**
     * Ordena internamente el array de datos utilizando el método {@code sort()} 
     * de la clase {@code Arrays}. Este método es privado y se llama durante la 
     * inicialización de la instancia.
     */
    private void ordenar() {
        Arrays.sort(datos); // Método `sort()` de `Arrays`
    }

    /**
     * Calcula la suma de todos los datos en el array.
     * Este método es privado y se utiliza internamente para calcular otras estadísticas.
     *
     * @return La suma de todos los datos.
     */
    private int sumar() {
        int suma = 0;
        for (int dato : datos) {
            suma += dato;
        }
        return suma;
    }

    /**
     * Obtiene el número total de datos que se están analizando.
     *
     * @return El número de datos.
     */
    public int getNumDatos() {
        return numDatos;
    }

    /**
     * Obtiene una copia del array de datos ordenado.
     *
     * @return Un nuevo array de enteros que contiene los datos ordenados.
     */
    public int[] getDatos() {
        return datos.clone();
    }

    /**
     * Encuentra el valor mínimo en el conjunto de datos.
     * Debido a que los datos están ordenados, el mínimo es el primer elemento.
     *
     * @return El valor mínimo de los datos.
     */
    public int minimo() {
        return datos[0];
    }

    /**
     * Encuentra el valor máximo en el conjunto de datos.
     * Debido a que los datos están ordenados, el máximo es el último elemento.
     *
     * @return El valor máximo de los datos.
     */
    public int maximo() {
        return datos[numDatos - 1];
    }

    /**
     * Calcula el rango del conjunto de datos, que es la diferencia entre el
     * valor máximo y el valor mínimo.
     *
     * @return El rango de los datos.
     */
    public int rango() {
        return maximo() - minimo();
    }

    /**
     * Calcula el primer cuartil (Q1) del conjunto de datos.
     * Representa el valor por debajo del cual se encuentra el 25% de los datos.
     *
     * @return El valor del primer cuartil.
     */
    public double cuartil_1() {
        int i = (int) numDatos / 4; /* 25/100 = 1/4 */
        if (numDatos % 4 == 0) {
            return (datos[i] + datos[i - 1]) / 2.;
        } else {
            return datos[i];
        }
    }

    /**
     * Calcula el segundo cuartil (Q2) del conjunto de datos, que también es la mediana.
     * Representa el valor por debajo del cual se encuentra el 50% de los datos.
     *
     * @return El valor del segundo cuartil (mediana).
     */
    public double cuartil_2() {
        int i = (int) numDatos / 2; /* 50/100 = 1/2 */
        if (numDatos % 4 == 0) {
            return (datos[i] + datos[i - 1]) / 2.;
        } else {
            return datos[i];
        }
    }

    /**
     * Calcula el tercer cuartil (Q3) del conjunto de datos.
     * Representa el valor por debajo del cual se encuentra el 75% de los datos.
     *
     * @return El valor del tercer cuartil.
     */
    public double cuartil_3() {
        int i = (int) 3 * numDatos / 4; /* 75/100 = 3/4 */
        if (numDatos % 4 == 0) {
            return (datos[i] + datos[i - 1]) / 2.;
        } else {
            return datos[i];
        }
    }

    /**
     * Calcula el rango intercuartílico (RIC), que es la diferencia entre el 
     * tercer cuartil (Q3) y el primer cuartil (Q1). Proporciona una medida 
     * de la dispersión del 50% central de los datos.
     *
     * @return El rango intercuartílico.
     */
    public double ric() {
        return cuartil_3() - cuartil_1();
    }

    /**
     * Calcula la media aritmética (promedio) del conjunto de datos.
     *
     * @return La media de los datos.
     */
    public double media() {
        return (double) sumar() / numDatos;
    }

    /**
     * Calcula la varianza muestral del conjunto de datos.
     * La varianza mide la dispersión de los datos alrededor de la media.
     * Se utiliza la fórmula para la varianza muestral (dividiendo por n-1).
     *
     * @return La varianza muestral de los datos.
     */
    public double varianza() {
        double numerador = 0;
        double media = media();
        for (int i = 0; i < numDatos; i++)
            numerador += Math.pow(datos[i] - media, 2);
        return numerador / (numDatos - 1);
    }

    /**
     * Calcula la desviación estándar muestral del conjunto de datos.
     * Es la raíz cuadrada de la varianza y proporciona una medida de la dispersión
     * en las mismas unidades que los datos originales.
     *
     * @return La desviación estándar muestral de los datos.
     */
    public double desvStd() {
        return Math.sqrt(varianza());
    }

    /**
     * Calcula el coeficiente de variación del conjunto de datos.
     * Es una medida relativa de la dispersión y se expresa como un porcentaje.
     * Es útil para comparar la variabilidad entre conjuntos de datos con 
     * diferentes unidades o medias.
     *
     * @return El coeficiente de variación de los datos.
     */
    public double coefVar() {
        return desvStd() / media();
    }

    /**
     * Genera una representación en cadena de los datos contenidos en la instancia.
     * Los datos se muestran en una sola línea separados por espacios.
     *
     * @return Una cadena que representa los datos.
     */
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