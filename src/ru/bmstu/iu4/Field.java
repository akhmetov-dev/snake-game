package ru.bmstu.iu4;

public class Field {
    private int width;
    private int height;
    private char horizontalSide = '-';
    private char verticalSide = '|';
    private char filler = ' ';

    public void setWidth(int width) {
        this.width = width;
    }
}
