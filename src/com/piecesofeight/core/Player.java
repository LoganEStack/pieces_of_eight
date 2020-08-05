package com.piecesofeight.core;

import com.piecesofeight.parser.Parser;

import java.util.ArrayList;

//Singleton class
public class Player {
    private static Player player_instance = null;

    private String currentLocation;
    private int health;
    private int noiseLevel;
    private ArrayList<String> inventory = new ArrayList<String>();
    //Parser parser = new Parser();

    // private constructor restricted to this class itself
    private Player()
    {
        currentLocation = "unset";
        health = 100;
        noiseLevel = 0;
    }

    // static method to create instance of Singleton class
    public static Player getInstance()
    {
        if (player_instance == null)
            player_instance = new Player();

        return player_instance;
    }

    public void setLocation(String location) { this.currentLocation = location; }

    public String getLocation() { return currentLocation; }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void removeFromInventory(String item) { inventory.remove(item); }

    public void getInventory() {
        System.out.println(inventory);
    }

    int handleAction(String command) {
        Parser parser = new Parser(command);
        return (parser.run() == 0) ? 0 : 1;
    }
}
