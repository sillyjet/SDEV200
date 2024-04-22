package com.example.colorchange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class ColorChange extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane pane = new GridPane();
        pane.setMinHeight(500);
        pane.setMinWidth(500);
        pane.setAlignment(Pos.CENTER);
        BackgroundFill bgFill = new BackgroundFill(Color.valueOf("#EEEEEE"), new CornerRadii(10), new Insets(10));
        Background bg = new Background(bgFill);
        pane.setBackground(bg);
        Circle circle = new Circle(100);
        circle.setFill(Color.rgb(255, 255, 255));
        pane.getChildren().add(circle);
        circle.setOnMousePressed(e -> {circle.setFill(Color.rgb(0, 0, 0));});
        circle.setOnMouseReleased(e -> {circle.setFill(Color.rgb(255, 255, 255));});
        Scene scene = new Scene(pane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
