package com.devgames.game;

import objects.Vector;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Detector      
{   
    public Rectangle rect;
    int levelTarget;
    int roomTarget;
    int boost;
    public int health = 3;
    Vector spawnPos;
    BufferedImage[] Sprites = new BufferedImage[4];
    
    // DETECTOR FOR ROOM TRANSITIONS
    public Detector(        Rectangle _rect, 
                            int _levelTarget, 
                            int _roomTarget, 
                            Vector _spawnPos    )
    {
        rect = _rect;
        levelTarget = _levelTarget;
        roomTarget = _roomTarget;
        spawnPos = _spawnPos;
    }
    
    // DETECTOR FOR WIND
    public Detector(            Rectangle _rect, 
                                int _boost      )
    {
        rect = _rect;
        boost = _boost;
    }
    
    
    // DETECTOR FOR STALAGMITES
    public Detector(Rectangle _rect, int _health, int sceneUID)
    {
        System.out.println("NEW STALAGMITE");
        rect = _rect;
        health = _health;
        Sprites = new BufferedImage[health];
        for (int i = 0; i < (health); i++)
        {
            System.out.println("HEALTH : " + i + " / " + health);
            try
            {
                System.out.println("get : " + i);
                Sprites[i] = ImageIO.read(getClass().getResource("/levels/level0/room1/room1stalgtite" + i + ".png"));
            }   catch(Exception ex) {System.err.println("Error loading stalagtite frame " + i);}
        }
    }
    
    // DETECTOR FOR PLATFORMS
    public Detector(Rectangle _rect)
    {
        rect = _rect;
    }
    
    // DETECTOR FOR DOORS
    public Detector(Rectangle _rect, int n, String path){
        rect = _rect;
        Sprites = new BufferedImage[1];
        try
            {
                Sprites[0] = ImageIO.read(getClass().getResource(path));
            }   catch(Exception ex) {System.err.println(path);}

    }
    
//    public Detector(            Rectangle _rect, int _health)
//    {
//        rect = _rect;
//        health = _health;
//    }
    
    public void DoSwap(Game _game)
    {   
        System.out.println("-----------Do Swap! " + levelTarget  + "   " + roomTarget);
        if (_game.LevelIndex != levelTarget){
            _game.goToLevel(levelTarget);
        }
        _game.CurrentLevel.GoToRoom(roomTarget);
        _game.CurrentLevel.player.Position.x = spawnPos.x;
        _game.CurrentLevel.player.Position.y = spawnPos.y + _game.CurrentLevel.player.Sprite.getHeight() - 1;
        //game.CurrentLevel.player.Position.y += game.CurrentLevel.player.Sprite.getHeight();
    }
    
    public void DoBoost(Game _game)
    {
        System.out.println("Do Boost!");
        if (_game.CurrentLevel.player.boostDelayTimer <= 0 
         && _game.CurrentLevel.player.velocity.y >= -10) 
        {
            _game.CurrentLevel.player.velocity.y -= boost + (Math.random() * 2);
            _game.CurrentLevel.player.boostDelayTimer = _game.CurrentLevel.player.BOOST_DELAY_DURATION;
        }
        
    }
    
    void TakeDamage()
    {
        health -= 1;
    }
}



