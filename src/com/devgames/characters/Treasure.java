package com.devgames.characters;

import com.devgames.levels.Vector;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Treasure 
{
    private Vector position;
    private int spriteWidth;
    private int spriteHeight;
    private boolean isVisible;
    
    private BufferedImage sprite;
    
    private int score;
    
    public Treasure()
    {
        position = new Vector (50, 100);
        score = 50;
        isVisible = true;
        
        try
        {
            sprite = ImageIO.read(getClass().getResourceAsStream
        ("/Sprites/skills/Skills_01.gif"));
        }catch(Exception ex)
        {
            System.err.println("Error loading treasure sprite");
        }
        
        spriteWidth = sprite.getWidth();
        spriteHeight = sprite.getHeight();
    }
    
    public BufferedImage getSprite()
    {
        return sprite;
    }
    
    public Rectangle getBounds()
    {
        Rectangle objectRect = new Rectangle(position.getX(), position.getY(),
        spriteWidth, spriteHeight);
        return objectRect;
    }
    
    public void setPosition(Vector v)
    {
        position.setToVector(v);
    }
    
    public Vector getPosition()
    {
        return position;
    }
    
    public void setScore(int newScore)
    {
        score = newScore;
    }
    
    public int getScore()
    {
        return score;
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
            g.drawImage(sprite, position.getX(), position.getY(), null);
    }
}
