package ch.gibb.minesweeper.ui.translators;

import ch.gibb.minesweeper.objects.Cell;
import ch.gibb.minesweeper.objects.GameField;

/***
 * Class to translate variables into visual
 * console output
 */
public class FieldTranslator {

    /**
     * Method to print the entire game field into system.out
     * @param gameField the GameField to print
     */
    public static void printField(GameField gameField) {
        final Cell[][] cells = gameField.getCells();

        for (int i = 0; i < gameField.getSize(); i++) {
            final StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < gameField.getSize(); j++) {
                final Cell cell = cells[i][j];

                stringBuilder.append(cell.isRevealed() ? cell.isBomb() ? "!" : "O" : " ").append(" ");
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
