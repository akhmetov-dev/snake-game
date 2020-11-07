package ru.bmstu.iu4;

public class Food {
    private int x;
    private int y;
    private char symbol = 'o';

    public void setX(int x) {                       // Сеттер координаты еды по Х
        this.x = x;
    }

    public int getX() {                             // Геттер координаты еды по Х
        return this.x;
    }

    public void setY(int y) {                       // Сеттер координаты еды по У
        this.y = y;
    }

    public int getY() {                             // Геттер координаты еды по У
        return this.y;
    }

    public void setSymbol(char symbol) {            // Сеттер символа еды
        this.symbol = symbol;
    }

    public char getSymbol() {                       // Геттер символа еды
        return this.symbol;
    }
}