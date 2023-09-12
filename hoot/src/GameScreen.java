/**
 * Created By: Joshua Hootman Lander Project
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Joshuahootman
 */
public class GameScreen extends JPanel {

    Image bgImage;
    SpaceShip ship;
    Lander landingPad;

    public GameScreen(SpaceShip in) {
        try {
			// load the image and then make it a little smaller. note that I say img = img...  I'm overwriting it
            // because of the way getScaledInstance works. It doesn't modify the original (like string.replace)
            // instead it returns a new, scaled copy. 

            bgImage = ImageIO.read(new File("land.jpg"));
            landingPad = new Lander();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ship = in;
    }

    public void paintComponent(Graphics gContext) {
        Graphics2D g2d = (Graphics2D) gContext;
        g2d.drawImage(bgImage, WIDTH, WIDTH, this);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Rocket coordinates: " + ship.x + " : " + ship.y, 5, 15);
        g2d.drawString("Fuel Remaining : [========] ", 5, 35);
        g2d.drawString("Planet : URRGG ", 5, 55);
        g2d.drawString("Current Gravity: " + ship._gravity + " m/s^2", 5, 75);
        ship.setParms(getWidth(), getHeight(), (Graphics2D) gContext);
        ship.updatePosition();

    }
}
