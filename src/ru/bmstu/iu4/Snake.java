package ru.bmstu.iu4;

public class Snake {
    private int x;
    private int y;
    private char body = '*';

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

    public void setBody(char b) {
        body = b;
    }

    public char getBody() {
        return body;
    }
}