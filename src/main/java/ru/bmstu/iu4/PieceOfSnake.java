package ru.bmstu.iu4;

public class PieceOfSnake {
    private int x;                                              // X coordinate
    private int y;                                              // Y coordinate
    private int turn;                                           // var contains direction_id of snake's move
                                                                // 0 - no moves, 1 - move left, 2 - move up, 3 - move right, 4 - move down
    private char symbol = '*';

    public void setX(int x) {                                   // Setter X coordinate current piece of snake
        this.x = x;
    }

    public void incrementX() {                                  // Increment of X coordinate current piece of snake
        this.x++;
    }

    public void decrementX() {                                  // Decrement of X coordinate current piece of snake
        this.x--;
    }

    public int getX() {                                         // Getter X coordinate current piece of snake
        return this.x;
    }

    public void setY(int y) {                                   // Setter Y coordinate current piece of snake
        this.y = y;
    }

    public void incrementY() {                                  // Increment of Y coordinate current piece of snake
        this.y++;
    }

    public void decrementY() {                                  // Decrement of Y coordinate current piece of snake
        this.y--;
    }

    public int getY() {                                         // Getter Y coordinate current piece of snake
        return this.y;
    }

    public void setSymbol(char symbol) {                        // Setter of symbol to display current piece of snake
        this.symbol = symbol;
    }

    public char getSymbol() {                                   // Getter of symbol to display current piece of snake
        return this.symbol;
    }

    public void setTurn(int turn) {                             // Setter of direction_id of snake's move
        this.turn = turn;
    }

    public int getTurn() {                                      // Getter of direction_id of snake's move
        return this.turn;
    }
}