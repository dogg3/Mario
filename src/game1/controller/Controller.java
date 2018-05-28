package game1.controller;

import city.cs.engine.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter implements ActionListener {
    private static final float JUMPING_SPEED = 12;
    private static final float WALKING_SPEED = 8;
    private Timer timer;
    private Walker body;
    private int counter;
    private int code;
    private BodyImage marioStanding;
    private BodyImage marioRun;
     private BodyImage marioStandingLeft;
    private BodyImage marioRunLeft;
     private BodyImage marioJumpingRight;
       private BodyImage marioJumpingLeft;
       private static SoundClip jumpSound;
    
    public Controller(Walker body) {
        this.body = body;
        timer = new Timer(400, this);
        timer.setInitialDelay(0);
        counter = 0;
        marioStanding = new BodyImage("data/mario.png", 3);
        marioRun = new BodyImage("data/marioRun.png", 3);
        marioStandingLeft = new BodyImage("data/marioLeft.png", 3);
        marioRunLeft = new BodyImage("data/marioRunLeft.png", 3);
        marioJumpingRight = new BodyImage("data/jumpingMarioRight.png", 2.5f);
        marioJumpingLeft = new BodyImage("data/jumpingMarioLeft.png", 2.5f);
    
        
        
           try {
            jumpSound = new SoundClip("data/sounds/jump.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }  
    }
    

    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
         code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_J) { // J = jump
            Vec2 v = body.getLinearVelocity();
            
            
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                jumpSound.play();
               
            }
             if(v.x >= 0){
                    body.removeAllImages();
                body.addImage(marioJumpingRight);
                } else if(v.x <= 0){
                    body.removeAllImages();
                  body.addImage(marioJumpingLeft);
                }
        } else if (code == KeyEvent.VK_1) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
            timer.start();
        } else if (code == KeyEvent.VK_2) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            timer.start();
           
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
         code = e.getKeyCode();
        if (code == KeyEvent.VK_1) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            body.stopWalking();
            
        }else if (code == KeyEvent.VK_J) {
            
            
        }
        timer.stop();
        body.removeAllImages();
        body.addImage(marioStanding);
    }
    
     public void setBody(Walker body) {
        this.body = body;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

if(code == KeyEvent.VK_1 || code == KeyEvent.VK_2){
       body.removeAllImages();
        if(counter % 2 == 0){
            if(code == KeyEvent.VK_1){
                    body.addImage(marioRunLeft);
            }
              if(code == KeyEvent.VK_2){
                     body.addImage(marioRun);
            }
        } else {
               if(code == KeyEvent.VK_2){
                    body.addImage(marioStanding);
            }
                   if(code == KeyEvent.VK_1){
                     body.addImage(marioStandingLeft);
            }
        }
        
}
         counter = (counter == 1) ? 0 : 1;


    }
}
