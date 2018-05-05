package game1;

import fsm.FSMState;

public class RollRightState extends FSMState<RollerBall> {

    protected void update() {
        RollerBall ball = getContext();
        if (ball.inRangeLeft()) {
            gotoState(new RollLeftState());
        } else if (!ball.inRange()) {
            gotoState(new StandStillState());
        } else {
            ball.setAngularVelocity(-2);
        }
    }

    protected void enter() {
        RollerBall ball = getContext();
        ball.setAngularVelocity(-1);
    }
    
    protected void exit() {}
}
