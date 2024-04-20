package com.example.displayimagesjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(50, 50, 50, 50));
        pane.setHgap(100);
        pane.setVgap(100);

        Image blaze = new Image("C:\\Users\\fishs\\IdeaProjects\\DisplayImagesJavaFX\\blaze.jpg");
        ImageView v1 = new ImageView(blaze);
        AddImage(v1, pane, 90, 10, 0, 0);

        Image phantom = new Image("C:\\Users\\fishs\\IdeaProjects\\DisplayImagesJavaFX\\phantom.jpg");
        ImageView v2 = new ImageView(phantom);
        AddImage(v2, pane, 0, 10, 1, 0);

        Image milo = new Image("C:\\Users\\fishs\\IdeaProjects\\DisplayImagesJavaFX\\milo.jpg");
        ImageView v3 = new ImageView(milo);
        AddImage(v3, pane, 0, 10, 0, 1);

        Image tornado = new Image("C:\\Users\\fishs\\IdeaProjects\\DisplayImagesJavaFX\\tornado.jpg");
        ImageView v4 = new ImageView(tornado);
        AddImage(v4, pane, 90, 10, 1, 1);

        Scene scene = new Scene(pane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void shrink(ImageView v, int i) {
        v.setFitWidth(v.getImage().getWidth() / i);
        v.setFitHeight(v.getImage().getHeight() / i);
    }

    public static void AddImage(ImageView v, GridPane pane, int r, int i, int col, int row) {
        shrink(v, i);
        v.setRotate(r);
        pane.add(v, col, row);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
