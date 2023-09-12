import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Flying Surface
 * <p/>
 * $Id: FlyingSurface $ 2014 adg <BR/>
 * $Created: 2/27/14 at 12:38 AM $
 *
 * @author Andrew G.
 */
public class FlyingSurface extends JPanel implements KeyListener {
    public static int frameWidth;
    public static int frameHeight;
    public static final long milisecInNanosec = 1000000L;
    public static final long secInNanosec = 1000000000L;
    public static enum GameState{STARTING, PAUSED, NEW_GAME, PLAYING, GAMEOVER};
    public static GameState gameState;
    private final int GAME_FPS = 16;
    private static boolean[] keyboardState = new boolean[525];
    private final long GAME_UPDATE_PERIOD = secInNanosec / GAME_FPS;

    private long gameTime;
    private long lastTime;

    private PlanetLander game;

    private BufferedImage menuImage;

    public FlyingSurface() {
        frameWidth = this.getWidth();
        frameHeight = this.getHeight();
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);

        this.addKeyListener(this);

        gameState = GameState.STARTING;

//        Thread gameThread = new Thread() {
//            @Override
//            public void run() {
//                gameLoop();
//            }
//        };
//        gameThread.start();
    }

    public void gameLoop() {
        long beginTime, timeTaken, timeLeft;

        while(true) {
            beginTime = System.nanoTime();

            switch (gameState) {
                case PLAYING:
                    gameTime += System.nanoTime() - lastTime;
                    game.updateGame();
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

            repaint();

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

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        super.paintComponent(graphics2D);
        switch (gameState) {
            case PLAYING:
                game.draw(graphics2D);
                break;
            case GAMEOVER:
                game.drawGameOver(graphics2D, gameTime);
                break;
            case PAUSED:
                graphics2D.drawImage(menuImage, 0, 0, frameWidth, frameHeight, null);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawString("Up, Down, Left, and Right to control the rocket", frameWidth / 2, frameHeight / 2);
                graphics2D.drawString("Press any key to start", frameWidth / 2, frameHeight / 2 - 50);
                break;
        }
    }

    public static boolean keyboardKeyState(int key) {
        return keyboardState[key];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    // Methods of the keyboard listener.
    @Override
    public void keyPressed(KeyEvent e)
    {
        keyboardState[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keyboardState[e.getKeyCode()] = false;
        keyReleasedFramework(e);
    }

    public void loadImages() {
        try {
            InputStream stream = this.getClass().getResourceAsStream("menu.jpg");
//            URL menuImageURL = this.getClass().getResource("menu.jpg");
            menuImage = ImageIO.read(stream);
        } catch (IOException e) {
            Logger.getLogger(FlyingSurface.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void keyReleasedFramework(KeyEvent e) {
        switch (gameState) {
            case NEW_GAME:
                newGame();
                break;
            case GAMEOVER:
                if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)
                    restartGame();
                break;
        }
    }

    private void newGame() {
        gameTime = 0;
        lastTime = System.nanoTime();

        game = new PlanetLander();
    }

    private void restartGame() {
        gameTime = 0;
        lastTime = System.nanoTime();
        game.restartGame();
        gameState = GameState.PLAYING;
    }
}
