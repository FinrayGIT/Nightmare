package com.devgames.game;


import com.devgames.characters.Monster;
import com.devgames.characters.Treasure;
import com.devgames.game.screens.StartGamePanel;
import com.devgames.game.screens.EndGamePanel;
import com.devgames.levels.Vector;
import com.devgames.levels.baseLevelObject;
import com.devgames.levels.level;
import com.devgames.levels.platform;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;





public class Game {
    
    
    // Sets the height/width of the game
    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;
    public static final int MAX_ASSETS = 6;
    JFrame gameWindow; // Main Game Window    
    StartGamePanel startScreen; // Splash screen
    EndGamePanel endScreen; // Game Over screen
    level currentLevel;
    //Level1 lvl1; // This is the leve 1 object
    
    public level[] levels =  
        {                     
            new level("/backgroundTemp/backgroundTemp.png",
                    new platform[]
                    {
                        new platform(new Vector(0, 800), "/backgroundPlaceholder/Room1A1.png"),
                        new platform(new Vector(0, 800), "/backgroundPlaceholder/Room1A1.png")
                    },
                    new Monster[]
                    {   
                        new Monster(new Vector(350,500), null )
                    },
                    new Treasure[]
                    {   
                        new Treasure(new Vector(900,800), "/Sprites/skills/Skills_01.gif")
                    })
        };
    
    public void goToLevel(int _levelIndex)
    {
        if (currentLevel != null)
        {
            currentLevel.setVisible(false);
        }
        
        currentLevel = levels[_levelIndex];
        //currentLevel.reset()
        currentLevel.requestFocus();
        currentLevel.setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) 
    {   
        Game window = new Game();
        
        window.showStartScreen();
    }
    
    public void showStartScreen()
    {
        gameWindow.setVisible(true);
        startScreen.requestFocus();
    }
    
    public void showEndScreen()
    {
        endScreen.requestFocus();
    }
    
    public Game()
    {
        
        initWindow();
        initScreens();
    }
    
    private void initWindow()
    {
        gameWindow = new JFrame();
        gameWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setLayout(new CardLayout());
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setTitle("Nightmare");
        gameWindow.setVisible(true);
    }
    
    private void initScreens()
    {
        startScreen = new StartGamePanel(this);
        startScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        endScreen = new EndGamePanel(this);
        endScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        
        //This will add a start screen to the main window
        gameWindow.getContentPane().add(startScreen, "INTRO");
        for (int i = 0; i < levels.length; i++)
        {
            levels[i].setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
            gameWindow.getContentPane().add(levels[i], "Level " +i);
        }        
        
        gameWindow.getContentPane().add(endScreen, "OUTRO");
        endScreen.setVisible(false);
        
    }
    
    public void startGame()
    {
        // This method will start the main game
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        
        cl.next(gameWindow.getContentPane());
        goToLevel(0);
        //lvl1.requestFocus();
        //lvl1.start();
    }
    
    public void endGame()
    {   
        // This method will show the "Game Over" screen
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        
        //lvl1.stop();
        cl.next(gameWindow.getContentPane());
        endScreen.requestFocus();
        endScreen.setVisible(true);
    }
    
    /** FOR LATER
     * 
     * This is a private KeyAdapter Class that we use to process key presses
     
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
        
    }*/
}
