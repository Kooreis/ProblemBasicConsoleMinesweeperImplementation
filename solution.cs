```C#
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
```