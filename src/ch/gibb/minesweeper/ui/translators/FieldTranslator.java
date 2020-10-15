package ch.gibb.minesweeper.ui.translators;

import ch.gibb.minesweeper.objects.Cell;
import ch.gibb.minesweeper.objects.GameField;

import java.io.IOException;

public class FieldTranslator {

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
