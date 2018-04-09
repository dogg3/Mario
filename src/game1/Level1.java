package game1;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {
    
    private static final int NUM_ORANGES = 5;
    
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(90, -11.5f));
      
        //Create plattforms
        for(int i = 0; i<10; i++){
            double mathNumber = Math.random() * 10.0f -8.0f;
            Platform platform = new Platform(this);
            platform.setPosition(new Vec2(i*20, (float) mathNumber));
        }
       
        //add enemy
        for(int i=0; i<20; i++){
            Enemy enemy = new Enemy(this);
            enemy.setPosition(new Vec2(i*20, -10));
            enemy.addCollisionListener(new Pickup(super.getPlayer()));
            enemy.setLinearVelocity(new Vec2(-2,0));
        }

        //Make oranges
        for(int i=0; i<100; i++){
             Orange orange = new Orange(this);
             orange.setPosition(new Vec2(i*10-5, 10));
            orange.addCollisionListener(new Pickup(super.getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(190, -9f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCount() > NUM_ORANGES;
    }
}
