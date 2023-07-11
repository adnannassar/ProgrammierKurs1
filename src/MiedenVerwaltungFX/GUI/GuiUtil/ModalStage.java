package MiedenVerwaltungFX.GUI.GuiUtil;

import javafx.stage.Modality;
import javafx.stage.Stage;


public abstract class ModalStage extends Stage{
   public ModalStage(Stage primaryStage){
       super();
       super.initOwner(primaryStage);
       super.initModality(Modality.WINDOW_MODAL);
   }
}
