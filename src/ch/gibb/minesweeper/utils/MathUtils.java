package ch.gibb.minesweeper.utils;

public class MathUtils {

    public static int getRandom(int lower, int upper) {
        return (int)(Math.random() * upper) + lower;
    }
}
