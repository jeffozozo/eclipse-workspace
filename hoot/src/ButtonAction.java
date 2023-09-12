/**
 * Joshua Hootman Lander Project
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Gandalf
 */
public class ButtonAction implements ActionListener {

    UIControls ButtonPanel;
    SpaceShip ship;

    public ButtonAction(SpaceShip ship_in, UIControls bp) {
        ButtonPanel = bp;
        ship = ship_in;
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == ButtonPanel.left) 
        {
        	ship.xMove -= .01;

        } else if (b == ButtonPanel.right) 
        {
        	ship.xMove += .01;
        } else {
        	ship.yMove -= .05;
        }
        
        ship.updatePosition();
    }

}
