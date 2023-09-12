import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

/**
 * Planet Lander
 * <p/>                                                                                `
 * $Id: PlanetLander $ 2014 adg <BR/>
 * $Created: 2/20/14 at 5:26 PM $
 *
 * @author Andrew G.
 */
public class PlanetLander extends JFrame implements Runnable {

    StatsBarPanel statsBarPanel;
    DataModel dataModel;
    Rocket rocket;
    LandingPad landingPad;
    FlyingSurface flyingSurface;
    public static enum GameState{STARTING, PAUSED, NEW_GAME, PLAYING, GAMEOVER};
    public static GameState gameState;
    private long gameTime;
    private long lastTime;
    private final int GAME_FPS = 16;
    public static final long milisecInNanosec = 1000000L;
    public static final long secInNanosec = 1000000000L;
    private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;

    private BufferedImage backgroundImg;

    public PlanetLander() {
        setTitle("Planet Lander");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(700,700);
        setMinimumSize(new Dimension(500,400));

        dataModel = new DataModel();
        rocket = new Rocket();
        landingPad = new LandingPad();
        flyingSurface = new FlyingSurface();


        // create menu

        setJMenuBar(Menu.createMenu(dataModel));
        setLayout(new BorderLayout());

        //stats bar
        statsBarPanel = new StatsBarPanel(this, dataModel);
        statsBarPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        //create surface
        loadImages();

        add(statsBarPanel, BorderLayout.PAGE_START);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure that you want to Quit?", "Are you sure?", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                } else {
                    setVisible(true);
                }
            }
        });
        gameState = GameState.STARTING;
        Thread gameThread = new Thread() {
            @Override
            public void run() {
                //todo; not sure if it goes here
                gameLoop();
            }
        };
        gameThread.start();
    }


    public void loadImages() {
        try {
            //URL backgroundURL = this.getClass().getResource("background.jpg");
            File r = new File("background.jpg");
        	backgroundImg = ImageIO.read(r);
        } catch (IOException e) {
            Logger.getLogger(PlanetLander.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void restartGame() {
        rocket.resetPlayer();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(backgroundImg, 0,0, FlyingSurface.frameWidth, FlyingSurface.frameHeight, null);
        landingPad.draw(g2d);
        rocket.draw(g2d);
        flyingSurface.paintComponent(g2d);
        
        System.out.println("in here.");
        
    }

    public void drawGameOver(Graphics2D g2d, long gameTime) {
        draw(g2d);

        g2d.drawString("Press space or enter to restart.", FlyingSurface.frameWidth / 2 - 100, FlyingSurface.frameHeight / 3 + 70);

        if(rocket.landed)
        {
            g2d.drawString("You have successfully landed!", FlyingSurface.frameWidth / 2 - 100, FlyingSurface.frameHeight / 3);
            g2d.drawString("You have landed in " + gameTime / FlyingSurface.secInNanosec + " seconds.", FlyingSurface.frameWidth / 2 - 100, FlyingSurface.frameHeight / 3 + 20);
        }
        else
        {
            g2d.setColor(Color.red);
            g2d.drawString("You have crashed the rocket!", FlyingSurface.frameWidth / 2 - 95, FlyingSurface.frameHeight / 3);
//            g2d.drawImage(redBorderImg, 0, 0, FlyingSurface.frameWidth, FlyingSurface.frameHeight, null);
        }
    }

    public void updateGame() {
        rocket.update();

        if(rocket.y + rocket.rocketImgHeight - 10 > landingPad.y)
        {
            // Here we check if the rocket is over landing area.
            if((rocket.x > rocket.x) && (rocket.x < landingPad.x + landingPad.landingAreaImgWidth - rocket.rocketImgWidth))
            {
                // Here we check if the rocket speed isn't too high.
                if(rocket.speedY <= rocket.maxLandingSpeed)
                    rocket.landed = true;
                else
                    rocket.crashed = true;
            }
            else
                rocket.crashed = true;

            FlyingSurface.gameState = FlyingSurface.GameState.GAMEOVER;
        }
    }

    @Override
    public void run() {
        setVisible(true);
    }

    public void gameLoop() {
        long beginTime, timeTaken, timeLeft;

        while(true) {
            beginTime = System.nanoTime();

            switch (gameState) {
                case PLAYING:
                    gameTime += System.nanoTime() - lastTime;
                    updateGame();
                    lastTime = System.nanoTime();
                    break;
                case PAUSED:
                    //
                    break;
                case NEW_GAME:
                    break;
                case GAMEOVER:
                    break;
                case STARTING:
                    loadImages();

                    gameState = GameState.PAUSED;
                    break;
            }

            flyingSurface.repaint();


            timeTaken = System.nanoTime() - beginTime;
            timeLeft = (GAME_UPDATE_PERIOD - timeTaken) / milisecInNanosec;

            if (timeLeft < 10) {
                // wait at least 10 milliseconds
                timeLeft = 10;
            }
            try {
                Thread.sleep(timeLeft);
            } catch (InterruptedException ex) {
                // don't worry about it
            }
        }
    }
}
