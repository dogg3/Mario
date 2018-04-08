package game1;

import city.cs.engine.*;
import static java.lang.Math.random;
import org.jbox2d.common.Vec2;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Mario mario;
    private Enemy enemy;
   
    
    
    public GameWorld() {
        super();
        
        // make the ground
        Shape groundShape = new BoxShape(200, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(100, -11.5f));
        // walls
        //Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        //Fixture leftWall = new SolidFixture(ground, leftWallShape);
       
        
      

    
        
        //Create plattforms
        for(int i = 0; i<10; i++){
            double mathNumber = Math.random() * 10.0f -8.0f;
            Platform platform = new Platform(this);
            platform.setPosition(new Vec2(i*20, (float) mathNumber));
                   
        
        }
        

        // make a character
        mario = new Mario(this);
        mario.setPosition(new Vec2(-5, -7));
        
        //add enemy
        
        enemy = new Enemy(this);
        enemy.setPosition(new Vec2(5, -7));
        enemy.addCollisionListener(new Pickup(mario));
      
       //Make oranges
       
      for(int i=0; i<100; i++){
      Orange orange = new Orange(this);
      orange.setPosition(new Vec2(i*10-10, 10));
      orange.addCollisionListener(new Pickup(mario));
      orange.setGravityScale(10);
      
      
      }
        
      
    }
    
   public Mario getPlayer(){
        return mario;
    }
    
   
}
