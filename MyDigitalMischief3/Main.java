package com.example.mydigitalmischief;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {
    static AtomicReference<String> dialogue = new AtomicReference<>("Welcome to My Digital Mischief!");


    @Override
    public void start(Stage stage) throws IOException {
        Mischief myMischief = new Mischief();
        BorderPane pane = new BorderPane();
        Label WelcomeText = new Label(dialogue.get());
        pane.setTop(WelcomeText);
        Button start = new Button("Generate a Rat");
        pane.setLeft(start);
        EventHandler<ActionEvent> makeRat = e -> {
            Rat rat = new Rat();
            myMischief.setQuestion(rat);
            dialogue.set("Gender: " + rat.getGender());
            WelcomeText.setText(dialogue.get());
            pane.setCenter(rat.generateImage(rat.imageCode()));
            Button begin = new Button("Adopt this Rat");
            pane.setBottom(begin);
            EventHandler<ActionEvent> startGame = eee -> {
                myMischief.adoptRat();
                GridPane namePane = new GridPane();
                Label prompt = new Label("Give your rat a name:");
                TextField entry = new TextField();
                Button submit = new Button("Submit");
                namePane.add(prompt, 1, 0);
                namePane.add(entry, 1, 1);
                namePane.add(submit, 1, 2);
                Scene nameScene = new Scene(namePane, 500, 500);
                stage.setScene(nameScene);

                EventHandler<ActionEvent> NAME = EE -> {
                    myMischief.myRat1.setName(entry.getText());
                    GridPane cagePane = new GridPane();
                    StackPane cageImage = new StackPane();
                    Scene cageScene = new Scene(cagePane, 500, 500);
                    stage.setScene(cageScene);
                    Cage cage = new Cage();
                    cagePane.add(cage.generateCageBack(), 1, 1);
                    StackPane ratPic = myMischief.myRat1.getImage();
                    cagePane.add(ratPic, 1, 1);
                    FoodBowl foodBowl = new FoodBowl();
                    cagePane.add(foodBowl.generateImage(), 1, 1);
                    cagePane.add(cage.generateCageFront(), 1, 1);
                    WaterBottle waterBottle = new WaterBottle();
                    cagePane.add(waterBottle.generateImage(), 1, 1);
                    Label ratName = new Label(myMischief.myRat1.getName());
                    cagePane.add(ratName, 1, 2);
                };
                submit.setOnAction(NAME);
            };
            begin.setOnAction(startGame);
        };

        start.setOnAction(makeRat);

        Scene startPage = new Scene(pane, 500, 500);
        stage.setTitle("My Digital Mischief");
        stage.setScene(startPage);
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