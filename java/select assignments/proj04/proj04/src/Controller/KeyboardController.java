/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author araderma
 */
public class KeyboardController implements KeyListener
{
    private boolean[] keyStatus; 
    
    public static final int SPACE_KEY = KeyEvent.VK_SPACE; 
    public static final int LEFT_ARROW_KEY = KeyEvent.VK_LEFT;
    public static final int UP_ARROW_KEY = KeyEvent.VK_UP;
    public static final int RIGHT_ARROW_KEY = KeyEvent.VK_RIGHT;
    public static final int DOWN_ARROW_KEY = KeyEvent.VK_DOWN;

    public KeyboardController()
    {
        keyStatus = new boolean[256]; 
    }
    
    public boolean getKeyStatus(int keyCode)
    {
        if(keyCode < 0 || keyCode > 255)
        {
            return false; 
        }
        else
        {
            return keyStatus[keyCode]; 
        }
    }
    
    public boolean getSpaceKeyStatus()
    {
        return getKeyStatus(SPACE_KEY);
    }
    
    public boolean getLeftKeyStatus()
    {
        return getKeyStatus(LEFT_ARROW_KEY);
    }
    
    public boolean getUpKeyStatus()
    {
        return getKeyStatus(UP_ARROW_KEY);
    }
    
    public boolean getRightKeyStatus()
    {
        return getKeyStatus(RIGHT_ARROW_KEY);
    }
    
    public boolean getDownKeyStatus()
    {
        return getKeyStatus(DOWN_ARROW_KEY);
    }
    
    public void resetController()
    {
        keyStatus = new boolean[256]; 
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keyStatus[ke.getKeyCode()] = true; 
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keyStatus[ke.getKeyCode()] = false; 
    }
    
}
