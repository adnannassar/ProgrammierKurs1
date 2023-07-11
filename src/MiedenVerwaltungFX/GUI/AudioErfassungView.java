package MiedenVerwaltungFX.GUI;


import MiedenVerwaltungFX.Fachlogic.Audio;
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


public class AudioErfassungView extends ModalStage {

    private final Audio audio = new Audio();
    private final TextField tf_titel = new TextField();
    private final TextField tf_interpret = new TextField();
    private final TextField tf_erscheinungsjahr = new TextField();
    private final TextField tf_dauer = new TextField();

    private Medienverwaltung mv;


    public AudioErfassungView(Stage primaryStage, Medienverwaltung mv) {
        super(primaryStage);
        this.mv = mv;
    }

    public void showView() {
        setTitle("Audioerfassung");
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10.0));
        gp.setHgap(5.0);
        gp.setVgap(10.0);


        Label titelLabel = new Label("Titel:");
        GridPane.setHalignment(titelLabel, HPos.RIGHT);
        GridPane.setHgrow(tf_titel, Priority.ALWAYS);
        gp.addRow(1, titelLabel, tf_titel);

        Label interpretLabel = new Label("Interpret:");
        GridPane.setHalignment(interpretLabel, HPos.RIGHT);
        gp.addRow(2, interpretLabel, tf_interpret);

        Label jahrLabel = new Label("Erscheinungsjahr:");
        GridPane.setHalignment(jahrLabel, HPos.RIGHT);
        gp.addRow(3, jahrLabel, tf_erscheinungsjahr);
        bp.setCenter(gp);

        Label dauerLabel = new Label("Dauer:");
        GridPane.setHalignment(dauerLabel, HPos.RIGHT);
        gp.addRow(4, dauerLabel, tf_dauer);
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

        this.setScene(scene);

        this.show();
    }

    private void save() {
        try {
            String titel = tf_titel.getText();
            audio.setTitel(titel);
            String interpret = tf_interpret.getText();
            audio.setInterpret(interpret);
            int jahr = Integer.parseInt(tf_erscheinungsjahr.getText());
            audio.setJahr(jahr);
            int dauer = Integer.parseInt(tf_dauer.getText());
            audio.setDauer(dauer);
            mv.aufnehmen(audio);
            System.out.println("LOGGING: added new Audio: " + audio);
        } catch (NumberFormatException a) {
            close();
        }
    }


}
