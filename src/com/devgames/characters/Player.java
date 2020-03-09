package com.devgames.characters;

import com.devgames.levels.Vector;
import com.devgames.game.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import javax.imageio.ImageIO;

            


                /* This entire class will need refactoring */





public class Player 
{
    //Vectors to represent the character's current position
    //and movement from the current position
    public Vector position;
    Vector displacement;
    
    
    // This image represents the character    
    private BufferedImage sprite;
        
    // A score value - this could be a health or other approriate value
    private int score;
    
    private Game game;
    
    
    public Player(Game theGame)
    {
        //Starting X and Y co-ordinates
        position = new Vector(400, 400);
        
        //This vector will hold the movement from the current position
        displacement = new Vector(0,0);
        score = 0;
        
        game = theGame;
        
        init();
    }
    
    // This method is called to initalise the player    
    private void init()
    {
        try
        {
            sprite = ImageIO.read(getClass().getResource("/Sprites/Plague Doctor bigger.png"));
        }catch(Exception ex)
        {
            System.err.println("Error loading player sprite");
        }
        
        
    }
    
    /** This method returns a Rectangle object that we can use to determine
     * if a collision has taken place
     * @return
     */
    public Rectangle getBounds()
    {
        Rectangle characterRect = new Rectangle(position.getX(), position.getY(),
        sprite.getHeight(), sprite.getWidth());
        return characterRect;
    }
    
    public boolean checkCollision(Monster m)
    {
        if (m.getBounds().intersects(getBounds()))
        {   
            //This code is part of the tutorials
            //score -= m.getDamage();
            //game.endGame();            
            return true;
            
        }
        return false;        
    }
    
    public boolean checkCollision(Treasure t)
    {
        if (t.getBounds().intersects(getBounds()))
        {
            if (t.getVisible() == true)
            {
                //score += t.getScore();
                t.setVisible(false);
            }
            return true;
        }
        return false;     
    }
    
    public void setPosition(Vector v)
    {
        position = v;
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
    
    
    public BufferedImage getSprite()
    {
        return sprite;
    }
    
    /**
     * This method updates the displacement of the character based upon the
     * users key presses
     * @param direction
     */
    public void move(int direction)
    {           
        switch (direction)
        {
            case 1:
                displacement.setY(-10);
                break;
            case 2:
                displacement.setY(10);
                break;
            case 3:
                displacement.setX(-10);
                break;
            case 4:
                displacement.setX(10);
                break;
            default:
                break;                
        }
        
    }
    
    public void doMove()
    {
        position.add(displacement);  
    }
    
    /**
     * When the user releases the key, reset the move displacement to 0
     */
    
    public void stop()
    {
        displacement.setX(0);
        displacement.setY(0);
    }
    
    public void draw(Graphics2D g)
    {
        // Draw the sprite at the correct coordinates in the graphics context
        g.drawImage(sprite, position.getX(),position.getY(), null);
    }    
}
