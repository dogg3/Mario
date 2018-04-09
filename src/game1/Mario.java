/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author douglaslandvik
 */
public class Mario extends Walker {
    
    private int orangeCount;
    private int life;
    private static final Shape shape = new PolygonShape(0.46f,1.46f, 1.04f,-0.94f, 0.44f,-1.29f, -0.5f,-1.47f, -0.83f,-0.64f, -0.93f,0.72f, -0.66f,1.25f, 0.05f,1.47f);
    private static final BodyImage image =
    new BodyImage("data/mario.png", 3);
    
     public Mario(World world) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        life = 0;
        
        }
     
     //The score incrementing
     public void incrementOrangeCount(){
         orangeCount++;
         
     }
     
     //get score
     
     public String getScore(){
     
     return "SCORE: " + orangeCount;
     }
     
     
     
     //Life decrementing
     
     public void decrementLives(){
     life--;
     }
     
     
     
    }
