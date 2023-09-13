package org.example.games.seaBattle;

import org.example.games.Game;
import org.example.games.Player;
import org.example.visual.Painter;
import org.example.visual.SeaBattlePainter;

import java.util.ArrayList;
import java.util.List;

public class SeaBattle implements Game {

    private final Painter painter = new SeaBattlePainter();
    private List<Player> playerList = new ArrayList<>();
    @Override
    public void start() {
        init();

    }

    @Override
    public void pause() {

    }

    @Override
    public void end() {

    }

    private void init() {
        showIntro();
        addPlayers();
    }
    private void showIntro(){
        System.out.println("       Sea Battle");
        System.out.println("\u00A9 made by Vladimir Krasnov");
        sleep(2000);
        painter.clearConsole();
    }
    private void addPlayers(){
        for(int i = 1; i < 3; i++) {
            System.out.println("   "+i+" Player");
            Player player = new SeaBattlePlayer();
            playerList.add(player);
            System.out.println("Hello, " + player.getName());
            sleep(2000);
            painter.clearConsole();
        }
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Something bad happened...");
            System.exit(0);
        }
    }
}
