package ch.gibb.minesweeper.objects;

public class GameField {

    private Cell[][] cells;
    private final int size;

    public GameField(int size) {
        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getSize() {
        return size;
    }
}
