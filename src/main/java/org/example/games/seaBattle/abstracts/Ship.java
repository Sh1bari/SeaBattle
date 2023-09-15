package org.example.games.seaBattle.abstracts;

import org.example.games.seaBattle.enums.ShipStatus;
import org.example.games.seaBattle.models.Cell;

import java.util.List;

public abstract class Ship{

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
