package objects;

import com.devgames.game.RoomTransition;
import com.devgames.characters.Monster;
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
    public RoomTransition[] RTA;
        
    public room (   String _backgroundPath, 
                    platform[] _platforms, 
                    Monster[] _Monsters, 
                    Treasure[] _treasures,
                    ladder[] _ladders, 
                    RoomTransition[] _RTA   )
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
        }   catch (Exception ex) {System.err.println("Error loading image @" + _backgroundPath);}
    }
}
