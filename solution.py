import random

def create_board(m, n, num_mines):
    board = [['0' for _ in range(n)] for _ in range(m)]
    mines = []
    while len(mines) < num_mines:
        mine = random.randint(0, m*n-1)
        if mine not in mines:
            mines.append(mine)