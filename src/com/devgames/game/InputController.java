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
        new InputController.Input(KeyEvent.VK_LEFT, InputController.inputAction.MoveLeft),
        new InputController.Input(KeyEvent.VK_RIGHT,InputController.inputAction.MoveRight),
        new InputController.Input(KeyEvent.VK_UP, InputController.inputAction.ClimbUp),
        new InputController.Input(KeyEvent.VK_DOWN, InputController.inputAction.ClimbDown),
        new InputController.Input(KeyEvent.VK_SPACE,InputController.inputAction.Jump),
        new InputController.Input(KeyEvent.VK_HOME,InputController.inputAction.NextLvl),
        new InputController.Input(KeyEvent.VK_END,InputController.inputAction.PrevLvl),
        new InputController.Input(KeyEvent.VK_CAPS_LOCK,InputController.inputAction.EnableClimb),
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
        EnableClimb,
    }
    
    public static class Input
    {   
        //Input array constructor - requires keypress and action to be performed
        public int event;
        public inputAction action;
        public boolean IsPressed = false;
        
        public Input(int _event, inputAction _action)
        {
            event = _event;
            action = _action;
        }
    }
    
    public void updateInput()
    {
        //Once an input is performed, this function calls the code to perform
        //the required action
        for (int i = 0; i < inputs.length; i++)
        {
            if (inputs[i].IsPressed)
            {  
                switch(inputs[i].action)
                {
                    case MoveLeft:
                        level.player.MoveLeft();
                        break;
                        
                    case MoveRight:
                        level.player.MoveRight();
                        break;
                        
                    case ClimbUp:
                        level.player.ClimbUp();
                        break;
                        
                    case ClimbDown:
                        level.player.ClimbDown();
                        break;
                    case EnableClimb:
                        level.player.IsClimbing = true;
                        break;                        
                    case Jump:       
                        level.player.Jump();
                        break;
                    case NextLvl:
                        System.out.println("Attempting room+");
//                        if (level.rooms.length + 1 <= level.rooms.length)
//                        {
                            game.goToRoom(1);
                            System.out.println("Level+");
//                        }
                        break;
                    case PrevLvl:
                        System.out.println("Attempting room-");
//                        if (level.CurrentRoomInt - 1 >= level.rooms.length)
//                        {
                            game.goToRoom(0);
                            System.out.println("Level-");
//                        }
                        break;
                            
                        
                    
                }
            }
            if (!inputs[i].IsPressed)
            {   
                switch(inputs[i].action)
                {
                
                }
            }
        }
    }
    
    public void CheckKeyPress(KeyEvent e)
    {
        //This function stores whether or not a key has been pressed
        for (int i = 0; i < inputs.length; i++)
        {
            if (e.getKeyCode() == inputs[i].event)
            {
                inputs[i].IsPressed = true;
            }
        }
    }
    
    public void CheckKeyRelease(KeyEvent e)
    {
        //This function stores whether or not a key has been released
        for (int i = 0; i < inputs.length; i++)
        {
            if (e.getKeyCode() == inputs[i].event)
            {
                inputs[i].IsPressed = false;
            }
        }
    }
}
