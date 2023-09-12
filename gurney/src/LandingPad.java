import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 * Landing Pad
 * <p/>
 * $Id: LandingPad $ 2014 adg <BR/>
 * $Created: 3/2/14 at 2:00 AM $
 *
 * @author Andrew G.
 */
public class LandingPad {
    public int x;
    public int y;

    private BufferedImage landingPad;
    public int landingAreaImgWidth;


    public LandingPad() {
        initialize();
        loadContent();
    }

    private void initialize() {
        x = (int) (FlyingSurface.frameWidth * .46);
        y = (int) (FlyingSurface.frameHeight * .88);
    }

    private void loadContent() {
        try {
            //URL landingAreaImgUrl = this.getClass().getResource("landing_area.png");
            File r = new File("landing_area.png");
        	landingPad = ImageIO.read(r);
            landingAreaImgWidth = landingPad.getWidth();
        } catch (IOException ex) {
            Logger.getLogger(LandingPad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(landingPad, x, y, null);
    }
}
