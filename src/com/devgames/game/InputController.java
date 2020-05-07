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
        new InputController.Input(KeyEvent.VK_O, inputAction.Shoot, inputState.Down),
        new InputController.Input(KeyEvent.VK_INSERT, inputAction.ScaleUp, inputState.Down),
        new InputController.Input(KeyEvent.VK_DELETE, inputAction.ScaleUp, inputState.Down),
        // </editor-fold>
    };
    
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
        ScaleUp,
        ScaleDown,

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
            if (inputs[i].state == inputs[i].activeState)
            {
                switch(inputs[i].action)
                {
                    case MoveLeft:
                        if (!level.disablePlayer){level.player.MoveLeft();}
                        break;
                        
                    case MoveRight:
                        if (!level.disablePlayer){level.player.MoveRight();}
                        break;
                        
                    case ClimbUp:
                        if (!level.disablePlayer){level.player.MoveUp();}
                        break;
                        
                    case ClimbDown:
                        if (!level.disablePlayer){level.player.MoveDown();}
                        break;
                        
                    case EnableClimb: //Testing purposes, disable for hand in
                        {level.player.IsClimbing = !level.player.IsClimbing;}
                        break;
                        
                    case Jump:       
                        if (!level.disablePlayer){level.player.Jump();}
//                        System.out.println(game.CurrentLevel.roomIndex);
//                        System.out.println(game.LevelIndex);
                        
                        break;
                    case ScaleUp:
//                        Vector _reSpawnPos;
//                        if (level.player !=null){_reSpawnPos = level.player.Position;}
//                        else {_reSpawnPos = new Vector(0,0);}
//                        level.player.scale += 10;
//                        level.player = null;
//                        level.SpawnPlayer(level.player.scale, _reSpawnPos);
                        break;
                        
                    case ScaleDown:
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
