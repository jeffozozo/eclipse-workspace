/**
 * Joshua Hootman
 * Lander Project 
 */

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Joshuahootman
 */
public class UIControls extends JPanel{
    JButton right = new JButton (">");
    JButton left = new JButton ("<");
    JButton up = new JButton ("^");
   SpaceShip ship;
   
    public UIControls(SpaceShip s){
    ship = s;
    add(left);
    add(up);
    add(right);
    left.addActionListener(new ButtonAction(ship, this));
    right.addActionListener(new ButtonAction(ship, this));
    up.addActionListener(new ButtonAction(ship, this));
    
    }

}
