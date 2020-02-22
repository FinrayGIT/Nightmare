package com.devgames.levels;

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
    
    
    
    public Level1(Game theGame)
    {
        game = theGame;
        thePlayer = new Player(theGame);
        theTreasure = new Treasure();
        theMonster = new Monster();
        init();
    }
    
    private void init()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        
        try
        {
                background = ImageIO.read(getClass().getResource("/backgroundTemp/backgroundTemp.png"));
        }catch (Exception ex)
        {
            System.err.println("Error loading background image of level 1");
        }
        timer = new Timer(10, this);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //Cast the graphics object to a graphics2D object
        Graphics2D g2d = (Graphics2D) g;
        // Draw background
        g2d.drawImage(background, 0, 0, null);
        // Draw obstacles
        
        // Draw characters
        theMonster.draw(g2d);
        theTreasure.draw(g2d);
        thePlayer.draw(g2d);
        g.dispose(); 
    }
    
    /**
     * This method will be called to check for collisions
     */
    public void checkCollisions()
    {
        /** Check to see if the player boundary (rectangle) intersects
         * with the treasure boundary (i.e. there is a collision)
         */
        thePlayer.checkCollision(theMonster);
        thePlayer.checkCollision(theTreasure);        
    }
    
    public void movement()
    {
        thePlayer.doMove();
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
     */
    
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
    
    /** 
     * This is a private KeyAdapter Class that we use to process key presses
     */
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int move = 0;
            
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    move = 1;
                    break;
                case KeyEvent.VK_DOWN:
                    move = 2;
                    break;
                case KeyEvent.VK_LEFT:
                    move = 3;
                    break;
                case KeyEvent.VK_RIGHT:
                    move = 4;
                    break;
            }
            thePlayer.move(move);
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            thePlayer.stop();
        }
        
    }
}   

