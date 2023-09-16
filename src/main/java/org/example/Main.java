package org.example;

import org.example.games.Game;
import org.example.games.seaBattle.SeaBattle;

public class Main {

    //chcp 65001
    public static void main(String[] args) {
        Game game = new SeaBattle();
        game.start();
    }

}