import javax.swing.*;
import java.awt.*;

/**
 * Created by Nathan on 3/22/14.
 */
public class DashboardFrame extends JFrame implements Runnable
{
    ControlPanel cPanel;

    public DashboardFrame()
    {
        setTitle("Credit Card Clearinghouse");
        //setSize(800, 800);
        cPanel = new ControlPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(cPanel);
        //setLayout(new FlowLayout());

        pack();
        setVisible(true);


    }

    public void run()
    {
       // setVisible(true);
    }
}
