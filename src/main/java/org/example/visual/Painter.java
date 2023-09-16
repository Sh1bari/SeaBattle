package org.example.visual;

import org.example.games.seaBattle.enums.PaintBoard;

public interface Painter {
    void clearConsole();
    void fillBoard(int[][] board, PaintBoard paintBoard);

    void fillGameArea(int[][] yourBoard, int[][] enemyBoard);

    void countdown(int sec);
}
