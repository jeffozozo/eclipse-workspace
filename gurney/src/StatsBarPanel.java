import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Stats Bar Panel
 * <p/>
 * $Id: StatsBarPanel $ 2014 adg <BR/>
 * $Created: 2/20/14 at 11:09 PM $
 *
 * @author Andrew G.
 */
public class StatsBarPanel extends JPanel implements ActionListener {

    JLabel speed = new JLabel("Speed-");
    JLabel fuel = new JLabel("Fuel Spent-");
    JLabel altitude = new JLabel("Altitude-");
    JLabel time = new JLabel("Time-");
    JLabel difficulty = new JLabel("Difficultly-");
    JLabel planet = new JLabel("Planet-");
    JButton left = new JButton("<");
    JButton right = new JButton(">");
    JButton up = new JButton("^");

    PlanetLander lander;
    DataModel dataModel;


    public StatsBarPanel(PlanetLander landerIn, DataModel modelIn) {
        setFocusable(false);
        lander = landerIn;
        dataModel = modelIn;
        add(speed);
        add(fuel);
        add(altitude);
        add(time);
        add(difficulty);
        add(planet);
        add(left);
        add(right);
        add(up);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //todo: not sure at this point how to identify items to update
//
//        speed.setText("Speed-"); //todo:finish
//        fuel.setText("Fuel-"); //todo:finish
//        altitude.setText("Altitude-"); //todo:finish
//        time.setText("Time-"); //todo:finish
//        difficulty.setText("Difficutly-"); //todo:finish
    }

    public void updateStats() {
        speed.setText("Speed-" + dataModel.speed);
        fuel.setText("Fuel-" + dataModel.fuelSpent);
        altitude.setText("Altitude-" + dataModel.altitude.getX() + "-" + dataModel.altitude.getY());
        time.setText("Time-" + dataModel.time);
        difficulty.setText("Difficultly-" + dataModel.difficulty);
        planet.setText("Planet-" + dataModel.planetName);
    }
}
