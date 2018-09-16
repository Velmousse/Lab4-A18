package Objets;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.QuadCurve;
import javafx.util.Duration;

public class Oiseau extends Group {
    public Oiseau() {
        this.getChildren().add(build());
    }

    private Group build() {
        QuadCurve droite = new QuadCurve(100, 100, 125, 65, 150, 110);
        droite.setStroke(Color.BLACK);
        droite.setStrokeWidth(1);
        droite.setFill(Color.LIGHTGRAY);

        QuadCurve gauche = new QuadCurve(100, 100, 75, 65, 50, 110);
        gauche.setStroke(Color.BLACK);
        gauche.setStrokeWidth(1);
        gauche.setFill(Color.LIGHTGRAY);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        KeyValue kvd1 = new KeyValue(droite.endYProperty(), 80);
        KeyValue kvd2 = new KeyValue(droite.startYProperty(), 110);

        KeyValue kvg1 = new KeyValue(gauche.endYProperty(), 80);
        KeyValue kvg2 = new KeyValue(gauche.startYProperty(), 110);

        KeyFrame kf = new KeyFrame(Duration.seconds(1), kvd1, kvd2, kvg1, kvg2);

        timeline.getKeyFrames().add(kf);
        timeline.play();

        return new Group(droite, gauche);
    }
}
