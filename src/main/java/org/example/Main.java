package org.example;

import org.example.games.Game;
import org.example.games.seaBattle.SeaBattle;
import org.example.games.seaBattle.abstracts.Board;
import org.example.games.seaBattle.abstracts.Ship;
import org.example.games.seaBattle.models.Cell;
import org.example.visual.Painter;
import org.example.visual.SeaBattlePainter;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    //chcp 65001
    public static void main(String[] args){
        //Game game = new SeaBattle();
        //game.start();
        /*int[][] board = {{0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},
                        {0,2,2,2,0,0,0,1,0,0},
                         {0,0,0,0,0,0,0,1,0,0},
                         {0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,3,3,3,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0}};

        Painter painter = new SeaBattlePainter();
        painter.fillBoard(board);*/
        Board board = new Board(10);
        Painter painter = new SeaBattlePainter();
        painter.fillBoard(board.getBoard());
        Ship ship = new Ship();
        Cell cell = new Cell(1,3);
        if(ship.canPlace(board.getBoard(), cell)){
            int[][] area = board.getBoard();
            area[cell.getXCord()][cell.getYCord()] = 1;
            board.setBoard(area);
            painter.fillBoard(board.getBoard());
            System.out.println("можно");
        } else {
            System.out.println("нельзя");
        }
        Cell cell1 = new Cell(1,4);
        if(ship.canPlace(board.getBoard(), cell1)){
            int[][] area = board.getBoard();
            area[cell1.getXCord()][cell1.getYCord()] = 1;
            board.setBoard(area);
            painter.fillBoard(board.getBoard());
            System.out.println("можно");
        } else {
            System.out.println("нельзя");
        }
        Cell cell2 = new Cell(2,3);
        if(ship.canPlace(board.getBoard(), cell2)){
            int[][] area = board.getBoard();
            area[cell2.getXCord()][cell2.getYCord()] = 1;
            board.setBoard(area);
            painter.fillBoard(board.getBoard());
            System.out.println("можно");
        } else {
            System.out.println("нельзя");
        }
        /*Cell cell1 = new Cell(2,3);
        if(ship.canPlace(board.getBoard(), cell1)){
            int[][] area = board.getBoard();
            area[cell1.getXCord()][cell1.getYCord()] = 1;
            board.setBoard(area);
            painter.fillBoard(board.getBoard());
            System.out.println("можно");
        } else {
            System.out.println("нельзя");
        }
        Cell cell2 = new Cell(3,3);
        if(ship.canPlace(board.getBoard(), cell2)){
            int[][] area = board.getBoard();
            area[cell2.getXCord()][cell2.getYCord()] = 1;
            board.setBoard(area);
            painter.fillBoard(board.getBoard());
            System.out.println("можно");
        } else {
            System.out.println("нельзя");
        }*/
    }

}