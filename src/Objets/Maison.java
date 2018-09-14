package Objets;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Maison extends Group {
    public Maison(boolean effect) {
        this.getChildren().addAll(
                toit(effect),
                base(effect),
                porte(),
                fenetre());
    }

    private Rectangle base(boolean effect) {
        Rectangle base = new Rectangle(10, 50, 80, 50);
        base.setFill(Color.BEIGE);

        if (effect) {
            DropShadow ds = new DropShadow(8, -10, 10, Color.DARKGREY);
            base.setEffect(ds);
        }
        return base;
    }

    private Polygon toit(boolean effect) {
        Polygon toit = new Polygon(50, 0, 5, 50, 95, 50);
        toit.setFill(Color.BROWN);
        toit.setStroke(Color.BLACK);
        toit.setStrokeWidth(0.3);

        if (effect) {
            DropShadow ds = new DropShadow(8, -10, 10, Color.DARKGREY);
            toit.setEffect(ds);
        }
        return toit;
    }

    private Group porte() {
        Rectangle base = new Rectangle(25, 70, 20, 30);
        base.setFill(Color.SADDLEBROWN);

        Circle poignee = new Circle(40, 85, 4);
        poignee.setFill(Color.YELLOWGREEN);
        poignee.setStroke(Color.DARKGREY);
        poignee.setStrokeWidth(0.5);

        return new Group(base, poignee);
    }

    private Group fenetre() {
        Rectangle fond = new Rectangle(55, 60, 28, 20);
        fond.setFill(Color.AQUA);
        fond.setStroke(Color.GREY);
        fond.setStrokeWidth(1.0);

        Line ligne = new Line(55 + (28 * 0.5), 60, 55 + (28 * 0.5), 80);
        ligne.setStroke(Color.GREY);
        ligne.setStrokeWidth(1.0);

        Line colonne = new Line(55, 70, (55 + 28), 70);
        colonne.setStroke(Color.GREY);
        colonne.setStrokeWidth(1.0);

        return new Group(fond, ligne, colonne);
    }
}
