package org.example.games.seaBattle;

import org.example.games.Game;
import org.example.games.seaBattle.abstracts.Board;
import org.example.games.seaBattle.abstracts.Ship;
import org.example.games.seaBattle.enums.ShipStatus;
import org.example.games.seaBattle.models.Cell;
import org.example.visual.Painter;
import org.example.visual.SeaBattlePainter;

import java.util.ArrayList;
import java.util.List;

public class SeaBattle implements Game {

    private final Painter painter = new SeaBattlePainter();
    private final List<SeaBattlePlayer> playerList = new ArrayList<>();

    private final Board playerBoard1 = new Board(10);
    private final Board playerBoard2 = new Board(10);

    @Override
    public void start() {
        init();
        SeaBattlePlayer player1 = playerList.get(0);
        SeaBattlePlayer player2 = playerList.get(1);
        boolean win = false;
        painter.clearConsole();
        System.out.println("\t\t\t\t  " + player1.getName() + ", you move first! ");
        sleep(3000);
        while (!somebodyWin()) {
            while (player1Move(player1, player2)) {
                if (somebodyWin()) {
                    win = true;
                    break;
                }
            }
            if (win) {
                break;
            } else {
                painter.clearConsole();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("\t\t\t\t  Change of sides!");
                sleep(1000);
                painter.countdown(3);
            }
            while (player2Move(player1, player2)) {
                if (somebodyWin()) {
                    win = true;
                    break;
                }
            }
            if (win) {
                break;
            } else {
                painter.clearConsole();
                System.out.println("\t\t\t\t  Change of sides!");
                sleep(1000);
                painter.countdown(3);
            }
        }
        end();
    }


    //true - hit
    //false - missed
    private boolean player1Move(SeaBattlePlayer player1, SeaBattlePlayer player2) {
        painter.clearConsole();
        painter.fillGameArea(playerBoard1.getBoard(), playerBoard2.getBoard());
        Cell shot = player1.getShot();
        while (playerBoard2.getBoard()[shot.getXCord()][shot.getYCord()] > 1) {
            System.out.println("\t\t\t\t  Can't shoot here!");
            shot = player1.getShot();
        }
        for (Ship ship : player2.getShipList()) {
            for (Cell cell : ship.getCoordinates()) {
                if (cell.equals(shot)) {
                    if (ship.hit()) {
                        playerBoard2.placeMissedZone(ship);
                    }
                    int[][] board = playerBoard2.getBoard();
                    board[cell.getXCord()][cell.getYCord()] = 2;
                    playerBoard2.setBoard(board);
                    System.out.println("\t\t\t\t  Hit!");
                    sleep(1500);
                    return true;
                }
            }
        }
        int[][] board = playerBoard2.getBoard();
        board[shot.getXCord()][shot.getYCord()] = 3;
        playerBoard2.setBoard(board);
        System.out.println("\t\t\t\t  Missed!");
        sleep(1500);
        return false;
    }

    private boolean player2Move(SeaBattlePlayer player1, SeaBattlePlayer player2) {
        painter.clearConsole();
        painter.fillGameArea(playerBoard2.getBoard(), playerBoard1.getBoard());
        Cell shot = player2.getShot();
        while (playerBoard1.getBoard()[shot.getXCord()][shot.getYCord()] > 1) {
            System.out.println("\t\t\t\t  Can't shoot here!");
            shot = player2.getShot();
        }
        for (Ship ship : player1.getShipList()) {
            for (Cell cell : ship.getCoordinates()) {
                if (cell.equals(shot)) {
                    if (ship.hit()) {
                        playerBoard1.placeMissedZone(ship);
                    }
                    int[][] board = playerBoard1.getBoard();
                    board[cell.getXCord()][cell.getYCord()] = 2;
                    playerBoard1.setBoard(board);
                    System.out.println("\t\t\t\t  Hit!");
                    sleep(1500);
                    return true;
                }
            }
        }
        int[][] board = playerBoard1.getBoard();
        board[shot.getXCord()][shot.getYCord()] = 3;
        playerBoard1.setBoard(board);
        System.out.println("\t\t\t\t  Missed!");
        sleep(1500);
        return false;
    }

    @Override
    public void pause() {
    }

    @Override
    public void end() {
        painter.clearConsole();
        System.out.println();
        System.out.println("\t\t\t\t\t  WIN!!!");
    }

    private boolean somebodyWin() {
        SeaBattlePlayer player1 = playerList.get(0);
        SeaBattlePlayer player2 = playerList.get(1);
        boolean dead1 = true;
        boolean dead2 = true;

        for (Ship ship : player1.getShipList()) {
            if (ship.getShipStatus() == ShipStatus.ALIVE) {
                dead1 = false;
                break;
            }
        }
        for (Ship ship : player2.getShipList()) {
            if (ship.getShipStatus() == ShipStatus.ALIVE) {
                dead2 = false;
                break;
            }
        }
        return (dead1 || dead2);
    }

    private void init() {
        painter.clearConsole();
        //showIntro();
        addPlayers();
        addShips();
    }

    private void addShips() {
        System.out.println();
        System.out.println("\t\t\t\t" + playerList.get(0).getName() + ", it's your turn to place ships");
        sleep(2000);
        painter.clearConsole();
        playerList.get(0).placeShips(playerBoard1);
        sleep(1000);
        painter.clearConsole();
        System.out.println();
        System.out.println("\t\t\t\t" + playerList.get(1).getName() + ", it's your turn to place ships");
        sleep(2000);
        painter.clearConsole();
        playerList.get(1).placeShips(playerBoard2);
        sleep(1000);
    }

    private void showIntro() {
        System.out.println("\t\t\t\t\t  Sea Battle");
        System.out.println("\t\t\t\t \u00A9 made by Vladimir Krasnov");
        sleep(2000);
        painter.clearConsole();
    }

    private void addPlayers() {
        for (int i = 1; i < 3; i++) {
            System.out.println("\t\t\t\t     " + i + " Player");
            SeaBattlePlayer player = new SeaBattlePlayer();
            playerList.add(player);
            System.out.println("\t\t\t\t  Hello, " + player.getName());
            sleep(2000);
            painter.clearConsole();
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Something bad happened...");
            System.exit(0);
        }
    }
}
