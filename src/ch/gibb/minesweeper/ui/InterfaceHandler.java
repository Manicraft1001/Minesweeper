package ch.gibb.minesweeper.ui;

import ch.gibb.minesweeper.objects.SweeperGame;

import java.util.ArrayList;
import java.util.List;

public class InterfaceHandler {

    private List<SweeperGame> games;

    public InterfaceHandler() {
        games = new ArrayList<>();
        shuffleGame();
        startLoop();
    }

    private boolean finished;

    private void startLoop() {
        while (!finished) {
            final SweeperGame currentGame = getCurrentOrNewGame();
            
        }
    }

    private SweeperGame getCurrentOrNewGame() {
        final SweeperGame currentGame = getCurrentGame();
        if (currentGame.getGameResult().isFinished())
            shuffleGame();
        return getCurrentGame();
    }

    private SweeperGame getCurrentGame() {
        return games.get(games.size() - 1);
    }

    private void shuffleGame() {
        games.add(new SweeperGame());
    }
}
