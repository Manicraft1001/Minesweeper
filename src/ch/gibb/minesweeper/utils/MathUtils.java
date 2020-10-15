package ch.gibb.minesweeper.utils;

public class MathUtils {

    public static int getRandom(int lower, int upper) {
        return (int)(Math.random() * upper) + lower;
    }

    public static boolean isInteger(CharSequence toCheck) {
        try {
            Integer.parseInt(String.valueOf(toCheck));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
