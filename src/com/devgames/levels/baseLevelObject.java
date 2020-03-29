package com.devgames.levels;

import com.devgames.game.Game;
import com.devgames.levels.Vector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class baseLevelObject 
{
    public Vector Position;
    public BufferedImage Sprite;
    
    //Constructor for baseLevelObject, which extends from Monsters, platforms and treasure
    public baseLevelObject(Vector _position, String _path)
    {
        Position = _position;
        try
            {
                        Sprite = ImageIO.read(getClass().getResource(_path));
            }   catch (Exception ex)
            {
                System.err.println("Error loading level @" + _path);
            }
    }
    
    public Rectangle getBounds()
    {
        Rectangle rect = new Rectangle((int)Position.x, (int)Position.y,
        Sprite.getHeight(), Sprite.getWidth());
        return rect;
    }  
}
