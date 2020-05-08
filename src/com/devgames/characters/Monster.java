package com.devgames.characters;

import com.devgames.game.Game;
import com.devgames.game.level;
import objects.Vector;
import objects.baseLevelObject;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Monster extends baseLevelObject
{
    private boolean isVisible;
    
    Game game;
    public Vector velocity;

    public final float MOVE_SPEED = 0.3f;
    final float GRAVITY = 0.1f;

    public boolean movedLeftLast = false;
    public boolean movedRightLast = false;
    public boolean attacking = false;
    final float CHARGE_DELAY_DURATION = 1f;
    public float chargeDelayTimer = 0;
    boolean attackFrameSkip = false;
    
    boolean moving = false;
    public boolean IsGrounded = false;

    float frameTime;
    int frameIndex = 0;
    final float FRAME_LENGTH = 125;
    final int ALL_FRAMES = 17;
    public BufferedImage[] SpriteArray = new BufferedImage[ALL_FRAMES];

    //Lowest point can fall to
    public int lowestPoint = 1080;
    
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
    public Rectangle hitbox;

    public BufferedImage colSprite;
    public BufferedImage colSpriteRay;
    
    public enum eElement{
        fire,
        earth,
        water,
        air,
        //do elements list
    }
    
    public enum eMonsterType
    {
        normalorc,
        orc,
        slime,
        zombie,
        // monster types here
    }
    eMonsterType monsterType = eMonsterType.orc;
    
    // <editor-fold desc="ANIMATION VARIABLES">
    
    enum eAnimState
    {
        AttackLeft,
        AttackRight,
        WalkLeft,
        WalkRight,
        IdleLeft,
        IdleRight,
        Die,
    }
    
    class AnimSet
    {
        public int start;
        public int end;
        public Monster.eAnimState state;
        public AnimSet(Monster.eAnimState _state, int _start, int _end)
        {
            start = _start;
            end = _end;
            state = _state;
        }
    }
    
    public AnimSet[] Anims = new AnimSet[7];
    int animIndex;
    
    // </editor-fold>
    BufferedImage[] spriteArray;
    
    private int speed = 3;
    private int damage;
    private int score;
    
    int health = 3;
    int MaxHealth = 3;
    
    public Monster(     Vector _position,
                        Game _game,
                        eElement _element,
                        eMonsterType _type )
            
    {   
        super(_position);
        
        score = 50;
        game = _game;
        isVisible = true;
        health = MaxHealth;
        velocity = new Vector(0,0);
        frameTime = FRAME_LENGTH;
        setupMonster(_element, _type);
        Sprite = spriteArray[0];
        
        try
        {
            colSprite = ImageIO.read(getClass().getResource("/backgroundPlaceholder/collider.png"));
        }   catch(Exception ex) {System.err.println("Error loading collider sprite");}

        try
        {
            colSpriteRay = ImageIO.read(getClass().getResource("/backgroundPlaceholder/colliderRay.png"));
        }   catch(Exception ex) {System.err.println("Error loading collider sprite");}
    }
    
    private void setupMonster(eElement _element, eMonsterType _type)
    {   
        monsterType =  _type;
        int frames = 0;
        switch(_type)
        {
            case normalorc:
                Anims[0] = new AnimSet(eAnimState.AttackLeft, 0, 4);
                Anims[1] = new AnimSet(eAnimState.AttackRight, 5, 9);
                Anims[2] = new AnimSet(eAnimState.WalkLeft, 10, 13);                
                Anims[3] = new AnimSet(eAnimState.WalkRight, 14, 17);
                //also health and move speed etc
                break;
            case orc:
                Anims[0] = new AnimSet(eAnimState.AttackLeft, 0, 4);
                Anims[1] = new AnimSet(eAnimState.AttackRight, 5, 9);
                Anims[2] = new AnimSet(eAnimState.WalkLeft, 10, 13);                
                Anims[3] = new AnimSet(eAnimState.WalkRight, 14, 17);
                Anims[6] = new AnimSet(eAnimState.Die, 18, 22);
                //isFlying = true;
                break;
                
            case slime:
                
                break;
                
            case zombie:
                
                break;
        }
        
        frames = Anims[6].end+1;
        
        //idles 
        Anims[4] = new AnimSet(eAnimState.IdleLeft, Anims[2].start, Anims[2].start );
        Anims[5] = new AnimSet(eAnimState.IdleRight, Anims[3].start, Anims[3].start );
        
        spriteArray = new BufferedImage[frames];
        for (int i = 0; i <= (frames-1); i++)
        {   
            try
            {
                spriteArray[i] = ImageIO.read(getClass().getResource("/Sprites/Graded/enemies/" + _element + "/" + _type + "/" + _type + "_" + i + ".png"));
            }   catch(Exception ex) {System.err.println("Error loading " + _element + " " + _type + " animation frame " + i);}
        }
    }
    
    public BufferedImage GetFrame()
    { 
        //System.out.println("Asking for frame : " + frameIndex + "   of set : " + animIndex);
        if (frameIndex < Anims[animIndex].start){frameIndex = Anims[animIndex].start;}
        if (frameIndex > Anims[animIndex].end){frameIndex = Anims[animIndex].end;}
        
        return spriteArray[frameIndex];
    }

        
    public void TakeDamage(int _damage){
        health -= _damage;
        if (health < 0){
            Die();
        }
    }
    
    void Die()
    {
        System.out.println("DEAD");
        velocity.x = 0;
        animIndex = 6;
    }
    
    public boolean IsAlive(){
        return health > 0;
    }
    
    
     //movement
    public void MoveLeft()
    {
        if (IsAlive()){
        velocity.x -= MOVE_SPEED;
        animIndex = 2;
        movedLeftLast = true;
        movedRightLast = false;
        //attacking = false;
        }
    }

    public void MoveRight()
    {
        if (IsAlive()){
        velocity.x += MOVE_SPEED;
        animIndex = 3;
        movedLeftLast = false;
        movedRightLast = true;
        //attacking = false;
        }
    }
    public void LeftAttack()
    {   
        if ( rightColRay.intersects(game.CurrentLevel.player.leftCol) || rightColRay.intersects(game.CurrentLevel.player.rightCol))
            {
                game.CurrentLevel.player.TakeDamage(this);
            }
        animIndex = 0;
        frameIndex = Anims[animIndex].start;
        //dash
        velocity.x -= 8f;        
//        upperLimit = 12;
//        lowerLimit = 9;
//        if (frameIndex < lowerLimit || frameIndex > upperLimit) {
//            frameIndex = lowerLimit;
//        }
    //    System.out.println("On Frame " + frameIndex + " of " + lowerLimit + " / " + upperLimit);
        attacking = true;
        movedLeftLast = true;
        movedRightLast = false;
    }
    public void RightAttack(){
        animIndex = 1;
        frameIndex = Anims[animIndex].start;
        
        velocity.x += 8f;
//        if (frameIndex < lowerLimit || frameIndex > upperLimit) {
//            frameIndex = lowerLimit;
//        }
      //  System.out.println("On Frame " + frameIndex + " of " + lowerLimit + " / " + upperLimit);
        attacking = true;
        movedLeftLast = false;
        movedRightLast = true;
    }
    public void MoveDown()
    {
            IsGrounded = false;
    }
    
        public boolean Reachable(float Pp,float Mp ){
        boolean Reachable = false;
      if(Pp<Mp){
if((Mp-Pp)<=150){
    Reachable= true;
} else {
    Reachable= false;
}
      }
      else if(Pp>Mp){
          if((Pp-Mp)<=150){
              Reachable= true;
          } else {
              Reachable= false;
          }
      }
      //System.out.println("Reachable : " + Reachable);
        return Reachable;
    }
    
    public  void Updatemonster()
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
            hitbox = new Rectangle(Math.round((int)Position.x + ((Sprite.getWidth() / 2))),
                Math.round((int)Position.y), 1, Sprite.getHeight());
            
            
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
            
            
    
            //Reduces the cooldown on charge
            if (chargeDelayTimer > 0)
            {
                chargeDelayTimer -= 0.01f;
            }
            
            boolean wasGroundedLastStep = IsGrounded;
            IsGrounded = false;
            Vector lastPosition = Position;
            //Checks if a jump has been performed recently...
            //everything collision with world here, enemies elsewhere
            
            for (int i = 0; i <  game.CurrentLevel.currentRoom.platformColliders.length; i++)
            {   
                //"Raycast" collider logic.
                if (rightColRay.intersects(game.CurrentLevel.currentRoom.platformColliders[i].rect.getBounds()))
                {   
                    if (!movedLeftLast && movedRightLast){
                        MoveLeft();
                    }
                    velocity.x = 0;
                }

                if (leftColRay.intersects(game.CurrentLevel.currentRoom.platformColliders[i].rect.getBounds()))
                {
                    if (movedLeftLast && !movedRightLast){
                        MoveRight();
                    }
                    velocity.x = 0;
                    Position.x = (game.CurrentLevel.currentRoom.platformColliders[i].rect.x + game.CurrentLevel.currentRoom.platformColliders[i].rect.width);
                }

                if (!IsGrounded && bottomColRay.intersects(game.CurrentLevel.currentRoom.platformColliders[i].rect.getBounds()))
                {   
                    IsGrounded = true;
                    velocity.y = 0;
                    Position.y = ( game.CurrentLevel.currentRoom.platformColliders[i].rect.y - Sprite.getHeight()+2);
                }

                if ( topColRay.intersects(game.CurrentLevel.currentRoom.platformColliders[i].rect.getBounds()))
                {
                    velocity.y = 0;
                    Position.y = game.CurrentLevel.currentRoom.platformColliders[i].rect.getBounds().y + game.CurrentLevel.currentRoom.platformColliders[i].rect.getBounds().height;
                }                
            }
            
             if (IsAlive() && !IsGrounded && wasGroundedLastStep)
            {
                Position = lastPosition;
                velocity.x = -velocity.x;
                System.out.println("FALLIN");
                if (movedRightLast)
                {
                    MoveLeft();
                }
                else
                {
                    MoveRight();
                }
            }
             if (!IsGrounded){
                 System.out.println("AAAAAAAAAAAAaaaaaaaagggggh");
             }
        }
        
        boolean reachable = Reachable(game.CurrentLevel.player.Position.x, Position.x);
        if (IsAlive() && game.CurrentLevel.player.Position.x > Position.x && IsGrounded && !attacking) 
        {
            if (reachable && chargeDelayTimer <= 0)
                RightAttack();
            else
                if (movedRightLast){
                    MoveRight();
                }
                else{
                    MoveLeft();
                }
        } else if (IsAlive() && game.CurrentLevel.player.Position.x < Position.x && IsGrounded && !attacking)
        {
            if (reachable && chargeDelayTimer <= 0)
                LeftAttack();
            else
                if (movedLeftLast){
                MoveLeft();
                }
                else{
                    MoveRight();
                }
        }
        
