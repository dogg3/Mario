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
    private Game game;
    public DoorListener(Game game) {
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        Mario player = game.getPlayer();
        if (e.getOtherBody() == player &&
            game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }else{

            System.out.println(player.getCount());
        
        }
    }
}
