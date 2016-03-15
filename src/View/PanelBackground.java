/*
 *     Name :  Iman Syahputra Situmorang
 *     NIM  :  11113064
 *     Date :  09/December/2014
 
 */

package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Takiya
 */
public class PanelBackground extends JPanel{
    Image image;
    
    public PanelBackground (Image gambar) {
        image=gambar;
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
 
        Graphics2D gd = (Graphics2D) g.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
    
    
}
