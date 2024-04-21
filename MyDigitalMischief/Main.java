package com.example.mydigitalmischief;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader
        // (Main.class.getResource("hello-view.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        GridPane pane = new GridPane();
        // pane.setAlignment(Pos.CENTER);
        Label WelcomeText = new Label("Welcome to My Digital Mischief!");
        pane.add(WelcomeText, 0, 0);
        Button start = new Button("Generate a Rat");
        pane.add(start, 0, 1);
        Label name = new Label("Rat Name: ");
        pane.add(name, 0, 2);
        Label gender = new Label("Rat Gender: ");
        pane.add(gender, 0, 3);
        Label color = new Label("Rat Color: ");
        pane.add(color, 0, 4);
        Label eyeColor = new Label("Rat Eye Color: ");
        pane.add(eyeColor, 0, 5);
        Label dumbo = new Label("Dumbo: ");
        pane.add(dumbo, 0, 6);
        Label albino = new Label("Albino: ");
        pane.add(albino, 0, 7);
        Label rex = new Label("Rex: ");
        pane.add(rex, 0, 8);
        Label hairless = new Label("Hairless: ");
        pane.add(hairless, 0, 9);
        Button begin = new Button("Adopt a Rat");
        pane.add(begin, 0, 10);
        EventHandler<ActionEvent> makeRat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Rat rat = new Rat();
                String text = rat.generateNewDNA();
                WelcomeText.setText(text);
                name.setText("Rat Name: " + rat.getName());
                gender.setText("Gender: " + rat.getGender());
                color.setText("Main Color: " + rat.getColor());
                eyeColor.setText("Rat Eye Color: " + rat.getEyeColor());
                dumbo.setText("Dumbo: " + rat.getDumbo());
                albino.setText("Albino: " + rat.getAlbino());
                rex.setText("Rex: " + rat.getRex());
                hairless.setText("Hairless: " + rat.getHairless());
            }
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

        Scene startPage = new Scene(pane);
        CurrentScreen current = new CurrentScreen(startPage);
        stage.setTitle("Welcome");
        stage.setScene(current.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
