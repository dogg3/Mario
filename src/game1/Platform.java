/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author douglaslandvik
 */
public class Platform extends StaticBody {
   public static final Shape shape = new BoxShape(4, 0.5f);

    public Platform(World w) {
        super(w,shape);
    }

    


}
