package org.example.games.seaBattle.abstracts;

import org.example.games.seaBattle.enums.ShipDirection;
import org.example.games.seaBattle.enums.ShipStatus;
import org.example.games.seaBattle.models.Cell;

import java.util.ArrayList;
import java.util.List;

public class Ship{

    protected List<Cell> coordinates = new ArrayList<>();
    protected ShipStatus shipStatus;

    private ShipDirection shipDirection;
    
    private boolean isOwnCell(int x, int y){
        for(Cell cell : coordinates){
            if((cell.getXCord() == x) && (cell.getYCord() == y)){
                return true;
            }
        }
        return false;
    }

    //true - can place
    //false - cant place
    private boolean checkAround(Cell cell, int[][] board){
        int x = cell.getXCord();
        int y = cell.getYCord();
        return ((board[x + 1][y - 1] != 1) || ((board[x + 1][y - 1] == 1) && isOwnCell(x + 1, y - 1))) &&
                ((board[x + 1][y] != 1) || ((board[x + 1][y] == 1) && isOwnCell(x + 1, y))) &&
                ((board[x + 1][y + 1] != 1) || ((board[x + 1][y + 1] == 1) && isOwnCell(x + 1, y + 1))) &&
                ((board[x][y - 1] != 1) || ((board[x][y - 1] == 1) && isOwnCell(x, y - 1))) &&
                ((board[x][y] != 1) || ((board[x][y] == 1) && isOwnCell(x, y))) &&
                ((board[x][y + 1] != 1) || ((board[x][y + 1] == 1) && isOwnCell(x, y + 1))) &&
                ((board[x - 1][y - 1] != 1) || ((board[x - 1][y - 1] == 1) && isOwnCell(x - 1, y - 1))) &&
                ((board[x - 1][y] != 1) || ((board[x - 1][y] == 1) && isOwnCell(x - 1, y))) &&
                ((board[x - 1][y + 1] != 1) || ((board[x - 1][y + 1] == 1) && isOwnCell(x - 1, y + 1)));
    }

    private boolean placeSecondPlace(int[][] board, Cell cell){
        Cell placedCell = coordinates.get(0);
        int placedX = placedCell.getXCord();
        int placedY = placedCell.getYCord();
        if(((cell.equals(new Cell(placedX, placedY - 1))) ||
                (cell.equals(new Cell(placedX, placedY + 1)))) && checkAround(cell, board)){
            shipDirection = ShipDirection.Y;
            coordinates.add(cell);
            return true;
        } else if (((cell.equals(new Cell(placedX - 1, placedY))) ||
                (cell.equals(new Cell(placedX + 1, placedY)))) && checkAround(cell, board)) {
            shipDirection = ShipDirection.X;
            coordinates.add(cell);
            return true;
        }
        return false;
    }
    private List<Cell> getListOfPermittedCells(int[][] board){
        List<Cell> cellList = new ArrayList<>();
        for(Cell cell : coordinates){
            int x = cell.getXCord();
            int y = cell.getYCord();
            if(shipDirection == ShipDirection.Y){
                if(checkAround(new Cell(x, y + 1), board)){
                    cellList.add(new Cell(x, y + 1));
                }
                if (checkAround(new Cell(x, y - 1), board)){
                    cellList.add(new Cell(x, y - 1));
                }
            } else if (shipDirection == ShipDirection.X) {
                if (checkAround(new Cell(x - 1, y), board)){
                    cellList.add(new Cell(x - 1, y));
                }
                if (checkAround(new Cell(x + 1, y), board)){
                    cellList.add(new Cell(x + 1, y));
                }
            }
        }
        return cellList;
    }
    public boolean canPlace(int[][] board, Cell cell){
        int x = cell.getXCord();
        int y = cell.getYCord();
        if(board[x][y] == 0){
            if((coordinates.size() == 0) && checkAround(cell, board)){
                coordinates.add(cell);
                return true;
            }else if ((coordinates.size()) == 1){
                return placeSecondPlace(board, cell);
            } else {
                for(Cell l : getListOfPermittedCells(board)){
                    if(l.equals(cell)){
                        coordinates.add(cell);
                        return true;
                    }
                }
            }
        }
        return false;
    }

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
