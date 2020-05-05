package com.devgames.game;

import objects.room;
import com.devgames.characters.Player;
import com.devgames.characters.Monster;
import com.devgames.game.Game;
import com.devgames.game.InputController;
import objects.Vector;


import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import objects.Treasure;
import objects.platform;
import objects.room;

public class level extends JPanel implements ActionListener
{   
    public Game game;
    public Player player;
    public room[] rooms; 
    public room currentRoom;
    public static int CurrentRoomInt;
    public Timer timer;
    private InputController inputController;

    public level (room[] _rooms)
    {   
        //Constructer to create level objects.
        
        player = new Player(new Vector(0,0), this);
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TAdapter());
        inputController = new InputController(this);
        rooms = _rooms;          
        timer = new Timer(10, this);   
    }
    
    public void StartLevel()
    {
        timer.start();
    }
    
    public void EndLevel()
    {
        timer.stop();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {   
               
        //This function draws all required graphics in level.
        super.paintComponent(g);
        g.drawImage(currentRoom.Background,0,0,null);
        
        for(Monster m: currentRoom.Monsters)
        {            
            g.drawImage(m.Sprite, (int)m.Position.x, (int)m.Position.y, null);                    
        }
        for(Treasure t: currentRoom.treasures)
        {
            g.drawImage(t.Sprite, (int)t.Position.x, (int)t.Position.y, null);           
        }
        for(platform p: currentRoom.Platforms)
        {
            g.drawImage(p.Sprite, (int)p.Position.x, (int)p.Position.y, null);
        }
//        for(ladder l: currentRoom.Ladders)
//        {
//            g.drawImage(l.Sprite, (int)l.Position.x, (int)l.Position.y, null);
//        }
        
        player.draw(g);
        g.dispose();        
        Toolkit.getDefaultToolkit().sync();            
    }
    
    //@Override
    public void actionPerformed(ActionEvent ae)
    {  
        //Once input it detected, updates and redraws scene.        
        player.UpdatePlayer(this);
        inputController.updateInput();
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }
    
    
    private class TAdapter extends KeyAdapter
    {
        //This function listens for inputs and performs their respective
        //function once detected in inputController.updateInput() through
        //level.actionPerformed().
        @Override
        public void keyPressed(KeyEvent e)
        {
            inputController.CheckKeyPress(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            inputController.CheckKeyRelease(e);
        }
    }
}
