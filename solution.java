for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = HIDDEN;
                if (random.nextInt(7) == 0)
                    mines[i][j] = MINE;
                else
                    mines[i][j] = EMPTY;
            }