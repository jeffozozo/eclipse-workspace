/**
 * Created By: Joshua Hootman Lander Project
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Gandalf
 */
public class Lander {

    /**
     * X coordinate of the landing area.
     */
    public int x;
    /**
     * Y coordinate of the landing area.
     */
    public int y;

    /**
     * Image of landing area.
     */
    private Image img;

    /**
     * Width of landing area.
     */
    public int landingAreaImgWidth;

    public Lander() {
        Initialize();
        LoadContent();
    }

    private void Initialize() {
        // X coordinate of the landing area is at 46% frame width.
        x = 500;
        // Y coordinate of the landing area is at 86% frame height.
        y = 500;
    }

    private void LoadContent() {
        try {
//			 load the image and then make it a little smaller. note that I say img = img...  I'm overwriting it
//			 because of the way getScaledInstance works. It doesn't modify the original (like string.replace)
            // instead it returns a new, scaled copy. 

            img = ImageIO.read(new File("landing_area.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, null);
    }

}
