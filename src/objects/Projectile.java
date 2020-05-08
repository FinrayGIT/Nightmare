package objects;

import java.awt.image.BufferedImage;
import javax.swing.text.Position;
import objects.Vector;
import objects.baseLevelObject;

public class Projectile extends baseLevelObject 
{
    final float MOVE_SPEED = 15;
    public boolean isAlive = false;
    float speed;
    float yVelocity;
    public int damage = 2;
    public eType type;
    public boolean isVisible = false;
    public float life = 100;
    
    public Projectile(Vector _position, String _path) 
    {
        super(_position, _path);
    }
    
    public Projectile(Vector _position, BufferedImage _sprite)
    {
        super(_position, _sprite);
    }
    
    public enum eType
    {   
        //Switches between weapon type
        FakeMelee,
        Arrow,
        Syringe,
    }
    
    public void Fire(boolean left, eType _type)
    {   
        
        isVisible = true;
        isAlive = true;
        type = _type;
        if (left)
        {
            speed = -MOVE_SPEED;
        }
        else
        {
            speed = MOVE_SPEED;
        }
        
        if (_type == Projectile.eType.Arrow){
            damage = 1;
        }
        if (_type == Projectile.eType.Syringe){
            damage = 3;
        }
    }
    
    public void Update()
    {
        if (isAlive)
        {        
            yVelocity += 0.15f;
            Position.x += speed;
            Position.y += yVelocity;
        }
        
        life -= 0.01f;
    }
    
    public void Stop()
    {   
        isAlive = false;
    }
}
