package com.example.mydigitalmischief;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FoodBowl extends Material {
    public int fullness; // number 0 to 3 for how full it is. 0 = empty, 1 = low, 2 = high, and 3 = full

    public FoodBowl() {
        this.fullness = 3;
        this.colorHex = "#5A1717";
        this.color = "dark red";
    }

    // Constructor to create a FoodBowl with a specific fullness level.
    public FoodBowl(int fullness) {
        this.fullness = fullness;
        this.colorHex = "#5A1717";
        this.color = "dark red";
    }

    // Constructor included for future development. Currently, there is only one possible color.
    public FoodBowl(int fullness, String colorHex, String color) {
        this.fullness = fullness;
        this.colorHex = colorHex;
        this.color = color;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public int getFullness() {
        return fullness;
    }

    public void fill() {
        this.fullness = 3;
    }

    public ImageView generateImage() {
        String filePath = "C:\\Users\\fishs\\IdeaProjects\\MyDigitalMischief\\";
        String fileName = switch (fullness) {
            case 0 -> "foodempty.png";
            case 1 -> "foodlow.png";
            case 2 -> "foodhigh.png";
            default -> "foodfull.png";
        };
        Image bowl = new Image(filePath + fileName);
        ImageView bowlImageView = new ImageView(bowl);
        Main.shrink(bowlImageView, 5);
        return bowlImageView;
    }
}
