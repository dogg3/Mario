/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.GhostlyFixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;


/**
 *
 * @author douglaslandvik
 */
public class Enemy extends Walker implements CollisionListener, ActionListener {
    private static final Shape shape = new PolygonShape(0.531f,0.808f, 0.802f,0.035f, 0.499f,-0.976f, -0.419f,-0.817f, -0.805f,-0.466f, -0.687f,0.227f, -0.369f,0.979f);
    private static final BodyImage image = new BodyImage("data/enemy.png", 2);
    private static SoundClip enemySound;
   private Timer timer;
    private static final float WALKING_SPEED = 3;
    private static final float JUMPING_SPEED = 10;
    private int counter;
            
            
    public Enemy(World world) {
        super(world, shape);
        addImage(image);
        this.startWalking(-WALKING_SPEED);
        this.addCollisionListener(this);
        this.setBullet(true);
        counter = 0;
        timer = new Timer(100, this);
        timer.start();

    }
    
    @Override
    public void destroy()
    {
        super.destroy();
        enemySound.play();
        timer.stop();
    }

 static {
        try {
           enemySound = new SoundClip("data/sounds/hit.wav");
           System.out.println("Loading orange sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         } 
 }

    @Override
    public void collide(CollisionEvent ce) {
        if (ce.getOtherBody() instanceof Orange ){
            
            this.jump(10);
        }
        if(ce.getOtherBody() instanceof Platform){
         this.jump(10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         switch (counter) {
             case 1: this.rotateDegrees(-10);
             break;
             case 0: this.rotateDegrees(10);
              
         }
         counter = (counter == 1) ? 0 : 1;
    }


    
    
}
