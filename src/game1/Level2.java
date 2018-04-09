/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**
 *
 * @author douglaslandvik
 */
public class Level2 extends GameLevel {

    private static final int NUM_ORANGES = 5;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

         // make the ground
        Shape groundShape = new BoxShape(10, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(5, -11.5f));
        // walls
        //Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        //Fixture leftWall = new SolidFixture(ground, leftWallShape);
       
       
         //Make oranges
       
      for(int i=0; i<100; i++){
      Orange orange = new Orange(this);
      orange.setPosition(new Vec2(i*10-10, 10));
      orange.addCollisionListener(new Pickup(super.getPlayer()));
      
      
      
      }
        

        //add enemy
        for(int i=0; i<20; i++){
        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(i*20-10, -10));
        enemy.addCollisionListener(new Pickup(super.getPlayer()));
        enemy.setLinearVelocity(new Vec2(-2,0));
        }
       
      
      
      
      
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -5);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() > NUM_ORANGES;
    }
}
