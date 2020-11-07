package ru.bmstu.iu4;

public class PieceOfSnake {
    private int x;
    private int y;
    private int turn;                                           // Содержит идентификатор направления хода выбранного элемента (1 ячейки) змейки
                                                                // 0 - хода не было, 1 - влево, 2 - вверх, 3 - вправо, 4 - влево
    private char symbol = '*';

    public void setX(int x) {                                   // Сеттер координаты по Х текущего элемента (1 ячейки) змейки
        this.x = x;
    }

    public void incrementX() {                                  // Инкремент (увеличение на 1) координаты по Х текущего элемента (1 ячейки) змейки
        this.x++;
    }

    public void decrementX() {                                  // Декремент (уменьшение на 1) координаты по Х текущего элемента (1 ячейки) змейки
        this.x--;
    }

    public int getX() {                                         // Геттер координаты по Х текущего элемента (1 ячейки) змейки
        return this.x;
    }

    public void setY(int y) {                                   // Сеттер координаты по У текущего элемента (1 ячейки) змейки
        this.y = y;
    }

    public void incrementY() {                                  // Инкремент (увеличение на 1) координаты по У текущего элемента (1 ячейки) змейки
        this.y++;
    }

    public void decrementY() {                                  // Декремент (уменьшение на 1) координаты по У текущего элемента (1 ячейки) змейки
        this.y--;
    }

    public int getY() {                                         // Геттер координаты по У текущего элемента (1 ячейки) змейки
        return this.y;
    }

    public void setSymbol(char symbol) {                        // Сеттер переменной хранящей символ для отображения текущего элемента змейки
        this.symbol = symbol;
    }

    public char getSymbol() {                                   // Геттер переменной хранящей символ для отображения текущего элемента змейки
        return this.symbol;
    }

    public void setTurn(int turn) {                             // Сеттер идентификатора направления хода выбранного элемента змейки
        this.turn = turn;
    }

    public int getTurn() {                                      // Геттер идентификатора направления хода выбранного элемента змейки
        return this.turn;
    }
}