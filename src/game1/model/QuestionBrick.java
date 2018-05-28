/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author douglaslandvik
 */
public class QuestionBrick extends DynamicBody implements CollisionListener  {
private final SolidFixture top = new SolidFixture(this,new PolygonShape(-2.48f,2.48f, 2.48f,2.46f, 2.48f,-2.46f, -2.47f,-2.41f, -2.49f,2.43f));
private final SolidFixture bottom = new SolidFixture(this,new PolygonShape(-2.49f,-2.03f, 2.48f,-2.06f, 2.42f,-2.44f, -2.48f,-2.42f, -2.5f,-2.08f));
  
public QuestionBrick(World w) {
        super(w);
    }

    @Override
    public void collide(CollisionEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
