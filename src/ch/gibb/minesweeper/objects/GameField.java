package ch.gibb.minesweeper.objects;

import ch.gibb.minesweeper.objects.inheritances.BombCell;
import ch.gibb.minesweeper.objects.inheritances.CommonCell;
import ch.gibb.minesweeper.utils.MathUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public void generateCells(double percentageBombs) {
        if (percentageBombs > 1)
            throw new IllegalArgumentException("percentageBombs cannot be > 1");
        if (percentageBombs <= 0)
            throw new IllegalArgumentException("percentageBombs cannot be <= 0");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new CommonCell();
                cells[i][j].setCoordinate(new Coordinate(i, j));
            }
        }

        int expectedBombs = (int) ((size * size) * percentageBombs);

        while (getBombCells() < expectedBombs) {
            final Coordinate randomCoordinate = new Coordinate(MathUtils.getRandom(0, size),
                    MathUtils.getRandom(0, size));
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
}
