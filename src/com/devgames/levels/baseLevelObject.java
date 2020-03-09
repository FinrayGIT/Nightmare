package com.devgames.levels;

import com.devgames.game.Game;
import com.devgames.levels.Vector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class baseLevelObject 
{
    public Vector Position;
    public BufferedImage Sprite;
    
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
    
    /*@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //Cast the graphics object to a graphics2D object
        Graphics2D g2d = (Graphics2D) g;
        // Draw background
        g2d.drawImage(background, 0, 0, null);
        // Draw obstacles        
        for(int i = 1; i < Game.MAX_ASSETS; i++){g2d.drawImage(A[i], 0, 800, null);}
        
        // Draw characters
        theMonster.draw(g2d);
        theTreasure.draw(g2d);
        thePlayer.draw(g2d);
        g.dispose(); 
    }*/

    
}
