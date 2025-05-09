package Clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 * Clase genérica para la creación de gráficos. En esta clase, se dibuja el
 * contorno básico del gráfico, los ejes, todos los títulos y la leyenda (que
 * es opcional). Ya que se dibuja el contorno del gráfico, se le agrega una 
 * gráfica específica que se debe crear con una clase derivada. 
 * 
 * @author Victoria Darina Basurto
 * @author Alejandro Bermudez
 * @author Alfredo Nader
 */

public class Graficos extends JPanel {
    // Atributos
    
    /** 
     * Color principal (el que llevará la gráfica, los ejes, la leyenda, etc.).
     * Por default es negro.
     */
    private final Color COLOR = new Color(0, 0, 0);
    
    /**
     * Font principal (usado en los ejes y ticks).
     */
    private final Font FONT = new Font("Monospaced", Font.PLAIN, 12);
    
    /**
     * Margen superior de la gráfica. El contorno básico de la gráfica se va
     * a dibujar en ({@code MARGIN_L}, {@code MARGIN_T}).
     */
    public final int MARGIN_T = 50;
    
    /**
     * Margen izquierdo de la gráfica. El contorno básico de la gráfica se va
     * a dibujar en ({@code MARGIN_L}, {@code MARGIN_T}).
     */
    public final int MARGIN_L = 30;
    
    /** 
     * La dimensión de anchura (width) del gráfico. No se permiten valores negativos.
     */
    public int ANCHO = 150; // WIDTH
    
    /** 
     * La dimensión de altura (height) del gráfico. No se permiten valores negativos.
     */
    public int ALTO = 100; // HEIGHT
    
    /** 
     * Nombres de columnas de datos. Útil para la layenda y para los títulos
     * de los ejes.
     */
    public String[] columnas;
    
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
    
    
    // Constructores
    
    /**
     * Método constructor; TODO
     */
    public Graficos() {
        super();
        setSize(ANCHO, ALTO);
        // TODO logic
    }
    
    
    // Métodos
    
    /**
     * Establece la dimensión del gráfico con el objeto de {@code Dimension} 
     * proporcionado.
     * 
     * @param size Dimensión del gráfico.
     */
    @Override
    public final void setSize(Dimension size) {
        ANCHO = size.width;
        ALTO = size.height;
        setPreferredSize(getDimension());
    }
    
    /**
     * Establece el tamaño del gráfico con los valores proporcionados.<br>
     * <strong>Nota:</strong> Los métodos {@code setSize} y {@code getSizeG} 
     * tienen una {@code G} (de {@code Graficos}) al final para diferenciarse 
     * de los métodos de {@code JPanel}.
     * 
     * @param width Anchura del gráfico.
     * @param height Altura del gráfico.
     */
    @Override
    public final void setSize(int width, int height) {
        setSize(new Dimension(MARGIN_L + width, MARGIN_T + height));
    }
    
    /**
     * Establece el tamaño del gráfico con los valores predeterminados.
     */
    public final void setSize() {
        setSize(getDimension());
    }
    
    /**
     * Devuelve el tamaño del gráfico como <em>arreglo</em> de enteros.
     * 
     * @return Tamaño del gráfico como arreglo de enteros.
     */
    public int[] getSizeArray() {
        return new int[] {ANCHO, ALTO};
    }
    
    /**
     * Devuelve el tamaño del <em>panel</em> como instancia de {@code Dimension}.
     * 
     * @return Tamaño del gráfico como objeto de {@code Dimension}.
     */
    public Dimension getDimension() {
        return new Dimension(MARGIN_L + ANCHO, MARGIN_T + ALTO);
    }
    
    /**
     * Dibuja el contorno básico del gráfico. Éste se posiciona por default en 
     * la posición (0, {@code MARGIN_T}) y tiene el tamaño de ({@code ANCHO}, 
     * {@code ALTO}). Se dibuja en esta posición vertical porque este es el 
     * tamaño necesario para dibujar el título del gráfico y dejar un margen 
     * adecuado.
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     */
    public void drawSize(Graphics g) {
        System.out.println("Dibujando contorno del gráfico...");
        if (g != null) {
            int xs = MARGIN_L;      // X Start
            int xe = xs + ANCHO;    // X End
            int ys = MARGIN_T;      // X Start
            int ye = ys + ALTO;     // X End
            
            g.setColor(COLOR);
            g.drawLine(xs, ys, xe, ye); // Línea de arriba
            g.drawLine(xe, ys, xe, ye); // Línea de abajo
            g.drawLine(xs, ys, xs, ye); // Línea de izquierda
            g.drawLine(xe, ys, xe, ye); // Línea de derecha
        } else NG();
    }
    
