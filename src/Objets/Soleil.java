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

    private Line lineBuilder(int grand) {
        Line ligne;
        if (grand == 0)
            ligne = new Line(100, 65, 100, 25);
        else
            ligne = new Line(100, 65, 100, 35);

        ligne.setStroke(Color.YELLOW);
        ligne.setStrokeWidth(1.0);

        return ligne;
    }

    private Group lineGrouper() {
        Line lignes[] = new Line[8];
        double valeurs[] = new double[3];

        for (int i = 0; i < 8; i++) {
            lignes[i] = lineBuilder(i % 2);
            valeurs = lineSetter(i);
            lignes[i].setRotate(valeurs[0]);
            lignes[i].setTranslateX(valeurs[1]);
            lignes[i].setTranslateY(valeurs[2]);
        }

        return new Group(lignes[0], lignes[1], lignes[2], lignes[3], lignes[4], lignes[5], lignes[6], lignes[7]);
    }

    private double[] lineSetter(int i) {
        switch (i) {
            case 0: return new double[]{0, 0, 0};
            case 1: return new double[]{45.0, 35, 15};
            case 2: return new double[]{90.0, 55, 55};
            case 3: return new double[]{-45.0, -35, 15};
            case 4: return new double[]{-90.0, -55, 55};
            case 5: return new double[]{135.0, 35, 85};
            case 6: return new double[]{180.0, 0, 110};
            case 7: default: return new double[]{-135.0, -35, 85};
        }
    }
}
