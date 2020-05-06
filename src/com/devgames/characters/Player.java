package com.devgames.characters;

import objects.Treasure;
import objects.baseLevelObject;
import objects.Vector;
import com.devgames.game.level;
import com.devgames.game.Game;
import com.devgames.game.RoomTransition;
import com.devgames.game.InputController;
import com.devgames.game.Projectile;
import com.devgames.game.RoomTransition;
import objects.platform;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Player extends baseLevelObject
{   
    Game game;
    
    // <editor-fold desc="FINAL VALUES">
    
    //Final values to store values which may require tweaking.
    public final float CLIMB_SPEED = 0.5f;
    public final float MOVE_SPEED = 0.6f;
    public final float JUMP_FORCE = 4f;
    final float JUMP_DELAY_DURATION = 0.1f;
    final float GRAVITY = 0.1f;
    final float FRAME_LENGTH = 125;
    final int CROUCH_FRAMES = 0;
    final int DEATH_FRAMES = 5;
    final int WALK_FRAMES = 3;
    final int IDLE_FRAMES = 0;
    final int ALL_FRAMES = 49;
    float jumpDelayTimer;
    
    // </editor-fold>
    // <editor-fold desc="PLAYER STATES">
    
    //Variables to store the possible states of the player.
    boolean moving = false;    
    public boolean IsGrounded = false;
    public boolean canClimb = false;
    public boolean IsClimbing = false;
    public boolean PlayedGrabAnim = false;
    public boolean movedLeftLast = false;
    public boolean movedRightLast = false;
    eHeldWeapon HeldWeapon;
    boolean sawUnlocked;
    boolean crossbowUnlocked;
    boolean syringeUnlocked;
    public Vector velocity;
    int health = 4;
    int MaxHealth = 4;
    
    // </editor-fold>
    // <editor-fold desc="COLLIDERS">
    
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
    
    //Sprites
    public BufferedImage colSprite;
    BufferedImage colSpriteRay;
    
    //Lowest point player can fall to
    public int lowestPoint = 1080;
    
    // </editor-fold>
    // <editor-fold desc="ANIMATION VARIABLES">
    
    public int lowerLimit = 0;
    public int upperLimit = 0;
    public int animationFrames;
    int frameIndex = 0;
    float frameTime;
    
    // </editor-fold>
    // <editor-fold desc="SPRITE SETUP">
    
    Vector healthPos = new Vector(0,0);
    BufferedImage[] healthImages = new BufferedImage[4];
    public BufferedImage[] SpriteArray = new BufferedImage[ALL_FRAMES];
    
    // </editor-fold>
    
    enum eHeldWeapon
    {
        None,
        Bonesaw,
        Crossbow, // arrow - gravity
        Syringe //thrown - straight line
    }
    
    
        
    public Player(Vector _position, Game _game)
    {
        //Constuctor for player.
        super(_position, "/Sprites/Plague Doctor.png");
        
        game = _game;
        
        velocity = new Vector(0,0);
        frameTime = FRAME_LENGTH;
        
        health = MaxHealth;
        
        for (int i = 0; i <= ALL_FRAMES; i++)
        {
        try
        {
            SpriteArray[i] = ImageIO.read(getClass().getResource("/Sprites/Graded/Player/movement/player_" + i + ".png"));
        }   catch(Exception ex) {System.err.println("Error loading animated sprite frame " + i);}
        }
        
        try
        {
            Sprite = ImageIO.read(getClass().getResource("/Sprites/Graded/Player/movement/player_0.png"));
        }   catch(Exception ex) {System.err.println("Error loading player sprite");}
        
        try
        {
            colSprite = ImageIO.read(getClass().getResource("/backgroundPlaceholder/collider.png"));
        }   catch(Exception ex) {System.err.println("Error loading collider sprite");}
        
        try
        {
            colSpriteRay = ImageIO.read(getClass().getResource("/backgroundPlaceholder/colliderRay.png"));
        }   catch(Exception ex) {System.err.println("Error loading collider sprite");}
    
        try{
        healthImages[0] = ImageIO.read(getClass().getResource("/Sprites/Graded/Player/health_01.png"));
        healthImages[1] = ImageIO.read(getClass().getResource("/Sprites/Graded/Player/health_02.png"));
        healthImages[2] = ImageIO.read(getClass().getResource("/Sprites/Graded/Player/health_03.png"));
        healthImages[3] = ImageIO.read(getClass().getResource("/Sprites/Graded/Player/health_04.png"));
    
        }
        catch(Exception ex){
            System.err.println("Error Loading Health " + ex);
        }
    }
    
    public void TakeDamage()
    {
        health -= 1;
        if (health == 0)
        {
            Die();
        }
    }
    
    void Die()
    {
        
    }
    
  
    public void MoveLeft()
    {       
        if (!IsClimbing)
        {
            velocity.x -= MOVE_SPEED;
            upperLimit = 4;
            lowerLimit = 1;
            
            if (frameIndex < lowerLimit || frameIndex > upperLimit)
            {
                frameIndex = lowerLimit;
            }
        }
        
        else
        {
            velocity.x -= CLIMB_SPEED;
            upperLimit = 36;
            lowerLimit = 31;
            frameIndex = 31;
        }
        
        movedLeftLast = true;
        movedRightLast = false;
    }
    
    public void MoveRight()
    {      
        if (!IsClimbing)
        {
            velocity.x += MOVE_SPEED;
            upperLimit = 8;
            lowerLimit = 5;
            if (frameIndex < lowerLimit || frameIndex > upperLimit)
            {
                frameIndex = lowerLimit;
            }
        }
        
        else
        {
            velocity.x += CLIMB_SPEED;
            lowerLimit = 31;
            upperLimit = 36;
            
        }
        
        movedLeftLast = false;
        movedRightLast = true;
    }
    
    public void MoveUp()
    {
        if (canClimb && !IsClimbing)
        {
            if (!PlayedGrabAnim && movedLeftLast)
            {   
                frameIndex = 16;
                lowerLimit = 16;
                upperLimit = 20;
                PlayedGrabAnim = true;
            }
            
            else if (!PlayedGrabAnim && movedRightLast)
            {   
                frameIndex = 21;
                lowerLimit = 21;
                upperLimit = 25;
                PlayedGrabAnim = true;
            }
            
            IsClimbing = true;
            IsGrounded = false;
        }
        
        if (IsClimbing)
        {
            velocity.y -= CLIMB_SPEED;
            
            if (movedLeftLast)
            {
                frameIndex = 31;
                lowerLimit = 31;
                upperLimit = 36;
            }
            
            else if (movedRightLast)
            {
                frameIndex = 37;
                lowerLimit = 37;
                upperLimit = 42;
            }
        }
    }
    
    public void Crouch()
    {
        frameIndex = 15;
        lowerLimit = 15;
        upperLimit = 15;
        Position.y = (Position.y + 35);
    }
        
    public void MoveDown()
    {
        if (canClimb && !IsClimbing)
        {
            IsClimbing = true;
            IsGrounded = false;
        }
        if (IsClimbing)
        {
            velocity.y += CLIMB_SPEED;
        }
    }
    
    public void Jump()
    {
        if (IsGrounded || IsClimbing)
        {   
            IsGrounded = false;
            IsClimbing = false;
            velocity.y -= JUMP_FORCE;
            jumpDelayTimer = JUMP_DELAY_DURATION;
            velocity.x += (velocity.x / 2);
        }
    }
    
    public void Attack()
    {
        if (HeldWeapon != eHeldWeapon.None)
        {        
            Projectile.eType type = Projectile.eType.FakeMelee;
            if (HeldWeapon == eHeldWeapon.Crossbow)
            {
                type = Projectile.eType.Arrow;
            }
            if (HeldWeapon == eHeldWeapon.Syringe)
            {
                    type = Projectile.eType.Syringe;
            }
            game.CurrentLevel.AddProjectile( (int)Position.x, (int)Position.y, (velocity.x < 0), type );
        }
    }
        
    public void UpdatePlayer()
    {        
        if (game.levelReady = true)
        {   
                        
            // <editor-fold desc="COLLIDER PLACEMENT">
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
            
// </editor-fold>
            
            canClimb = false;
            
            //Checks if you are intersecting a climbable object  
            for (int i = 0; i < game.CurrentLevel.currentRoom.Ladders.length; i++)
            {
                if ( game.CurrentLevel.currentRoom.Ladders[i].getBounds().intersects(getBounds()))
                {
                    canClimb = true;
                }
            }
            
            if (IsClimbing && !canClimb)
            {
                IsClimbing = false;
            }

            //Reduces the cooldown on jump
            if (jumpDelayTimer > 0)
            {
                jumpDelayTimer -= 0.01f;
            }
        
            //This loop checks if the colliders intersect any platforms, 
            //and prevents movement if so.
            
            else
            {   
                // <editor-fold desc="COLLIDER LOGIC">
                IsGrounded = false;
                for (int i = 0; i <  game.CurrentLevel.currentRoom.Platforms.length; i++)
                {   
                    //"Raycast" collider logic.
//                    if (!IsClimbing && rightColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                    {   
//                        Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x - 1), 
//                                                   (_level.currentRoom.Platforms[i].Position.y - 1));
//                        velocity.x = 0;
//                    }
//
//                    if (!IsClimbing && leftColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                    {
//                        Vector newPos = new Vector((_level.currentRoom.Platforms[i].Position.x + _level.currentRoom.Platforms[i].getBounds().width), 
//                                                   (_level.currentRoom.Platforms[i].Position.y - 1));
//                        velocity.x = 0;
//                    }

                 //   System.out.println("Bottom Ray : " + (bottomColRay!=null) + "    CurrentLevel : " + game.CurrentLevel);
                    if (!IsClimbing && !IsGrounded && bottomColRay.intersects(game.CurrentLevel.currentRoom.Platforms[i].getBounds()))
                    {   
                        //System.out.println("Hit Rock Bottom");
                        IsGrounded = true;
                        velocity.y = 0;
                        Position.y = ( game.CurrentLevel.currentRoom.Platforms[i].Position.y - Sprite.getHeight()+2);
                    }

//                    if (!IsClimbing && topColRay.intersects(_level.currentRoom.Platforms[i].getBounds()))
//                    {
//                       // System.out.println("Hit Top of the world");
//                        velocity.y = 0;
//                        Position.y = _level.currentRoom.Platforms[i].getBounds().y + _level.currentRoom.Platforms[i].getBounds().height;
//                    }                

                }
            
                for (int i = 0; i < game.CurrentLevel.currentRoom.RTA.length; i++)
                {
                    //System.out.println("Checking RTA "+ game.CurrentLevel.currentRoom.RTA[i].rect.toString() + "  " + Position.x + ", " + Position.y);
                    if (getBounds().intersects(game.CurrentLevel.currentRoom.RTA[i].rect))  
                    {
                       game.CurrentLevel.currentRoom.RTA[i].DoSwap(game);
                    }
                }
                
                
                for (int i = 0; i < game.CurrentLevel.currentRoom.Monsters.length; i++){
                    //loop monsters, collide = die;
                }
                // </editor-fold>
            }
            
            //In-air movement
            if (!IsClimbing && !IsGrounded)
            {   
                Position.x += velocity.x;           //Left & right movement
                velocity.x -= velocity.x * 0.1f;    //Drag
                
                //Gravity
                if (Position.y + velocity.y <= lowestPoint) 
                {
                    Position.y += velocity.y;
                    velocity.y += GRAVITY;
                }
            }
            
            //Decelleration
            if (!IsClimbing)
            {
                velocity.x -= velocity.x * 0.1f;
            }
            
            //Climbing movement
            else
            {
               velocity.x -= velocity.x * 0.15f;
               velocity.y -= velocity.y * 0.2f;
            }
            
            //Grounded/Climbing movement
            Position.x += velocity.x;               //Left & right movement
            Position.y += velocity.y;               //Up & down movement
       
            //Idle check
            if (IsGrounded && !IsClimbing && Math.abs(velocity.x) < 1 && movedLeftLast)
            {
                upperLimit = 48;
                lowerLimit = 48;
                frameIndex = 48;
            }
            
            else if (IsGrounded && !IsClimbing && Math.abs(velocity.x) < 1 && movedRightLast)
            {
                upperLimit = 0;
                lowerLimit = 0;
                frameIndex = 0;
            }
            
            //Disables turbo button effect
            if (frameTime > 0){
                frameTime -= game.CurrentLevel.timer.getDelay();// / 1000f;
                if (frameTime <= 0)
                {
                    frameIndex ++;
                    if (frameIndex > upperLimit)
                    {
                        //System.out.println("On Frame " + frameIndex + " of " + lowerLimit + " / " + upperLimit);
                        frameIndex = lowerLimit;
                    }
                    frameTime = FRAME_LENGTH;
                }
            } 
        }  
    }
    
    public void draw(Graphics g)
    {
        //This function draws the player sprite, and for testing purposes
        //can draw graphical representation of colliders.

        g.drawImage(SpriteArray[frameIndex], (int)Position.x, (int)Position.y, null);        
        
        //Health
        for (int i = 0; i < health; i++)
        {
            g.drawImage(healthImages[i], (int)healthPos.x, (int)healthPos.y, null);
        }
        
        if(colSprite != null && bottomCol != null)
        {     
            // <editor-fold desc="COLLIDER SPRITE DRAWING">   
//            g.drawImage(colSprite, topLeftCol.x, topLeftCol.y, null);
//            g.drawImage(colSprite, topCol.x, topCol.y, null);
//            g.drawImage(colSprite, topRightCol.x, topRightCol.y, null);
//            g.drawImage(colSprite, leftCol.x, leftCol.y, null);
//            g.drawImage(colSprite, rightCol.x, rightCol.y, null);
//            g.drawImage(colSprite, bottomLeftCol.x, bottomLeftCol.y, null);
//            g.drawImage(colSprite, bottomCol.x, bottomCol.y, null);
//            g.drawImage(colSprite, bottomRightCol.x, bottomRightCol.y, null);
//            
            //g.drawImage(colSpriteRay, (int)(topLeftColRay.x + velocity.x), (int)(topLeftColRay.y + velocity.y), null);
            g.drawImage(colSpriteRay, (int)(topColRay.x + velocity.x), (int)(topColRay.y + velocity.y), null);
           // g.drawImage(colSpriteRay, (int)(topRightColRay.x + velocity.x), (int)(topRightColRay.y + velocity.y), null);
            g.drawImage(colSpriteRay, (int)(leftColRay.x + velocity.x), (int)(leftColRay.y + velocity.y), null);
            g.drawImage(colSpriteRay, (int)(rightColRay.x + velocity.x), (int)(rightColRay.y + velocity.y), null);
            //g.drawImage(colSpriteRay, (int)(bottomLeftColRay.x + velocity.x), (int)(bottomLeftColRay.y + velocity.y), null);
            g.drawImage(colSpriteRay, (int)(bottomColRay.x + velocity.x), (int)(bottomColRay.y + velocity.y), null);
            //g.drawImage(colSpriteRay, (int)(bottomRightColRay.x + velocity.x), (int)(bottomRightColRay.y + velocity.y), null);
                            // </editor-fold>
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
}
        