package com.devgames.characters;

import objects.Treasure;
import objects.baseLevelObject;
import objects.Vector;
import com.devgames.game.level;
import com.devgames.game.Game;
import com.devgames.game.InputController;
import objects.platform;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends baseLevelObject
{   
    //Final variables to store values which may require tweaking.
    public final float CLIMB_SPEED = 0.5f;
    public final float MOVE_SPEED = 0.5f;
    public final float JUMP_FORCE = 10.0f;
    final float JUMP_DELAY_DURATION = 0.2f;
    float jumpDelayTimer; // Should this just be JUMP_DELAY_DURATION?
    
    //The position of the player in a single frame. 
    public Vector velocity; 
    
    //Variables to store the possible states of the player.
    boolean moving = false;    
    boolean IsGrounded = false;
    boolean IsLefted = false;
    boolean IsRighted = false;
    boolean IsRoofed = false;
    public boolean IsClimbing = false;
    
    
    level level;
    
    //Colliders.
    Rectangle topLeftCol;
    Rectangle topCol;
    Rectangle topRightCol;
    Rectangle leftCol;
    Rectangle rightCol;
    Rectangle bottomLeftCol;
    Rectangle bottomCol;
    Rectangle bottomRightCol;
    
    
    //Collider raycasts.
    Rectangle topLeftColRay;
    Rectangle topColRay;
    Rectangle topRightColRay;
    Rectangle leftColRay;
    Rectangle rightColRay;
    Rectangle bottomLeftColRay;
    Rectangle bottomColRay;
    Rectangle bottomRightColRay;
    
    
    BufferedImage colSprite;
    BufferedImage colSpriteRay;
    
    public Player(Vector _position, level _level)
    {
        //Constuctor for player.
        super(_position, "/Sprites/Plague Doctor.png");
        velocity = new Vector(0,0);
        level = _level;
        
        try
        {
            Sprite = ImageIO.read(getClass().getResource("/Sprites/Plague-Doctor-Idle-Small.png"));
        }   catch(Exception ex) {System.err.println("Error loading player sprite");}
        
        try
        {
            colSprite = ImageIO.read(getClass().getResource("/backgroundPlaceholder/collider.png"));
        }   catch(Exception ex) {System.err.println("Error loading collider sprite");}
        
        try
        {
            colSpriteRay = ImageIO.read(getClass().getResource("/backgroundPlaceholder/colliderRay.png"));
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
    
    public void ClimbUp()
    {
        if (IsClimbing)
        {
            velocity.y -= CLIMB_SPEED;
        }
    }
    
    public void ClimbDown()
    {
        if (IsClimbing)
        {
            velocity.y += CLIMB_SPEED;
        }
    }
     
    public void Jump()
    {
        if (IsGrounded)
        {   
            IsGrounded = false;
            velocity.y -= JUMP_FORCE;
            jumpDelayTimer = JUMP_DELAY_DURATION;
            velocity.x += (JUMP_FORCE / 2);
        }
    }
        
    public void UpdatePlayer(level _level)
    {
        //This function contains gravity and colliders
        if (!IsGrounded || !IsClimbing)
        {
            velocity.y += 0.4f;
        }
        
        if (Game.levelReady = true)
        {

//Colliders
            
/*TOP*/     topLeftCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth() / 4)),
                Math.round((int)Position.y + colSprite.getHeight()), 1, 1);
            
            topCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth() / 2)),
                Math.round((int)Position.y + colSprite.getHeight()), 1, 1);
            
            topRightCol = new Rectangle(Math.round((int)Position.x + ((Sprite.getWidth() / 2 ) + (Sprite.getWidth()) / 4)),
                Math.round((int)Position.y + colSprite.getHeight()), 1, 1);
            
            
/*MIDDLE*/  leftCol = new Rectangle(Math.round((int)Position.x + ((Sprite.getWidth() / 8))),
                Math.round((int)Position.y + (Sprite.getHeight()/2)), 1, 1);
            
            rightCol = new Rectangle(Math.round((int)Position.x + ((Sprite.getWidth() / 5) * 4 )),
                Math.round((int)Position.y + (Sprite.getHeight()/2)), 1, 1); 
            
            
