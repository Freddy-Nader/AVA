package Clases;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Clase genérica para la creación de gráficos. En esta clase, se dibuja el
 * contorno básico del gráfico, los ejes, todos los títulos y la leyenda (que
 * es opcional). Ya que se dibuja el contorno del gráfico, se le agrega una 
 * gráfica específica que se debe crear con una clase derivada. 
 * @author Victoria Darina Basurto
 * @author Alejandro Bermudez
 * @author Alfredo Nader
 */

public class Graficos {
    // Atributos
    
    /** 
     * Color principal (el que llevará la gráfica, los ejes, la leyenda, etc.).
     * Por default es negro.
     */
    private final Color COLOR = new Color(0, 0, 0);
    
    /** 
     * La dimensión de anchura del gráfico. No se permiten valores negativos.
     */
    public int width;
    
    /** 
     * La dimensión de altura del gráfico. No se permiten valores negativos.
     */
    public int height;
    
    /** 
     * Título del gráfico.
     */
    protected String titulo;
    
    /** 
     * Título del eje X.
     */
    private String ejeX;
    
    /** 
     * Título del eje Y.
     */
    private String ejeY;
    
    /** 
     * Espacio entre ticks horizontales. Solo se permiten valores positivos.
     */
    public int tickX;
    
    /** 
     * Espacio entre ticks verticales. Solo se permiten valores positivos.
     */
    public int tickY;
    
    /** 
     * Nombres de columnas de datos. Útil para la layenda y para los títulos
     * de los ejes.
     */
    public String[] columnas;
    
    /**
     * Margen superior de la gráfica. El contorno básico de la gráfica se va
     * a dibujar en (0, {@code MARGIN_T}).
     */
    public int MARGIN_T = 50;
    
    
    // Constructores
    
    /**
     * Método constructor; TODO
     */
    public Graficos() {
        setSize();
        // TODO logic
    }
    
    /**
     * Método constructor; TODO
     * @param width Ancho del gráfico
     * @param height Altura del gráfico
     */
    public Graficos(int width, int height) {
        setSize(width, height);
        // TODO logic
    }
    
    
    // Métodos
    
    /**
     * Establece el tamaño del gráfico en 100 x 100 pixeles.
     */
    public void setSize() {
        width = height = 100;
    }
    
    /**
     * Establece el tamaño del gráfico con los valores proporcionados.
     * @param width Anchura del gráfico.
     * @param height Altura del gráfico.
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * Establece la dimensión del gráfico con el objeto de {@code Dimension} 
     * proporcionado.
     * @param size Dimensión del gráfico.
     */
    public void setSize(Dimension size) {
        width = size.width;
        height = size.height;
    }
    
    /**
     * Devuelve el tamaño del gráfico como arreglo de enteros.
     * @return Tamaño del gráfico como arreglo de enteros.
     */
    public int[] getSize() {
        return new int[] {width, height};
    }
    
    /**
     * Devuelve el tamaño del gráfico como objeto de {@code Dimension}.
     * @return Tamaño del gráfico como objeto de {@code Dimension}.
     */
    public Dimension getDimension() {
        return new Dimension(width, height);
    }
    
    /**
     * Dibuja el contorno básico del gráfico. Éste se posiciona por default en 
     * la posición (0, {@code MARGIN_T}) y tiene el tamaño de ({@code width}, 
     * {@code height}). Se dibuja en esta posición vertical porque este es el 
     * tamaño necesario para dibujar el título del gráfico y dejar un margen adecuado.
     */
    public void drawSize() {
        // TODO logic
        // Es literalmente dibujar dos líneas verticales y dos horizontales. 
    }
    
    /**
     * Establece el título del gráfico.
     * @param t Texto del título del gráfico.
     */
    public void setTitle(String t) {
        titulo = t;
    }
    
    /**
     * Dibuja el título del gráfico.
     */
    public void drawTitle() {
        // TODO logic
    }
    
    /**
     * Establece los títulos de los ejes horizontales.
     * @param e Texto del título del eje X.
     */
    public void setEjeX(String e) {
        ejeX = e;
    }
    
    /**
     * Establece los títulos de los ejes verticales.
     * @param e Texto del título del eje Y.
     */
    public void setEjeY(String e) {
        ejeY = e;
    }
    
    /**
     * Establece los títulos de los ejes horizontales y verticales.
     * @param x Texto del título del eje X.
     * @param y Texto del título del eje Y.
     */
    public void setEjes(String x, String y) {
        ejeX = x;
        ejeY = y;
    }
    
    /**
     * Establece los títulos de los ejes horizontales y verticales.
     * @param e Arreglo de los textos de los títulos de los ejes.
     */
    public void setEjes(String[] e) {
        if (e.length == 2) {
            ejeX = e[0];
            ejeY = e[1];
        } else {
            System.err.println("Error: Se tienen que proporcionar dos argumentos en setEjes(String[] e).");
        }
    }
    
    /**
     * Dibuja los títulos de los ejes horizontales y vertivales.
     */
    public void drawEjes() {
        // TODO logic
    }
    
    /**
     * Establece el espacio entre los ticks horizontales.
     * @param x Cantidad de espacio entre ticks del eje X (palitos en los ejes).
     */
    public void setTickX(int x) {
        tickX = x;
    }
    
    /**
     * Establece el espacio entre los ticks verticales.
     * @param y Cantidad de espacio entre ticks del eje Y (palitos en los ejes).
     */
    public void setTickY(int y) {
        tickY = y;
    }
    
    /**
     * Establece el espacio entre los ticks horizontales y verticales.
     * @param t Arreglo con la cantidad de espacio entre los ticks de ambos ejes.
     */
    public void setTicks(int[] t) {
        if (t.length == 2) {
            tickX = t[0];
            tickY = t[1];
        } else {
            System.err.println("Error: Se tienen que proporcionar dos argumentos en setTicks(int[] t).");
        }
    }
    
    /**
     * Dibuja los ticks en el gráfico.
     */
    public void drawTicks() {
        // TODO logic
    }
    
    /**
     * Agrega el contenido visual al gráfico en la posición proporcionada.
     * Éste debe ser creado en una clase derivada.
     * @param posX Posición de X del contenido visual.
     * @param posY Posición de Y del contenido visual.
     * @param vista JPanel que se agregará al gráfico. 
     */
    public void add(int posX, int posY, JPanel vista) {
        // TODO logic
    }
    
    /**
     * Agrega (dibuja) una leyenda en la parte superior derecha.
     */
    public void leyenda() {
        // TODO logic
    }
    
    /**
     * Agrega (dibuja) una leyenda en una posición especificada.
     * @param posX Posición de X de la leyenda. 
     * @param posY Posición de Y de la leyenda. 
     */
    public void leyenda(int posX, int posY) {
        // TODO logic
    }
    
    /**
     * Agrega (dibuja) una leyenda en una posición especificada. 
     * @param pos Arreglo de posiciones de ambos ejes de la leyenda. El arreglo
     * debe contener un arreglo con exactamente dos elementos.
     */
    public void leyenda(int[] pos) {
        if (pos.length == 2) {
            // TODO logic
        } else {
            System.err.println("Error: Se tienen que proporcionar dos argumentos en leyenda(int[] pos).");
        }
    }
}
