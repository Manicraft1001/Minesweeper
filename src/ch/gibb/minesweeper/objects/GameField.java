package ch.gibb.minesweeper.objects;

import ch.gibb.minesweeper.objects.inheritances.BombCell;
import ch.gibb.minesweeper.objects.inheritances.CommonCell;
import ch.gibb.minesweeper.utils.MathUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameField {

    private Cell[][] cells;
    private final int size;

    public GameField(int size, double percentageBombs) {
        this.size = size;
        this.cells = new Cell[size][size];

        generateCells(percentageBombs);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCellAt(int x, int y) {
        return cells[x][y];
    }

    public Cell getCellAt(Coordinate cellCoord) {
        return getCellAt(cellCoord.getX(), cellCoord.getY());
    }

    public int getSize() {
        return size;
    }

    public void generateCells(double percentageBombs) {
        if (percentageBombs > 1)
            throw new IllegalArgumentException("percentageBombs cannot be > 1");
        if (percentageBombs <= 0)
            throw new IllegalArgumentException("percentageBombs cannot be <= 0");

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                cells[i][j] = new CommonCell();
                cells[i][j].setCoordinate(new Coordinate(i, j));
            }
        }

        int expectedBombs = (int) ((getSize() * getSize()) * percentageBombs);

        while (getBombCells() < expectedBombs) {
            final Coordinate randomCoordinate = new Coordinate(MathUtils.getRandom(0, getSize()),
                    MathUtils.getRandom(0, getSize()));
            final BombCell bombCell = new BombCell();
            bombCell.setCoordinate(randomCoordinate);
            cells[randomCoordinate.getX()][randomCoordinate.getY()] = bombCell;
        }
    }

    private int getBombCells() {
        return (int) Arrays.stream(cells).flatMap(Arrays::stream).filter(Cell::isBomb).count();
    }

    public List<Cell> getAllCells() {
        return Arrays.stream(cells).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    public void revealNeighbourCells(final Cell cell, final int iteration) {
        if (iteration > 3)
            return;

        if (cell.isRevealed())
            return;

        cell.setRevealed(true);

        int[] delta = new int[] {-1, 1};

        for (int i = 0; i < delta.length; i++) {
            for (int j = 0; j < delta.length; j++) {
                final int x = cell.getCoordinate().getX() + i;
                final int y = cell.getCoordinate().getY() + j;

                if (x < size && x > 0 && y < size && y > 0)
                    revealNeighbourCells(getCellAt(x, y), iteration + 1);
            }
        }
    }
}
