/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.model;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author douglaslandvik
 */
public class Platform extends StaticBody {
   private static final Shape shape = new BoxShape(4, 0.8f);
   private static final BodyImage imagePlattform1 = new BodyImage("data/brick.png",2);

    public Platform(World w) {
        super(w,shape);
        this.addImage(imagePlattform1);
    }

    


}
