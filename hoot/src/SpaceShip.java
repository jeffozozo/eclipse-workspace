/**
 * Joshua Hootman Lander Project
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Joshuahootman
 */
public class SpaceShip {

    protected Image img;
    protected double _gravity = .0001;
    protected double x, y;
    protected double xMove, yMove = 0;
    protected int size;
    protected Graphics2D g2;
    Image imgLand;
    
    int width = 600;
    int height = 500;

    public SpaceShip() {

        x = 100;
        y = 1;
        size = 50;
        xMove = 0;
        yMove = 0;

        try {
//			 load the image and then make it a little smaller. note that I say img = img...  I'm overwriting it
//			 because of the way getScaledInstance works. It doesn't modify the original (like string.replace)
            // instead it returns a new, scaled copy.
            //  imgLand = ImageIO.read(new File("landing_area.png"));
            img = ImageIO.read(new File("Rocket.png"));
            img = img.getScaledInstance(70, 50, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setParms(int widthIn, int heightIn, Graphics2D gIn)
    {
    	width = widthIn;
    	height = heightIn;
    	g2 = gIn;
    }

    public void updatePosition() {


        x += xMove;

        yMove += _gravity; //simulate gravity by adding a constant amount to the yMove each time.
        y += yMove;  

        if (x > width - size) {
            x = width - size;
            xMove *= -1;
        }

        if (x < 1) {
            x = 1;
            xMove *= -1;

        }

        if (y > height - size) {

             //  JOptionPane.showMessageDialog(null, " You came in too hot, game over "
            // ,"Game Over", JOptionPane.PLAIN_MESSAGE);
            // System.exit(0);
            y = height - size;
            yMove *= -1;
        }

        if (y < 1) {

            System.out.println("");
            y = 1;
            yMove *= -1;
        }

        g2.drawImage(img, (int)x, (int)y, null);

    }

    public SpaceShip getShip() {
        return this;
    }

    public Graphics2D GetGraphics() {
        return g2;
    }

}
