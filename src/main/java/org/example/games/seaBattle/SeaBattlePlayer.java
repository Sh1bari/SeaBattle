package org.example.games.seaBattle;

import org.example.games.Player;
import org.example.games.seaBattle.abstracts.Board;
import org.example.games.seaBattle.enums.PaintBoard;
import org.example.games.seaBattle.models.Cell;
import org.example.games.seaBattle.abstracts.Ship;
import org.example.games.seaBattle.units.ShipX4;
import org.example.visual.Painter;
import org.example.visual.SeaBattlePainter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SeaBattlePlayer extends Player {

    private List<Ship> shipList = new ArrayList<>();

    private List<Cell> shotList = new ArrayList<>();


    public void move() {

    }

    public Cell getShot(){
        return shot(scanCellToShot());
    }
    private Cell shot(Cell cell){
        if(!hasShot(cell)){
            shotList.add(cell);
            return cell;
        }else {
            System.out.println("\t\t\t\t  Can't shoot here!!");
            shot(scanCellToShot());
        }
        return new Cell(0,0);
    }

    private boolean hasShot(Cell cell){
        for(Cell c : shotList){
            if(c.equals(cell)){
                return true;
            }
        }
        return false;
    }

    private Cell scanCellToShot(){
        System.out.print("\t\t\t\t  Enter coordinates to shot: ");
        String coordinate = in.nextLine();
        List<String> list = Stream.of(coordinate.split("")).filter(o -> !o.equals(" ")).toList();
        StringBuilder xString = new StringBuilder();
        int y = 0;
        for (String symbol : list) {
            try {
                xString.append(Integer.parseInt(symbol));
            } catch (Exception e) {
                switch (symbol) {
                    case "a", "A" -> y = A;
                    case "b", "B" -> y = B;
                    case "c", "C" -> y = C;
                    case "d", "D" -> y = D;
                    case "e", "E" -> y = E;
                    case "f", "F" -> y = F;
                    case "g", "G" -> y = G;
                    case "h", "H" -> y = H;
                    case "i", "I" -> y = I;
                    case "j", "J" -> y = J;
                    default -> {}
                }
                break;
            }
        }
        int x;
        try {
            x = Integer.parseInt(xString.toString());
        } catch (Exception e){
            x = 99;
        }
        if ((y == 0) || (xString.isEmpty()) || x > 10) {
            System.out.println("\t\t\t\t  Wrong coordinates");
            return scanCellToShot();
        } else {
            return new Cell(x, y);
        }
    }

    protected void init() {
        Scanner in = new Scanner(System.in);
        System.out.print("\t\t\t\t  Print your name: ");
        name = in.nextLine();
    }
    private Painter painter = new SeaBattlePainter();

    public void placeShips(Board board){
        painter.fillBoard(board.getBoard(), PaintBoard.FOR_ME);

        //addShip(board, new ShipX1(board.getBoard()));
        addShip(board, new ShipX4(board.getBoard()));
        //addShip(board, new ShipX1(board.getBoard()));
        /*addShip(board, new ShipX1(board.getBoard()));
        addShip(board, new ShipX1(board.getBoard()));

        addShip(board, new ShipX2(board.getBoard()));
        addShip(board, new ShipX2(board.getBoard()));
        addShip(board, new ShipX2(board.getBoard()));

        addShip(board, new ShipX3(board.getBoard()));
        addShip(board, new ShipX3(board.getBoard()));

        addShip(board, new ShipX4(board.getBoard()));*/
        System.out.println("\t\t\t\t  Final board");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private void addShip(Board board, Ship ship){
        board.placeShipToBoard(ship);
        shipList.add(ship);
        painter.clearConsole();
        painter.fillBoard(board.getBoard(), PaintBoard.FOR_ME);
    }

    //Getters and Setters

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }


    public SeaBattlePlayer(){
        init();
    }

    private Scanner in = new Scanner(System.in);

    private int A = 1;
    private int B = 2;
    private int C = 3;
    private int D = 4;
    private int E = 5;
    private int F = 6;
    private int G = 7;
    private int H = 8;
    private int I = 9;
    private int J = 10;
    public List<Cell> getShotList() {
        return shotList;
    }

    public void setShotList(List<Cell> shotList) {
        this.shotList = shotList;
    }
}