/*BOTTOM*/  bottomLeftCol = new Rectangle(Math.round((int)Position.x) + ((Sprite.getWidth() / 8) * 3),
                Math.round((int)Position.y + (Sprite.getHeight() - colSprite.getHeight() + 7)), 1, 1);
            
            bottomCol = new Rectangle(Math.round((int)Position.x + (Sprite.getWidth() / 2)),
                Math.round((int)Position.y + (Sprite.getHeight() - colSprite.getHeight() + 7)), 1, 1);
            
            bottomRightCol = new Rectangle(Math.round((int)Position.x + ((Sprite.getWidth() / 10) * 6)),
                Math.round((int)Position.y + (Sprite.getHeight() - colSprite.getHeight() + 7)), 1, 1);
            
            
//Collider Raycasts


/*TOP*/     topLeftColRay = new Rectangle(Math.round((int)topLeftCol.x + velocity.x),
                Math.round((int)topLeftCol.y + velocity.y), 1, 1);
            
            topColRay = new Rectangle(Math.round((int)topCol.x + velocity.x),
                Math.round((int)topCol.y + velocity.y), 1, 1);
            
            topRightColRay = new Rectangle(Math.round((int)topRightCol.x + velocity.x),
                Math.round((int)topRightCol.y + velocity.y), 1, 1);
            
            
/*MIDDLE*/  leftColRay = new Rectangle(Math.round((int)leftCol.x + velocity.x),
                Math.round((int)leftCol.y + velocity.y), 1, 1);
            
            rightColRay = new Rectangle(Math.round((int)rightCol.x + velocity.x),
                Math.round((int)rightCol.y + velocity.y), 1, 1);
            
            
/*BOTTOM*/  bottomLeftColRay = new Rectangle(Math.round((int)bottomLeftCol.x + velocity.x),
                Math.round((int)bottomLeftCol.y + velocity.y), 1, 1);
            
            bottomColRay = new Rectangle(Math.round((int)bottomCol.x + velocity.x),
                Math.round((int)bottomCol.y + velocity.y), 1, 1);
            
            bottomRightColRay = new Rectangle(Math.round((int)bottomRightCol.x + velocity.x),
                Math.round((int)bottomRightCol.y + velocity.y), 1, 1);

            
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
            boolean hitRoofThisTick = false;
            boolean hitGroundThisTick = false;
            boolean hitLeftThisTick = false;
            boolean hitRightThisTick = false;
            
            
            
            for (int i = 0; i <  _level.currentRoom.Platforms.length; i++)
            {   
                //Raycast collider logic.
                if (!IsRighted && rightColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
                {
                    Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x - 1), 
                                               (_level.currentRoom.Platforms[i].Position.y - 1));
                    velocity.x = 0;
                    //System.out.println("Right Raycast doing work");
                    hitRightThisTick = true;
                    IsRighted = true;
                    Position.x = (newPos.x - (Sprite.getWidth() / 5) * 4);
                }
                
                if (!IsLefted && leftColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
                {
                    Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x + _level.currentRoom.Platforms[i].getBounds().width), 
                                               (_level.currentRoom.Platforms[i].Position.y - 1));
                    velocity.x = 0;
                    //System.out.println("Left Raycast doing work");
                    hitLeftThisTick = true;
                    IsLefted = true;
                    Position.x = (newPos.x - Sprite.getWidth() / 8);
                }
                
                if (!IsClimbing && !IsGrounded && bottomColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
                {
                    Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x), 
                                               (_level.currentRoom.Platforms[i].Position.y));
                    //System.out.println("Bottom Raycast doing work " + Position.y);
                    IsGrounded = true;
                    hitGroundThisTick = true;
                    velocity.y = 0;
                    Position.y = (newPos.y - Sprite.getHeight());
                }
                
                if (!IsClimbing && !IsRoofed && topColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
                {
                    Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x),
                                               (_level.currentRoom.Platforms[i].Position.y - 1));
                    //System.out.println("Top Raycast doing work");
                    IsRoofed = true;
                    hitRoofThisTick = true;
                    velocity.y = 0;
                    Position.y = (newPos.y + _level.currentRoom.Platforms[i].getBounds().height + 1);
                }                
                
                    
                //Traditional collider logic.
//                if (!IsGrounded && ((velocity.x > 0 && bottomRightCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                                || (velocity.x < 0 && bottomLeftCol.intersects(_level.currentRoom.Platforms[i].getBounds())) 
//                                || (velocity.x > 0 && topRightCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                                || (velocity.x < 0 && topLeftCol.intersects(_level.currentRoom.Platforms[i].getBounds()))))
//                {   
//                    velocity.x = 0;   
//                }
                
