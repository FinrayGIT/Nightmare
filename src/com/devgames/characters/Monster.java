package com.devgames.characters;

import com.devgames.levels.Vector;
import com.devgames.levels.baseLevelObject;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static java.lang.Math.sqrt;
import java.util.Random;
import javax.imageio.ImageIO;


public class Monster extends baseLevelObject
{
    private boolean isVisible;
    public Player player;
    
    private int speed = 3;
    private int damage;
    private int score;
    
    public Monster(Vector _position, Player thePlayer)
    {   
        super(_position, "/Sprites/Graded/Frost-Brute-Graded-Single.png");
        player = thePlayer;    
        score = 50;
        isVisible = true;
        
        /*try
        {
            sprite = ImageIO.read(getClass().getResourceAsStream
                ("/Sprites/Graded/Frost-Brute-Graded-Single.png"));
        }catch(Exception ex)
        {
            System.err.println("Error loading monster sprite");
        }*/        
        
    }
    
    public BufferedImage getSprite()
    {
        return Sprite;        
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(Position.getX(), Position.getY(), Sprite.getHeight(), Sprite.getWidth());
                
    }
    
    public void setPosition(Vector v)
    {
        Position.setToVector(v);
    }
    
    public int getPlayerX()
    {           
        return player.position.getX();
    }
    
    public int getDamage()
    {
        return damage;
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
            g.drawImage(Sprite, Position.getX(), Position.getY(), null);
    }
    
    public void doMove(int levelWidth, int levelHeight)
    {
        //Random rand = new Random();
        //int randomDirection;        
        // Create a vector to store the current position of the monster
        // we will only update the movement vector if the monster does not
        // collide with anything 
        
        //randomDirection = rand.nextInt(4) + 1;
        
        /*switch(randomDirection)
        {
            case 1:
                displacement.setY(-speed);
                break;
            case 2:
                displacement.setY(speed);
                break;  
            case 3:
                displacement.setX(-speed);
                break;
            case 4:
                displacement.setX(speed);                
        }
        
        Vector tempPosition = new Vector(position);
        Vector displacement = new Vector();
        
        /* Adding in some boundary checks, X coordinate first
        First check that the new X coordinate won't go off the left hand side
        of the window, then check that the X coordinate won't go off the right
        hand side
        
        if(tempPosition.getX() < (spriteWidth / 2))
        {
            //displacement.setX(1);
            displacement.setX(player.position.getX()*speed);
        }else if(tempPosition.getX() > levelWidth - (spriteWidth / 2))
        {
            displacement.setX(-1);
            
        }    
        /*Now check the Y coordinate - first the top of the screen, then the
        bottom of the screen
        
        if(tempPosition.getY() < spriteHeight / 2)
        {
            //displacement.setY(1);
            displacement.setY(player.position.getY()*speed);
            
        }else if (spriteHeight > levelHeight - (spriteHeight /2))
        {
            displacement.setY(1);
        } 
            
        tempPosition.add(displacement);
        
        //Change the current position vector to the temporary vector
        position.setToVector(tempPosition);*/

        Vector direction = new Vector(Position);      
        
        
        direction.setX(player.position.getX() - Position.getX());
        direction.setY(player.position.getY() - Position.getY());
        
        double hyp = sqrt(direction.getX()*direction.getX() + direction.getY()*direction.getY());
        
        direction.setX((int) (direction.getX() / hyp)*speed);
        direction.setY((int) (direction.getY() / hyp)*speed);
        
        
        
    }
    
    
    
    public boolean attack()
    {
        return true;
    }
    
    
}
