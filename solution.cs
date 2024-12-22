Here is a simple implementation of Minesweeper in C#:

```C#
using System;

class Program
{
    static void Main(string[] args)
    {
        Game game = new Game(5, 5, 5);
        game.Play();
    }
}

class Game
{
    private int rows;
    private int cols;
    private int mines;
    private char[,] board;
    private bool[,] revealed;

    public Game(int rows, int cols, int mines)
    {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.board = new char[rows, cols];
        this.revealed = new bool[rows, cols];
    }

    public void Play()
    {
        InitializeBoard();
        while (true)
        {
            PrintBoard();
            Console.Write("Enter row: ");
            int row = int.Parse(Console.ReadLine());
            Console.Write("Enter column: ");
            int col = int.Parse(Console.ReadLine());
            if (board[row, col] == '*')
            {
                Console.WriteLine("Game Over!");
                return;
            }
            else
            {
                revealed[row, col] = true;
            }
        }
    }

    private void InitializeBoard()
    {
        Random random = new Random();
        for (int i = 0; i < mines; i++)
        {
            int row, col;
            do
            {
                row = random.Next(rows);
                col = random.Next(cols);
            } while (board[row, col] == '*');
            board[row, col] = '*';
        }
    }

    private void PrintBoard()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (revealed[i, j])
                {
                    Console.Write(board[i, j] + " ");
                }
                else
                {
                    Console.Write("? ");
                }
            }
            Console.WriteLine();
        }
    }
}
```

This program creates a simple Minesweeper game in the console. The game board is a 5x5 grid with 5 mines randomly placed. The player is asked to enter the row and column of the cell they want to reveal. If the cell contains a mine, the game ends. Otherwise, the cell is revealed and the game continues. The game board is printed after each move, with unrevealed cells displayed as '?'.