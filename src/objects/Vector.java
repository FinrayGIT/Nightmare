package objects;

public class Vector 
{
    public float x;
    public float y;
        
    public Vector(float newX, float newY)
    {
        x = Math.round(newX);
        y = Math.round(newY);
    }
}
