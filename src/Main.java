import Objets.Maison;
import Objets.Oiseau;
import Objets.Soleil;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
    public static void main(String[] args) { launch(args); }

    public void start(Stage stage) {
        stage.setTitle("Dessins");
        stage.setWidth(800);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.setScene(setScene());
        stage.show();
    }

    public Scene setScene() {
        Maison maison = new Maison(true);
        maison.setTranslateX(140);
        maison.setTranslateY(150);

        Maison maison1 = new Maison(false);
        maison1.setTranslateX(550);
        maison1.setTranslateY(150);

        Soleil soleil = new Soleil();
        soleil.setTranslateX(220);
        soleil.setTranslateY(-20);

        RotateTransition rt = new RotateTransition(Duration.seconds(6), soleil);
        rt.setByAngle(360);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();

        Oiseau oiseau = new Oiseau();
        oiseau.setScaleX(0.85);
        oiseau.setScaleY(0.85);
        oiseau.setTranslateX(-40);
        oiseau.setTranslateY(20);

        Oiseau oiseau1 = new Oiseau();
        oiseau1.setScaleX(0.85);
        oiseau1.setScaleY(0.85);
        oiseau1.setTranslateX(90);
        oiseau1.setTranslateY(-20);

        Group root = new Group(
                fond(),
                maison,
                maison1,
                texte(),
                lune(),
                soleil,
                etoile(3, 1, 0, 215, -215, 0.3),
                etoile(2, 1, 0, 245, -150, 0.2),
                etoile(2, 0, 1, 300, -175, 0.3),
                etoile(2, 0, 1, 375, -160, 0.37),
                oiseau,
                oiseau1);

        return new Scene(root, 800, 400);
    }

    public Group fond() {
        Rectangle gauche = new Rectangle(0, 0, 400, 800);
        gauche.setFill(Color.LIGHTGRAY);
        Rectangle droite = new Rectangle(400, 0, 400, 800);
        droite.setFill(Color.BLACK);

        return new Group(gauche, droite);
    }

    public Group texte() {
        Text jour = new Text(152, 325, "Jour");
        jour.setFill(Color.BLACK);
        jour.setFont(new Font(Font.getDefault().getName(), 40));

        Text nuit = new Text(560, 325, "Nuit");
        nuit.setFill(Color.WHITE);
        nuit.setFont(new Font(Font.getDefault().getName(), 40));

        return new Group(jour, nuit);
    }

    public Circle lune() {
        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.BLACK) };
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);

        Circle lune = new Circle(750, 65, 30);
        lune.setFill(lg);

        return lune;
    }

    public Polygon etoile(int temps, double from, double to, double transX, double transY, double scale) {
        Polygon etoile = new Polygon(250, 200, 262, 238, 300, 238, 269, 262, 281, 300, 250, 277, 219, 300, 231, 262, 200, 238, 238, 238);
        etoile.setFill(Color.YELLOW);
        etoile.setTranslateX(transX);
        etoile.setTranslateY(transY);
        etoile.setScaleX(scale);
        etoile.setScaleY(scale);

        FadeTransition ft = new FadeTransition(Duration.seconds(temps), etoile);
        ft.setFromValue(from);
        ft.setToValue(to);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        return etoile;
    }
}
