package com.devgames.game;

import com.devgames.characters.Monster;
import com.devgames.characters.Treasure;
import com.devgames.game.screens.StartGamePanel;
import com.devgames.levels.Vector;
import com.devgames.levels.level;
import com.devgames.levels.platform;
import com.devgames.levels.room;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;


public class Game 
{   
    //Sets the width/height of the game
    public static final int WINDOW_WIDTH = 1920; 
    public static final int WINDOW_HEIGHT = 1080;
    
    //Variable to store number of maximum assets per level *CURRENTLY NOT IN USE*    
    //public static final int MAX_ASSETS = 6;
    
    //Main Game Window, "Start Menu" and Game Over screen
    JFrame gameWindow;    
    StartGamePanel startScreen; 
    //EndGamePanel endScreen;
    
    //Variables to store which level and room is currently being played
    level currentLevel;
    //room currentRoom;
    
    //A check to ensure level has been fully loaded
    public static boolean levelReady = false;
    
    public Game()
    {   
        //Game constructor
        initWindow();
        initScreens();
    }
    
    public level[] levels =  
    {   
        //This constructor creates levels, which have rooms inside them, which
        //have platforms, monsters and treasure inside them. Objects inside 
        //level are created extending the baseLevelObject class.
        new level( 
            new room[]
            {   
                new room("/backgrounds/Room0.png",
                
                new platform[]
                {
                    new platform(new Vector(0,620), "/backgroundPlaceholder/collisionblockPlaceholder3.png"),
                    new platform(new Vector(640,0), "/backgroundPlaceholder/collisionblockPlaceholder.png"),
                },            
                new Monster[]
                {
                    new Monster(new Vector(350,500), null ),
                         new Monster(new Vector(250,500), null ),
                          new Monster(new Vector(350,100), null )
                },
                new Treasure[]
                {
                    new Treasure(new Vector(900,800), "/Sprites/skills/Skills_01.gif")
                })                
            })
    };
    
    public void goToLevel(int _levelIndex)
    {
        //This function handles switching levels, and plays background music.
        currentLevel = levels[_levelIndex];
        currentLevel.requestFocus();
        goToRoom(_levelIndex);
        currentLevel.StartLevel();
        //Sound.play(getClass().getResourceAsStream("/Sounds/Music/BGM" + _levelIndex + ".wav"), true);
    }   
    
    public void goToRoom(int _roomIndex)
    {
        //This function handles switching rooms
        if (currentLevel.currentRoom != null) {currentLevel.currentRoom.setVisible(false);}
        currentLevel.currentRoom = currentLevel.rooms[_roomIndex];     
        //currentLevel.currentRoom.requestFocus();
        currentLevel.currentRoom.setVisible(true);
    }
    
    public static void main(String[] args) 
    {   
        //This function handles creating & starting the game
        Game window = new Game();        
        window.startScreen.requestFocus();        
    }
    
    /*public void showstartScreen()
    {        
        startScreen.requestFocus(); 
    
        Turned this function off, handled it in main instead
    
    }*/
    
    public void showEndScreen()
    {
        //TBD: Add lose condition
        //Brings up death screen
        //endScreen.requestFocus();
    }   
    
    private void initWindow()
    {
        //Creates JFrame to handle window
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
        gameWindow.getContentPane().add(startScreen, "INTRO");         
        //endScreen = new EndGamePanel(this);
        //endScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        //gameWindow.getContentPane().add(endScreen, "OUTRO");
        
        //This loop sets up the levels on the gameWindow JFrame
        for (int levelLoop = 0; levelLoop < levels.length; levelLoop++)
        {
            levels[levelLoop].setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
            gameWindow.getContentPane().add(levels[levelLoop], "Level " + levelLoop);
            
            //This loop sets up rooms inside levels
            for (int roomLoop = 0; roomLoop < levels[levelLoop].rooms.length; roomLoop++)
            {
                levels[levelLoop].rooms[roomLoop].setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
                gameWindow.getContentPane().add(levels[levelLoop].rooms[roomLoop], "Room " + roomLoop);
            }
        }

    }
    
    public void startGame()
    {
        //This method will start the game after the splash screen and go to hub
        //Currently, it just goes straight to level 1        
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        cl.next(gameWindow.getContentPane());
        goToLevel(0);    
        levelReady = true;
    }
    
    public void endGame()
    {   
        // This method will show the "Game Over" screen
        //CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        //cl.next(gameWindow.getContentPane());
        //endScreen.requestFocus();
        //endScreen.setVisible(true);
    }
}
