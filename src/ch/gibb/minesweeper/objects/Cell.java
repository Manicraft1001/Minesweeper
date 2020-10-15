package ch.gibb.minesweeper.objects;

import ch.gibb.minesweeper.objects.inheritances.BombCell;

public abstract class Cell {

    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isBomb() {
        return this instanceof BombCell;
    }
}
