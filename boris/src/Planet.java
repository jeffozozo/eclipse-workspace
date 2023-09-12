
/**
 * Boris Jurosevic
 *
 * @author Boris Jurosevic
 * @ CS 3230
 *   Planet Lander
 */
import java.awt.Image;
import java.awt.event.MouseEvent;

public class Planet extends Galaxy {

    int horizontalPosition, verticalPosition; 
    int yHorizontal, xPosition;


    public Planet(int xPlace, int yPlace, Image pic) {
        super(xPlace, yPlace, pic);
    }

    public int getX_offset() {
        return horizontalPosition;
    }

    public void setX_offset(int x_offset) {
        this.horizontalPosition = x_offset;
    }

    public int getY_offset() {
        return verticalPosition;
    }

    public void setY_offset(int y_offset) {
        this.verticalPosition = y_offset;
    }

    public int getMx() {
        return yHorizontal;
    }

    public void setMx(int mx) {
        this.yHorizontal = mx;
    }

    public int getMy() {
        return xPosition;
    }

    public void setMy(int my) {
        this.xPosition = my;
    }



    public boolean clickMe() {
        return getTheParameter().contains(yHorizontal, xPosition);
    }

 
    public void moveIt(MouseEvent e) {
        setPosX(getPosX() + (e.getX() - yHorizontal));
        setPosY(getPosY() + (e.getY() - xPosition));
        setMx(e.getX());
        setMy(e.getY());
    }

}
