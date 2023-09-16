package org.example.visual;

import org.example.games.seaBattle.enums.PaintBoard;

import java.io.IOException;

public class SeaBattlePainter implements Painter {

    @Override
    public void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param board 0 - clear
     *              1 - ship
     *              2 - shotted ship
     *              3 - missed shot
     *              4 - side
     */
    @Override
    public void fillBoard(int[][] board, PaintBoard paintBoard) {
        System.out.println("         A       B       C       D       E       F       G       H       I       J");
        for(int i = 0; i < board.length; i++){
            fillLine(board[i], i, paintBoard);
        }
    }
    @Override
    public void countdown(int sec){
        clearConsole();
        for(int i = sec; i > 0; i--){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("\t\t\t\t     " + i);
            try {
                Thread.sleep(1000);
                clearConsole();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fillGameArea(int[][] yourBoard, int[][] enemyBoard){
        System.out.println("\t\t\t\t\t  ENEMY BOARD");
        System.out.println();
        fillBoard(enemyBoard, PaintBoard.FOR_ENEMY);
        System.out.println();
        System.out.println("\t\t\t\t\t  YOUR BOARD");
        fillBoard(yourBoard, PaintBoard.FOR_ME);
    }

    private void fillTopLine(int length){
        for (int i = 0; i < length + 1; i++) {
            if (i == 0) {
                System.out.print("     ");
            } else if (i == 1) {
                System.out.print("\u2554");
            } else if (i == length) {
                System.out.print("\u2557\n");
            } else if(i != length - 1){
                System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566");
            }else System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        }
    }
    private void fillBottomLine(int length){
        for (int i = 0; i < length + 1; i++) {
            if (i == 0) {
                System.out.print("     ");
            } else if (i == 1) {
                System.out.print("\u255A");
            } else if (i == length) {
                System.out.print("\u255D\n");
            } else if(i != length - 1) {
                System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569");
            }else System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        }
    }

    private void fillIndex(int index){
        if (index >= 10) {
            System.out.print("  " + index + " \u2551");
        } else System.out.print("  " + index + "  \u2551");
    }

    private void fillBridges(int length){
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                System.out.print("     \u2560");
            } else if (i == length - 1) {
                System.out.print("\u2563\n");
            } else if(i != length - 2){
                System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C");
            } else System.out.print("\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
        }
    }
    private void fillCells(int[] line, int index, PaintBoard paintBoard){
        for (int j = 0; j < 3; j++) {
            if (j == 1) {
                fillIndex(index);
            } else System.out.print("     \u2551");

            for (int i = 1; i < line.length; i++) {
                switch (j) {
                    case 0, 2 -> {
                        switch (line[i]) {
                            case 0, 3 -> System.out.print("       \u2551");
                            case 1 -> {
                                if(paintBoard == PaintBoard.FOR_ME) {
                                    System.out.print("\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551");
                                } else System.out.print("       \u2551");
                            }
                            case 2 -> System.out.print("\u221A     \u221A\u2551");
                        }
                    }
                    case 1 -> {
                        switch (line[i]) {
                            case 0 -> System.out.print("       \u2551");
                            case 1 -> {
                                if(paintBoard == PaintBoard.FOR_ME) {
                                    System.out.print("\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551");
                                }  else System.out.print("       \u2551");
                            }
                            case 2 -> System.out.print("   \u221A   \u2551");
                            case 3 -> System.out.print("   \u20DD   \u2551");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private void fillLine(int[] line, int index, PaintBoard paintBoard) {
        if (index == 0) {
            fillTopLine(line.length);
        } else if (index == line.length - 1) {
            fillBottomLine(line.length);
        } else {
            fillCells(line, index, paintBoard);
            if(index != line.length - 2) {
                fillBridges(line.length);
            }
        }
    }
}
