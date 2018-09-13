import Objets.Maison;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

        Group root = new Group(
                fond(),
                maison,
                maison1,
                texte(),
                lune());

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

        Circle lune = new Circle(750, 50, 30);
        lune.setFill(lg);

        return lune;
    }
}
