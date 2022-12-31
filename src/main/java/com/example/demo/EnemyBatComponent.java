package com.example.demo;
/* demo
 * @created 12/30/2022
 * @author Konstantin Staykov
 */

import com.almasb.fxgl.entity.Entity;

public class EnemyBatComponent extends BatComponent {
    private Entity ball;

    @Override
    public void onUpdate(double tpf) {
        if (ball == null) {
            ball = entity.getWorld().getSingletonOptional(EntityType.BALL).orElse(null);
        } else {
            moveAI();
        }
    }

    private void moveAI() {
        Entity bat = entity;

        boolean isBallToLeft = ball.getRightX() <= bat.getX();

        if (ball.getY() < bat.getY()) {
            if (isBallToLeft)
                up();
            else
                down();
        } else if (ball.getY() > bat.getY()) {
            if (isBallToLeft)
                down();
            else
                up();
        } else {
            stop();
        }
    }
}
