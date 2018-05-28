package game1.model;

import game1.model.GameLevel;
import game1.model.Mario;
import city.cs.engine.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;
import city.cs.engine.BodyImage;
import game1.Game;
import game1.controller.Orange;
import game1.controller.Pickup;

/**
 * Level 1 of the game
 */
public class Level2 extends GameLevel implements ActionListener {
    
    private static final int NUM_ORANGES = 5;
       private static BodyImage groundImage; 
       private StaticBody flowerMonster;
       private Mario player;
       private Timer timer;
       private Game game;
       
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
       
        this.player = game.getPlayer();
        this.game = game;

           //make a flower monster
         flowerMonster = new FlowerMonster(this);
         flowerMonster.setPosition(new Vec2(5,-8.6f));
        // make the ground
        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        groundImage = new BodyImage("data/ground.png",1);
        ground.addImage(groundImage);
        ground.setPosition(new Vec2(90, -11.5f));
      
    
        //Create plattforms
        for(int i = 0; i<8; i++){
            double mathNumber = Math.random() * 10.0f -8.0f;
            Platform platform = new Platform(this);
            platform.setPosition(new Vec2(i*20+20, (float) mathNumber));
            
        }
       
       
        timer = new Timer(3000, this);
        timer.start();
        //add enemy
  


        //Make oranges
        for(int i=0; i<20; i++){
             Orange orange = new Orange(this);
             orange.setPosition(new Vec2(i*10-5+20, 10));
             
            orange.addCollisionListener(new Pickup(super.getPlayer(), game));
        }
    }
    
 
    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(180f, -9.2f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() > NUM_ORANGES;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("Action perfromed");
             
             Vec2 position = player.getPosition();
             if(position.x + 20< 180){
              Enemy enemy = new Enemy(this);
             enemy.addCollisionListener(new Pickup(super.getPlayer(), game));
             enemy.setPosition(new Vec2(position.x+15,position.y));
             
             }
    }


   
}
