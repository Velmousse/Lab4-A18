package Objets;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Soleil extends Group {
    public Soleil() {
        this.getChildren().add(build());
    }

    private Group build() {
        Circle base = new Circle(100, 100, 30);
        base.setFill(Color.YELLOW);

        FillTransition ft = new FillTransition(Duration.seconds(4), base);
        ft.setToValue(Color.DARKORANGE);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        return new Group(base, lineGrouper());
    }

    private Line lineBuilder(boolean grand) {
        Line ligne;
        if (grand)
            ligne = new Line(100, 65, 100, 25);
        else
            ligne = new Line(100, 65, 100, 35);

        ligne.setStroke(Color.YELLOW);
        ligne.setStrokeWidth(1.0);

        return ligne;
    }

    private Group lineGrouper() {
        Line ligne = lineBuilder(true);

        Line ligne1 = lineBuilder(false);
        ligne1.setRotate(45.0);
        ligne1.setTranslateX(35);
        ligne1.setTranslateY(15);

        Line ligne2 = lineBuilder(false);
        ligne2.setRotate(-45.0);
        ligne2.setTranslateX(-35);
        ligne2.setTranslateY(15);

        Line ligne3 = lineBuilder(true);
        ligne3.setRotate(90.0);
        ligne3.setTranslateX(55);
        ligne3.setTranslateY(55);

        Line ligne4 = lineBuilder(true);
        ligne4.setRotate(-90);
        ligne4.setTranslateX(-55);
        ligne4.setTranslateY(55);

        Line ligne5 = lineBuilder(false);
        ligne5.setRotate(135.0);
        ligne5.setTranslateX(35);
        ligne5.setTranslateY(85);

        Line ligne6 = lineBuilder(false);
        ligne6.setRotate(-135.0);
        ligne6.setTranslateX(-35);
        ligne6.setTranslateY(85);

        Line ligne7 = lineBuilder(true);
        ligne7.setRotate(180);
        ligne7.setTranslateY(110);

        return new Group(ligne, ligne1, ligne2, ligne3, ligne4, ligne5, ligne6, ligne7);
    }
}
