package com.devgames.game;

import com.devgames.levels.Level1;
import com.devgames.game.screens.StartGamePanel;
import com.devgames.game.screens.EndGamePanel;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;





public class Game {
    
    
    // Sets the height/width of the game
    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;
    
    JFrame gameWindow; // Main Game Window    
    StartGamePanel startScreen; // Splash screen
    EndGamePanel endScreen; // Game Over screen
    Level1 lvl1; // This is the leve 1 object
    
    public static void main(String[] args) 
    {   
        System.out.println("fhfhs");
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
        lvl1 = new Level1(this);
        lvl1.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        endScreen = new EndGamePanel(this);
        endScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        //This will add a start screen to the main window
        gameWindow.getContentPane().add(startScreen, "INTRO");        
        gameWindow.getContentPane().add(lvl1, "LVL1");
        gameWindow.getContentPane().add(endScreen, "OUTRO");
        
        
    }
    
    public void startGame()
    {
        // This method will start the main game
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        
        cl.next(gameWindow.getContentPane());
        lvl1.requestFocus();
        lvl1.start();
    }
    
    public void endGame()
    {   
        // This method will show the "Game Over" screen
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        
        lvl1.stop();
        cl.next(gameWindow.getContentPane());
        endScreen.requestFocus();
        endScreen.setVisible(true);
    }
}
