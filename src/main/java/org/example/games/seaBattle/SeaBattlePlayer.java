package org.example.games.seaBattle;

import org.example.games.Player;
import org.example.games.seaBattle.models.Cell;
import org.example.games.seaBattle.abstracts.Ship;

import java.util.List;
import java.util.Scanner;

public class SeaBattlePlayer extends Player {

    private List<Ship> shipList;

    private List<Cell> shotList;


    public void move() {

    }

    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.print("Print your name: ");
        name = in.nextLine();
    }

    //Getters and Setters

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    public List<Cell> getShotList() {
        return shotList;
    }

    public void setShotList(List<Cell> shotList) {
        this.shotList = shotList;
    }

    SeaBattlePlayer(){
        init();
    }
}
