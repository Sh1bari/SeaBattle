package org.example.games;

public abstract class Player {
    protected String name;
    public abstract void move();
    public abstract void init();
    public String getName(){
        return this.name;
    }
}
