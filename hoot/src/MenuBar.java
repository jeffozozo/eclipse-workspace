/**
 * Joshua Hootman Lander Project
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Joshuahootman
 */
public class MenuBar extends JMenuBar {

    JMenuBar menubar = new JMenuBar();
    SpaceShip s;

    public MenuBar(SpaceShip ship) {
        s = ship;
        JMenu file = new JMenu("Game");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu imp = new JMenu("Import");
        imp.setMnemonic(KeyEvent.VK_M);
        final JMenuItem fileNew = new JMenuItem("Start New Game");
        fileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //put the x and y postions to 0, make it start from the 
                //upper left cornonr 
                s.x = 0;
                s.y = 0;
            }
        });
        fileNew.setMnemonic(KeyEvent.VK_N);
        final JMenuItem pause = new JMenuItem("Pause/Continue");
        fileNew.setMnemonic(KeyEvent.VK_N);
        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.setMnemonic(KeyEvent.VK_C);
        fileExit.setToolTipText("Exit application");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                ActionEvent.CTRL_MASK));
        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(fileNew);
        file.addSeparator();
        file.add(pause);
        file.addSeparator();
        file.add(fileExit);
        menubar.add(file);

        //---------------------Settings menu ----------------------------------
        JMenu set = new JMenu("Settings");
        set.setMnemonic(KeyEvent.VK_A);
        JMenuItem settings_menu = new JMenuItem("settings");
        set.setMnemonic(KeyEvent.VK_9);

        settings_menu.setToolTipText("Change the starting paramater this project");
        settings_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                SettingsWindow sW = new SettingsWindow(s);
            }
        });
        set.add(settings_menu);
        menubar.add(set);
  //---------------------Settings menu ----------------------------------

 //---------------------About menu ----------------------------------
        JMenu about = new JMenu("About");
        file.setMnemonic(KeyEvent.VK_A);
        JMenuItem AboutProject = new JMenuItem("About");
        AboutProject.setMnemonic(KeyEvent.VK_9);

        AboutProject.setToolTipText("View Info Regaurding this project");
        AboutProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(fileNew, "Created By Joshua Hootman 2014 ", "LanderProject V1.0", JOptionPane.PLAIN_MESSAGE);
            }
        });
        about.add(AboutProject);
        menubar.add(about);
 //---------------------About menu ----------------------------------

    }

    JMenuBar getBar() {
        // new MenuBar();
        return menubar;
    }

}
