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
public class Enemy extends Walker {
    private static final Shape shape = new PolygonShape(0.531f,0.808f, 0.802f,0.035f, 0.499f,-0.976f, -0.419f,-0.817f, -0.805f,-0.466f, -0.687f,0.227f, -0.369f,0.979f);
    private static final BodyImage image = new BodyImage("data/enemy.png", 2);

    public Enemy(World world) {
        super(world, shape);
        addImage(image);
        
    }
    
    
}
