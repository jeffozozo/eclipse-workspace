/**
 *
 * @author ${user}
 */

import java.awt.EventQueue;
import javax.swing.Timer;

/**
 *
 * @author Joshuahootman
 */
public class LanderProject {

    /**
     * @param args the command line arguments
     */
    public static Timer t;

    public static void main(String[] args) {
        // TODO code application logic here
        MainFrame myUI = new MainFrame();
        EventQueue.invokeLater(myUI);

        //ui timer
        t = new Timer(100, myUI);
        t.start();
    }

}
