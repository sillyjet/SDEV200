package com.example.mydigitalmischief;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cage extends Material {
    public int max; // This is the max amount of rats the cage can house.
    public int doors; // This is the number of doors the cage has.
    public int levels; // This is the number of levels the cage has.

    // This is a constructor for a basic cage. Currently, this is the only cage configuration possible.
    public Cage() {
        this.max = 2;
        this.doors = 1;
        this.levels = 3;
    }

    // This constructor is included for the possibility of future development. Currently, there is only one possible configuration.
    public Cage(int max, int doors, int levels) {
        this.max = max;
        this.doors = doors;
        this.levels = levels;
    }

    public StackPane generateCageBack() {
        int i = 5;
        StackPane imagePane = new StackPane();
        String filePath = "C:\\Users\\fishs\\IdeaProjects\\MyDigitalMischief\\";
        Image back = new Image(filePath + "cageback.png");
        ImageView backImageView = new ImageView(back);
        Main.shrink(backImageView, i);
        imagePane.getChildren().add(backImageView);
        Image mid = new Image(filePath + "cagemid.png");
        ImageView midImageView = new ImageView(mid);
        Main.shrink(midImageView, i);
        imagePane.getChildren().add(midImageView);

        return imagePane;
    }

    public StackPane generateCageFront() {
        int i = 5;
        StackPane imagePane = new StackPane();
        String filePath = "C:\\Users\\fishs\\IdeaProjects\\MyDigitalMischief\\";
        Image front = new Image(filePath + "cagefront.png");
        ImageView frontImageView = new ImageView(front);
        Main.shrink(frontImageView, i);
        imagePane.getChildren().add(frontImageView);
        Image door = new Image(filePath + "doorclose.png");
        ImageView doorImageView = new ImageView(door);
        Main.shrink(doorImageView, i);
        imagePane.getChildren().add(doorImageView);
        return imagePane;
    }
}
