package com.devgames.characters;

import objects.Vector;
import objects.baseLevelObject;
import java.awt.Graphics2D;


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
    }
    
        public void draw(Graphics2D g)
    {
        //Draw the sprite at the correct coordinates in the graphics context
        if(isVisible == true)
            g.drawImage(Sprite, (int)Position.x, (int)Position.y, null);
    }
    
      //TODO: Refactor/remove this code
//    public BufferedImage getSprite()
//    {
//        return Sprite;        
//    }
//        
//    public void setPosition(Vector v)
//    {
//        Position.x += v.x;
//        Position.y += v.y;
//    }
//    
//    public int getPlayerX()
//    {           
//       return player.position.getX();
//    }
//    
//    public int getDamage()
//    {
//        return damage;
//    }
//    
//    public void setScore(int newScore)
//    {
//        score = newScore;
//    }
//    
//    public int getScore()
//    {
//        return score;
//    }
//    
//    public void setVisible(boolean visible)
//    {
//        isVisible = visible;
//    }
//    
//    public boolean getVisible()
//    {
//        return isVisible;
//    }
    
//    public void doMove(int levelWidth, int levelHeight)
//    {
        //Random rand = new Random();
        //int randomDirection;        
        // Create a vector to store the current position of the Monster
        // we will only update the movement vector if the Monster does not
        // collide with anything 
        
        //randomDirection = rand.nextInt(4) + 1;
        
        /*switch(randomDirection)
        {
            case 1:
                velocity.setY(-speed);
                break;
            case 2:
                velocity.setY(speed);
                break;  
            case 3:
                velocity.setX(-speed);
                break;
            case 4:
                velocity.setX(speed);                
        }
        
        Vector tempPosition = new Vector(position);
        Vector velocity = new Vector();
        
        /* Adding in some boundary checks, X coordinate first
        First check that the new X coordinate won't go off the left hand side
        of the window, then check that the X coordinate won't go off the right
        hand side
        
        if(tempPosition.getX() < (spriteWidth / 2))
        {
            //velocity.setX(1);
            velocity.setX(player.position.getX()*speed);
        }else if(tempPosition.getX() > levelWidth - (spriteWidth / 2))
        {
            velocity.setX(-1);
            
        }    
        /*Now check the Y coordinate - first the top of the screen, then the
        bottom of the screen
        
        if(tempPosition.getY() < spriteHeight / 2)
        {
            //velocity.setY(1);
            velocity.setY(player.position.getY()*speed);
            
        }else if (spriteHeight > levelHeight - (spriteHeight /2))
        {
            velocity.setY(1);
        } 
            
        tempPosition.add(velocity);
        
        //Change the current position vector to the temporary vector
        position.setToVector(tempPosition);*/

//        Vector direction = new Vector(Position);      
//        
//        
//        direction.setX(player.Position.getX() - Position.getX());
//        direction.setY(player.Position.getY() - Position.getY());
//        
//        double hyp = sqrt(direction.getX()*direction.getX() + direction.getY()*direction.getY());
//        
//        direction.setX((int) (direction.getX() / hyp)*speed);
//        direction.setY((int) (direction.getY() / hyp)*speed);
//    }
    
//    public boolean attack()
//    {
//        return true;
//    }
    
    
}
