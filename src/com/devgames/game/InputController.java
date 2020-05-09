package com.devgames.game;

import java.awt.event.KeyEvent;
import objects.Vector;

public class InputController
{   
    //Passes level & game to InputController
    level level;
    Game game;
    
    public InputController(level _level, Game _game)
    {
        level = _level;
        game = _game;
    }
    
    public static InputController.Input[] inputs =
    {   
        // <editor-fold desc="INPUTS">
        //Array of possible inputs
        new InputController.Input(KeyEvent.VK_LEFT, inputAction.MoveLeft, inputState.Held),
        new InputController.Input(KeyEvent.VK_RIGHT,inputAction.MoveRight, inputState.Held),
        new InputController.Input(KeyEvent.VK_UP, inputAction.ClimbUp, inputState.Held),
        new InputController.Input(KeyEvent.VK_DOWN, inputAction.ClimbDown, inputState.Held),
        new InputController.Input(KeyEvent.VK_SPACE,inputAction.Jump, inputState.Down),
        new InputController.Input(KeyEvent.VK_HOME,inputAction.NextLvl, inputState.Down),
        new InputController.Input(KeyEvent.VK_END,inputAction.PrevLvl, inputState.Down),
        new InputController.Input(KeyEvent.VK_CAPS_LOCK,inputAction.EnableClimb, inputState.Down),
        new InputController.Input(KeyEvent.VK_C, inputAction.Crouch, inputState.Down),
        new InputController.Input(KeyEvent.VK_PAGE_UP, inputAction.NextRoom, inputState.Down),
        new InputController.Input(KeyEvent.VK_PAGE_DOWN, inputAction.PrevRoom, inputState.Down),
        new InputController.Input(KeyEvent.VK_SHIFT, inputAction.Shoot, inputState.Down),
        new InputController.Input(KeyEvent.VK_INSERT, inputAction.WeaponUp, inputState.Down),
        new InputController.Input(KeyEvent.VK_DELETE, inputAction.WeaponDown, inputState.Down),
        new InputController.Input(KeyEvent.VK_ENTER, inputAction.RestartGame, inputState.Down)
        // </editor-fold>
    };
    
    
    
    
    
//    Projectiles that are no longer in flight will still damage an enemy that walks into it.
//Player interaction with monsters.
//Monster death, player will still collider with dead monsters.
//DoBoost could use some random force on top of its current input to simulate bobblyness.
//
    
    
//             where the rotation in part 3 is calculated from...
//             vector a = position of projectile.
//             vector b = position of projectile + velocity.
//             angle = Math.Atan2(b.y - a.y,b.x - a.x);  //

//No game over, it's turned off, why?
    
    
    
    
    
    
    
    
    
    public static enum inputAction
    {   
        //Enumeration of possible inputs
        MoveLeft,
        MoveRight,
        ClimbUp,
        ClimbDown,
        Jump,
        NextLvl,
        PrevLvl,
        NextRoom,
        PrevRoom,
        EnableClimb,
        Crouch,
        Shoot,
        WeaponUp,
        WeaponDown,
        RestartGame,

    }
    
    public static enum inputState
    {   
        //Enumeration of possible input states
        None,
        Down,
        Held,
        Up
    }
    
    public static class Input
    {   
        //Input array populator - requires keypress and action to be performed
        public int keyCode;
        public inputAction action;
        public inputState state;
        public inputState activeState;
        
        public Input(int _event, inputAction _action, inputState _state)
        {
            keyCode = _event;
            action = _action;
            activeState = _state;
            state = inputState.Up;
        }
    }
    
