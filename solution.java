import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char EMPTY = ' ';
    private static final char MINE = '*';
    private static final char HIDDEN = '.';
    private static final int SIZE = 10;

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        char[][] mines = new char[SIZE][SIZE];
        int row, col;
        Random random = new Random();
        Scanner input = new Scanner(System.in);