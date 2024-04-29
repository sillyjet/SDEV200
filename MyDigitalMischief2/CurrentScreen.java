package com.example.mydigitalmischief;

import javafx.scene.Scene;

public class CurrentScreen {
    public Scene scene;

    public CurrentScreen(Scene scene) {
        this.scene = scene;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
