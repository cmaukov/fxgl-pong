package com.example.demo;
/* demo
 * @created 12/30/2022
 * @author Konstantin Staykov
 */

import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.animationBuilder;
import static com.almasb.fxgl.dsl.FXGL.getUIFactoryService;

public class MainUIController implements UIController {

    @FXML
    private Label labelScorePlayer;

    @FXML
    private Label labelScoreEnemy;

    public Label getLabelScoreEnemy() {
        return labelScoreEnemy;
    }

    public Label getLabelScorePlayer() {
        return labelScorePlayer;
    }

    @Override
    public void init() {
        labelScorePlayer.setFont(getUIFactoryService().newFont(72));
        labelScoreEnemy.setFont(getUIFactoryService().newFont(72));

        labelScoreEnemy.layoutBoundsProperty().addListener((observable, oldValue, newBounds) -> {
            double width = newBounds.getWidth();
            labelScoreEnemy.setTranslateX(800 - 100 - width);
        });

        labelScorePlayer.textProperty().addListener((observable, oldValue, newValue) -> {
            animateLabel(labelScorePlayer);
        });

        labelScoreEnemy.textProperty().addListener((observable, oldValue, newValue) -> {
            animateLabel(labelScoreEnemy);
        });
    }

    private void animateLabel(Label label) {
        animationBuilder()
                .duration(Duration.seconds(0.33))
                .fadeIn(label)
                .build();
    }
}