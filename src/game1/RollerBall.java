package game1;

import fsm.FSM;
import city.cs.engine.*;

public class RollerBall extends DynamicBody implements StepListener {
    
    private static final float radius = 1.0f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
        new BodyImage("data/bowl.png", 2*radius);

    public static final float RANGE = 5;
    
    private Game game;
    private FSM<RollerBall> fsm;
    
    public RollerBall(Game game) {
        super(game.getWorld(), ballShape);
        this.game = game;
        addImage(ballImage);
        fsm = new FSM<RollerBall>(this, new StandStillState());
        getWorld().addStepListener(this);
    }
    
    public boolean inRangeLeft() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }
    
    public boolean inRangeRight() {
        Body a = game.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
    }
    
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }
    
    public void preStep(StepEvent e) {
        fsm.update();
    }
    
    public void postStep(StepEvent e) {}
}
