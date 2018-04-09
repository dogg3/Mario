package game1;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Walker body;

    public Tracker(WorldView view, Walker body) {
        this.view = view;
        this.body = body;
    }
    
  
    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));
        
    }
    
     public void setBody(Walker body) {
        this.body = body;
    }
    
}
