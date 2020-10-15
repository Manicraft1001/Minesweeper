package ch.gibb.minesweeper.objects;

public class GameResult {

    private int revealedCells;
    private int closeCalls;
    private boolean finished;


    public int getCloseCalls() {
        return closeCalls;
    }

    public int getRevealedCells() {
        return revealedCells;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setCloseCalls(int closeCalls) {
        this.closeCalls = closeCalls;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setRevealedCells(int revealedCells) {
        this.revealedCells = revealedCells;
    }
}
