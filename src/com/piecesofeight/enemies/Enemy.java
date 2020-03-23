package com.piecesofeight.enemies;

abstract class Enemy {
    private String name;
    private String description;
    private String weapon;
    private String[] nounDescriptors;
    private String[] adjectivenounDescriptors;
    private int health;

    public Enemy(String weapon) {
        this.weapon = weapon;
    }

    public void setWeapon(String weapon) { this.weapon = weapon; }
    public String getWeapon() { return weapon; }


    public int attack() {
        System.out.println("The " + name + " attacked you!");
        return 10;
    }
    public int death() {
        System.out.println("The " + name + " has died.");
        return 10;
    }
}