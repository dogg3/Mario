package game1;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

public class StandStillState extends FSMState<RollerBall> {

    protected void update() {
        RollerBall ball = getContext();
        if (ball.inRangeLeft()) {
            gotoState(new RollLeftState());
        } else if (ball.inRangeRight()) {
            gotoState(new RollRightState());
        }
    }

    protected void enter() {
        RollerBall ball = getContext();
        ball.setAngularVelocity(0);
        ball.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }
}
