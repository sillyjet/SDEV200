package com.example.mydigitalmischief;

import java.util.ArrayList;

public class Mischief {
    public ArrayList<Rat> rats;
    public int numberOfRats = rats.size();

    public Mischief() {
    }

    public void adoptRat(Rat e) {
        rats.add(e);
    }
}