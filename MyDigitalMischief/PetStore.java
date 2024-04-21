package com.example.mydigitalmischief;

import java.util.ArrayList;
import java.util.Random;

public class PetStore {
    public ArrayList<Rat> rats = new ArrayList<Rat>(6);
    public int numberOfRats;

    public PetStore() {
        Random rand = new Random();
        int max = rand.nextInt(7);
        for (int i = 0; i <= max; i++) {
            rats.set(i, new Rat());
        }
    }

    public int getSize() {
        return numberOfRats;
    }

    public ArrayList<Rat> getList() {
        return rats;
    }

    public Rat getRat(int i) {
        return rats.get(i);
    }
}
