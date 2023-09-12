import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 * Rocket
 * <p/>
 * $Id: Rocket $ 2014 adg <BR/>
 * $Created: 3/2/14 at 1:30 AM $
 *
 * @author Andrew G.
 */
public class Rocket {
    public int x;
    public int y;
    public boolean landed;
    public boolean crashed;
    public int engineSpeed;
    public int gravity;
    public int speedX;
    public int speedY;
    public int maxLandingSpeed;
    public BufferedImage rocketImg;
    public BufferedImage rocketFireImg;
    public BufferedImage rocketLandedImg;
    public BufferedImage rocketCrashedImg;
    private Random random;
    public int rocketImgWidth;
    public int rocketImgHeight;

    public Rocket() {
        initialise();
        loadContent();

        x = random.nextInt(5/*FlyingSurface.frameWidth - rocketImgWidth*/);
    }

    private void initialise() {
        random = new Random();

        resetPlayer();

        engineSpeed = 2;
        engineSpeed = 1;
        maxLandingSpeed = 5;
    }

    private void loadContent() {
        try {
        	File r = new File("rocket.png");
            //URL rocketImgUrl = this.getClass().getResource("rocket.png");
            rocketImg = ImageIO.read(r);
            rocketImgWidth = rocketImg.getWidth();
            rocketImgHeight = rocketImg.getHeight();

            //URL rocketLandedImgUrl = this.getClass().getResource("rocket_landed.png");
            r = new File("rocket_landed.png");
            rocketLandedImg = ImageIO.read(r);

            //URL rocketCrashedImgUrl = this.getClass().getResource("rocket_crashed.png");
            r = new File("rocket_crashed.png");
            rocketCrashedImg = ImageIO.read(r);

            //URL rocketFireImgUrl = this.getClass().getResource("rocket_fire.png");
            r = new File("rocket_fire.png");
            rocketFireImg = ImageIO.read(r);
            
        } catch (IOException ex) {
            Logger.getLogger(Rocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resetPlayer() {
        landed = false;
        crashed = false;
        x = random.nextInt(5/*FlyingSurface.frameWidth - rocketImgWidth*/);
        y = 10;
        speedX = 0;
        speedY = 0;
    }

    public void update() {
        // handle up, right, and left

        // up
        if(FlyingSurface.keyboardKeyState(KeyEvent.VK_UP)) {
            speedY -= engineSpeed;
        } else {
            speedY += gravity;
        }

        // left
        if (FlyingSurface.keyboardKeyState(KeyEvent.VK_LEFT)) {
            speedX -= engineSpeed;
        }

        // right
        if (FlyingSurface.keyboardKeyState(KeyEvent.VK_RIGHT)) {
            speedX += engineSpeed;
        }

        x += speedX;
        y += speedY;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.drawString("Rocket coordinates: " + x + " : " + y, 5, 15);

        // If the rocket is landed.
        if (landed) {
            g2d.drawImage(rocketLandedImg, x, y, null);
        }
        // If the rocket is crashed.
        else if (crashed) {
            g2d.drawImage(rocketCrashedImg, x, y + rocketImgHeight - rocketCrashedImg.getHeight(), null);
        }
        // If the rocket is still in the space.
        else {
            // If player hold down a W key we draw rocket fire.
            if (FlyingSurface.keyboardKeyState(KeyEvent.VK_W))
                g2d.drawImage(rocketFireImg, x + 12, y + 66, null);
            g2d.drawImage(rocketImg, x, y, null);
        }
    }
}
