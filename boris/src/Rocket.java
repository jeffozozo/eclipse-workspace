

/**
 * Boris Jurosevic
 *
 * @author Boris Jurosevic
 * @ CS 3230
 *   Planet Lander
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class Rocket extends Galaxy {

    private int speed = 1;
    private boolean crashing;
    private boolean isPicture;
    private int goingAround;
    private int increaseByOne;

    private URL webaddress = this.getClass().getResource("/images/rocket.gif");
    URL newWebAd = this.getClass().getResource("/images/explosion_b.gif");
    private Image myPic = Toolkit.getDefaultToolkit().getImage(webaddress);    
    private Image rocketPic = Toolkit.getDefaultToolkit().getImage(newWebAd);   


    public Rocket(int posX, int posY, Image image) {
        super(posX, posY, image);
        crashing = false;
        isPicture = false;
        goingAround = 25;
        increaseByOne = -1;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isIn_collision() {
        return crashing;
    }

    public void setIn_collision(boolean in_collision) {
        this.crashing = in_collision;
    }

    public boolean isChangeImage() {
        return isPicture;
    }

    public void setChangeImage(boolean changeImage) {
        this.isPicture = changeImage;
    }

    public int getCollisionCycles() {
        return goingAround;
    }

    public void setCollisionCycles(int collisionCycles) {
        this.goingAround = collisionCycles;
    }

    public int getCollisionCyclesCounter() {
        return increaseByOne;
    }

    public void setCollisionCyclesCounter(int collisionCyclesCounter) {
        this.increaseByOne = collisionCyclesCounter;
    }

    public URL getrURL() {
        return webaddress;
    }

    public void setrURL(URL rURL) {
        this.webaddress = rURL;
    }

    public URL getExpURL() {
        return newWebAd;
    }

    public void setExpURL(URL expURL) {
        this.newWebAd = expURL;
    }

    public Image getNormalImage() {
        return myPic;
    }

    public void setNormalImage(Image normalImage) {
        this.myPic = normalImage;
    }

    public Image getCollisionImage() {
        return rocketPic;
    }

    public void setCollisionImage(Image collisionImage) {
        this.rocketPic = collisionImage;
    }

    public void decreaseCollisionCyclesCounter() {
        setCollisionCyclesCounter(increaseByOne - 1);
    }

    public void destroy() {
    	crashing = true;
    	increaseByOne = goingAround;
        isPicture = true;
    }

    public void endIt() {
    	crashing = false;
    	increaseByOne = -1;
        isPicture = true;
    }

    public void getNewPic() {
        if (crashing) {
            setImageIcon(new ImageIcon(rocketPic));
        } else {
            setImageIcon(new ImageIcon(myPic));
        }
        isPicture = false;
    }

    public void showNew() {
        if (!crashing) {
            fall();
        }

        if (isPicture) {
        	getNewPic();
        }
    }

    public void fall() {
        setPosY(getPosY() + speed);
    }
}
