package org.example.games.seaBattle.abstracts;

public class Board {
    private int[][] board;

    public Board(int size){
        this.board = new int[size + 2][size + 2];
        createSides(size);
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
        board[1][1] = 1;
    }
}
