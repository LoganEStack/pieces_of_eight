package com.piecesofeight.objects;

import java.util.ArrayList;

public class GameObjectHandler {
    // List of all game objects currently in the world
    private static ArrayList<GameObject> gameObjectList = new ArrayList<GameObject>();

    void initializeGameObject(String noun) {
        //gameObjectList.add();
    }

    public static GameObject gameObjectLookup(String noun) {
        for(final GameObject o : gameObjectList){
            if (o.getName() == noun) {
                return o;
            }
        }
        return new GameObject("", new String[]{""}, 0, "");
    }
}
