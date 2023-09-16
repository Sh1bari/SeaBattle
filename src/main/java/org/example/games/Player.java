package org.example.games;

public abstract class Player {
    protected String name;
    public abstract void move();
    protected abstract void init();
    public String getName(){
        return this.name;
    }
}
