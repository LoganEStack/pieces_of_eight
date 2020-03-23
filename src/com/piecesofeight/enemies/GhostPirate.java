package com.piecesofeight.enemies;

public class GhostPirate extends Enemy{
    private String name = "Ghost Pirate";
    private String description = "";
    private String weapon;
    private String[] nounDescriptors = { "enemy", "foe", "monster", "ghost", "pirate", "spectre", "ghoul", "spectre", "being" };
    private String[] adjectiveDescriptors = { "etherial", "ghostly", "blue", "humanoid", "spectre" };

    public GhostPirate(String weapon) {
        super(weapon);
    }

    public int attack() {
        if (Math.random() > 0.5) {
            System.out.println("Slash");
            if (Math.random() > 0.75) {
                System.out.println("The " + name + " slashed you with its " + getWeapon() + "!");
                return 30;
            }
            else {
                System.out.println("The " + name + " missed with its " + getWeapon() + "!");
                return 0;
            }
        }
        else {
            System.out.println("Stab");
            if (Math.random() > 0.75) {
                System.out.println("The " + name + " stabbed you with its " + getWeapon() + "!");
                return 40;
            }
            else {
                System.out.println("The " + name + " missed with its " + getWeapon() + "!");
                return 0;
            }
        }
    }
}