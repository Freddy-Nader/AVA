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
    
    //-----------
    // Atributos
    //-----------

    // Atributos generales

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
     * Grosor de las línea (e.g., en ejes y en ticks.)
     */
    private final int STROKE = 2;

    /**
     * Bandera que permite saber cuándo ya se dibujó el gráfico, para no 
     * tenerlo que dibujar en cada repaint.
     */
    private boolean firstTime = true;
    
    // Tamaños

    /**
     * Valor default del margen superior.
     */
    protected static final int DEFAULT_MARGIN_T = 50;

    /**
     * Margen superior de la gráfica. El contorno básico de la gráfica se va
     * a dibujar en ({@link #margin_L}, {@link #margin_T}).
     */
    public int margin_T;
    
    /**
     * Valor default del margen izquierdo.
     */
    protected static final int DEFAULT_MARGIN_L = 30;
    /**
     * Margen izquierdo de la gráfica. El contorno básico de la gráfica se va
     * a dibujar en ({@link #margin_L}, {@link #margin_T}).
     */
    public int margin_L;

    /**
     * Valor default del padding.
     */
    protected static final int DEFAULT_PADDING = 30;

    /**
     * Padding: espacio (en pixeles) entre los ejes de la gráfica y el 
     * área donde se dibuja el gráfico.
     */
    public int padding;
    
    /**
     * Valor default de la anchura.
     */
    protected static final int DEFAULT_WIDTH = 150 + DEFAULT_PADDING * 2;
    
    /** 
     * La dimensión de anchura (width) del gráfico (solo de la parte entre 
     * eje y eje, no considera el tamaño de {@link #margin_L}). No se 
     * permiten valores negativos. 
     */
    public int width;
    
    /**
     * Valor default de la altura.
     */
    protected static final int DEFAULT_HEIGHT = 100 + DEFAULT_PADDING * 2;
    
    /** 
     * La dimensión de altura (height) del gráfico (solo de la parte entre 
     * eje y eje, no considera el tamaño de {@link #margin_T}). No se 
     * permiten valores negativos. 
     */
    public int height;

    // Contorno (eje) del gráfico

    /**
     * Constante que determina si se debe dibujar el contorno o solamente 
     * el eje izquierdo del gráfico. Por default es {@code true}.
     */
    public final boolean DRAW_CONTOUR = true;

    /**
     * Variable que determina si se debe dibujar el contorno o solamente 
     * el eje izquierdo del gráfico. Si la variable es {@code false}, solo
     * se dibujará el eje izquierdo del gráfico (útil para diag. Frecuencia).
     */
    public boolean draw_contour = DRAW_CONTOUR;

    // Títulos y cosas relacionadas a texto dentro del gráfico

    /** 
     * Nombres de columnas de datos. Útil para la layenda y para los títulos
     * de los ejes.
     */
    public String[] cols; // Short for columns
    
    /** 
     * Título del gráfico.
     */
    public String title = "TITULO"; // Cambiar en clases derivadas

    /**
     * Constante que determina si se dibuja el título del gráfico. Por default 
     * es {@code true}.
     */
    public final boolean DRAW_TITLE = true;

    /**
     * Variable que determina si se dibuja el título del gráfico.
     */
    public boolean draw_title = DRAW_TITLE;
    
    /** 
     * Título del eje x.
     */
    private String titleX = "EJE_X"; // Cambiar en clases derivadas
    
    /**
     * Constante que determina si se dibuja el título del eje x. Por default 
     * es {@code true}.
     */
    public final boolean DRAW_TITLE_X = true;
    
    /**
     * Variable que determina si se dibuja el título del eje x.
     */
    public boolean draw_title_x = DRAW_TITLE_X;

    /** 
     * Título del eje y.
     */
    private String titleY = "EJE_Y"; // Cambiar en clases derivadas
    
    /**
     * Constante que determina si se dibuja el título del eje y. Por default 
     * es {@code true}.
     */
    public final boolean DRAW_TITLE_Y = true;
    
    /**
     * Variable que determina si se dibuja el título del eje x. Por default 
     * es {@code true}.
     */
    public boolean draw_title_y = DRAW_TITLE_Y;
    
    // Ticks

    /**
     * Tamaño en pixeles de la longitud de los ticks.
     */
    private final int TICKS_SIZE = 20;

    /** 
     * Espacio entre ticks horizontales. Solo se permiten valores positivos.
     */
    public int tickX;

    /**
     * Constante que determina si se dibujan los ticks horizontales. Por default 
     * es {@code true}.
     */
    public final boolean DRAW_TICKS_X = true;

    /**
     * Variable que determina si se dibujan los ticks horizontales.
     */
    public boolean draw_ticks_x = DRAW_TICKS_X;
    
    /** 
     * Espacio entre ticks verticales. Solo se permiten valores positivos.
     */
    public int tickY;

    /**
     * Constante que determina si se dibujan los ticks verticales. Por default 
     * es {@code true}.
     */
    public final boolean DRAW_TICKS_Y = true;

    /**
     * Variable que determina si se dibujan los ticks horizontales.
     */
    public boolean draw_ticks_y = DRAW_TICKS_Y;
    
    // Leyenda

    /**
     * Constante que determina si se dibuja la leyenda. 
     */
    public static final boolean DRAW_LEYEND = false;
    
    /**
     * Variable que determina si se dibuja la leyenda.
     */
    public boolean draw_legend = DRAW_LEYEND;
    
    
    //---------------
    // Constructores
    //---------------
    
    /**
     * Método constructor; TODO
     */
    public Graficos(int width, int height, int margin_L, int margin_T, int padding) {
        super();
        setSize(width, height);
        setPadding(padding);
        setMarginT(margin_T);
        setMarginL(margin_L);
        // TODO logic
    }
    
    /**
     * Método constructor; TODO
     */
    public Graficos(int width, int height) {
        this(width, height, DEFAULT_MARGIN_L, DEFAULT_MARGIN_T, DEFAULT_PADDING);
    }
    
    /**
     * Método constructor; TODO
     */
    public Graficos() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_MARGIN_L, DEFAULT_MARGIN_T, DEFAULT_PADDING);
    }
    

    //---------------------
    // Métodos de la clase
    //---------------------
    
    /**
     * Permite evitar que un elemento se dibuje. Por default, todos los 
     * elementos menos la leyenda se dibujan.
     * 
     * @param element Variable booleana del elemento que determina su visibilidad.
     */
    public void disable(boolean element) {
        element = false;
    }

    /**
     * Agrega el contenido visual al gráfico en la posición proporcionada.
     * Éste debe ser creado en una clase derivada.
     * 
     * @param posX Posición de x del contenido visual.
     * @param posY Posición de y del contenido visual.
     * @param vista {@link JPanel} que se agregará al gráfico. 
     */
    public void add(int posX, int posY, JPanel vista) {
        vista.setLocation(posX, posY);
        super.add(vista);
        revalidate();
        repaint();
    }

    public void add(JPanel vista) {
        add(margin_L + padding, margin_T + padding, vista);
    }
    
    /**
     * Sobreescribe el método {@link #paintComponent(Graphics)}. Este método es 
     * llamado por el sistema de pintura de Swing cada vez que el componente 
     * necesita ser redibujado. Aquí se deben realizar todas las operaciones de 
     * dibujo para mostrar el gráfico.
     * 
     * @param g El objeto {@link Graphics} sobre el cual se realizarán las 
     * operaciones de dibujo.
     * @see #drawContour(Graphics)
     * @see #drawTitle(Graphics)
     * @see #drawTitleAxis(Graphics)
     * @see #drawTicks(Graphics, int[], int[], int[], int[])
     * @see #drawLegend(Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawContour(g);
        drawTitle(g);
        drawTitleAxis(g);
        // drawTicks(g);
        drawLegend(g);
        
        firstTime = false;
    }
    

    // Tamaños

    /**
     * Establece un valor para el margen superior.
     * 
     * @param m Valor que tomará el margen superior.
     * @see #margin_T
     */
    public final void setMarginT(int m) {
        margin_T = m;
    }

    /**
     * Devuelve el valor del margen superior.
     * 
     * @return Margen superior del gráfico.
     * @see #margin_T
     */
    public final int getMarginT() {
        return margin_T;
    }

    /**
     * Establece un valor para el margen izquierdo.
     * 
     * @param m Valor que tomará el margen izquierdo.
     * @see #margin_L
     */
    public final void setMarginL(int m) {
        margin_L = m;
    }

    /**
     * Devuelve el valor del margen izquierdo.
     * 
     * @return Margen izquierdo del gráfico.
     * @see #margin_L
     */
    public final int getMarginL() {
        return margin_L;
    }

    /**
     * Establece un valor para el {@link padding}.
     * 
     * @param p Valor que tomará el {@link #padding}.
     * @see #padding
     */
    public final void setPadding(int p) {
        padding = p;
    }

    /**
     * Devuelve el valor del {@link #padding}.
     * 
     * @return {@link #padding} del gráfico.
     * @see #padding
     */
    public final int getPadding() {
        return padding;
    }

    /**
     * Establece un valor para la anchura del gráfico.
     * 
     * @param w Valor que tomará la anchura del gráfico.
     * @see #width
     */
    public final void setWidth(int w) {
        width = w;
    }

    /**
     * Devuelve la dimensión de anchura del gráfico. 
     * 
     * @return Anchura del gráfico.
     * @see #width
     */
    @Override
    public final int getWidth() {
        return width;
    }

    /**
     * Establece un valor para la altura.
     * 
     * @param h Valor que tomará la altura.
     * @see #height
     */
    public final void setHeight(int h) {
        height = h;
    }
    
    /**
     * Devuelve la dimensión de altura del gráfico. 
     * 
     * @return Altura del gráfico.
     * @see #height
     */
    @Override
    public final int getHeight() {
        return height;
    }

    /**
     * Establece la dimensión del gráfico con los valores de la instancia de 
     * {@link Dimension} proporcionada.
     * 
     * @param size Dimensión del gráfico.
     * @see #width
     * @see #height
     */
    @Override
    public final void setSize(Dimension size) {
        width = size.width;
        height = size.height;
        setPreferredSize(getDimension());
    }
    
    /**
     * Establece el tamaño del gráfico con los valores proporcionados.
     * 
     * @param width Anchura del gráfico.
     * @param height Altura del gráfico.
     * @see #setSize(Dimension)
     */
    @Override
    public final void setSize(int width, int height) {
        setSize(new Dimension(margin_L + width, margin_T + height));
    }
    
    /**
     * Establece el tamaño del gráfico con los valores predeterminados.
     * 
     * @see #setSize(Dimension)
     */
    public final void setSize() {
        setSize(getDimension());
    }
    
    /**
     * Devuelve el tamaño del gráfico como <em>arreglo</em> de enteros.
     * 
     * @return Tamaño del gráfico como arreglo de enteros.
     * @see #width
     * @see #height
     */
    public int[] getSizeArray() {
        return new int[] {width, height};
    }
    
    /**
     * Devuelve el tamaño del <em>panel</em> como instancia de {@link Dimension}.
     * 
     * @return Tamaño del gráfico como objeto de {@link Dimension}.
     * @see #width
     * @see #height
     */
    public Dimension getDimension() {
        return new Dimension(width, height);
    }

    /**
     * Dibuja el contorno básico del gráfico. Éste se posiciona por default en 
     * la posición ({@link #margin_L}, {@link #margin_T}) y tiene el tamaño de 
     * ({@link #width}, {@link #height}). Se dibuja en esta posición vertical 
     * porque este es el tamaño necesario para dibujar el título del gráfico y 
     * dejar un margen adecuado.
     * 
     * @param g La instancia de {@link Graphics} para realizar las operaciones
     *      de dibujo en este componente.
     */
    public void drawContour(Graphics g) {
        // La estructura lógica de este método dibujador es un poco diferente
        // a la de los otros porque siempre se va a dibujar algo
        if (g != null) {
            int n = 2 * padding + STROKE - 1; // Factor general
            int xs = margin_L;          // x Start
            int xe = xs + width + n;    // x End
            int ys = margin_T;          // y Start
            int ye = ys + height + n;   // y End
            int w = width + n;
            int h = height + n;
            g.setColor(COLOR);

            if (draw_contour) {
                // Se dibuja el contorno completo (útil para todos los gráficos 
                // menos el de Frecuencia)
                log("Dibujando contorno");
                // Tomamos el orden convencional de las manecillas del relog
                log("\tLínea de arriba");
                g.fillRect(xs, ys, w, STROKE); // Línea de arriba
                log("\tLínea de derecha");
                g.fillRect(xe, ys, STROKE, h); // Línea de derecha
                log("\tLínea de abajo");
                g.fillRect(xs, ye, w, STROKE); // Línea de abajo
                log("\tLínea de izquierda");
                g.fillRect(xs, ys, STROKE, h); // Línea de izquierda
            } else {
                // Se dibuja solo la línea izquierda (en el caso de Frecuencia)
                log("Dibujando eje izquierdo");
                g.fillRect(xs, ys, STROKE, ye); // Línea de izquierda
            }
            // Lógicamente, se podría dibujar la línea de la izquierda acá, 
            // pero se dibuja dentro de la condicional para que sea más fácil 
            // de entender y mantener
        } else NG();
    }
    
    // Títulos y cosas relacionadas a texto dentro del gráfico

    /**
     * Establece los nombres de las columnas (e.g., col1, col2, etc.).
     * 
     * @param columns Arreglo de los nombres de las columnas.
     * @see #cols
     */
    public void setCols(String[] columns) {
        // Equivalente a copiar dato por dato con for extendido:
        System.arraycopy(columns, 0, cols, 0, columns.length);
    }

    /**
     * Devuelve los nombres de las columnas (e.g., col1, col2, etc.).
     * 
     * @return Arreglo de los nombres de las columnas.
     * @see #cols
     */
    public String[] getCols() {
        return cols;
    }

    /**
     * Establece el título del gráfico.
     * 
     * @param t Texto del título del gráfico.
     * @see #title
     */
    public void setTitle(String t) {
        title = t;
    }

    /**
     * Devuelve el título del gráfico.
     * 
     * @return Texto del título del gráfico.
     * @see #title
     */
    public String getTitle(String t) {
        return title;
    }
    
    /**
     * Dibuja el título del gráfico.
     * 
     * @param g El objeto {@link Graphics} para realizar las operaciones de 
     * dibujo en este componente.
     * @see #title
     */
    public void drawTitle(Graphics g) {
        if (draw_title) {
            if (title != null) {
                if (g != null) {
                    log("Dibujando título");
                    g.setColor(COLOR);
                    g.setFont(FONT);
                    int anchTitulo = g.getFontMetrics().stringWidth(title);
                    int x = margin_L + (width - anchTitulo) / 2 - padding;
                    int y = margin_T / 2 + g.getFontMetrics().getAscent() / 2;
                    g.drawString(title, x, y);
                } else NG();
            } else
                System.err.println("Nunca se indicó el nombre del título.");
        }
    }
    
    /**
     * Establece el título del eje horizontal.
     * 
     * @param t Texto del título del eje x.
     * @see #titleX
     */
    public void setTitleX(String t) {
        titleX = t;
    }
    
    /**
     * Devuelve el título del eje horizontal.
     * 
     * @return Texto del título del eje x.
     * @see #titleX
     */
    public String getTitleX(String t) {
        return titleX;
    }
    
    /**
     * Establece el título del eje vertical.
     * 
     * @param t Texto del título del eje y.
     * @see #titleY
     */
    public void setTitleY(String t) {
        titleY = t;
    }
    
    /**
     * Devuelve el título del eje vertical.
     * 
     * @return Texto del título del eje y.
     * @see #titleY
     */
    public String getTitleY(String t) {
        return titleY;
    }
    
    /**
     * Establece el título de ambos ejes.
     * 
     * @param x Texto del título del eje x.
     * @param y Texto del título del eje y.
     * @see #titleX
     * @see #titleY
     */
    public void setTitleAxis(String x, String y) {
        titleX = x;
        titleY = y;
    }
    
    /**
     * Establece el título de ambos ejes.
     * 
     * @param t Arreglo de los textos de los títulos de los ejes.
     * @see #titleX
     * @see #titleY
     */
    public void setTitleAxis(String[] t) {
        if (t.length == 2) {
            titleX = t[0];
            titleY = t[1];
        } else DA();
    }
    
    /**
     * Dibuja los títulos de los ejes horizontales y verticales.
     * 
     * @param g El objeto {@link Graphics} para realizar las operaciones de 
     *      dibujo en este componente.
     * @see #titleX
     * @see #titleY
     */
    public void drawTitleAxis(Graphics g) {
        log("Dibujando títulos de ejes");
        if (g != null) {
            int posX, posY;
            
            g.setColor(COLOR);
            g.setFont(FONT);
            
            // Eje x
            if (titleX != null) {
                if (draw_title_x) {
                    posX = margin_L + (width - titleX.length()) / 2;
                    posY = (margin_T) / 2 + height;
                    log("\tDibujando título del eje x");
                    g.drawString(titleY, posX, posY);
                }
            }
            
            // Eje y
            if (titleY != null) {
                if (draw_title_y) {
                    Graphics2D g2d = (Graphics2D) g;
                    AffineTransform t = g2d.getTransform();
                    posX = (margin_L) / 2;
                    posY = margin_T + (height - titleY.length()) / 2;

                    g2d.rotate(Math.toRadians(-90), posX, posY); // Rotación de -90°
                    log("\tDibujando título del eje y");
                    g2d.drawString(titleY, posX, posY);
                    g2d.setTransform(t);
                }
            }
        } else NG();
    }
    
    // Ticks

    /**
     * Establece el espacio entre los ticks horizontales.
     * 
     * @param x Cantidad de espacio entre ticks del eje x (palitos en los ejes).
     */
    public void setTickX(int x) {
        tickX = x;
    }

    /**
     * Devuelve el espacio entre los ticks horizontales.
     * 
     * @return Cantidad de espacio entre ticks del eje x (palitos en los ejes).
     */
    public int getTickX() {
        return tickX;
    }
    
    /**
     * Establece el espacio entre los ticks verticales.
     * 
     * @param y Cantidad de espacio entre ticks del eje y (palitos en los ejes).
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
        } else DA();
    }
    
    /**
     * Dibuja los ticks en el gráfico.
     * 
     * @param g El objeto {@link Graphics} para realizar las operaciones de 
     *      dibujo en este componente.
     * @param start Posición {@code (x, y)} de inicio de dibujo de los ticks, donde 
     *      {@code (0, 0) = (}{@link #margin_L}{@code , }{@link #margin_T}{@code )}.
     * @param end Posición {@code (x, y)} de inicio de dibujo de los ticks, donde 
     *      {@code (MAX, MAX) = (}{@link #margin_L}{@code  + }{@link #width}{@code , }{@link #margin_T}{@code  + }{@link #height}{@code )}.
     * @param min Número mínimo (correspondiente al primer tick) que se muestra 
     *      en cada eje.
     * @param max Número máximo (correspondiente al último tick) que se muestra 
     *      en cada eje.
     */
    public void drawTicks(Graphics g, 
                          int[] start, int[] end, 
                          int[] min, int[] max) {
        log("Dibujando ticks");
        if (g != null) {
            int x = margin_T + height;
            int y = margin_L - TICKS_SIZE;

            g.setColor(COLOR);
            
            // Eje x
            if(draw_ticks_x) {
                log("\tDibujando ticks del eje x");
                // Parte que dibuja las líneas
                // Parte que dibuja los números
            }

            // Eje y
            if(draw_ticks_y) {
                log("\tDibujando ticks del eje x");
                // Parte que dibuja las líneas
                // Parte que dibuja los números
            }
        } else NG();
    }
    
    // Leyenda

    /**
     * Agrega (dibuja) una leyenda en una posición especificada a través de dos 
     * enteros.
     * 
     * @param g El objeto {@link Graphics} para realizar las operaciones de 
     *      dibujo en este componente.
     * @param posX Posición de x de la leyenda. 
     * @param posY Posición de y de la leyenda. 
     */
    public void drawLegend(Graphics g, int posX, int posY) {
        if (g != null) {
            log("Dibujando leyenda");
            g.setColor(COLOR);
            g.setFont(FONT);
            // TODO
        } else NG();
    }
    
    /**
     * Agrega (dibuja) una leyenda en una posición especificada a través de un 
     * arreglo de enteros. 
     * 
     * @param g El objeto {@link Graphics} para realizar las operaciones de 
     *      dibujo en este componente.
     * @param pos Arreglo de posiciones de ambos ejes de la leyenda. El arreglo
     *      debe contener un arreglo con exactamente dos elementos.
     */
    public void drawLegend(Graphics g, int[] pos) {
        if (pos.length == 2) {
            drawLegend(g, pos[0], pos[1]);
        } else DA();
    }
    
    /**
     * Agrega (dibuja) una leyenda en la parte superior derecha.
     * 
     * @param g El objeto {@link Graphics} para realizar las operaciones de 
     *      dibujo en este componente.
     */
    public void drawLegend(Graphics g) {
        // TODO: Cambiar valores de la posición.
        int x = 0;
        int y = 0;
        drawLegend(g, x, y);
    }
    
    //---------------------
    // "Manejo" de errores
    //---------------------
    
    /**
     * Método general que escribe cosas en la terminal que pueden ser útiles 
     * para debuggear y mantener el código. 
     */
    private void log(String msg) {
        if (firstTime) {
            System.out.println(msg);
        }
    }

    /**
     * Método general para llamar en los métodos setters cuando no se ingresan
     * dos argumentos. Se planea usar en las pruebas de la clase y por eso no
     * se levanta un error (complicaría la programación de los gráficos).
     */
    private void DA() {
        System.err.println("Error: Se tienen que proporcionar dos argumentos.");
    }

    /**
     * Método general para llamar en los métodos que dibujan cuando 
     * {@link Graphics} {@code g = null}. Se planea usar en las pruebas de la 
     * clase y por eso no se levanta un error (complicaría la programación de 
     * los gráficos).
     */
    private void NG() {
        System.err.println("Error: No se encontró el objeto de Graphics.");
    }
}
