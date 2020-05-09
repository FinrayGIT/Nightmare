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
    public Treasure[] treasures;
    public Monster[] Monsters;
    public ladder[] Ladders;
    public Detector[] RTA;
    public Detector[] wind;
    public Detector[] platformColliders;
    public Detector[] Breakables;
    public Detector[] doors;
    public Detector[] spikes;
        
//    public room (   String _backgroundPath, 
//                    Monster[] _Monsters, 
//                    Treasure[] _treasures,
//                    ladder[] _ladders, 
//                    Detector[] _RTA,
//                    Detector[] _platformColliders)
//    {
//        //Constructor to create room objects
//        Monsters = _Monsters;
//        treasures = _treasures;
//        Ladders = _ladders;
//        RTA = _RTA;
//        wind = new Detector[0];
//        platformColliders = _platformColliders;
//        
//        
//        
//        try
//        {
//            Background = ImageIO.read(getClass().getResource(_backgroundPath));
//        }   catch (IOException ex) {System.err.println("Error loading image @" + _backgroundPath);}
//    }
    
    public room (   String _backgroundPath, 
                  //  platform[] _platforms, 
                    Monster[] _Monsters, 
                    Treasure[] _treasures,
                    ladder[] _ladders, 
                    Detector[] _RTA,
                    Detector[] _platformColliders,
                    Detector[] _wind,
                    Detector[] _doors,
                    Detector[] _spikes,
                    Detector[] _breakables
                    )
    {
        //Constructor to create room objects
      //  Platforms = _platforms;
        Monsters = _Monsters;
        treasures = _treasures;
        Ladders = _ladders;
        RTA = _RTA;
        platformColliders = _platformColliders;
        wind = _wind;
        spikes = _spikes;
        Breakables = _breakables;
        doors = _doors;
        
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (IOException ex) {System.err.println("Error loading image @" + _backgroundPath);}
    }
    
    
    
}
