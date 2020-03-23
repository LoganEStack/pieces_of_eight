package com.piecesofeight.core;

public class Location {
    private String name;
    private String description;
    private String itemList;

    public Location(String enteredName, String enteredDescription) {
        name = enteredName;
        description = enteredDescription;
    }

    void setName(String name) { this.name = name; }

    String getName() { return "You have entered the " + name + "."; }

    void setDescription(String description) { this.description = description; }

    String getDescription() { return description; }

    void setItemList(String itemList) { this.itemList = itemList; }

    String getItemList() { return "In the room, you see " + itemList + "."; }

    void printMap() {
        System.out.println("_________________");
        System.out.println("|       |       |");
        switch (name) {
            case "Main Deck":
                System.out.println("|   x   |       |");
                break;
            case "Gun Deck":
                System.out.println("|       |   x   |");
                break;
            default:
                System.out.println("|       |       |");
        }
        System.out.println("|_______|_______|");
        System.out.println("|       |       |");
        switch (name) {
            case "Cargo Hold":
                System.out.println("|   x   |       |");
                break;
            case "Gallery":
                System.out.println("|       |   x   |");
                break;
            default:
                System.out.println("|       |       |");
        }
        System.out.println("|       |       |");
        System.out.println("=================");
    }
}
