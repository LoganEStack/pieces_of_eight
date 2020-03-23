package com.piecesofeight.core;

import java.util.*;

public class Game {

    public static void main(String []args){
        Location mainDeck = new Location("Main Deck", "This is the Main Deck.");
        Location gunDeck = new Location("Gun Deck", "This is the Gun Deck.");
        Location cargoHold = new Location("Cargo Hold", "This is the Cargo Hold.");
        Location gallery = new Location("Gallery", "This is the Gallery.");
        Location crowsNest = new Location("Crow's Nest", "This is the Crow's Nest.");
        Location brig = new Location("Brig", "This is the Brig.");

        Player player = new Player();

        Scanner in = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("quit")) {
            input = in.nextLine();
            while (player.handleAction(input.toLowerCase()) == 1 && !input.equalsIgnoreCase("quit")) {
                player.handleAction(in.nextLine());
            }
        }
    }
}

