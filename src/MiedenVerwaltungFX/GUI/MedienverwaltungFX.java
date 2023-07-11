package MiedenVerwaltungFX.GUI;

import MiedenVerwaltungFX.Datenhaltung.PersistenzException;
import MiedenVerwaltungFX.Fachlogic.Medienverwaltung;
import MiedenVerwaltungFX.Fachlogic.Medium;
import MiedenVerwaltungFX.GUI.GuiUtil.MessageView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class MedienverwaltungFX extends Application {
    private Medienverwaltung mv = new Medienverwaltung();
    private static ListView<String> listView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }


    private MenuBar createMenuBar(Stage primaryStage) {
        MenuBar mb = new MenuBar();
        Menu datei = new Menu("Datei");
        Menu medium = new Menu("Medium");
        Menu anzeige = new Menu("Anzeige");

        MenuItem audioneu = new MenuItem("Audio neu");
        MenuItem bildneu = new MenuItem("Bild neu");

        audioneu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AudioErfassungView audioerfassung = new AudioErfassungView(primaryStage, mv);
                audioerfassung.showView();
                refreshList(true);
            }
        });

        bildneu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BildErfassungView bilderfassung = new BildErfassungView(primaryStage, mv);
                bilderfassung.showView();
                refreshList(true);
            }

        });
        medium.getItems().addAll(audioneu, bildneu);

        MenuItem laden = new MenuItem("Laden");
        laden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mv.laden();
                    refreshList(false);
                    MessageView.create(primaryStage, "Laden", "Liste wurde erfolgreich geladen!").showView();
                } catch (PersistenzException e) {
                    MessageView.create(primaryStage, "Laden", "Liste kann nicht geladen werden, weil die List leer ist!").showView();
                }
            }
        });
        MenuItem speichern = new MenuItem("Speichern");
        speichern.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mv.speichern();
                    MessageView.create(primaryStage, "Speichern", "Liste wurde erfolgreich gespeichert!").showView();
                } catch (PersistenzException e) {
                    MessageView.create(primaryStage, "Laden", "Liste kann nicht gespeichert werden, weil die List leer ist!").showView();
                }
            }
        });
        MenuItem inDatei = new MenuItem("Medienliste in Datei");
        inDatei.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    mv.schreibeListeInDatei();
                    MessageView.create(primaryStage, "Speichern", "Liste wurde erfolgreich gespeichert!").showView();
                } catch (PersistenzException | FileNotFoundException e) {
                    MessageView.create(primaryStage, "Laden", "Liste kann nicht gespeichert werden, weil die List leer ist!").showView();
                }
            }
        });
        MenuItem beenden = new MenuItem("Beenden");
        beenden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        datei.getItems().addAll(laden, speichern, inDatei, new SeparatorMenuItem(), beenden);

        MenuItem erscheinungsjahr = new MenuItem("Erscheinungsjahr");
        erscheinungsjahr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MessageView.create(primaryStage, "Erscheinungsjahr", "Das durchschnittliches Erscheinungsjahr: " + mv.berechneErscheinungsjahr()).showView();
            }
        });
        MenuItem neuestesMedium = new MenuItem("Neuestes Medium");
        neuestesMedium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MessageView.create(primaryStage, "Neuestes Medium", mv.getNeuesMedium()).showView();
            }
        });

        MenuItem zeigeMedien = new MenuItem("Zeige Medien");
        zeigeMedien.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MessageView.create(primaryStage, "Medienliste", mv.zeigeMedien()).showView();

            }
        });

        anzeige.getItems().addAll(erscheinungsjahr, neuestesMedium, zeigeMedien);

        mb.getMenus().addAll(datei, medium, anzeige);

        return mb;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        bp.setTop(createMenuBar(primaryStage));
        bp.setLeft(listView);
        Scene scene = new Scene(bp, 500.0, 400.0);


        listView.prefWidthProperty().bind(scene.widthProperty());


        primaryStage.setTitle("Medienverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private void refreshList(boolean adding) {
        if (!adding) {
            listView.getItems().clear();
        }
        ObservableList<Medium> observableList = FXCollections.observableArrayList();
        Iterator<Medium> it;
        if ((it = mv.iterator()) != null) {
            while (it.hasNext()) {
                observableList.add(it.next());
            }
        }
        if (!observableList.isEmpty()) {
            for (Medium m : observableList) {
                listView.getItems().add(m.toString());
            }
        }
    }


    private static void solution38WithBoxes(Stage stage) {
        HBox mainBox = new HBox();
        listView = new ListView<>();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        List<String> stringList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            stringList.add("This is Item " + i);
        }

        observableList.addAll(stringList);
        listView.getItems().addAll(observableList);


        VBox rightBox = new VBox();


        HBox nameBox = new HBox(10);
        nameBox.setPadding(new Insets(5));
        nameBox.setMinWidth(250);
        Label name = new Label("Name");
        TextField nameInput = new TextField("Username");
        nameBox.getChildren().addAll(name, nameInput);
        HBox.setHgrow(nameInput, Priority.ALWAYS);

        HBox emailBox = new HBox(10);
        emailBox.setPadding(new Insets(5));
        emailBox.setMinWidth(250);
        Label email = new Label("Email");
        TextField emailInput = new TextField("Email");
        emailBox.getChildren().addAll(email, emailInput);
        HBox.setHgrow(emailInput, Priority.ALWAYS);


        HBox passwordBox = new HBox(10);
        passwordBox.setPadding(new Insets(5));
        passwordBox.setMinWidth(250);
        Label password = new Label("Password");
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        passwordBox.getChildren().addAll(password, passwordInput);
        HBox.setHgrow(passwordInput, Priority.ALWAYS);

        HBox buttonBox = new HBox();
        buttonBox.setMinWidth(250);
        Button start = new Button("Start");
        buttonBox.getChildren().add(start);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);


        rightBox.getChildren().addAll(nameBox, emailBox, passwordBox, buttonBox);
        mainBox.getChildren().addAll(listView, rightBox);
        Scene scene = new Scene(mainBox, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.show();
    }


    private static void solution38WithGridPane(Stage stage) {
        ObservableList list = FXCollections.observableArrayList();
        for (int i = 0; i < 50; i++) {
            list.add("This is Item " + i);
        }
        ListView lv = new ListView(list);


        GridPane gp = new GridPane();

        VBox vbox = new VBox(10, lv);
        vbox.setPadding(new Insets(10, 10, 30, 10));

        VBox vbox2 = new VBox(10, new Label("Label 1"), new Label("Label 2"));
        Label l = new Label();

        vbox2.setPadding(new Insets(10));

        VBox vbox3 = new VBox(10, new TextField("TextFiled 0"), new TextField("TextFiled 1"), new TextField("TextFiled 2"));
        vbox3.setPadding(new Insets(10));

        Button b = new Button("Start");

        gp.setPadding(new Insets(10));
        gp.add(vbox, 0, 0);
        gp.add(vbox2, 1, 0);
        gp.add(vbox3, 2, 0);
        gp.add(b, 2, 1);

        Scene scene = new Scene(gp);
        stage.setScene(scene);
        stage.setTitle("GridPaneLayout");
        stage.show();
    }

    private static void createXWithCircleInCenter(Stage stage) {
        Line topLeftToBottomRight = new Line();
        topLeftToBottomRight.setStroke(Color.BLACK);
        topLeftToBottomRight.setStartX(0);
        topLeftToBottomRight.setStartY(0);
        topLeftToBottomRight.setEndX(500);
        topLeftToBottomRight.setEndY(500);

        Line topRightoBottomLeft = new Line();
        topRightoBottomLeft.setStroke(Color.GOLD);
        topRightoBottomLeft.setStartX(0);
        topRightoBottomLeft.setStartY(500);
        topRightoBottomLeft.setEndX(500);
        topRightoBottomLeft.setEndY(0);

        Line centerH = new Line();
        centerH.setStroke(Color.GREEN);
        centerH.setStartX(250);
        centerH.setStartY(0);
        centerH.setEndX(250);
        centerH.setEndY(500);


        Line centerV = new Line();
        centerV.setStroke(Color.RED);
        centerV.setStartX(0);
        centerV.setStartY(250);
        centerV.setEndX(500);
        centerV.setEndY(250);

        Circle circle = new Circle();
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.TURQUOISE);
        circle.setRadius(100);
        circle.setLayoutX(250);
        circle.setLayoutY(250);


        Button click = new Button("Click");

        click.setLayoutX(250);
        click.setLayoutY(250);

        Pane pane = new Pane();
        pane.getChildren().addAll(topLeftToBottomRight, topRightoBottomLeft, centerV, centerH, circle, click);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("GridPaneLayout");
        stage.show();
    }


    private static void solution40(Stage stage) {
        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setFill(Color.GREEN);

        HBox hBox = new HBox();
        Button button = new Button("Farbe wechseln");
        Random random = new Random();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int red = random.nextInt(0, 255);
                int green = random.nextInt(0, 255);
                int blue = random.nextInt(0, 255);
                rectangle.setFill(Color.rgb(red, green, blue));
            }
        });


        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(rectangle);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Farbe-Test");
        stage.show();


    }

    private static void exampleBinding(Stage stage) {
        HBox hBox = new HBox(20);

        VBox left = new VBox(17);
        left.setPadding(new Insets(10));
        Label name = new Label("Name");
        Label cursor = new Label("Cursor-Position");
        Label length = new Label("Länge");
        Label select = new Label("Auswahl");
        Label text = new Label("Text");
        left.getChildren().addAll(name, cursor, length, select, text);

        VBox right = new VBox(15);
        right.setPadding(new Insets(10));
        TextField nameInput = new TextField();

        Label cursorResult = new Label();
        Label lengthResult = new Label();
        Label selectResult = new Label();
        Label textResult = new Label();

        textResult.textProperty().bind(nameInput.textProperty());
        cursorResult.textProperty().bind(nameInput.caretPositionProperty().asString());
        lengthResult.textProperty().bind(nameInput.lengthProperty().asString());
        selectResult.textProperty().bind(nameInput.selectedTextProperty());

        right.getChildren().addAll(nameInput, cursorResult, lengthResult, selectResult, textResult);


        hBox.getChildren().addAll(left, right);
        Scene scene = new Scene(hBox, 350, 250);


        stage.setTitle("Binding Example");
        stage.setScene(scene);
        stage.show();
    }


}