//                This loop checks if the bottom collider intersects any platforms.
//                Makes floors solid.
//                if (bottomCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                {
//                    if (!IsGrounded)
//                    {
//                        
//                    }
//                    
//                }
                
                //This loop checks if the left or right colliders intersect any
                //platforms, and stop movement if so. Makes walls solid.
//                for (platform Platform : _level.currentRoom.Platforms) 
//                {
//                    if (IsGrounded) 
//                    {
////                        if (velocity.x < 0 && leftCol.intersects(Platform.getBounds())) 
//////                        || (velocity.x > 0 && rightCol.intersects(Platform.getBounds())))
////                        {
////                            velocity.x = 0;
////                        }
////                    }
//                }
                
//                if (!IsRoofed && topCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                {
//                    IsRoofed = true;
//                    hitRoofThisTick = true;
//                    velocity.y = 0;
//                }
            }
                

                if (!hitRoofThisTick)
                {
                    IsRoofed = false;
                }

                if (!hitGroundThisTick)
                {
                    IsGrounded = false;
                }
                
                if (!hitLeftThisTick)
                {
                    IsLefted = false;
                }
                
                if (!hitRightThisTick)
                {
                    IsRighted = false;
                }
                
//               if (!IsGrounded && ((velocity.x > 0 && bottomRightColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                                  || (velocity.x < 0 && bottomLeftColRay.intersects(_level.currentRoom.Platforms[i].getBounds())))) 
////                                || (velocity.x > 0 && topRightColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
////                                || (velocity.x < 0 && topLeftColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))))
//                {
//                    Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x - 1),
//                                               (_level.currentRoom.Platforms[i].Position.y -1));
//                    Position.x = (newPos.x - (Sprite.getWidth() /5) * 4);
//                    velocity.x = 0;
//                }

//                    if (bottomCol.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                    {   
//                        System.out.println(newPos.y);
//                        Position.y = (newPos.y + 1);
//                        System.out.println(newPos.y);
//                        velocity.y = 0;
//                    }
            }
            //This code updates player position based upon inputs (or lack thereof)
            //then starts deceleration
            if (!IsClimbing)
            {
                Position.x += velocity.x;
                Position.y += velocity.y;
                velocity.x -= velocity.x * 0.1f;
            }
            if (IsClimbing)
            {
                
                if (InputController.inputs[4].IsPressed)
                {
                    Position.y -= velocity.y;
                }
                else if (InputController.inputs[3].IsPressed)
                {
                    Position.y += velocity.y;
                }
                else
                {
                    velocity.y -= velocity.y * 0.9f;
                }
                
                
            }
            //System.out.println(Position.y);
        }
    }
           

    
    public void draw(Graphics g)
    {
        //This function draws the player sprite, and for testing purposes
        //can draw graphical representation of colliders.
        g.drawImage(Sprite, (int)Position.x, (int)Position.y, null);
        
        if(colSprite != null && bottomCol != null)
        {        
//            g.drawImage(colSprite, topLeftCol.x, topLeftCol.y, null);
//            g.drawImage(colSprite, topCol.x, topCol.y, null);
//            g.drawImage(colSprite, topRightCol.x, topRightCol.y, null);
//            g.drawImage(colSprite, leftCol.x, leftCol.y, null);
//            g.drawImage(colSprite, rightCol.x, rightCol.y, null);
//            g.drawImage(colSprite, bottomLeftCol.x, bottomLeftCol.y, null);
//            g.drawImage(colSprite, bottomCol.x, bottomCol.y, null);
//            g.drawImage(colSprite, bottomRightCol.x, bottomRightCol.y, null);
//            
//            g.drawImage(colSpriteRay, (int)(topLeftColRay.x + velocity.x), (int)(topLeftColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(topColRay.x + velocity.x), (int)(topColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(topRightColRay.x + velocity.x), (int)(topRightColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(leftColRay.x + velocity.x), (int)(leftColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(rightColRay.x + velocity.x), (int)(rightColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(bottomLeftColRay.x + velocity.x), (int)(bottomLeftColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(bottomColRay.x + velocity.x), (int)(bottomColRay.y + velocity.y), null);
//            g.drawImage(colSpriteRay, (int)(bottomRightColRay.x + velocity.x), (int)(bottomRightColRay.y + velocity.y), null);
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
        