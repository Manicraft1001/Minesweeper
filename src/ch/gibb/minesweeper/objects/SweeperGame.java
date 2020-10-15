package ch.gibb.minesweeper.objects;

public class SweeperGame {

    private final GameField gameField;
    private final GameResult gameResult;

    public SweeperGame() {
        this.gameField = new GameField(12, 0.15D);
        this.gameResult = new GameResult();
    }

    public GameField getGameField() {
        return gameField;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
