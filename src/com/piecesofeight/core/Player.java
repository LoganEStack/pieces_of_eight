package com.piecesofeight.core;

import com.piecesofeight.parser.Parser;

import java.util.ArrayList;

public class Player {
    String location;
    int health = 150;
    int noise = 0;
    ArrayList<String> inventory = new ArrayList<String>();
    //Parser parser = new Parser();

    private void setLocation(String location) { this.location = location; }

    String getLocation() { return location; }

    private void addToInventory(String item) {
        inventory.add(item);
    }

    private void getInventory() {
        System.out.println(inventory);
    }

    int handleAction(String command) {
        //String[] parsedCommand = parser.parseAction(command);
            String[] parsedCommand = {};
        switch (parsedCommand[0]) {
            case "move":
                System.out.println(parsedCommand[1]);
                setLocation(parsedCommand[1]);
                break;
            case "look":
                System.out.println(getLocation());
                return 1;
            case "run":
                break;
            case "listen":
                break;
            case "speak":
                break;
            case "climb":
                break;
            case "sneak":
                break;
            case "take":
                addToInventory("Rock");
                break;
            case "inventory":
                getInventory();
                break;
            case "throw":
                break;
            case "attack":
                break;
            case "quit":
                break;
            case "help":
                System.out.println("List of available actions:");
                System.out.printf("%-15.15s  %-15.15s%n", "move", "look");
                System.out.printf("%-15.15s  %-15.15s%n", "run", "climb");
                System.out.printf("%-15.15s  %-15.15s%n", "listen", "speak");
                System.out.printf("%-15.15s  %-15.15s%n", "sneak", "take");
                System.out.printf("%-15.15s  %-15.15s%n", "inventory", "throw");
                System.out.printf("%-15.15s  %-15.15s%n", "attack", "help");
                System.out.printf("quit\n");

                return 1;
            default:
                System.out.println("Action unrecognized. Type 'help' for list of available actions.");
                return 1;
        }
        return 0;
    }
}
