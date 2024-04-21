package com.example.mydigitalmischief;

public class Cage extends Material {
    public int max;
    public int doors;
    public int levels;

    public Cage() {
        this.max = 3;
        this.doors = 1;
        this.levels = 2;
    }

    public Cage(int max, int doors, int levels) {
        this.max = max;
        this.doors = doors;
        this.levels = levels;
    }
}
