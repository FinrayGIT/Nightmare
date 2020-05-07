package com.devgames.game;

import objects.Vector;
import java.awt.Rectangle;


public class RoomTransition      
{   
    public Rectangle rect;
    int levelTarget;
    int roomTarget;
    int boost;
    Vector spawnPos;    
    
    public RoomTransition(  Rectangle _rect, 
                            int _levelTarget, 
                            int _roomTarget, 
                            Vector _spawnPos    )
    {
        rect = _rect;
        levelTarget = _levelTarget;
        roomTarget = _roomTarget;
        spawnPos = _spawnPos;
    }
    
        public RoomTransition(  Rectangle _rect, 
                                int _boost      )
    {
        rect = _rect;
        boost = _boost;
    }
    
    public void DoSwap(Game _game)
    {   
        System.out.println("Do Swap! " + levelTarget  + "   " + roomTarget);
        _game.goToLevel(levelTarget);
        _game.CurrentLevel.GoToRoom(roomTarget);
        _game.CurrentLevel.player.Position = spawnPos;
        //game.CurrentLevel.player.Position.y += game.CurrentLevel.player.Sprite.getHeight();
    }
    
    public void DoBoost(Game _game)
    {
        System.out.println("Do Boost!");
        _game.CurrentLevel.player.velocity.y -= 2;
    }
}



