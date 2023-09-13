package org.example.games.seaBattle;

import org.example.games.Player;
import org.example.games.seaBattle.models.Cell;
import org.example.games.seaBattle.models.Ship;

import java.util.List;
import java.util.Scanner;

public class SeaBattlePlayer implements Player {

    private String name;

    private List<Ship> shipList;

    private List<Cell> shotList;


    @Override
    public void move() {

    }

    @Override
    public void init() {
        Scanner in = new Scanner(System.in);
        System.out.print("Print your name: ");
        this.name = in.nextLine();
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
