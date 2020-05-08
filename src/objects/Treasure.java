package objects;

import java.awt.image.BufferedImage;
import java.awt.Graphics;



public class Treasure extends baseLevelObject
{    
    public boolean isVisible;
    public int treasureIndex;
    //public String name;
    
    public Treasure(Vector _position, String _path, int _treasureIndex)
    {   
        //Constructor for Treasure objects
        super(_position, _path);
        treasureIndex = _treasureIndex;
        isVisible = true;           
    }
    
    public BufferedImage getSprite()
    {
        return Sprite;
    }
        
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
}
