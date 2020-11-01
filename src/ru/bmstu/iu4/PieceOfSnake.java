package ru.bmstu.iu4;

public class PieceOfSnake {
    private int x;
    private int y;
    private char symbol  = '*';

    public void setX(int valX) {
        x = valX;
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }

    public int getX() {
        return x;
    }

    public void setY(int valY) {
        y = valY;
    }

    public void incrementY() {
        y++;
    }

    public void decrementY() {
        y--;
    }

    public int getY() {
        return y;
    }

    public void setSymbol(char b) {
        symbol = b;
    }

    public char getSymbol() {
        return symbol;
    }
}