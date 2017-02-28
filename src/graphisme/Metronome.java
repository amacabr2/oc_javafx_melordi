package graphisme;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Metronome extends Parent {

    private ImageView fondMetronome;
    private ImageView aiguille;

    public Metronome() {

        fondMetronome = new ImageView(new Image(Metronome.class.getResourceAsStream("../images/metronome.png")));
        aiguille = new ImageView(new Image(Metronome.class.getResourceAsStream("../images/aiguille.png")));

        createImg();
        rotation();
    }

    /**
     * Création d'image pour le métronome
     */
    public void createImg() {


        fondMetronome.setFitHeight(40);
        fondMetronome.setPreserveRatio(true);

        aiguille.setFitHeight(32);
        aiguille.setPreserveRatio(true);
        aiguille.setTranslateX(16);
        aiguille.setTranslateY(2);

        this.getChildren().add(fondMetronome);
        this.getChildren().add(aiguille);
        this.setTranslateX(400);
        this.setTranslateY(200);

    }

    /**
     * Gère la rotation de l'aiguille du métronome
     */
    private void rotation() {

        Rotate rotation = new Rotate(0, 3, 29);
        aiguille.getTransforms().add(rotation);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 45)),
                new KeyFrame(new Duration(1000), new KeyValue(rotation.angleProperty(), -45))
        );

        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

}
