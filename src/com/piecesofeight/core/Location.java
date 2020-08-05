package com.piecesofeight.core;

import com.piecesofeight.objects.GameObject;
import com.piecesofeight.objects.GameObjectHandler;

import java.util.ArrayList;

public class Location {
    private String name;
    private String description;
    private ArrayList<String> itemList = new ArrayList<String>();

    public Location(String name, String description, ArrayList<String> itemList) {
        this.name = name;
        this.description = description;
        this.itemList = itemList;
        // Instantiates all objects upon location creation, could change to only create when a new room is entered
        for (String item : itemList)  {
            //gameObjectHandler.initializeGameObject(item);
        }
    }

    private void refresh() {
        //ensure that objectItemList is the same as itemList
    }

    public String getName() { return "You have entered the " + name + "."; }

    public void setDescription(String description) { this.description = description; }

    public String getDescription() { return description; }

    public String getItemList() { return "In the room, you see " + itemList + "."; }

    public void addToItemList(String item) {
        itemList.add(item);
        refresh();
    }

    public void removeFromItemList(String item) {
        itemList.remove(item);
        refresh();
    }
}
