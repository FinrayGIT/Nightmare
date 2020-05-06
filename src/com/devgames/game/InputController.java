package com.devgames.game;

import com.devgames.game.Game;

import java.awt.event.KeyEvent;

public class InputController
{   
    //Passes level to InputController
    level level;
    Game game;
    
    public InputController(level _level)
    {
        level = _level;
        game = game;
    }
    
    public static InputController.Input[] inputs =
    {   
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
        Crouch
    }
    
    public static enum inputState
    {
        None,
        Down,
        Held,
        Up
    }
    
    public static class Input
    {   
        //Input array constructor - requires keypress and action to be performed
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
                        {level.player.MoveLeft();}
                        break;
                        
                    case MoveRight:
                        level.player.MoveRight();
                        break;
                        
                    case ClimbUp:
                        level.player.MoveUp();
                        break;
                        
                    case ClimbDown:
                        level.player.MoveDown();
                        break;
                        
                    case EnableClimb: //Testing purposes, disable for hand in
                        {level.player.IsClimbing = !level.player.IsClimbing;}
                        break;
                        
                    case Jump:       
                        level.player.Jump();
                        break;
                    case NextLvl:
                        System.out.println("Attempting lvl+");
                        if (game.LevelIndex + 1 <= game.levels.length)
                        {                           
                            game.goToLevel(game.LevelIndex + 1);
                            System.out.println("Level+");
                        }
                        break;
                    case PrevLvl:
                        System.out.println("Attempting lvl-");
                        if (game.LevelIndex - 1 >= 0)
                        {                           
                            game.goToLevel(game.LevelIndex - 1);
                            System.out.println("Level-");
                        }
                        break;
                    case NextRoom:
                        System.out.println("Attempting room+");
                        if (level.roomIndex + 1 < level.rooms.length)
                        {                           
                            level.GoToRoom(level.roomIndex + 1);
                            System.out.println("Level+");
                        }
                        break;
                    case PrevRoom:
                        System.out.println("Attempting room-");
                        if (level.roomIndex - 1 >= 0)
                        {
                            level.GoToRoom(level.roomIndex - 1);
                            System.out.println("Level+");
                        }
                        break;
                    case Crouch:
                        level.player.Crouch();
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
