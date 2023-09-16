package org.example;

import org.example.games.Game;
import org.example.games.seaBattle.SeaBattle;
import org.example.games.seaBattle.abstracts.Board;
import org.example.games.seaBattle.abstracts.Ship;
import org.example.games.seaBattle.models.Cell;
import org.example.games.seaBattle.units.ShipX1;
import org.example.games.seaBattle.units.ShipX2;
import org.example.games.seaBattle.units.ShipX3;
import org.example.visual.Painter;
import org.example.visual.SeaBattlePainter;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    //chcp 65001
    public static void main(String[] args){
        Game game = new SeaBattle();
        game.start();
    }

}