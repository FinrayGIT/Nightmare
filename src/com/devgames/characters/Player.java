package com.devgames.characters;

import com.devgames.levels.baseLevelObject;
import com.devgames.levels.Vector;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.imageio.ImageIO;

public class Player extends baseLevelObject
{
    //Vectors to represent the character's current position
    //and movement from the current position
    public Vector velocity;
    
    boolean moving = false;
    public final float MOVE_SPEED = 1.0f;
    public final float JUMP_FORCE = 10.0f;
    boolean IsGrounded = false;
    boolean IsClimbing = false;

    public Player(Vector _position)
    {
        super(_position, "/Sprites/Plague Doctor.png");

        //This vector will hold the movement from the current position
        velocity = new Vector(0,0);
     
        try
        {
            Sprite = ImageIO.read(getClass().getResource("/Sprites/Plague Doctor bigger.png"));
        }catch(Exception ex)
        {
            System.err.println("Error loading player sprite");
        }
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
        }
    }
    
    public void UpdatePlayer()
    {
        if (!IsGrounded){
            velocity.y += 0.4f;
        }
        if (Position.y > 300){//fake ground collision
            IsGrounded = true;
            Position.y = 300;
            velocity.y = 0;
        }
        
       // if (IsGrounded){
            velocity.x -= velocity.x * 0.1f;// deceleration
       // } //air decelerate? bunny hop mode
        
        Position.x += velocity.x;
        Position.y += velocity.y;
    }
    
    public void draw(Graphics g)
    {
        // Draw the sprite at the correct coordinates in the graphics context
        g.drawImage(Sprite, (int)Position.x, (int)Position.y, null);
    }    
}
