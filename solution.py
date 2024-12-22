Here is a simple implementation of Minesweeper in Python:

```python
import random

def create_board(m, n, num_mines):
    board = [['0' for _ in range(n)] for _ in range(m)]
    mines = []
    while len(mines) < num_mines:
        mine = random.randint(0, m*n-1)
        if mine not in mines:
            mines.append(mine)
    for mine in mines:
        row = mine // n
        col = mine % n
        board[row][col] = 'X'
        if row > 0 and col > 0 and board[row-1][col-1] != 'X':
            board[row-1][col-1] = str(int(board[row-1][col-1]) + 1)
        if row > 0 and board[row-1][col] != 'X':
            board[row-1][col] = str(int(board[row-1][col]) + 1)
        if row > 0 and col < n-1 and board[row-1][col+1] != 'X':
            board[row-1][col+1] = str(int(board[row-1][col+1]) + 1)
        if col > 0 and board[row][col-1] != 'X':
            board[row][col-1] = str(int(board[row][col-1]) + 1)
        if col < n-1 and board[row][col+1] != 'X':
            board[row][col+1] = str(int(board[row][col+1]) + 1)
        if row < m-1 and col > 0 and board[row+1][col-1] != 'X':
            board[row+1][col-1] = str(int(board[row+1][col-1]) + 1)
        if row < m-1 and board[row+1][col] != 'X':
            board[row+1][col] = str(int(board[row+1][col]) + 1)
        if row < m-1 and col < n-1 and board[row+1][col+1] != 'X':
            board[row+1][col+1] = str(int(board[row+1][col+1]) + 1)
    return board

def print_board(board):
    for row in board:
        print(' '.join(row))

def play_game():
    m = int(input("Enter the number of rows: "))
    n = int(input("Enter the number of columns: "))
    num_mines = int(input("Enter the number of mines: "))
    board = create_board(m, n, num_mines)
    print_board(board)

play_game()
```

This program first asks the user to input the number of rows, columns, and mines. It then creates a board of the specified size and randomly places the specified number of mines. For each mine, it increments the count of neighboring cells. Finally, it prints the board.