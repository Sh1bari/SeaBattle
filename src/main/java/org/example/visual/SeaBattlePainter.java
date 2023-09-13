package org.example.visual;

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
     */
    @Override
    public void fillBoard(int[][] board) {
        System.out.println("       A    B    C    D    E    F    G    H    I    G");
        for(int i = 0; i < 10; i++){
            fillLine(board[i], i);
        }
    }

    private void fillLine(int[] line, int index) {
        for (int j = 0; j < 3; j++) {

            if(j == 1){
                System.out.print("  "+ index + "  ");
            }else System.out.print("     ");

            for (int i = 0; i < 10; i++) {
                switch (j) {
                    case 0, 2 -> {
                        switch (line[i]) {
                            case 0, 3 -> System.out.print("     ");
                            case 1 -> System.out.print("\u2588\u2588\u2588\u2588\u2588");
                            case 2 -> System.out.print("\u221A   \u221A");
                        }
                    }
                    case 1 -> {
                        switch (line[i]) {
                            case 0 -> System.out.print("     ");
                            case 1 -> System.out.print("\u2588\u2588\u2588\u2588\u2588");
                            case 2 -> System.out.print("  \u221A  ");
                            case 3 -> System.out.print("  \u20DD  ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
