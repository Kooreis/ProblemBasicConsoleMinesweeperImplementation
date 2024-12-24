for mine in mines:
        row = mine // n
        col = mine % n
        board[row][col] = 'X'