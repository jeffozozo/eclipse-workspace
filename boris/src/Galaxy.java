

/**
 * Boris Jurosevic
 *
 * @author Boris Jurosevic
 * @ CS 3230
 *   Planet Lander
 */
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Galaxy {

    private int vertical;           
    private int horizontal;	
    private ImageIcon gallery;    


    public Galaxy(int vertical, int horizontal, Image image) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        gallery = new ImageIcon(image);
    }


    public void setPosX(int vertical) {
        this.vertical = vertical;
    }

 
    public int getPosX() {
        return vertical;
    }

 
    public void setPosY(int horizontal) {
        this.horizontal = horizontal;
    }


    public int getPosY() {
        return horizontal;
    }


    public void setImageIcon(ImageIcon icono) {
        this.gallery = icono;
    }


    public ImageIcon getImageIcon() {
        return gallery;
    }


    public int getXX() {
        return gallery.getIconWidth();
    }


    public int getYY() {
        return gallery.getIconHeight();
    }


    public Image getMyGallery() {
        return gallery.getImage();
    }


    public Rectangle getTheParameter() {
        return new Rectangle(getPosX(), getPosY(), getXX(), getYY());
    }


    public boolean destroyer(Galaxy obj) {
        return getTheParameter().intersects(obj.getTheParameter());
    }

 
    public Rectangle getNewPar() {
        return new Rectangle(getPosX() + getXX() / 4, getPosY() + getYY() / 4, getXX() / 2, getYY() / 2);
    }

    public boolean destroyPar(Galaxy obj) {
        return getNewPar().intersects(obj.getTheParameter());
    }

}
