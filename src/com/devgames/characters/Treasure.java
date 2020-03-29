package com.devgames.characters;

import com.devgames.levels.Vector;
import com.devgames.levels.baseLevelObject;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Treasure extends baseLevelObject
{    
    private boolean isVisible;
    
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
    
  
    
//    public void setPosition(Vector v)
//    {
//        Position += v;
//    }
    
    public Vector getPosition()
    {
        return Position;
    }
    
    public void setScore(int newScore)
    {
        
    }
    
    public void getScore()
    {
        
    }
    
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
    
    public boolean getVisible()
    {
        return isVisible;
    }
    
    public void draw(Graphics2D g)
    {
        //Draw the sprite at the correct coordinates in the graphics context
        if(isVisible == true)   g.drawImage(Sprite, (int)Position.x, (int)Position.y, null);
    }
}
