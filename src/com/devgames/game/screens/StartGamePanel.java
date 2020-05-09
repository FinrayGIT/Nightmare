package com.devgames.game.screens;

import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.devgames.game.Game;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.IOException;

public class StartGamePanel extends JPanel
{
    private Game game;
    private BufferedImage backgroundImage;
    private BufferedImage deadImage;
    private BufferedImage winImage;
    
    public StartGamePanel(Game theGame)
    {   
        //Constructor to create the StartGamePanel object.
        game = theGame;
        addKeyListener(new TAdapter());
        
        try
        {
            backgroundImage = ImageIO.read(getClass().getResource("/backgroundTemp/backgroundTemp.png"));
        }   catch(IOException ex) {System.err.println("Error Loading Background Image 1");}

        
        try
        {
            deadImage = ImageIO.read(getClass().getResource("/backgroundTemp/gameOver.png"));
        }   catch(IOException ex) {System.err.println("Error Loading Background Image Death");}
        
        try
        {
            winImage = ImageIO.read(getClass().getResource("/backgroundTemp/gameWin.png"));
        }   catch(IOException ex) {System.err.println("Error Loading Background Image Death");}
        
        
        
        setFocusable(true);
    }   
    
   // @Override
    public void paintComponent(Graphics g)
    {
        //Call the paintComponent method on the superclass to initalise drawing
        super.paintComponent(g);
        if (game.CurrentLevel != null)
        {
              if(game.CurrentLevel.player.IsAlive() && !game.CurrentLevel.player.hasWon)
              {
                  g.drawImage(backgroundImage, 0, 0, null);  
              }
              else if (game.CurrentLevel.player.hasWon)
              {
                  g.drawImage(winImage, 0,0, null);
              }
              else
              {
                  g.drawImage(deadImage, 0, 0, null);    
              }
        } 
        else
        {
            g.drawImage(backgroundImage, 0, 0, null);  
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    private class TAdapter extends KeyAdapter
    {   
        //Listens for keypress on P and starts the game     
        @Override        
        public void keyReleased(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_P) 
            {
                System.out.println("P P P P P P");
                if (game.CurrentLevel != null)
                {
                    game.restartGame();
//                    if(!game.CurrentLevel.player.IsAlive())
//                    {
//                        game.restartGame();
//                    }
//                    else
//                    {
//                        game.startGame(); 
//                    }
                }
                else{
                    game.startGame();
                }
             }
        }
    }
}
