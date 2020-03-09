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
    public platform[] Platforms;  
    BufferedImage Background;
    private Treasure[] treasures;
    private Monster[] monsters;
    
    
    public level (String _backgroundPath, platform[] _platforms, Monster[] _monsters, Treasure[] _treasures)
    {        
        Platforms = _platforms;
        monsters = _monsters;
        treasures = _treasures;
        
        
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (Exception ex)
        {
            System.err.println("Error loading level @" + _backgroundPath);
        }
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        // Calls the paintComponent method on the superclass to initalise drawing
        super.paintComponent(g);
        
        g.drawImage(Background, 0, 0, null);
        Toolkit.getDefaultToolkit().sync();
        
        for(Monster m: monsters)
        {            
            g.drawImage(m.Sprite, m.Position.getX(), m.Position.getY(), null);                    
        }
        for(Treasure t: treasures)
        {
            g.drawImage(t.Sprite, t.Position.getX(), t.Position.getY(), null);            
        }
        for(platform p: Platforms)
        {
            g.drawImage(p.Sprite, p.Position.getX(), p.Position.getY(), null);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {               
        repaint();
    }
}
