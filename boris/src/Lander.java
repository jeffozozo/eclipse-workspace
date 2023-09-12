

/**
 * Boris Jurosevic
 *
 * @author Boris Jurosevic
 * @ CS 3230
 *   Planet Lander
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.ImageIcon;

public class Lander extends Applet implements Runnable, MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
   
    private int moveUpHorizontal;    
    private int moveUpVertical;    
    private int totalLifes;    
    private final int less = -5;   
    private final int more = 6;    
    private Image theImage;    
    private Image finished;    
    private Image currentPic;      
    private ImageIcon here;
    private Image demolisn;
    private Graphics graph;	
    private AudioClip killed;    
    private AudioClip footer;    
    private Planet planet;    
    private Rocket rocket;    
    private int howFast; 
    private boolean clickerr;
    private boolean isItGone;
    private int circle;
    private int increaseTheCircle;
    private int destroyedVertical;
    private int destroyedHorizontal;
    private LinkedList<Rocket> passedBy;
    private URL rURL = this.getClass().getResource("/images/rocket.gif");
    private int board = 0;
    private int points = 100;
    private int minusPoints = 20;
    private int destroyedTotal = 0;

    private boolean falseMatch;

    public void init() {
    	totalLifes = 5;    
        this.setSize(500, 500);

        int isItHorizontal = (int) (Math.random() * (getWidth()));    
        int isItVertical = getHeight();    
        URL exploer = this.getClass().getResource("/images/planet.gif");
        planet = new Planet(isItHorizontal, isItVertical, Toolkit.getDefaultToolkit().getImage(exploer));
        if (planet.getPosX() > getWidth() - planet.getXX()) {
        	planet.setPosX(getWidth() - planet.getXX());
        }
        if (planet.getPosY() > getHeight() - planet.getYY()) {
        	planet.setPosY(getHeight() - planet.getYY());
        }

        passedBy = getANewList(5, 10);

        howFast = 1;
        setBackground(Color.black);

        addMouseListener(this);
        addMouseMotionListener(this);
      
        URL firstAddress = this.getClass().getResource("/sounds/8-bit-explosion.wav");
        killed = getAudioClip(firstAddress);
        URL secondAddress = this.getClass().getResource("/sounds/Explosion.wav");
        footer = getAudioClip(firstAddress);
        URL showMe = this.getClass().getResource("/images/gameover.jpg");
        finished = Toolkit.getDefaultToolkit().getImage(showMe);
        URL currentAddress = this.getClass().getResource("/images/whiterectangle.gif");
        currentPic = Toolkit.getDefaultToolkit().getImage(currentAddress);
        here = new ImageIcon(currentPic);

        clickerr = false;
        falseMatch = false;
    }


    public void start() {
        
        Thread th = new Thread(this);
      
        th.start();
    }


    public void run() {
        while (totalLifes > 0) {
        	CheckTheStatus();
        	isItAlive();

           
            repaint();

            try {
               
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
    }


    public void CheckTheStatus() {

        for (Rocket start : passedBy) {
        	start.showNew();
        }

    }


    public void isItAlive() {

        for (Rocket start : passedBy) {
            
            if (start.isIn_collision() && start.getCollisionCyclesCounter() > 0) {
            	start.decreaseCollisionCyclesCounter();
            } else {
                
                if (start.getPosY() > getHeight() - start.getYY() && !start.isIn_collision()) {
                	footer.play();
                	start.destroy();
                    if (totalLifes > 0) {
                    	destroyedTotal++;
                        if (destroyedTotal >= 10) {
                        	totalLifes--;
                        	howFast++;
                        	destroyedTotal = 0;
                        }
                        board -= minusPoints;
                    }
                } else if (planet.destroyer(start) && !start.isIn_collision()) {
                    int notRight = start.getPosX() - planet.getPosX(); 
                 
                    if (start.getPosY() < planet.getPosY()) {
                       
                        if (notRight > -5 && notRight < planet.getXX() - start.getXX() + 5) {
                            
                            if (!falseMatch) {
                            	killed.play();    
                            	start.destroy();
                               
                                board += points;
                            } else {
                            	falseMatch = false;
                            }
                        }
                    } else if (planet.destroyPar(start)) {
                        
                    	falseMatch = true;
                    }

                } else if (start.getCollisionCyclesCounter() <= 0 && start.isIn_collision()) {
                	start.endIt();

                   
                	start.setPosX((int) (Math.random() * getWidth()));
                    if (start.getPosX() > getWidth() - start.getXX()) {
                        
                    	start.setPosX(getWidth() - start.getXX());
                    }
                    start.setPosY(0);
                    start.setSpeed(howFast);
                }

            }
        }

        
        int runAway = 5;
        
        if (planet.getPosX() <= 0 || planet.getPosY() <= 0
                || planet.getPosX() >= (getWidth() - planet.getXX())
                || planet.getPosY() >= getHeight() - planet.getYY()) {
            if (clickerr) {
            	clickerr = false;
            }
            if (planet.getPosX() <= 0) {
                planet.setPosX(planet.getPosX() + runAway);
            }
            if (planet.getPosX() >= (getWidth() - planet.getXX())) {
                planet.setPosX(planet.getPosX() - runAway);
            }
            if (planet.getPosY() <= 0) {
                planet.setPosY(planet.getPosY() + runAway);
            }
            if (planet.getPosY() >= (getHeight() - planet.getYY())) {
                planet.setPosY(planet.getPosY() - runAway);
            }
        }
    }


    public void update(Graphics g) {
        
        if (theImage == null) {
        	theImage = createImage(this.getSize().width, this.getSize().height);
        	graph = theImage.getGraphics();
        }

       
        graph.setColor(getBackground());
        graph.fillRect(0, 0, this.getSize().width, this.getSize().height);

       
        graph.setColor(getForeground());
        paint(graph);

       
        g.drawImage(theImage, 0, 0, this);
    }


    public void paint(Graphics g) {
        if (totalLifes > 0) {
            if (planet != null && !passedBy.isEmpty()) {
                int text_length = 70;
                g.setColor(Color.BLUE);
                Font newf = g.getFont().deriveFont(Font.BOLD);
                g.setFont(newf);
                g.drawString("ENERGY:", 15, 15);
                for (int i = 0; i < totalLifes; i++) {
                    g.drawImage(here.getImage(), text_length + i * here.getIconWidth(), 0, this);
                }
                String showScore = "SCORE: " + board;
                g.drawString(showScore, getWidth() - 150, 15);

                g.drawImage(planet.getMyGallery(), planet.getPosX(), planet.getPosY(), this);

                for (Rocket starts : passedBy) {
                    g.drawImage(starts.getMyGallery(), starts.getPosX(), starts.getPosY(), this);
                }

            } else {
                
                g.drawString("no picture..", 20, 20);
            }
        } else {
            g.drawImage(finished, 0, 0, this);
        }
    }


    public Rocket makeANewOne() {
       
        int hor = (int) (Math.random() * getWidth());
        int vert = (int) (Math.random() * -200);

        Rocket planet = new Rocket(hor, vert, Toolkit.getDefaultToolkit().getImage(rURL));
        if (planet.getPosX() > getWidth() - planet.getXX()) {
           
        	planet.setPosX(getWidth() - planet.getXX());
        }
        return planet;
    }
    

    public LinkedList<Rocket> getANewList(int lower, int upper) {
        int R = (int) (Math.random() * (upper - lower)) + lower;
        LinkedList<Rocket> starts = new LinkedList<Rocket>();
        for (int i = 0; i < R; i++) {
        	starts.add(makeANewOne());
        }
        return starts;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }


    @Override
    public void mousePressed(MouseEvent me) {
        planet.setMx(me.getX());
        planet.setMy(me.getY());
        clickerr = planet.clickMe();

        me.consume();
    }


    @Override
    public void mouseReleased(MouseEvent me) {
    	clickerr = false;
        me.consume();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    @Override
    public void mouseDragged(MouseEvent me) {
        if (clickerr) {
            planet.moveIt(me);
        }
        me.consume();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
