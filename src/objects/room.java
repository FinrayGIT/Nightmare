package objects;

import com.devgames.game.Detector;
import com.devgames.characters.Monster;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class room extends JPanel
{
    public BufferedImage Background;
    public platform[] Platforms;
    public Treasure[] treasures;
    public Monster[] Monsters;
    public ladder[] Ladders;
    public Detector[] RTA;
    public Detector[] wind;
    public Detector[] platformColliders;
        
    public room (   String _backgroundPath, 
                    platform[] _platforms, 
                    Monster[] _Monsters, 
                    Treasure[] _treasures,
                    ladder[] _ladders, 
                    Detector[] _RTA )
    {
        //Constructor to create room objects
        Platforms = _platforms;
        Monsters = _Monsters;
        treasures = _treasures;
        Ladders = _ladders;
        RTA = _RTA;
        
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (IOException ex) {System.err.println("Error loading image @" + _backgroundPath);}
    }
    
    public room (   String _backgroundPath, 
                    platform[] _platforms, 
                    Monster[] _Monsters, 
                    Treasure[] _treasures,
                    ladder[] _ladders, 
                    Detector[] _RTA,
                    Detector[] _wind,
                    Detector[] _platformColliders)
    {
        //Constructor to create room objects
        Platforms = _platforms;
        Monsters = _Monsters;
        treasures = _treasures;
        Ladders = _ladders;
        RTA = _RTA;
        wind = _wind;
        platformColliders = _platformColliders;
        
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (IOException ex) {System.err.println("Error loading image @" + _backgroundPath);}
    }
}
