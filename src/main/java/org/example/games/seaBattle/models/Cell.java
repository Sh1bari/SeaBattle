package org.example.games.seaBattle.models;

import java.util.Objects;

public class Cell {
    private int xCord;
    private int yCord;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell cell)) return false;
        return xCord == cell.xCord && yCord == cell.yCord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCord, yCord);
    }

    public Cell(int x, int y){
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
