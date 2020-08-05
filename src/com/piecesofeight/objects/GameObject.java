package com.piecesofeight.objects;

public class GameObject {
    private String ID;
    private String name;
    private String description;
    private String[] adjectives;
    private int health;
    private String destructionSentence;

    public GameObject(String name, String[] adjectives, int health, String destructionSentence) {
        this.name = name;
        this.adjectives = adjectives;
        this.health = health;
        this.destructionSentence = destructionSentence;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAdjectives() {
        return adjectives;
    }

    public int getHealth() {
        return health;
    }

    public String getDestructionSentence() {
        return destructionSentence;
    }

}
