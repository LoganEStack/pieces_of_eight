package com.piecesofeight.parser;

import com.piecesofeight.core.Player;

public class Actions {
    Player player;

    public Actions(Player player) {
        this.player = player;
    }

    public void move(String location, String adjective) {
        player.setLocation(location);
        System.out.println("Moving to the " + player.getLocation());
    }

    public void look(String noun, String adjective) {

    }
    public void look() {

    }

    public void run(String location, String adjective) {
        player.setLocation(location);
    }

    public void listen(String noun, String adjective) {

    }
    public void listen() {

    }

    public void speak(String noun, String adjective) {

    }
    public void speak() {

    }

    public void climb(String noun, String adjective) {

    }

    public void sneak(String location, String adjective) {
        player.setLocation(location);
    }

    public void take(String noun, String adjective) {
        player.addToInventory(noun);
    }

    public void inventory() {
        player.getInventory();
    }

    public void throw_(String noun, String adjective) {

    }

    public void attack(String noun, String adjective) {

    }

    public void quit() {
        System.out.println("Are you sure you want to quit?");
    }
    public void help() {
        System.out.println("List of available actions:");
        System.out.printf("%-15.15s  %-15.15s%n", "move", "look");
        System.out.printf("%-15.15s  %-15.15s%n", "run", "climb");
        System.out.printf("%-15.15s  %-15.15s%n", "listen", "speak");
        System.out.printf("%-15.15s  %-15.15s%n", "sneak", "take");
        System.out.printf("%-15.15s  %-15.15s%n", "inventory", "throw");
        System.out.printf("%-15.15s  %-15.15s%n", "attack", "help");
        System.out.printf("quit\n");
    }


}
