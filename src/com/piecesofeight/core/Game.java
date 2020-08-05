package com.piecesofeight.core;

import com.piecesofeight.objects.GameObjectHandler;

import java.util.*;

public class Game {

    public static void main(String []args) {
        Player player = Player.getInstance();
        Scanner in = new Scanner(System.in);
        String input = "";

        Location mainDeck = new Location("Main Deck", "This is the Main Deck.",
                new ArrayList<String>(Arrays.asList("rope", "bucket", "canon")));
        Location gunDeck = new Location("Gun Deck", "This is the Gun Deck.",
                new ArrayList<String>(Arrays.asList("gun", "chair", "table")));
        Location cargoHold = new Location("Cargo Hold", "This is the Cargo Hold.",
                new ArrayList<String>(Arrays.asList("table", "chair", "candle")));
        Location gallery = new Location("Gallery", "This is the Gallery.",
                new ArrayList<String>(Arrays.asList("table", "chair", "candle")));
        Location crowsNest = new Location("Crow's Nest", "This is the Crow's Nest.",
                new ArrayList<String>(Arrays.asList("table", "chair", "candle")));
        Location brig = new Location("Brig", "This is the Brig.",
                new ArrayList<String>(Arrays.asList("table", "chair", "candle")));

        while (!input.equalsIgnoreCase("quit")) {
            input = in.nextLine();
            if ( player.handleAction(input.toLowerCase()) == 0 ) {
            }
        }
    }
}

