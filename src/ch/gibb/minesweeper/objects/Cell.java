package ch.gibb.minesweeper.objects;

import ch.gibb.minesweeper.objects.inheritances.BombCell;

public abstract class Cell {

    private Coordinate coordinate;
    private boolean revealed;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isBomb() {
        return this instanceof BombCell;
    }
}
