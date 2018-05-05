package game1;

import fsm.FSMState;

public class RollLeftState extends FSMState<RollerBall> {

    protected void update() {
        RollerBall ball = getContext();
        if (ball.inRangeRight()) {
            gotoState(new RollRightState());
        } else if (!ball.inRange()) {
            gotoState(new StandStillState());
        } else {
            ball.setAngularVelocity(2);
        }
    }

    protected void enter() {
        RollerBall ball = getContext();
        ball.setAngularVelocity(1);
    }
    
    protected void exit() {}
}
