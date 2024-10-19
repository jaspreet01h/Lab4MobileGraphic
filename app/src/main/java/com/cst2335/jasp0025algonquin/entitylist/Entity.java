package com.cst2335.jasp0025algonquin.entitylist;

public class Entity {
    private int type;
    private String name;
    private String textType;

    // Constructor
    public Entity(int type, String name, String textType) {
        this.type = type;
        this.name = name;
        this.textType = textType;
    }

    // Getters
    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTextType() {
        return textType;
    }
}
