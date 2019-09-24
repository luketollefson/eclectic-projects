/*
 * To change this license header, choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package Game;

import Controller.KeyboardController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author araderma
 */
public class GamePanel extends JPanel
{
    // These are for handling the frame rate of the game and player controls
    // You should pass the controller to any objects you create that will
    //  be under keyboard control
    private Timer gameTimer; 
    private KeyboardController controller; 
    
    // Controls size of game window and framerate
    // You can adjust these if you want to use different values 
    private final int gameWidth = 600; 
    private final int gameHeight = 720; 
    private final int framesPerSecond = 60; 
        
    /**
     * This method is called by the GameFrame class when starting the game for 
     *  the first time. It should be used like a constructor method where you
     *  initialize all of the instance variables. 
     * You can also use this method to reset a game after a player wins or loses
     *  and wants to play again. 
     */
    public final void setupGame()
    {
        
    }
    
    /**
     * This method is automatically called by the game timer every frame. As typical,
     *  you should use it to draw all of your game objects.
     * 
     * @param g The Graphics object used for drawing the GameObject instances.
     */
    @Override
    public void paint(Graphics g)
    {
        
    }
    
    /**
     * This method is automatically called by the game timer every frame. Any of your
     *  code for moving game objects or handling collisions, etc. should be done 
     *  by this method. 
     * The method has a single parameter which represents the 
     *  current frame number, which is incremented by the Timer each time before 
     *  the method is called. You can assume that it will always increase, but it
     *  will eventually overflow if the game runs long enough (something like 1 year)
     * 
     * @param frameNumber The number of the current frame.
     */
    public void updateGameState(int frameNumber)
    {
              
    }
    
   
    /**
     * Constructor method for GamePanel class.
     * It is not necessary for you to modify this code at all
     */
    public GamePanel()
    {
        // Set the size of the Panel
        this.setSize(gameWidth, gameHeight);
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        
        this.setBackground(Color.BLACK);
        
        // Register KeyboardController as KeyListener
        controller = new KeyboardController(); 
        this.addKeyListener(controller); 
        
        // Call setupGame to initialize fields
        this.setupGame(); 
        
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    /**
     * Method to start the Timer that drives the animation for the game.
     * It is not necessary for you to modify this code unless you need to in 
     *  order to add some functionality. 
     */
    public void start()
    {
        // Set up a new Timer to repeat every 20 milliseconds (50 FPS)
        gameTimer = new Timer(1000 / framesPerSecond, new ActionListener() {

            // Tracks the number of frames that have been produced.
            // May be useful for limiting action rates
            private int frameNumber = 0; 
                        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Update the game's state and repaint the screen
                updateGameState(frameNumber++);
                repaint();  
            }
        });
        
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    
    
}
