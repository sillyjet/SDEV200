package com.example.mydigitalmischief;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WaterBottle extends Material {
    public int fullness; // number 0 to 3 for how full it is. 0 = empty, 1 = low, 2 = high, and 3 = full

    public WaterBottle() {
        this.fullness = 3;
        this.colorHex = "8AA9FF";
        this.color = "light blue";
    }

    public WaterBottle(int fullness) {
        this.fullness = fullness;
        this.colorHex = "8AA9FF";
        this.color = "light blue";
    }

    // Constructor included for future development. Currently, there is only one possible color.
    public WaterBottle(int fullness, String colorHex, String color) {
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
            case 0 -> "waterempty.png";
            case 1 -> "waterlow.png";
            case 2 -> "waterhigh.png";
            default -> "waterfull.png";
        };
        Image bottle = new Image(filePath + fileName);
        ImageView bottleImageView = new ImageView(bottle);
        Main.shrink(bottleImageView, 5);
        return bottleImageView;
    }

    @Override
    public void setImage() {
        super.setImage();
    }
}
