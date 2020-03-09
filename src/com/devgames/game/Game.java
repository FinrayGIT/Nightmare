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
        
    public static final int WINDOW_WIDTH = 1920;//Sets the width/height of the game
    public static final int WINDOW_HEIGHT = 1080;    
    public static final int MAX_ASSETS = 6;//Variable to store number of maximum assets per level
    
    JFrame gameWindow; // Main Game Window        
    StartGamePanel startScreen; // Splash screen
    EndGamePanel endScreen; // Game Over screen
    level currentLevel;    
    
    public Game()
    {   
        //Game constructor
        initWindow();
        initScreens();
    }
    
    public level[] levels =  
    {   
        //This function creates levels, which have platforms, monsters and
        //treasure inside them. Objects inside level are created as baseLevelObjects.
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
        //Handles level switching
        if (currentLevel != null) {currentLevel.setVisible(false);}        
        currentLevel = levels[_levelIndex];
        //currentLevel.reset() Turned off for later use.
        currentLevel.requestFocus();
        currentLevel.setVisible(true);        
    }   
    
    public static void main(String[] args) 
    {   
        //Handles starting the game
        Game window = new Game();        
        window.showstartScreen();
    }
    
    public void showstartScreen()
    {
        //Brings up the splash screen 
        startScreen.requestFocus();
    }
    
    public void showEndScreen()
    {
        //Brings up death screen *This is done in endgame() atm*
        //endScreen.requestFocus();
    }   
    
    private void initWindow()
    {
        //Constructs JFrame to handle window
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
        //This function draws screens on the gameWindow JFrame
        startScreen = new StartGamePanel(this);
        startScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));        
        endScreen = new EndGamePanel(this);
        endScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        gameWindow.getContentPane().add(startScreen, "INTRO");  
        gameWindow.getContentPane().add(endScreen, "OUTRO");
        
        //This loop sets up the levels on the gameWindow JFrame
        for (int i = 0; i < levels.length; i++)
        {
            levels[i].setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
            gameWindow.getContentPane().add(levels[i], "Level " +i);
        }
    }
    
    public void startGame()
    {
        // This method will start the game after the splash screen and go to hub level.        
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        cl.next(gameWindow.getContentPane());
        goToLevel(0);        
    }
    
    public void endGame()
    {   
        // This method will show the "Game Over" screen
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        cl.next(gameWindow.getContentPane());
        endScreen.requestFocus();
        endScreen.setVisible(true);
    }
    
    /** FOR LATER
     *  This code handles player movement.
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
