package com.piecesofeight.parser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Dictionary {
    private HashMap<String, ArrayList<String>> verbs = new HashMap<>();
    private HashMap<String, ArrayList<String>> locations = new HashMap<>();
    private HashMap<String, ArrayList<String>> objects = new HashMap<>();
    private HashMap<String, ArrayList<String>> entities = new HashMap<>();
    private HashMap<String, ArrayList<String>> adjectives = new HashMap<>();
    private HashMap<String, ArrayList<String>> other = new HashMap<>();        //command = command.replaceAll("(the|if|what|to|a|an|i)","");
    private String[] locationsWithASpace = { "main", "gun", "orlop", "crows", "captains" };

    public Dictionary() {
        //https://stackoverflow.com/questions/19541582/storing-and-retrieving-arraylist-values-from-hashmap
        //map.putIfAbsent(key, new ArrayList<Integer>());
        //map.get(key).add(number);     add element

        verbs.put( "move", new ArrayList<String>(Arrays.asList("mve", "mov")) );
        verbs.put( "look", new ArrayList<String>(Arrays.asList("lok", "ook")) );
        verbs.put( "run", new ArrayList<String>(Arrays.asList()) );
        verbs.put( "listen", new ArrayList<String>(Arrays.asList("lsten", "lisen", "liste", "listn")) );
        verbs.put( "speak", new ArrayList<String>(Arrays.asList("spek", "spak")) );
        verbs.put( "climb", new ArrayList<String>(Arrays.asList("clim", "clmb")) );
        verbs.put( "sneak", new ArrayList<String>(Arrays.asList("snek", "snak")) );
        verbs.put( "take", new ArrayList<String>(Arrays.asList("tke", "tak")) );
        verbs.put( "inventory", new ArrayList<String>(Arrays.asList("inventor", "inventry", "inv", "inventery", "nventory", "nventry",
                "inventroy", "inentory", "invetory")) );
        verbs.put( "throw", new ArrayList<String>(Arrays.asList("thrw", "trow", "hrow", "thro")) );
        verbs.put( "attack", new ArrayList<String>(Arrays.asList("atack", "attac", "attak", "ttack")) );
        verbs.put( "quit", new ArrayList<String>(Arrays.asList("qut", "qui", "qit")) );
        verbs.put( "help", new ArrayList<String>(Arrays.asList("hel", "hlp")) );

        locations.put( "main deck", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "gun deck", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "orlop deck", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "gallery", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "crows nest", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "captains quarters", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "brig", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "lazarette", new ArrayList<String>(Arrays.asList("", "")) );
        locations.put( "bow", new ArrayList<String>(Arrays.asList("", "")) );

        objects.put( "door", new ArrayList<String>(Arrays.asList("dor")) );
        objects.put( "floor", new ArrayList<String>(Arrays.asList("foor", "flor")) );
        objects.put( "bed", new ArrayList<String>(Arrays.asList()) );

        entities.put( "ghost pirate", new ArrayList<String>(Arrays.asList()) );

        other.put( "the", new ArrayList<String>(Arrays.asList()) );
        other.put( "at", new ArrayList<String>(Arrays.asList()) );
        other.put( "to", new ArrayList<String>(Arrays.asList()) );
        other.put( "a", new ArrayList<String>(Arrays.asList()) );
        other.put( "an", new ArrayList<String>(Arrays.asList()) );
    }

    public Boolean isVerb(String word) {
        if (verbs.containsKey(word)) {
            return true;
        }
        misspelledVerb(word);
        return false;
    }
    public int isLocation(String word) {
        if (locations.containsKey(word)) { return 1; }
        else if (Arrays.asList(locationsWithASpace).contains(word)) { return 2; }
        misspelledLocation(word);
        return 0;
    }
    public Boolean isObject(String word) {
        if (objects.containsKey(word)) { return true; }
        misspelledObject(word);
        return false;
    }
    public Boolean isEntity(String word) {
        if (entities.containsKey(word)) { return true; }
        misspelledEntity(word);
        return false;
    }
    public Boolean isAdjective(String word) {
        if (adjectives.containsKey(word)) { return true; }
        misspelledAdjective(word);
        return false;
    }
    public Boolean isOther(String word) {
        if (other.containsKey(word)) { return true; }
        misspelledOther(word);
        return false;
    }

    public void misspelledVerb(String word) {
        for (HashMap.Entry<String, ArrayList<String>> entry : verbs.entrySet()) {
            if (entry.getValue().contains(word))
                System.out.println("Did not recognize the word " + word + ". Did you mean " + entry.getKey() + "?");
        }
    }
    public void misspelledLocation(String word) {
        for (HashMap.Entry<String, ArrayList<String>> entry : locations.entrySet()) {
            if (entry.getValue().contains(word))
                System.out.println("Did not recognize the word " + word + ". Did you mean " + entry.getKey() + "?");
        }
    }
    public void misspelledObject(String word) {
        for (HashMap.Entry<String, ArrayList<String>> entry : objects.entrySet()) {
            if (entry.getValue().contains(word))
                System.out.println("Did not recognize the word " + word + ". Did you mean " + entry.getKey() + "?");
        }
    }
    public void misspelledEntity(String word) {
        for (HashMap.Entry<String, ArrayList<String>> entry : entities.entrySet()) {
            if (entry.getValue().contains(word))
                System.out.println("Did not recognize the word " + word + ". Did you mean " + entry.getKey() + "?");
        }
    }
    public void misspelledAdjective(String word) {
        for (HashMap.Entry<String, ArrayList<String>> entry : adjectives.entrySet()) {
            if (entry.getValue().contains(word))
                System.out.println("Did not recognize the word " + word + ". Did you mean " + entry.getKey() + "?");
        }
    }
    public void misspelledOther(String word) {
        for (HashMap.Entry<String, ArrayList<String>> entry : other.entrySet()) {
            if (entry.getValue().contains(word))
                System.out.println("Did not recognize the word " + word + ". Did you mean " + entry.getKey() + "?");
        }
    }
}
