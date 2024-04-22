package com.example.scrollbar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class UseScrollBar extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane pane = new GridPane();
        pane.setMinWidth(300);
        pane.setMinHeight(300);
        pane.setAlignment(Pos.CENTER);
        BackgroundFill bgFill = new BackgroundFill(Color.valueOf("#EEEEEE"), new CornerRadii(10), new Insets(10));
        Background bg = new Background(bgFill);
        pane.setBackground(bg);
        Text text = new Text("Show Colors");
        ScrollBar red = new ScrollBar();
        ScrollBar green = new ScrollBar();
        ScrollBar blue = new ScrollBar();
        ScrollBar opacity = new ScrollBar();
        red.setMin(0);
        red.setMax(255);
        green.setMin(0);
        green.setMax(255);
        blue.setMin(0);
        blue.setMax(255);
        opacity.setMin(0);
        opacity.setMax(255);
        opacity.setValue(255);
        Label RED = new Label("Red");
        Label GREEN = new Label("Green");
        Label BLUE = new Label("Blue");
        Label OPACITY = new Label("Opacity");
        pane.add(text, 1, 0);
        pane.add(RED, 0, 1);
        pane.add(GREEN, 0, 2);
        pane.add(BLUE, 0, 3);
        pane.add(OPACITY, 0, 4);
        pane.add(red, 1, 1);
        pane.add(green, 1, 2);
        pane.add(blue, 1, 3);
        pane.add(opacity, 1, 4);

        AtomicInteger r = new AtomicInteger();
        AtomicInteger g = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        AtomicInteger o = new AtomicInteger(255);
        red.valueProperty().addListener((observable, oldValue, newValue) -> {
            r.set((int) red.getValue());
            text.setFill(Color.rgb(r.intValue(), g.intValue(), b.intValue(), o.doubleValue() / 255d));
        });
        green.valueProperty().addListener((observable, oldValue, newValue) -> {
            g.set((int) green.getValue());
            text.setFill(Color.rgb(r.intValue(), g.intValue(), b.intValue(), o.doubleValue() / 255d));
        });
        blue.valueProperty().addListener((observable, oldValue, newValue) -> {
            b.set((int) blue.getValue());
            text.setFill(Color.rgb(r.intValue(), g.intValue(), b.intValue(), o.doubleValue() / 255d));
        });
        opacity.valueProperty().addListener((observable, oldValue, newValue) -> {
            o.set((int) opacity.getValue());
            text.setFill(Color.rgb(r.intValue(), g.intValue(), b.intValue(), o.doubleValue() / 255d));
        });

        Scene scene = new Scene(pane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
