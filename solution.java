Here is a simple implementation of Minesweeper in Java:

```java
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

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = HIDDEN;
                if (random.nextInt(7) == 0)
                    mines[i][j] = MINE;
                else
                    mines[i][j] = EMPTY;
            }

        do {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }

            System.out.print("Enter your move (row[1-10] column[1-10]): ");
            row = input.nextInt() - 1;
            col = input.nextInt() - 1;

            if (mines[row][col] == MINE) {
                System.out.println("You lost");
                break;
            } else {
                int count = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if (mines[row + i][col + j] == MINE)
                            count++;
                board[row][col] = (char) (count + '0');
            }
        } while (true);
    }
}
```

This program creates a 10x10 board and randomly places mines on it. The user is asked to enter a row and column number. If the chosen cell contains a mine, the game ends. If not, the number of mines in the adjacent cells is calculated and displayed. The game continues until the user hits a mine.