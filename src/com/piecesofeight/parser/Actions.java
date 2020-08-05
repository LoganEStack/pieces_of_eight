package com.piecesofeight.parser;

import com.piecesofeight.core.Player;
import com.piecesofeight.objects.GameObject;
import com.piecesofeight.objects.GameObjectHandler;

public class Actions {
    Player player = Player.getInstance();

    public Actions() {
    }

    public void move(String location, String adjective) {
        player.setLocation(location);
        System.out.println("Moving to the " + player.getLocation());
    }

    public void look(String noun, String adjective) {
        GameObject gameObject = GameObjectHandler.gameObjectLookup(noun);
        gameObject.getDescription();
    }
    public void look() {
        System.out.println("You are at the " + player.getLocation());
    }

    public void run(String location, String adjective) {
        player.setLocation(location);
        System.out.println("Running to the " + player.getLocation());
    }

    public void listen(String noun, String adjective) {
        System.out.println("Specific listen text here");
    }
    public void listen() {
        System.out.println("Listen text here");
    }

    public void speak(String noun, String adjective) {
        System.out.println("Specific speak text here");
    }
    public void speak() {
        System.out.println("Speak text here");
    }

    public void climb(String noun, String adjective) {
        System.out.println("Climb text here");
    }

    public void sneak(String location, String adjective) {
        player.setLocation(location);
    }

    public void take(String noun, String adjective) {
        player.addToInventory(noun);
        System.out.println("You take the " + noun);
    }

    public void inventory() {
        player.getInventory();
    }

    public void throw_(String noun, String adjective) {
        System.out.println("You throw the " + noun);
    }

    public void attack(String noun, String adjective) {
        System.out.println("You attack the " + noun);
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
