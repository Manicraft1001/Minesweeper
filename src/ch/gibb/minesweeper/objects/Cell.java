package ch.gibb.minesweeper.objects;

import ch.gibb.minesweeper.objects.inheritances.BombCell;

public abstract class Cell {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBomb() {
        return this instanceof BombCell;
    }
}
