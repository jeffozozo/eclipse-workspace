import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Main Menu
 * <p/>
 * $Id: Menu $ 2014 adg <BR/>
 * $Created: 2/20/14 at 5:54 PM $
 *
 * @author Andrew G.
 */
public class Menu {
    public static JMenuBar createMenu(DataModel modelIn) {
        DataModel model = modelIn;

        // create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Not sure what goes here");
        menuBar.add(menu);
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo: do something here
                System.out.println("New Game");
            }
        });
        menu.add(newGame);
        JMenuItem pause = new JMenuItem("Pause Game");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo: do something here
                System.out.println("Pause Game");
            }
        });
        menu.add(pause);
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo: do something here
                System.out.println("Quit");
            }
        });
        menu.add(quit);
        return menuBar;
    }
}
