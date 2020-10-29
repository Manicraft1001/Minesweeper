package ch.gibb.minesweeper.objects;

import ch.gibb.minesweeper.objects.inheritances.BombCell;
import ch.gibb.minesweeper.objects.inheritances.CommonCell;
import ch.gibb.minesweeper.utils.MathUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Class represents the field
 * on an game instance
 */
public class GameField {

    private final Cell[][] cells;
    private final int size;

    /**
     * Constructor to create a new instance
     * of a GameField
     * @param size the size of the field
     * @param percentageBombs the wanted percentage
     *                        of bombs in the field
     */
    public GameField(int size, double percentageBombs) {
        this.size = size;
        this.cells = new Cell[size][size];

        generateCells(percentageBombs);
    }

    /**
     * Getter to get all cells
     * @return returns an array of all cells
     */
    public Cell[][] getCells() {
        return cells;
    }

    /**
     * Get a cell at a specific
     * location
     * @param x the x coordinate of the location
     * @param y the y coordinate of the location
     * @return returns a single cell
     */
    public Cell getCellAt(int x, int y) {
        return cells[x][y];
    }

    /**
     * Get a cell at a specific coordinate
     * @param cellCoord the coordinate
     * @return returns a single cell
     */
    public Cell getCellAt(Coordinate cellCoord) {
        return getCellAt(cellCoord.getX(), cellCoord.getY());
    }

    /**
     * Getter to get the current field size
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to generate cells into the field
     * @param percentageBombs the amount of bombs in percentage
     */
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

    /**
     * Get all cells if they contain a bomb
     * @return return all bomb cells
     */
    private int getBombCells() {
        return (int) Arrays.stream(cells).flatMap(Arrays::stream).filter(Cell::isBomb).count();
    }

    /**
     * Get all cells
     * @return returns all cells
     */
    public List<Cell> getAllCells() {
        return Arrays.stream(cells).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    /**
     * Recursive Method to reveal
     * all neighbour cells if the iteration
     * is below allowed.
     * May occur in performance issues if iteration is too
     * high or recursive break not works.
     * @param cell the cell to reveal from (inclusive)
     * @param iteration the iteration count
     */
    public void revealNeighbourCells(final Cell cell, final int iteration) {
        if (iteration > 3)
            return;

        if (cell.isRevealed())
            return;

        cell.setRevealed(true);

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                final int x = cell.getCoordinate().getX() + i;
                final int y = cell.getCoordinate().getY() + j;

                if (x < size && x > 0 && y < size && y > 0)
                    revealNeighbourCells(getCellAt(x, y), iteration + 1);
            }
        }
    }
}