    public void updateInput()
    {   
        //Once an input is performed, this function calls the code to perform
        //the required action
        for (int i = 0; i < inputs.length; i++)
        {
            if (inputs[i].state == inputs[i].activeState && level.player.IsAlive())
            {
                switch(inputs[i].action)
                {
                    case MoveLeft:
                        if (!level.disablePlayer){level.player.MoveLeft();}
                        //System.out.println(level.player.PlayedGrabAnim);
                        break;
                        
                    case MoveRight:
                        if (!level.disablePlayer){level.player.MoveRight();}
                        //System.out.println(level.player.PlayedGrabAnim);
                        break;
                        
                    case ClimbUp:
                        if (!level.disablePlayer){level.player.MoveUp();}
                        //System.out.println(level.player.PlayedGrabAnim);
                        break;
                        
                    case ClimbDown:
                        if (!level.disablePlayer){level.player.MoveDown();}
                        //System.out.println(level.player.PlayedGrabAnim);
                        break;
                        
                    case EnableClimb: //Testing purposes, disable for hand in
                        {level.player.IsClimbing = !level.player.IsClimbing;}
                        break;
                        
                    case Jump:       
                        if (!level.disablePlayer){level.player.Jump();}
//                        System.out.println(game.CurrentLevel.roomIndex);
//                        System.out.println(game.LevelIndex);
                        
                        break;
                    case WeaponUp:
//                        Vector _reSpawnPos;
//                        if (level.player !=null){_reSpawnPos = level.player.Position;}
//                        else {_reSpawnPos = new Vector(0,0);}
//                        level.player.scale += 10;
//                        level.player = null;
//                        level.SpawnPlayer(level.player.scale, _reSpawnPos);
                        break;
                    case RestartGame:
                            //game.restartGame();
                    case WeaponDown:
                            
                          
                            
                          
                            
//                        if (level.player !=null){_reSpawnPos = level.player.Position;}
//                        else {_reSpawnPos = new Vector(0,0);}
//                        level.player = null;
//                        level.player.scale -= 10;
//                        level.SpawnPlayer(level.player.scale, _reSpawnPos);
                        break;
                        
                    case NextLvl:
                            game.CurrentLevel.GRAVITY += 0.01f;
                            System.out.println("GRAVITY: " + game.CurrentLevel.GRAVITY);
//                        System.out.println("Attempting lvl+");
//                        if (game.LevelIndex + 1 <= game.levels.length)
//                        {                           
//                            game.goToLevel(game.LevelIndex + 1);
//                            System.out.println("Level+");
//                        }
                        break;
                        
                    case PrevLvl:
                        game.CurrentLevel.GRAVITY -= 0.01f;
                        System.out.println("GRAVITY: " + game.CurrentLevel.GRAVITY);
//                        System.out.println("Attempting lvl-");
//                        if (game.LevelIndex - 1 >= 0)
//                        {                           
//                            game.goToLevel(game.LevelIndex - 1);
//                            System.out.println("Level-");
//                        }
                        break;
                        
                    case NextRoom:
                        
                            game.CurrentLevel.player.JUMP_FORCE += 0.1f;
                            System.out.println("JUMP FORCE: " + game.CurrentLevel.player.JUMP_FORCE);
//                        System.out.println("Attempting room+");
//                        if (level.roomIndex + 1 < level.rooms.length)
//                        {                           
//                            level.GoToRoom(level.roomIndex + 1);
//                            System.out.println("Room+");
//                        }
                        break;
                        
                    case PrevRoom:
                        game.CurrentLevel.player.JUMP_FORCE -= 0.1f;
                        System.out.println("JUMP FORCE: " + game.CurrentLevel.player.JUMP_FORCE);
//                        System.out.println("Attempting room-");
//                        if (level.roomIndex - 1 >= 0)
//                        {
//                            level.GoToRoom(level.roomIndex - 1);
//                            System.out.println("Room-");
//                        }
                        break;
                        
                    case Crouch:
                        //level.player.Crouch();
                        level.disablePlayer = !level.disablePlayer;
                        break;
                        
                    case Shoot:
                        if (!level.disablePlayer){level.player.Attack();}
                        break;
                }
            }
                
                if (inputs[i].state == inputState.Down)
                {
                    inputs[i].state = inputState.Held;
                }
                if (inputs[i].state == inputState.Up)
                {
                    inputs[i].state = inputState.None;
                }
        }
    }
    
    public void CheckKeyPress(KeyEvent e)
    {
        //This function stores whether or not a key has been pressed
        for (int i = 0; i < inputs.length; i++)
        {
            if (e.getKeyCode() == inputs[i].keyCode)
            {
                if (inputs[i].state == inputState.None)
                {
                    inputs[i].state = inputState.Down;
                }
            }
        }
    }
    
    public void CheckKeyRelease(KeyEvent e)
    {
        //This function stores whether or not a key has been released
        for (int i = 0; i < inputs.length; i++)
        {
            if (e.getKeyCode() == inputs[i].keyCode)
            {
                if (inputs[i].state == inputState.Held || inputs[i].state == inputState.Down)
                {
                    inputs[i].state = inputState.Up;
                }
            }
        }
    }
}
