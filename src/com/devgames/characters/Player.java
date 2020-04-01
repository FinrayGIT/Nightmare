package com.devgames.characters;

import com.devgames.levels.baseLevelObject;
import com.devgames.levels.Vector;
import com.devgames.levels.level;
import com.devgames.game.Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends baseLevelObject
{   
    //Final variables to store values which may require tweaking.
    public final float MOVE_SPEED = 1.0f;
    public final float JUMP_FORCE = 15.0f;
    final float JUMP_DELAY_DURATION = 0.2f;
    float jumpDelayTimer; // Should this just be JUMP_DELAY_DURATION?
    
    //The position of the player in a single frame. 
    public Vector velocity; 
    
    //Variables to store the possible states of the player.
    boolean moving = false;    
    boolean IsGrounded = false;
    boolean IsClimbing = false;
    
    //Colliders.
    Rectangle bottomCol;
    Rectangle bottomRightCol;
    Rectangle bottomLeftCol;
    Rectangle topRightCol;
    Rectangle topLeftCol;
    Rectangle topCol;
    Rectangle leftCol;
    Rectangle rightCol;
    
    BufferedImage colSprite;
    
    public Player(Vector _position)
    {
        //Constuctor for player.
        super(_position, "/Sprites/Plague Doctor.png");
        velocity = new Vector(0,0);
     
        try
        {
            Sprite = ImageIO.read(getClass().getResource("/Sprites/Plague Doctor bigger.png"));
        }   catch(Exception ex) {System.err.println("Error loading player sprite");}
        
        try
        {
            colSprite = ImageIO.read(getClass().getResource("/backgroundPlaceholder/collider.png"));
        }   catch(Exception ex) {System.err.println("Error loading collider sprite");}
    }

    public void MoveLeft()
    {
        if (!IsClimbing)
        {        
            velocity.x -= MOVE_SPEED;
        }
    }
    
    public void MoveRight()
    {
        if (!IsClimbing)
        {        
            velocity.x += MOVE_SPEED;
        }
    }
     
    public void Jump()
    {
        if (IsGrounded)
        {   
            IsGrounded = false;
            velocity.y -= JUMP_FORCE;
            jumpDelayTimer = JUMP_DELAY_DURATION;
        }
    }
        
    public void UpdatePlayer(level _level)
    {
        //This function contains gravity and colliders
        if (!IsGrounded)
        {
            velocity.y += 0.4f;
        }
        
        if (Game.levelReady = true)
        {

//Colliders
            
/*TOP*/     topLeftCol = new Rectangle(Math.round((int)Position.x),
                Math.round((int)Position.y), 1, 1);
            
            topCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth() / 2)),
                Math.round((int)Position.y), 1, 1);
            
            topRightCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth())),
                Math.round((int)Position.y), 1, 1);
            
            
/*MIDDLE*/  leftCol = new Rectangle(Math.round((int)Position.x),
                Math.round((int)Position.y + (Sprite.getHeight()/2)), 1, 1);
            
            rightCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth())),
                Math.round((int)Position.y + (Sprite.getHeight()/2)), 1, 1); 
            
            
/*BOTTOM*/  bottomLeftCol = new Rectangle(Math.round((int)Position.x),
                Math.round((int)Position.y + (Sprite.getHeight())), 1, 1);
            
            bottomCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth() / 2)),
                Math.round((int)Position.y + (Sprite.getHeight())), 1, 1);
            
            bottomRightCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth())),
                Math.round((int)Position.y + (Sprite.getHeight())), 1, 1);
            
            
        //This loop checks if the left or right colliders intersect any
        //platforms, and stop movement if so. Makes walls solid.
        for (int i = 0; i <  _level.currentRoom.Platforms.length; i++)
        {
            if (IsGrounded)
            {
                if ( (velocity.x < 0 && leftCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
                   || (velocity.x > 0 && rightCol.intersects(_level.currentRoom.Platforms[i].getBounds())))
                {
                    velocity.x = 0;
                }
            }
        }
         
        //Checks if a jump has been performed recently...
        if (jumpDelayTimer > 0)
        {
            jumpDelayTimer -= 0.01f;
        }
        
        //If not, this loop checks if the corner colliders intersect any 
        //platforms, and stop movement if so. Makes platforms solid when
        //approaching from an angle other than 90°.
        else
        {
            boolean hitGroundThisTick = false;

            for (int i = 0; i <  _level.currentRoom.Platforms.length; i++)
            {
                if (!IsGrounded && ((velocity.x > 0 && bottomRightCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
                        || (velocity.x < 0 && bottomLeftCol.intersects(_level.currentRoom.Platforms[i].getBounds())) 
                        || (velocity.x > 0 && topRightCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
                        || (velocity.x < 0 && topLeftCol.intersects(_level.currentRoom.Platforms[i].getBounds()))))
                {
                   velocity.x = 0;   
                }
                
                //This loop checks if the bottom collider intersects any platforms.
                //Makes floors solid.
                if (bottomCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
                {
                    if (!IsGrounded)
                    {
                        IsGrounded = true;
                    }
                    hitGroundThisTick = true;
                    velocity.y = 0;
                }
                
                //              *TODO: Add ceiling collision code*
            }
            
            if (!hitGroundThisTick)
            {
                IsGrounded = false;
            }
        }
    }
        //This code updates player position based upon inputs (or lack thereof)
        //then starts deceleration
        Position.x += velocity.x;
        Position.y += velocity.y;
        velocity.x -= velocity.x * 0.1f;
    }
    
    public void draw(Graphics g)
    {
        //This function draws the player sprite, and for testing purposes
        //can draw graphical representation of colliders.
        g.drawImage(Sprite, (int)Position.x, (int)Position.y, null);
        
        if(colSprite != null && bottomCol != null)
        {        
            g.drawImage(colSprite, topLeftCol.x, topLeftCol.y, null);
            g.drawImage(colSprite, topCol.x, topCol.y, null);
            g.drawImage(colSprite, topRightCol.x, topRightCol.y, null);
            g.drawImage(colSprite, leftCol.x, leftCol.y, null);
            g.drawImage(colSprite, rightCol.x, rightCol.y, null);
            g.drawImage(colSprite, bottomLeftCol.x, bottomLeftCol.y, null);
            g.drawImage(colSprite, bottomCol.x, bottomCol.y, null);
            g.drawImage(colSprite, bottomRightCol.x, bottomRightCol.y, null);
        }    
    }

    public boolean checkCollision(Treasure t)
    {
        //This function handles picking up of treasures/pickups.
        if (t.getBounds().intersects(getBounds()))
        {
            if (Treasure.isVisible == true)
            {                
                Treasure.isVisible = false;
            }
            return true;
        }
        return false;     
    }
    
//    public void checkCollision()
//    {
//        
//    }
//    
//    //                TODO: Write Monster collision code*
    
//    public boolean checkCollision(Monster m)
//    {
//        if (m.getBounds().intersects(getBounds()))
//        {   
//            //This code is part of the tutorials
//            //score -= m.getDamage();
//            //game.endGame();            
//            return true;
//            
//        }
//        return false;        
//    }
}
        