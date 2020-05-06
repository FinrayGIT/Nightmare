package objects;

import com.devgames.characters.Monster;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class room extends JPanel
{
    public BufferedImage Background;
    public platform[] Platforms;
    public Treasure[] treasures;
    public Monster[] Monsters;
    public ladder[] Ladders;
    public Rectangle[] Triggers;
    public Vector SpawnPos;
    
    
    public room (String _backgroundPath, platform[] _platforms, 
                Monster[] _Monsters, Treasure[] _treasures,
                ladder[] _ladders, Rectangle[] _triggers, Vector _spawnpos)
    {
        //Constructor to create room objects
        Platforms = _platforms;
        Monsters = _Monsters;
        treasures = _treasures;
        Ladders = _ladders;
        Triggers = _triggers;
        SpawnPos = _spawnpos;
        
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (Exception ex) {System.err.println("Error loading image @" + _backgroundPath);}
    }
    
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
