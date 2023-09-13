package org.example;

import org.example.games.Game;
import org.example.games.seaBattle.SeaBattle;
import org.example.visual.Painter;
import org.example.visual.SeaBattlePainter;

import java.io.IOException;

public class Main {

    //chcp 65001
    public static void main(String[] args){
        Game game = new SeaBattle();
        game.start();
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
    }

}