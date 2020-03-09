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
        super(_position, _path);
        isVisible = true;      
                        
    }
    
    public BufferedImage getSprite()
    {
        return Sprite;
    }
    
    public Rectangle getBounds()
    {
        Rectangle objectRect = new Rectangle(Position.getX(), Position.getY(),
        Sprite.getWidth(), Sprite.getHeight());
        return objectRect;
    }
    
    public void setPosition(Vector v)
    {
        Position.setToVector(v);
    }
    
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
        if(isVisible == true)
            g.drawImage(Sprite, Position.getX(), Position.getY(), null);
    }
}
