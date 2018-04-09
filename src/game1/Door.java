/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author douglaslandvik
 */
class Door extends StaticBody {
    
    private static final Shape shape = new PolygonShape(-0.65f,0.77f, 0.69f,0.73f, 0.7f,-1.3f, -0.71f,-1.32f, -0.69f,0.75f);
    private static final BodyImage image = new BodyImage("data/door.png",5);

    public Door(World world) {
        super(world, shape);
        addImage(image);
        
    }


    
}
