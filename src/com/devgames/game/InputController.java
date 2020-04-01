package com.devgames.game;

import com.devgames.levels.level;
import java.awt.event.KeyEvent;

public class InputController
{   
    //Passes level to InputController
    level level;
    
    public InputController(level _level)
    {
        level = _level;
    }
    
    public InputController.Input[] inputs =
    {   
        //Array of possible inputs
        new InputController.Input(KeyEvent.VK_LEFT, InputController.inputAction.MoveLeft),
        new InputController.Input(KeyEvent.VK_RIGHT,InputController.inputAction.MoveRight),
        new InputController.Input(KeyEvent.VK_UP, InputController.inputAction.ClimbUp),
        new InputController.Input(KeyEvent.VK_DOWN, InputController.inputAction.ClimbDown),
        new InputController.Input(KeyEvent.VK_SPACE,InputController.inputAction.Jump),
    };
    
    public static enum inputAction
    {   
        //Enumeration of possible inputs
        MoveLeft,
        MoveRight,
        ClimbUp,
        ClimbDown,
        Jump
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
                        break;
                        
                    case ClimbDown:
                        
                        break;
                        
                    case Jump:       
                        level.player.Jump();
                        break;
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
