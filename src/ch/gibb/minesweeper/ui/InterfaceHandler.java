package ch.gibb.minesweeper.ui;

import ch.gibb.minesweeper.objects.Cell;
import ch.gibb.minesweeper.objects.Coordinate;
import ch.gibb.minesweeper.objects.SweeperGame;
import ch.gibb.minesweeper.ui.translators.FieldTranslator;
import ch.gibb.minesweeper.utils.ConsoleInterface;

import java.util.ArrayList;
import java.util.List;

public class InterfaceHandler {

    private final List<SweeperGame> games;

    public InterfaceHandler() {
        games = new ArrayList<>();
        shuffleGame();
        startLoop();
    }

    private boolean finished;

    private void startLoop() {
        while (!finished) {
            final SweeperGame currentGame = getCurrentOrNewGame();

            while (!currentGame.getGameResult().isFinished()) {
                FieldTranslator.printField(currentGame.getGameField());
                final Coordinate toRevealCoord = ConsoleInterface.getCoordinateFromConsole();
                final Cell toReveal = currentGame.getGameField().getCellAt(toRevealCoord);
                currentGame.getGameField().revealNeighbourCells(toReveal, 0);
                if (toReveal.isBomb()) {
                    currentGame.getGameResult().setFinished(true);
                    System.out.println(AnsiColor.ANSI_RED + "You lost the game!");
                }
            }
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
