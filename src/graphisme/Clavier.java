package graphisme;

import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Clavier extends Parent{

    private Touche[] touches;

    public Clavier(){

        Rectangle fondClavier = new Rectangle();
        fondClavier.setWidth(400);
        fondClavier.setHeight(200);
        fondClavier.setArcWidth(30);
        fondClavier.setArcHeight(30);
        fondClavier.setFill(Color.BLACK);
        fondClavier.setFill(
                new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#333333")),
                        new Stop(1, Color.web("#000000")))
        );

        Reflection r = new Reflection();//on applique un effet de réflection
        r.setFraction(0.25);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        fondClavier.setEffect(r);

        touches = new Touche[]{
                new Touche("U",50,20,60),
                new Touche("I",128,20,62),
                new Touche("O",206,20,64),
                new Touche("P",284,20,65),
                new Touche("J",75,98,67),
                new Touche("K",153,98,69),
                new Touche("L",231,98,71),
                new Touche("M",309,98,72)
        };

        this.setTranslateX(50);
        this.setTranslateY(250);
        this.getChildren().add(fondClavier);
        for (Touche touche: touches) {
            getChildren().add(touche);
        }

    }


}
