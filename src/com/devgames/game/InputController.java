
package com.devgames.game;

import com.devgames.levels.level;
import java.awt.event.KeyEvent;

public class InputController
{    
    level level;
    public InputController(level _level)
    {
        level = _level;
    }
    
    public InputController.Input[] inputs =
    {   
        new InputController.Input(KeyEvent.VK_LEFT, InputController.inputAction.MoveLeft),
        new InputController.Input(KeyEvent.VK_RIGHT,InputController.inputAction.MoveRight),
        new InputController.Input(KeyEvent.VK_UP, InputController.inputAction.ClimbUp),
        new InputController.Input(KeyEvent.VK_DOWN, InputController.inputAction.ClimbDown),
        new InputController.Input(KeyEvent.VK_SPACE,InputController.inputAction.Jump),
    };
    
    public static enum inputAction
    {
        MoveLeft,
        MoveRight,
        ClimbUp,
        ClimbDown,
        Jump
    }
    
    public static class Input
    {    
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
        for (int i = 0; i < inputs.length; i++)
        {
            System.out.println("update input tick " + i);
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
        for (int i = 0; i < inputs.length; i++)
        {
            if (e.getKeyCode() == inputs[i].event)
            {
                inputs[i].IsPressed = false;
            }
        }
    }
}
