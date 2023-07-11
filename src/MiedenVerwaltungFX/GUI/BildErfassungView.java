package MiedenVerwaltungFX.GUI;


import MiedenVerwaltungFX.Fachlogic.Bild;
import MiedenVerwaltungFX.Fachlogic.Medienverwaltung;
import MiedenVerwaltungFX.GUI.GuiUtil.ModalStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class BildErfassungView extends ModalStage {

    private final Bild bild = new Bild();

    private final TextField tf_titel = new TextField();
    private final TextField tf_ort = new TextField();
    private final TextField tf_aufnahmejahr = new TextField();

    private Medienverwaltung mv;

    public BildErfassungView(Stage primaryStage,Medienverwaltung mv) {
        super(primaryStage);
        this.mv = mv;
    }

    public void showView() {
        setTitle("Bilderfassung");
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10.0));
        gp.setHgap(5.0);
        gp.setVgap(10.0);

        Label titelLabel = new Label("Titel:");
        GridPane.setHalignment(titelLabel, HPos.RIGHT);
        GridPane.setHgrow(tf_titel, Priority.ALWAYS);
        gp.addRow(1, titelLabel, tf_titel);

        Label ortLabel = new Label("Ort:");
        GridPane.setHalignment(ortLabel, HPos.RIGHT);
        gp.addRow(2, ortLabel, tf_ort);

        Label jahrLabel = new Label("Aufnahmejahr:");
        GridPane.setHalignment(jahrLabel, HPos.RIGHT);
        gp.addRow(3, jahrLabel, tf_aufnahmejahr);
        bp.setCenter(gp);

        FlowPane fp = new FlowPane();
        fp.setAlignment(Pos.CENTER);
        fp.setPadding(new Insets(20.0));
        fp.setHgap(20.0);

        Button neu = new Button("Neu");
        Button abbrechen = new Button("Abbrechen");
        abbrechen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                close();
            }
        });

        fp.getChildren().addAll(neu, abbrechen);

        neu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                save();
                close();
            }

        });

        bp.setBottom(fp);

        Scene scene = new Scene(bp);
        setScene(scene);

        show();
    }

    private void save() {

        try {
            String titel = tf_titel.getText();
            bild.setTitel(titel);
            String ort = tf_ort.getText();
            bild.setOrt(ort);
            int jahr = Integer.parseInt(tf_aufnahmejahr.getText());
            bild.setJahr(jahr);
            this.mv.aufnehmen(bild);
            System.out.println("LOGGING: added new Bild: " + bild);

        } catch (NumberFormatException a) {
            close();
        }
    }


}
