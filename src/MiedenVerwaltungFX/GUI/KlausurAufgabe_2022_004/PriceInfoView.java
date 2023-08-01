package MiedenVerwaltungFX.GUI.KlausurAufgabe_2022_004;

import AlteKlausuren.Klausur_14_02_2022.Aufgabe_002.Car;
import MiedenVerwaltungFX.GUI.GuiUtil.ModalStage;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PriceInfoView extends ModalStage {
    private Car car;

    public PriceInfoView(Stage primaryStage, Car car) {
        super(primaryStage);
        initOwner(primaryStage);
        initModality(Modality.WINDOW_MODAL);
        this.car = car;
    }




}
