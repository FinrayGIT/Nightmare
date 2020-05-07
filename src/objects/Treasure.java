package objects;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;



public class Treasure extends baseLevelObject
{    
    public static boolean isVisible;
    public String name;
    
    public Treasure(Vector _position, String _path, String _name)
    {   
        //Constructor for Treasure objects
        super(_position, _path);
        name = _name;
        isVisible = true;      
                        
    }
    
    public BufferedImage getSprite()
    {
        return Sprite;
    }
    
    public void draw(Graphics2D g)
    {
        //Draw the sprite at the correct coordinates in the graphics context
        if(isVisible == true)   g.drawImage(Sprite, (int)Position.x, (int)Position.y, null);
    }
        
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
}
