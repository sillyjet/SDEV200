package com.example.mydigitalmischief;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        // pane.setAlignment(Pos.CENTER);
        Label WelcomeText = new Label("Welcome to My Digital Mischief!");
        pane.setTop(WelcomeText);
        Button start = new Button("Generate a Rat");
        pane.setLeft(start);
        Button begin = new Button("Adopt a Rat");
        pane.setBottom(begin);
        EventHandler<ActionEvent> makeRat = e -> {
            Rat rat = new Rat();
            WelcomeText.setText("DNA: " + rat.getDNA() + " | imageCode: " + rat.imageCode());
            StackPane ratImage = rat.generateImage(rat.imageCode());
            pane.setCenter(ratImage);
        };
        GridPane storePane = new GridPane();
        Label header = new Label("Welcome to the Pet Store!");
        storePane.add(header, 0, 0);
        Label header2 = new Label("Pick one or more rats to adopt:");
        storePane.add(header2, 0, 1);
        Label rat1 = new Label("empty");
        storePane.add(rat1, 0, 2);
        Button adoptRat1 = new Button("Adopt");
        storePane.add(adoptRat1, 1, 2);
        Label rat2 = new Label("empty");
        storePane.add(rat2, 0, 3);
        Button adoptRat2 = new Button("Adopt");
        storePane.add(adoptRat2, 1, 3);
        Label rat3 = new Label("empty");
        storePane.add(rat3, 0, 4);
        Button adoptRat3 = new Button("Adopt");
        storePane.add(adoptRat3, 1, 4);
        Label rat4 = new Label("empty");
        storePane.add(rat4, 0, 5);
        Button adoptRat4 = new Button("Adopt");
        storePane.add(adoptRat4, 1, 5);
        Label rat5 = new Label("empty");
        storePane.add(rat5, 0, 6);
        Button adoptRat5 = new Button("Adopt");
        storePane.add(adoptRat5, 1, 6);
        Label rat6 = new Label("empty");
        storePane.add(rat6, 0, 7);
        Button adoptRat6 = new Button("Adopt");
        storePane.add(adoptRat6, 1, 7);
        Scene storePage = new Scene(storePane);
        EventHandler<ActionEvent> initiate = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(storePage);
                PetStore store = new PetStore();
                Mischief myMischief = new Mischief();
                Inventory myInventory = new Inventory();
                Cage myCage = new Cage();
                rat1.setText(store.getRat(0).getGender());
                rat2.setText(store.getRat(1).getGender());
            }
        };
        start.setOnAction(makeRat);
        begin.setOnAction(initiate);

        Scene startPage = new Scene(pane, 500, 500);
        CurrentScreen current = new CurrentScreen(startPage);
        stage.setTitle("Welcome");
        stage.setScene(current.getScene());
        stage.show();
    }

    public static void shrink(ImageView v, int i) {
        v.setFitWidth(v.getImage().getWidth() / i);
        v.setFitHeight(v.getImage().getHeight() / i);
    }

    public static void main(String[] args) {
        launch();
    }
}
