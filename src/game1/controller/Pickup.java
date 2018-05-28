package game1;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Mario mario;
    private Game game;
    public Pickup(Mario mario) {
        this.mario = mario;
     
    }
    
    public Pickup(Mario mario, Game game){
    this.mario = mario;
    this.game = game;
    }

   
    
     @Override
    public void collide(CollisionEvent e) {
       if (e.getOtherBody() == mario) {
            if (e.getReportingBody() instanceof Orange) {
                mario.incrementOrangeCount();
                e.getReportingBody().destroy();
            } else if (e.getReportingBody() instanceof Enemy)
                mario.decrementLives();
             e.getReportingBody().destroy();
             if(mario.isAlive()){
                 game.gameOver();
             
             }
            }
            
        }
    
    
}
