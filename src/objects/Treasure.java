package objects;

import objects.baseLevelObject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Treasure extends baseLevelObject
{    
    public static boolean isVisible;
    
    public Treasure(Vector _position, String _path)
    {   
        //Constructor for Treasure objects
        super(_position, _path);
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
        
      //TODO: Refactor/remove this code
//    public void setPosition(Vector v)
//    {
//        Position += v;
//    }
    
//    public Vector getPosition()
//    {
//        return Position;
//    }
//    
//    public void setScore(int newScore)
//    {
//        
//    }
//    
//    public void getScore()
//    {
//        
//    }
//    

//    
//    public boolean getVisible()
//    {
//        return isVisible;
//    }
}
