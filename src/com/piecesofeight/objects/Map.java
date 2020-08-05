package com.piecesofeight.objects;

public class Map extends GameObject {

    public Map(String name, String[] adjectives, int health, String destructionSentence) {
        super(name, adjectives, health, destructionSentence);

    }

    public void printMap(String location) {
        System.out.println("_________________");
        System.out.println("|       |       |");
        switch (location) {
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
        switch (location) {
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
