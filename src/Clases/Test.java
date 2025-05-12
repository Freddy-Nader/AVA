package Clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends Graficos {

    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        
        // Create Graficos with desired drawing area size
        Graficos g = new Graficos(800 - DEFAULT_MARGIN_L - DEFAULT_PADDING * 2, 600 - DEFAULT_MARGIN_T - DEFAULT_PADDING * 2); 
        
        // Set the layout of the Graficos panel to null for manual positioning
        g.setLayout(null); 
        
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                // IMPORTANT: Do NOT call super.paintComponent(g) here if you want
                // transparency and want the Graficos panel underneath to show.
                // super.paintComponent(graphics); 
                
                // You might need to clear the previous drawings on this panel if necessary,
                // depending on how frequently you repaint.
                // graphics.clearRect(0, 0, getWidth(), getHeight()); 

                graphics.setColor(Color.BLUE);
                int r = 5;
                int n = 100; // Increased number of points
                int d = 2 * r;
                Random random = new Random();
                
                // Get the drawing area dimensions relative to the Graficos panel
                // These are the dimensions where your JPanel 'p' is placed by Graficos.add
                // Referencing the Graficos object 'g' from the enclosing scope
                int drawingAreaWidth = g.getWidth() - g.getMarginL() - g.getPadding() * 2;
                int drawingAreaHeight = g.getHeight() - g.getMarginT() - g.getPadding() * 2;
                
                for (int i = 0; i < n; i++) {
                    // Draw points within the bounds of this panel 'p'
                    // which covers the drawing area of Graficos
                    int x = random.nextInt(drawingAreaWidth - d);
                    int y = random.nextInt(drawingAreaHeight - d);
                    graphics.fillOval(x, y, d, d);
                }
            }
        };
        
        // Set the size of the panel 'p' to match the drawing area of Graficos
        // This is crucial so paintComponent draws within the correct bounds
        int panelWidth = g.getWidth() - g.getMarginL() - g.getPadding() * 2;
        int panelHeight = g.getHeight() - g.getMarginT() - g.getPadding() * 2;
        p.setPreferredSize(new Dimension(panelWidth, panelHeight));
        p.setSize(panelWidth, panelHeight); // Use setSize for null layout
        p.setOpaque(false); // Make the panel transparent so Graficos background is visible
        
        // Add the panel with points to the Graficos object
        // Graficos.add(JPanel vista) positions the panel at (margin_L + padding, margin_T + padding)
        g.add(p);
        
        // Set the size of the Graficos panel to fill the frame's content area
        g.setPreferredSize(new Dimension(800, 600)); // Set preferred size for layout
        g.setSize(800, 600); // Set actual size if using null layout for Graficos, though BorderLayout will handle this
        
        // Set frame properties
        f.setPreferredSize(new Dimension(800, 600)); // Set frame preferred size
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add the Graficos object (which contains the panel with points) to the frame
        f.add(g);
        
        // Make the frame visible
        f.pack(); // pack() sizes the frame based on preferred sizes of components
        f.setVisible(true);
    }
}