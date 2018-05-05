/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.World;
import javax.swing.JPanel;
import org.jbox2d.common.Vec2;

/**
 *
 * @author douglaslandvik
 */
public abstract class GameLevel extends Model {
    private Mario player;
    private JPanel menu;
    public Mario getPlayer() {
    return player;
    }
    public String getScore (){
        return player.getScore();
    }
    public JPanel addMenu(){
    
        return menu;
    }
    public void populate(Game game) {
  
        player = new Mario(this, game);
        menu = new Menu(game, getPlayer());
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(door.new DoorListener(game));
        
       
    }
    
    
    public abstract Vec2 startPosition();
    public abstract Vec2 doorPosition();
    public abstract boolean isCompleted();
    
}