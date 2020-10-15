package ch.gibb.minesweeper.utils;

import ch.gibb.minesweeper.objects.Coordinate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInterface {

    public static Coordinate getCoordinateFromConsole() {
        Coordinate coordinate = null;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (coordinate == null) {
            try {
                System.out.print("Reveal cell: ");
                final String line = reader.readLine();
                final String[] parts = line.split(" ");
                if (parts.length >= 2 && MathUtils.isInteger(parts[0]) && MathUtils.isInteger(parts[1])) {
                    coordinate = new Coordinate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                } else {
                    System.out.println("Not valid! Try again");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return coordinate;
    }
}
