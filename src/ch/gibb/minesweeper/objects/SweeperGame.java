package ch.gibb.minesweeper.objects;

public class SweeperGame {

    private GameField gameField;
    private GameResult gameResult;

    public SweeperGame() {
        this.gameField = new GameField(12);
        this.gameResult = new GameResult();
    }

    public GameField getGameField() {
        return gameField;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
