package org.example.games.seaBattle.models;

import org.example.games.seaBattle.enums.ShipStatus;

import java.util.List;

public class Ship{

    private List<Cell> coordinates;
    private ShipStatus shipStatus;

    //Getters and Setters
    public List<Cell> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Cell> coordinates) {
        this.coordinates = coordinates;
    }

    public ShipStatus getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(ShipStatus shipStatus) {
        this.shipStatus = shipStatus;
    }
}