//        if (attacking && reee){
//            if (movedLeftLast && !movedRightLast){
//                velocity.x -= 1f;
//            }
//            if (!movedLeftLast && movedRightLast){
//                velocity.x += 1f;
//            }
//        }

        // update position from velocity
        if (IsAlive() && !IsGrounded)
        {
            //Left & right movement
            Position.x += velocity.x;
            //Decelleration
            velocity.x -= velocity.x * 0.1f;
            //Gravity
            if (Position.y + velocity.y <= lowestPoint)
            {
                Position.y += velocity.y;
                velocity.y += GRAVITY;
            }
        }

        if (IsAlive() && IsGrounded)
        {
            if (!attacking){
            velocity.x -= velocity.x * 0.15f;
            velocity.y -= velocity.y * 0.2f;
            }
            else{
                velocity.x -= velocity.x * 0.05f;
            }
        }

        //modify positions
        Position.x += velocity.x;
        Position.y += velocity.y;

        // check speed low enough for idle frame;

        if (IsGrounded &&  Math.abs(velocity.x) < 1 && movedLeftLast&&!attacking)
        {
            animIndex = 4;
        }
        else if (IsGrounded && Math.abs(velocity.x) < 1 && movedRightLast&&!attacking)
        {
            animIndex = 5;
        }


        if (frameTime > 0){
            frameTime -= game.CurrentLevel.timer.getDelay();// / 1000f;
            if (frameTime <= 0){
                frameIndex ++;
                if (attacking){
                    System.out.println("Attacking, frame : " + frameIndex);
                        }
                if (chargeDelayTimer > 0){
                    System.out.println("Charge Delay Cooldown : " + chargeDelayTimer);
                }

                if (frameIndex > Anims[animIndex].end)
                {
                    if (attacking)
                    {
                        attacking = false;
                        System.out.println("Ending Attack!, starting cooldown");
                        chargeDelayTimer = CHARGE_DELAY_DURATION;
                    }
                    
                    
                    frameIndex = Anims[animIndex].start;
                }
                frameTime = FRAME_LENGTH;
            }
        }
    }
}

