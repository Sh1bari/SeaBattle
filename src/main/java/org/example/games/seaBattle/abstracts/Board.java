package org.example.games.seaBattle.abstracts;

import org.example.games.seaBattle.SeaBattlePlayer;
import org.example.games.seaBattle.enums.ShipDirection;
import org.example.games.seaBattle.models.Cell;

import java.util.List;

public class Board {
    private int[][] board;

    public Board(int size){
        this.board = new int[size + 2][size + 2];
        createSides(size);
    }
    public void clear(List<Cell> cells){
        for(Cell cell : cells){
            this.board[cell.getXCord()][cell.getYCord()] = 0;
        }
    }

    public void placeShipToBoard(Ship ship){
        for (Cell cell: ship.coordinates){
            fillCell(cell);
        }
    }
    public void placeMissedZone(Ship ship){
        for(Cell cell : ship.getCoordinates()){
            int x = cell.getXCord();
            int y = cell.getYCord();
            fillMissedZone(x,y - 1);
            fillMissedZone(x,y + 1);
            fillMissedZone(x + 1,y - 1);
            fillMissedZone(x + 1,y);
            fillMissedZone(x + 1,y + 1);
            fillMissedZone(x - 1,y - 1);
            fillMissedZone(x - 1,y);
            fillMissedZone(x - 1,y + 1);
        }
    }
    private void fillMissedZone(int x, int y){
        if(this.board[x][y] == 0){
            this.board[x][y] = 3;
        }
    }
    private void fillCell(Cell cell){
        int x = cell.getXCord();
        int y = cell.getYCord();
        this.board[x][y] = 1;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    private void createSides(int size){
        for(int i = 0; i < size + 2; i++){
            for(int j = 0; j < size + 2; j++){
                if((i == 0) || (i == size + 1)){
                    this.board[i][j] = 4;
                } else if ((j == 0) || (j == size + 1)) {
                    this.board[i][j] = 4;
                }
            }
        }
    }
}
