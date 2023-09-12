/**
 * Created by Nathan on 2/27/14.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;



public class DrawingSurface extends JPanel implements ActionListener, KeyListener
{
    private static final long serialVersionUID = 1L;

    int xPoly[] = {0,25, 50, 0};
    int yPoly[] = {30, 0, 30, 30};


    int delay = 15;
    int dx=0;
    int dy=1;
    int steps = 500;
    int counter = 0;

    Timer timer = new Timer(delay,this);



    public void actionPerformed(ActionEvent ae)
    {
        for (int i=0; i<Array.getLength(xPoly);i++)
        {
            xPoly[i] += dx;
            yPoly[i] += dy;
        }

        counter += 1;
        if (counter % 30 == 0)
        {
            dy += 1;
        }
        repaint();

        if (--steps ==0) timer.stop();


    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            this.setVisible(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            dx += 100; repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            dy -= 10;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            dy += 10;
        }

    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void paintComponent(Graphics gContext)
    {
        Graphics2D g2 = (Graphics2D) gContext;
        super.paintComponent(g2);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.BLUE);
        g2.fillRect(getWidth() / 2 + 20, getHeight() - 10, 70, 10);
        g2.setColor(Color.WHITE);
        Shape polygon1 = new Polygon ( xPoly, yPoly, xPoly.length);
        g2.fill(polygon1);

    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Planet Lander");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        DrawingSurface ds = new DrawingSurface();
        frame.getContentPane().add(ds);
        frame.setSize(600,500);
        frame.setVisible(true);

        ds.timer.start();
    }
}