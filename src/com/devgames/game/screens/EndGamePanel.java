package com.devgames.game.screens;

import com.devgames.game.Game;
import static com.devgames.game.Game.WINDOW_HEIGHT;
import static com.devgames.game.Game.WINDOW_WIDTH;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Toolkit;


public class EndGamePanel extends JPanel

{
    private Game game;
    private BufferedImage backgroundImage = null;
    
    
    public EndGamePanel(Game theGame)
    {   
        //Constructor for EndGamePanel object
        game = theGame;
        try
        {
            backgroundImage = ImageIO.read(getClass().getResource("/backgroundTemp/gameOver.png"));
        }catch(Exception ex)
        {
            System.err.println("Error loading background image gameOver");
        }
        setFocusable(true);
        
        
    }        
    
    @Override
    public void paintComponent(Graphics g)
    {
        //Calls the paintComponent method on the superclass to initalise drawing
        super.paintComponent(g);        
        g.drawImage(backgroundImage, 0, 0, null);
        Toolkit.getDefaultToolkit().sync();
    }        
}
