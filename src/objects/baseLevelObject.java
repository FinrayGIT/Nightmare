package objects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class baseLevelObject 
{
    public Vector Position;
    public BufferedImage Sprite;
    
    //Constructor to create baseLevelObjects

    //baseLevelObjects contain code that will be required in every object the
    //game uses.
    public baseLevelObject(Vector _position, String _path)
    {
        Position = _position;
        try
            {
                Sprite = ImageIO.read(getClass().getResource(_path));
            }   catch(Exception ex) {System.err.println("Error loading image @" + _path);}
    }
    
    public baseLevelObject(Vector _position)
    {
        Position = _position;
    }
    
    public baseLevelObject(Vector _position, BufferedImage _sprite)
    {
        Position = _position;
        Sprite = _sprite;
    }
    
    public Rectangle getBounds()
    {
        Rectangle rect = new Rectangle((int)Position.x, (int)Position.y,
                Sprite.getWidth(), Sprite.getHeight());
        return rect;
    }
}