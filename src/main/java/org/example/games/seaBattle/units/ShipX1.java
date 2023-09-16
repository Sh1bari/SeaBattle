package org.example.games.seaBattle.units;

import org.example.games.seaBattle.abstracts.Board;
import org.example.games.seaBattle.abstracts.Ship;
import org.example.games.seaBattle.models.Cell;

import java.util.ArrayList;
import java.util.List;


public class ShipX1 extends Ship {


    public ShipX1(int[][] board) {
        hearts = 1;
        init(board);
    }

    @Override
    protected void init(int[][] board) {
        List<Cell> savedCells = new ArrayList<>();
        System.out.println("\t\t\t\t\t  X1 ship");
        Board board1 = new Board(10);
        board1.setBoard(board);
        int i = 0;
        while (i < hearts) {
            Cell cell = scanCord();
            if (!cell.equals(new Cell(0, 0))) {
                if (place(board1.getBoard(), cell)) {
                    board1.placeShipToBoard(this);
                    i++;
                }
            } else {
                board1.clear(savedCells);
                savedCells = new ArrayList<>();
                i = 0;
            }
        }
        System.out.println("\t\t\t\t  Success!");
    }

}
