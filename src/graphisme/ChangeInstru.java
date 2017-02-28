package graphisme;

import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChangeInstru extends Parent {

    private GridPane gridpane;
    private RadioButton rbPiano;
    private RadioButton rbGuitare;
    private RadioButton rbOrgue;

    public ChangeInstru() {

        gridpane = new GridPane();

        createImg();
        createBtn();

        setTranslateX(100);
        setTranslateY(30);

        getChildren().add(gridpane);

    }

    /**
     * Insert les images
     */
    private void createImg() {

        ImageView piano = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("../images/piano.png")));
        piano.setFitHeight(50);
        piano.setPreserveRatio(true);

        ImageView guitare = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("../images/guitare.png")));
        guitare.setFitHeight(50);
        guitare.setPreserveRatio(true);

        ImageView orgue = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("../images/orgue.png")));
        orgue.setFitHeight(50);
        orgue.setPreserveRatio(true);

        gridpane.add(piano, 1, 0);
        gridpane.add(guitare, 1, 1);
        gridpane.add(orgue, 1, 2);
        gridpane.setVgap(15);

    }

    /**
     * Création des radio button
     */
    private void createBtn() {

        ToggleGroup groupe = new ToggleGroup();

        rbPiano = new RadioButton();
        rbGuitare = new RadioButton();
        rbOrgue = new RadioButton();

        rbPiano.setToggleGroup(groupe);
        rbGuitare.setToggleGroup(groupe);
        rbOrgue.setToggleGroup(groupe);

        rbPiano.setFocusTraversable(false);
        rbGuitare.setFocusTraversable(false);
        rbOrgue.setFocusTraversable(false);
        rbPiano.setSelected(true);

        gridpane.add(rbPiano, 0, 0);
        gridpane.add(rbGuitare, 0, 1);
        gridpane.add(rbOrgue, 0, 2);
        gridpane.setHgap(20);

    }

}
