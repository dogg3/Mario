/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.model;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;
import city.cs.engine.World;
import game1.Game;

/**
 *
 * @author douglaslandvik
 */
public class Mario extends Walker {
 
    private int orangeCount;
    private int life;
    private static final Shape shape = new PolygonShape(0.46f,1.46f, 1.04f,-0.94f, 0.44f,-1.29f, -0.5f,-1.47f, -0.83f,-0.64f, -0.93f,0.72f, -0.66f,1.25f, 0.05f,1.47f);
    private static SolidFixture fixture;
    private static final BodyImage image =
    new BodyImage("data/mario.png", 3);
    private final Game game;
    
    /**
     * 
     * @param world the world the body will exist in
     * @param game 
     */
     public Mario(World world, Game game) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        life = 3;
        this.game = game;
        fixture = new SolidFixture(this,shape);
      fixture.setFriction(5);
      
        }
     
  
     
     /**
      * incrementing the score of Mario
      */
     public void incrementOrangeCount(){
         orangeCount++;
         game.changed();
       
     }
     
    
     
     public String getScore(){
     
     return "SCORE: " + orangeCount;
     
     }
     
     /**
      * 
      * @return "LIFE" + LIFE;
      */
     public String getLife(){
     return "LIFE: " + life;
     }
     //Life decrementing
     
     public void decrementLives(){
     life--;
     game.changed();
     }

    public int getCount() {
       return orangeCount;
    }
    
   public int getLifeCount(){
     return life;
     }
     
   public boolean isAlive(){
    if (this.getLifeCount() > 0){
    return false;
    }
    return true;
    }
     
     
    }
