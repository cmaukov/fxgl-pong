package com.example.demo;
/* demo
 * @created 12/30/2022
 * @author Konstantin Staykov
 */

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

public class BatComponent extends Component {
    private static final double BAT_SPEED = 420;

    protected PhysicsComponent physics;

    public void up() {
        if (entity.getY() >= BAT_SPEED / 60)
            physics.setVelocityY(-BAT_SPEED);
        else
            stop();
    }

    public void down() {
        if (entity.getBottomY() <= FXGL.getAppHeight() - (BAT_SPEED / 60))
            physics.setVelocityY(BAT_SPEED);
        else
            stop();
    }

    public void stop() {
        physics.setLinearVelocity(0, 0);
    }
}
