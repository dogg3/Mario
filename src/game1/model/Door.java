/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.model;

import game1.model.Mario;
import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import game1.Game;
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
class Door extends StaticBody  {

   
    private static SolidFixture topFixture;
    private World world;
    
   
    private static final BodyImage image = new BodyImage("data/newDoor.png",3.5f);

    public Door(World world) {
        super(world);
        this.world = world;
       
        Shape topShape = new PolygonShape(-1.48f,1.49f, 1.48f,1.47f, 1.48f,0.74f, -1.49f,0.75f, -1.49f,1.46f);
       topFixture = new SolidFixture(this, topShape,10);
        Shape bottomShape = new PolygonShape( -1.27f,0.72f, -1.28f,-1.32f, 1.27f,-1.32f, 1.27f,0.73f, -1.25f,0.73f);
        SolidFixture bottomFixture = new SolidFixture(this, bottomShape,1);
        addImage(image);
    }

    
     SolidFixture getTopFixture(){
    return topFixture;
    
    }
 
     class DoorListener implements CollisionListener, ActionListener {
    private Game game;
    private Timer timer;
    private SoundClip levelMusic;
    
    
    public DoorListener(Game game) {
        this.game = game;
        timer = new Timer(2500,this);
        timer.setRepeats(false);
      
        try {
            levelMusic = new SoundClip("data/sounds/levelwin.wav");   // Open an audio input stream
            
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
        
       
    }
    @Override
    public void collide(CollisionEvent e) {
        Mario player = game.getPlayer();
        
        if (e.getOtherBody() == player && e.getReportingFixture() == topFixture &&
             
            game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            player.putOn(Door.this);
           timer.start();
           levelMusic.play();
           world.stop();
           game.stopBackgroundMusic();
         
           
            
        }else{

            System.out.println(player.getCount());
        
        }
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            game.goNextLevel();
       
        }
    }

    
}
