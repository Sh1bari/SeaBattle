package org.example.games.seaBattle.abstracts;

import org.example.games.seaBattle.enums.ShipDirection;
import org.example.games.seaBattle.enums.ShipStatus;
import org.example.games.seaBattle.models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class Ship {

    protected List<Cell> coordinates = new ArrayList<>();
    protected ShipStatus shipStatus = ShipStatus.ALIVE;

    protected int hearts;

    //true - dead
    //false - hit or miss
    public boolean hit() {
        this.hearts--;
        if (hearts == 0) {
            shipStatus = ShipStatus.DEAD;
            System.out.println("\t\t\t\t  Ship destroyed!");
            return true;
        }
        return false;
    }

    protected Scanner in = new Scanner(System.in);

    protected int A = 1;
    protected int B = 2;
    protected int C = 3;
    protected int D = 4;
    protected int E = 5;
    protected int F = 6;
    protected int G = 7;
    protected int H = 8;
    protected int I = 9;
    protected int J = 10;

    public ShipDirection getShipDirection() {
        return shipDirection;
    }

    protected ShipDirection shipDirection;

    protected Cell scanCord() {
        System.out.print("\t\t\t\t  Enter coordinates: ");
        String coordinate = in.nextLine();
        if (coordinate.equals("delete")) {
            System.out.println("\t\t\t\t  Deleted. Recreating...");
            coordinates = new ArrayList<>();
            shipDirection = null;
            return new Cell(0, 0);
        } else {
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
                        default -> {
                        }
                    }
                    break;
                }
            }
            int x;
            try {
                x = Integer.parseInt(xString.toString());
            } catch (Exception e) {
                x = 99;
            }
            if ((y == 0) || (xString.isEmpty()) || x > 10) {
                System.out.println("\t\t\t\t  Wrong coordinates");
                return scanCord();
            } else {
                return new Cell(x, y);
            }
        }
    }

    private boolean isOwnCell(int x, int y) {
        for (Cell cell : coordinates) {
            if ((cell.getXCord() == x) && (cell.getYCord() == y)) {
                return true;
            }
        }
        return false;
    }

    protected abstract void init(int[][] board);

    //true - can place
    //false - cant place
    private boolean checkAround(Cell cell, int[][] board) {
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

    private boolean placeSecondPlace(int[][] board, Cell cell) {
        Cell placedCell = coordinates.get(0);
        int placedX = placedCell.getXCord();
        int placedY = placedCell.getYCord();
        if (((cell.equals(new Cell(placedX, placedY - 1))) ||
                (cell.equals(new Cell(placedX, placedY + 1)))) && checkAround(cell, board)) {
            shipDirection = ShipDirection.Y;
            coordinates.add(cell);
            return true;
        } else if (((cell.equals(new Cell(placedX - 1, placedY))) ||
                (cell.equals(new Cell(placedX + 1, placedY)))) && checkAround(cell, board)) {
            shipDirection = ShipDirection.X;
            coordinates.add(cell);
            return true;
        }
        System.out.println("\t\t\t\t  Can't place here!");
        return false;
    }

    private List<Cell> getListOfPermittedCells(int[][] board) {
        List<Cell> cellList = new ArrayList<>();
        for (Cell cell : coordinates) {
            int x = cell.getXCord();
            int y = cell.getYCord();
            if (shipDirection == ShipDirection.Y) {
                try {
                    if (checkAround(new Cell(x, y + 1), board)) {
                        cellList.add(new Cell(x, y + 1));
                    }
                } catch (Exception e) {

                }
                try {
                    if (checkAround(new Cell(x, y - 1), board)) {
                        cellList.add(new Cell(x, y - 1));
                    }
                } catch (Exception e) {

                }
            } else if (shipDirection == ShipDirection.X) {
                try {
                    if (checkAround(new Cell(x - 1, y), board)) {
                        cellList.add(new Cell(x - 1, y));
                    }
                } catch (Exception e) {

                }
                try {
                    if (checkAround(new Cell(x + 1, y), board)) {
                        cellList.add(new Cell(x + 1, y));
                    }
                } catch (Exception e) {

                }
            }
        }
        return cellList;
    }

    protected boolean place(int[][] board, Cell cell) {
        int x = cell.getXCord();
        int y = cell.getYCord();
        if (board[x][y] == 0) {
            if ((coordinates.size() == 0) && checkAround(cell, board)) {
                coordinates.add(cell);
                return true;
            } else if ((coordinates.size()) == 1) {
                return placeSecondPlace(board, cell);
            } else {
                for (Cell l : getListOfPermittedCells(board)) {
                    if (l.equals(cell)) {
                        coordinates.add(cell);
                        return true;
                    }
                }
            }
        }
        System.out.println("\t\t\t\t  Can't place here!");
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
