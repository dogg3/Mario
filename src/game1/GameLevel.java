/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package game1;
//
//import city.cs.engine.World;
//import org.jbox2d.common.Vec2;
//
///**
// *
// * @author douglaslandvik
// */
//public abstract class GameLevel extends World {
//    private Mario player;
//    public Mario getPlayer() {
//        return player;
//    }
//    public void populate(Game game) {
//        player = new Mario(this);
//        player.setPosition(startPosition());
//        Door door = new Door(this);
//        door.setPosition(doorPosition());
//        door.addCollisionListener(new DoorListener(game));
//    }
//    public abstract Vec2 startPosition();
//    public abstract Vec2 doorPosition();
//    public abstract boolean isCompleted();
//}