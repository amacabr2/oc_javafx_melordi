import graphisme.ChangeInstru;
import graphisme.Clavier;
import graphisme.Metronome;
import graphisme.Son;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import moteur.Instru;

public class Melordi extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        primaryStage.setTitle("Melordi");
        primaryStage.setScene(new Scene(root, 500, 500, Paint.valueOf(String.valueOf(Color.WHITE))));

        Instru instru = new Instru();
        Clavier clavier = new Clavier(instru);
        ChangeInstru changeInstru = new ChangeInstru(instru);
        Son son = new Son(clavier);
        Metronome metronome = new Metronome();

        root.getChildren().add(clavier);
        root.getChildren().add(changeInstru);
        root.getChildren().add(son);
        root.getChildren().add(metronome);

        primaryStage.show();
        clavier.requestFocus();
        instru.volume.bind(son.slider.valueProperty());

    }

    public static void main(String[] args) {
        launch(args);
    }

}
