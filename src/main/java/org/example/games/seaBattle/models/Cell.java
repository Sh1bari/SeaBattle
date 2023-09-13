package org.example.games.seaBattle.models;

public class Cell {
    private int xCord;
    private int yCord;

    Cell(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }

    //Getters and Setters
    public int getXCord() {
        return xCord;
    }

    public void setXCord(int xCord) {
        this.xCord = xCord;
    }

    public int getYCord() {
        return yCord;
    }

    public void setYCord(int yCord) {
        this.yCord = yCord;
    }
}
