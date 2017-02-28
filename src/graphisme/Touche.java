package graphisme;

import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import moteur.Instru;

public class Touche extends Parent {


    public String lettre;
    private int positionX = 0;
    private int positionY = 0;
    private int note = 0;
    private Instru instru;

    Rectangle fondTouche = new Rectangle(75, 75, Color.WHITE);
    Text lettreTouche = new Text();

    public Touche(String l, int posX, int posY, int n, Instru instru) {

        lettre = l;
        positionX = posX;
        positionY = posY;
        note = n;
        this.instru = instru;

        fondTouche = new Rectangle(75,75, Color.WHITE);
        fondTouche.setArcHeight(10);
        fondTouche.setArcWidth(10);
        this.getChildren().add(fondTouche);//ajout du rectangle de fond de la touche

        lettreTouche = new Text(lettre);
        lettreTouche.setFont(new Font(25));
        lettreTouche.setFill(Color.GREY);
        lettreTouche.setX(25);
        lettreTouche.setY(45);

        this.getChildren().add(lettreTouche);//ajout de la lettre de la touche
        this.setTranslateX(positionX);//positionnement de la touche sur le clavier
        this.setTranslateY(positionY);

        Light.Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        Lighting li = new Lighting();
        li.setLight(light);
        fondTouche.setEffect(li);

        this.setOnMouseEntered(me -> fondTouche.setFill(Color.LIGHTGREY));
        this.setOnMouseExited(me -> fondTouche.setFill(Color.WHITE));
        this.setOnMousePressed(me -> appuyer());
        this.setOnMouseReleased(me -> relacher());

    }

    /**
     * L'utilisateur clique sur une touche
     */
    public void appuyer() {
        fondTouche.setFill(Color.DARKGRAY);
        lettreTouche.setFill(Color.WHITE);
        this.setTranslateY(positionY + 2);
        instru.noteOn(note);
    }

    /**
     * L'utilisateur relache son clic
     */
    public void relacher() {
        fondTouche.setFill(Color.WHITE);
        lettreTouche.setFill(Color.GRAY);
        this.setTranslateY(positionY);
        instru.noteOff(note);
    }

}
