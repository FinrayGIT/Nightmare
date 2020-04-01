package com.devgames.levels;

import com.devgames.characters.Monster;
import com.devgames.characters.Treasure;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class room extends JPanel
{
    BufferedImage Background;
    public platform[] Platforms;
    public Treasure[] treasures;
    public Monster[] Monsters;
    
    
    public room (String _backgroundPath, platform[] _platforms, Monster[] _Monsters, Treasure[] _treasures)
    {
        //Constructor to create room objects
        Platforms = _platforms;
        Monsters = _Monsters;
        treasures = _treasures;
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (Exception ex) {System.err.println("Error loading image @" + _backgroundPath);}
    }   
}
