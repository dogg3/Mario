/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1.model;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 *
 * @author douglaslandvik
 */
public class FlowerMonster extends StaticBody {
    private static  Shape shape = 
            new PolygonShape(-1.42f,0.29f, 1.18f,0.35f, 0.74f,-2.64f, -1.03f,-2.63f, -1.54f,0.2f);
   private final Shape head =  new PolygonShape(-0.43f,0.49f, -1.06f,1.86f, 0.33f,3.0f, 1.58f,2.48f, 1.12f,0.9f, 0.68f,0.31f);
   private static final BodyImage headImage = new BodyImage("data/monsterHead.png",1);
   private static final BodyImage bottomImage = new BodyImage("data/newDoor.png",1);
    
   
   public FlowerMonster(World w) {
        super(w);
        SolidFixture bottomFixture = new SolidFixture(this,shape);
        SolidFixture headFixture = new SolidFixture(this,head,15);
        
        
  AttachedImage imageHandler = new AttachedImage(this,headImage,3.5f,0,new Vec2(0,3));
  AttachedImage imageHandler2 = new AttachedImage(this,bottomImage,3.5f,0,new Vec2(0,0));
      
       
    }
    
}
