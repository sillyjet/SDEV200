package com.example.mydigitalmischief;

import javafx.scene.image.ImageView;

public abstract class Material {
    public ImageView image;
    public String colorHex; // hexadecimal string for color. This is included for future development.
    public String color; // name of color, included for future development.

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getColorHex() {
        return colorHex;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage() {
    }
}
