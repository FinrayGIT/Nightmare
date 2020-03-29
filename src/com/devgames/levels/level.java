package com.devgames.levels;

import com.devgames.characters.Player;

import com.devgames.characters.Treasure;
import com.devgames.characters.Monster;
import com.devgames.game.InputController;
//import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class level extends JPanel implements ActionListener
{
    public Player player;
    public room[] rooms; 
    public room currentRoom;  
    public  Timer timer;
    private InputController inputController;

    public level (room[] _rooms)
    {
        player = new Player(new Vector(0,0));
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
        
        player.draw(g);
        
        Toolkit.getDefaultToolkit().sync();
    
        g.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {   
        inputController.updateInput();
        player.UpdatePlayer();
        repaint();
    }
    
    //needs our current active panel to capture key event 
    private class TAdapter extends KeyAdapter
    {
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
