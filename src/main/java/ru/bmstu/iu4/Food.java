package ru.bmstu.iu4;

public class Food {
    private int x;
    private int y;
    private char symbol = 'o';

    public void setX(int x) {                       // Setter X coordinate
        this.x = x;
    }

    public int getX() {                             // Getter X coordinate
        return this.x;
    }

    public void setY(int y) {                       // Setter Y coordinate
        this.y = y;
    }

    public int getY() {                             // Getter Y coordinate
        return this.y;
    }

    public void setSymbol(char symbol) {            // Setter of symbol to display current piece of snake
        this.symbol = symbol;
    }

    public char getSymbol() {                       // Getter of symbol to display current piece of snake
        return this.symbol;
    }
}