    /**
     * Establece el título del gráfico.
     * 
     * @param t Texto del título del gráfico.
     */
    public void setTitle(String t) {
        titulo = t;
    }
    
    /**
     * Dibuja el título del gráfico.
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     */
    public void drawTitle(Graphics g) {
        System.out.println("Dibujando título del gráfico...");
        if (g != null) {
            g.setColor(COLOR);
            g.setFont(FONT);
            g.drawString(titulo, MARGIN_L + (ANCHO - titulo.length()) / 2, 
                    (MARGIN_T - 12) / 2);
        } else NG();
    }
    
    /**
     * Establece los títulos de los ejes horizontales.
     * 
     * @param e Texto del título del eje X.
     */
    public void setEjeX(String e) {
        ejeX = e;
    }
    
    /**
     * Establece los títulos de los ejes verticales.
     * 
     * @param e Texto del título del eje Y.
     */
    public void setEjeY(String e) {
        ejeY = e;
    }
    
    /**
     * Establece los títulos de los ejes horizontales y verticales.
     * 
     * @param x Texto del título del eje X.
     * @param y Texto del título del eje Y.
     */
    public void setEjes(String x, String y) {
        ejeX = x;
        ejeY = y;
    }
    
    /**
     * Establece los títulos de los ejes horizontales y verticales.
     * 
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
     * Dibuja los títulos de los ejes horizontales y verticales.
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     */
    public void drawEjes(Graphics g) {
        System.out.println("Dibujando títulos de ejes...");
        if (g != null) {
            int posX, posY;
            
            g.setColor(COLOR);
            g.setFont(FONT);
            
            // Eje X
            posX = MARGIN_L + (ANCHO - ejeX.length()) / 2;
            posY = (MARGIN_T - 12) / 2;
            g.drawString(ejeY, posX, posY);
            
            // Eje y
            Graphics2D g2d = (Graphics2D) g;
            AffineTransform t = g2d.getTransform();
            posX = (MARGIN_L - 12) / 2;
            posY = MARGIN_T + (ALTO - ejeY.length()) / 2;

            g2d.rotate(Math.toRadians(90), posX, posY); // Rotación de 90°
            g2d.drawString(ejeY, posX, posY);
            g2d.setTransform(t);
        } else NG();
    }
    
    /**
     * Establece el espacio entre los ticks horizontales.
     * 
     * @param x Cantidad de espacio entre ticks del eje X (palitos en los ejes).
     */
    public void setTickX(int x) {
        tickX = x;
    }
    
    /**
     * Establece el espacio entre los ticks verticales.
     * 
     * @param y Cantidad de espacio entre ticks del eje Y (palitos en los ejes).
     */
    public void setTickY(int y) {
        tickY = y;
    }
    
    /**
     * Establece el espacio entre los ticks horizontales y verticales.
     * 
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
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     */
    public void drawTicks(Graphics g) {
        // TODO logic
    }
    
    /**
     * Agrega el contenido visual al gráfico en la posición proporcionada.
     * Éste debe ser creado en una clase derivada.
     * 
     * @param posX Posición de X del contenido visual.
     * @param posY Posición de Y del contenido visual.
     * @param vista {@code JPanel} que se agregará al gráfico. 
     */
    public void add(int posX, int posY, JPanel vista) {
        // TODO logic
    }
    
    /**
     * Agrega (dibuja) una leyenda en la parte superior derecha.
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     */
    public void leyenda(Graphics g) {
        // TODO logic
    }
    
    /**
     * Agrega (dibuja) una leyenda en una posición especificada.
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     * @param posX Posición de X de la leyenda. 
     * @param posY Posición de Y de la leyenda. 
     */
    public void leyenda(Graphics g, int posX, int posY) {
        // TODO logic
    }
    
    /**
     * Agrega (dibuja) una leyenda en una posición especificada. 
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     * @param pos Arreglo de posiciones de ambos ejes de la leyenda. El arreglo
     * debe contener un arreglo con exactamente dos elementos.
     */
    public void leyenda(Graphics g, int[] pos) {
        if (pos.length == 2) {
            // TODO logic
        } else {
            System.err.println("Error: Se tienen que proporcionar dos argumentos en leyenda(int[] pos).");
        }
    }
    
    /**
     * Método general para llamar en los métodos que dibujan cuando
     * {@code Graphics g = null}.
     */
    private void NG() {
        System.err.println("Error: No se encontró el objeto de Graphics.");
    }
    
    /**
     * Sobreescribe el método {@code paintComponent}. Este método es llamado por
     * el sistema de pintura de Swing cada vez que el componente necesita ser 
     * redibujado. Aquí se deben realizar todas las operaciones de dibujo para 
     * mostrar el gráfico.
     * 
     * @param g El objeto {@code Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSize(g);
        drawTitle(g);
        // ...
    }
}
