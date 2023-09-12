/**
 * Joshua Hootman
 * Lander Project 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Gandalf
 */
public class SettingsWindow extends JFrame implements ActionListener {

    SpaceShip ship;
    JButton save = new JButton("Save");
    JButton cancel = new JButton("Cancel");
    JLabel gravity;
    JLabel Xpos;
    JLabel Ypos;
    JLabel CrashingVel;
    JLabel initFuel;
    JLabel widthOfPad;
    JTextField gvtextField = new JTextField();
    JTextField xtextField = new JTextField();
    JTextField ytextField = new JTextField();
    JTextField ctextField = new JTextField();
    JTextField itextField = new JTextField();
    JTextField wtextField = new JTextField();

    public SettingsWindow(SpaceShip s) {
        ship = s;

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setLocationRelativeTo(null);
        setTitle("Settings Window");
        setSize(300, 600);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //setResize(false);
        setVisible(true);

        gravity = new JLabel("Planet Gravity:",
                JLabel.CENTER);
        gvtextField.setText(Double.toString(ship._gravity));

        Xpos = new JLabel("Inital X Velocity:",
                JLabel.CENTER);
        xtextField.setText(Double.toString(ship.x));

        Ypos = new JLabel("Inital Y Velocity:",
                JLabel.CENTER);
        ytextField.setText(Double.toString(ship.y));

        CrashingVel = new JLabel("Crashing Velocity:",
                JLabel.CENTER);

        initFuel = new JLabel("Initial Fuel Amount:",
                JLabel.CENTER);

        widthOfPad = new JLabel("Width of Landing Pad:",
                JLabel.CENTER);

        save.addActionListener(this);
        add(gravity);
        add(gvtextField);

        add(Xpos);
        add(xtextField);

        add(Ypos);
        add(ytextField);

        add(CrashingVel);
        add(ctextField);

        add(initFuel);
        add(itextField);

        add(widthOfPad);
        add(wtextField);

        add(save);
        add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == save) {
            ship._gravity = Integer.parseInt(gvtextField.getText());
            ship.x = Integer.parseInt(xtextField.getText());
            ship.y = Integer.parseInt(ytextField.getText());
        } else {
            setVisible(false);
        }
    }

}
