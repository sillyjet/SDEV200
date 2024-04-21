package com.example.mydigitalmischief;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Material> items;
    public int numberOfItems = items.size();

    public Inventory() {

    }

    public void addItem(Material m) {
        items.add(m);
    }

    public void removeItem(Material m) {
        items.remove(m);
    }
}
