package com.devgames.game.screens;

import com.devgames.game.Game;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class StartGamePanel extends JPanel
{
    private Game game; // This links back to the Game controller class
    private BufferedImage backgroundImage = null;     
    
    public StartGamePanel(Game theGame)
    {
        game = theGame;
        init();
    }
    
    private void init()
    {
        addKeyListener(new TAdapter());
        
        //Loads the first background image
        try
        {
            backgroundImage = ImageIO.read(getClass().getResource("/backgroundTemp/backgroundTemp2.png"));
        }catch(Exception ex)
        {
            System.err.println("Error Loading Background Image 1");
        }
        setFocusable(true);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        // Call the paintComponent method on the superclass to initalise drawing
        super.paintComponent(g);
        
        // Start drawing - the background goes first
        g.drawImage(backgroundImage, 0, 0, null);
        //g.drawImage(zombieSprite, 0, 600, null);
        //g.drawImage(theDoc, 1400, 600, null);        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private class TAdapter extends KeyAdapter
    {
        @Override
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_P)
                game.startGame();
        }
        
        @Override
        public void keyPressed(KeyEvent e)
        {
            
        }
    }
}
