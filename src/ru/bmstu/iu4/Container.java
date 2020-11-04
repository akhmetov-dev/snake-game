package ru.bmstu.iu4;

public class Container {
    private int width;
    private int height;
    private char horizontalSide = '-';
    private char verticalSide = '|';
    private char filler = ' ';
    public Snake snake;
    public char[][] field;

    public void initContainer(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.snake = new Snake();
        this.snake.initSnake();
        this.snake.dbgAddPieceOfSnake((int)(width/2),(int)(height/2),0);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setVerticalSide(char verticalSide) {
        this.verticalSide = verticalSide;
    }

    public char getVerticalSide() {
        return this.verticalSide;
    }

    public void setHorizontalSide(char horizontalSide) {
        this.horizontalSide = horizontalSide;
    }

    public char getHorizontalSide() {
        return this.horizontalSide;
    }

    public void setFiller(char filler) {
        this.filler = filler;
    }

    public char getFiller() {
        return this.filler;
    }

    public void initField() {
        this.field = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.field[i][j] = this.filler;
            }
        }
    }

    public void printField () {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(this.field[i][j]);
            }
            System.out.println();
        }
    }
}
