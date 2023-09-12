/**
 * Joshua Hootman Lander Project
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Joshuahootman
 */
public class MainFrame extends JFrame implements Runnable, ActionListener {
    // ImageIcon bgImage = new ImageIcon("land");

	GameScreen _gs;
	
    @Override
    public void run() {
        //---------------------File menu ----------------------------------
        SpaceShip ship = new SpaceShip();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 550);
        
        //need to call repaint on this guy
        _gs = new GameScreen(ship);

        setLocationRelativeTo(null);
        addWindowListener(new WindowCloser());
        setTitle("Lander Mission");
        setResizable(false);
        setJMenuBar(new MenuBar(ship).getBar());
        setLayout(new BorderLayout());
        add(_gs, BorderLayout.CENTER);
        add(new UIControls(ship), BorderLayout.PAGE_START);
        //setResize(false);
        setVisible(true);
        
        //drawing timer (also notice that you need to get the swing timer and not the util timer)
        Timer t = new Timer(1,this);
        t.start();
        

    }

    public class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {

            int confirmed = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to quit?");
            //0 for yes, 1 for no
            System.out.println(confirmed);
            if (confirmed == 0) {
                System.exit(0);
            } else {
                setVisible(true);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _gs.repaint(); //note you need to call repaint on the game panel instead of the frame.
    }

}
