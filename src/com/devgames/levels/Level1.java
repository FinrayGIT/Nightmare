/*package com.devgames.levels;

import com.devgames.game.Game;
import com.devgames.game.screens.StartGamePanel;
import com.devgames.characters.Player;
import com.devgames.characters.Treasure;
import com.devgames.characters.Monster;

import java.awt.Font;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

// This is a small change


public class Level1 extends JPanel implements ActionListener
{
    private Game game;
    private BufferedImage background;
    private Timer timer;
    private Player thePlayer;
    private Treasure theTreasure;
    private Monster theMonster;
    private BufferedImage[] A = new BufferedImage[6];

    
    
    
    public Level1(Game theGame)
    {
        game = theGame;
        thePlayer = new Player(theGame);
        theTreasure = new Treasure();
        theMonster = new Monster(thePlayer);
        
        //addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);        
        
        //Loads background image
        try
            {
                        background = ImageIO.read(getClass().getResource("/backgroundTemp/backgroundTemp.png"));
            }   catch (Exception ex)
            {
                System.err.println("Error loading background image of level 1");
            }
        //Game timer
        timer = new Timer(10, this);
        
        //Loads cutout level pieces
        for (int i = 1; i < Game.MAX_ASSETS; i++)
        {
            String asset = "/backgroundPlaceholder/Room1A"+(i)+".png";
            try
                {   
                    System.out.println(i);
                    A[i] = ImageIO.read(getClass().getResource(asset));
                }
                    catch (Exception ex){System.err.println("Error loading A"+i);}        
        }
    }
    
    
    
    
    
    
    /**
     * This method will be called to check for collisions
     
    public void checkCollisions()
    {
        /** Check to see if the player boundary (rectangle) intersects
         * with the treasure boundary (i.e. there is a collision)
         
        thePlayer.checkCollision(theMonster);
        thePlayer.checkCollision(theTreasure);        
    }
    
    public void movement()
    {
        thePlayer.doMove();
        theMonster.doMove(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    }
    
    public void start()
    {
        timer.start();
    }
    
    public void stop()
    {
        timer.stop();
    }
    
    
    
    /**
     * This method is called in response to the timer firing
     * Every 10ms, this method will update the state of the game
     * in response to changes such as key presses and to generate computer 
     * movement
     * @param ae
     
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        // The repaint method starts the process of updating the screen
        // Calling our version of the paintComponent method, which has the code
        // for drawing our characters and objects
        checkCollisions();
        movement();
        repaint();
    }
    
    
}   

*/