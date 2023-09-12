


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 * The space rocket with which player will have to land.
 * 
 * @author www.gametutorial.net
 */

public class PlayerRocket {
    
    /**
     * We use this to generate a random number for starting x coordinate of the rocket.
     */
    private Random random;
 
    /**
     * X coordinate of the rocket.
     */
    public double x;
    /**
     * Y coordinate of the rocket.
     */
    public double y;
    
    /**
     * Is rocket landed?
     */
    public boolean landed;
    
    /**
     * Has rocket crashed?
     */
    public boolean crashed;
        
    /**
     * Accelerating speed of the rocket.
     */
    private double speedAccelerating;
    /**
     * Stopping/Falling speed of the rocket. Falling speed because, the gravity pulls the rocket down to the moon.
     */
    private double speedStopping;
    
    /**
     * Maximum speed that rocket can have without having a crash when landing.
     */
    public int topLandingSpeed;
    
    /**
     * How fast and to which direction rocket is moving on x coordinate?
     */
    private double speedX;
    /**
     * How fast and to which direction rocket is moving on y coordinate?
     */
    public double speedY;
            
    /**
     * Image of the rocket in air.
     */
    private Image rocketImg;
    /**
     * Image of the rocket when landed.
     */
    private Image rocketLandedImg;
    /**
     * Image of the rocket when crashed.
     */
    private Image rocketCrashedImg;
    /**
     * Image of the rocket fire.
     */
    private Image rocketFireImg;
    
    /**
     * Width of rocket.
     */
    public int rocketImgWidth;
    /**
     * Height of rocket.
     */
    public int rocketImgHeight;
    
    
    public PlayerRocket()
    {
        Initialize();
        LoadContent();
        
        // Now that we have rocketImgWidth we set starting x coordinate.
        x = random.nextInt(Framework.frameWidth - rocketImgWidth);
    }
    
    
    private void Initialize()
    {
        random = new Random();
        
        ResetPlayer();
        
        speedAccelerating = .51;
        speedStopping = .21;
        
        topLandingSpeed = 5;
    }
    
    private void LoadContent()
    {
        try
        {
            URL rocketImgUrl = this.getClass().getResource("rocket.png");
            rocketImg = ImageIO.read(rocketImgUrl);
            
            Image temp = rocketImg.getScaledInstance(20, 30, Image.SCALE_SMOOTH);
            rocketImg = temp;
            
            rocketImgWidth = rocketImg.getWidth(null);
            rocketImgHeight = rocketImg.getHeight(null);
                      
            URL rocketLandedImgUrl = this.getClass().getResource("rocket_landed.png");
            rocketLandedImg = ImageIO.read(rocketLandedImgUrl);            
            temp = rocketLandedImg.getScaledInstance(20,30,Image.SCALE_SMOOTH);
            rocketLandedImg = temp;
            
            URL rocketCrashedImgUrl = this.getClass().getResource("rocket_crashed.png");
            rocketCrashedImg = ImageIO.read(rocketCrashedImgUrl);
            temp = rocketCrashedImg.getScaledInstance(30,20, Image.SCALE_SMOOTH);
            rocketCrashedImg = temp;
            
            URL rocketFireImgUrl = this.getClass().getResource("rocket_fire.png");
            rocketFireImg = ImageIO.read(rocketFireImgUrl);
            temp = rocketFireImg.getScaledInstance(10, 30, Image.SCALE_SMOOTH);
            rocketFireImg = temp;
        }
        catch (IOException ex) {
            Logger.getLogger(PlayerRocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Here we set up the rocket when we starting a new game.
     */
    public void ResetPlayer()
    {
        landed = false;
        crashed = false;
        
        x = random.nextInt(Framework.frameWidth - rocketImgWidth);
        y = 10;
        
        speedX = 0;
        speedY = 0;
    }
    
    
    /**
     * Here we move the rocket.
     */
    public void Update()
    {
        // Calculating speed for moving up or down.
        if(Canvas.keyboardKeyState(KeyEvent.VK_W))
            speedY -= speedAccelerating;
        else
            speedY += speedStopping;
        
        // Calculating speed for moving or stopping to the left.
        if(Canvas.keyboardKeyState(KeyEvent.VK_A))
            speedX -= speedAccelerating;
        else if(speedX < 0)
            speedX += speedStopping;
        
        // Calculating speed for moving or stopping to the right.
        if(Canvas.keyboardKeyState(KeyEvent.VK_D))
            speedX += speedAccelerating;
        else if(speedX > 0)
            speedX -= speedStopping;
        
        // Moves the rocket.
        x += speedX;
        y += speedY;
    }
    
    public void Draw(Graphics2D g2d)
    {
        g2d.setColor(Color.white);
        g2d.drawString("Rocket coordinates: " + x + " : " + y, 5, 15);
        
        // If the rocket is landed.
        if(landed)
        {
            g2d.drawImage(rocketLandedImg, (int)x, (int)y, null);
        }
        // If the rocket is crashed.
        else if(crashed)
        {
            g2d.drawImage(rocketCrashedImg, (int)x, (int)y + rocketImgHeight - rocketCrashedImg.getHeight(null), null);
        }
        // If the rocket is still in the space.
        else
        {
            // If player hold down a W key we draw rocket fire.
            if(Canvas.keyboardKeyState(KeyEvent.VK_W))
                g2d.drawImage(rocketFireImg,(int) x+5, (int)y+24, null);
            g2d.drawImage(rocketImg, (int)x, (int)y, null);
        }
    }
    
}
