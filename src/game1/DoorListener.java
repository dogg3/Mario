/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author douglaslandvik
 */
public class DoorListener implements CollisionListener {
    private Mario mario;
    public DoorListener(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void collide(CollisionEvent e) {
         if (e.getOtherBody() == mario) {
            if (e.getReportingBody() instanceof Orange) {
                mario.incrementOrangeCount();
                e.getReportingBody().destroy();
            } else if (e.getReportingBody() instanceof Enemy)
                mario.decrementLives();
            }
            
        }
    
}
