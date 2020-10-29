package ru.bmstu.iu4;

public class Field {
    private int width;
    private int height;
    char horizontalSide = '.';
    char vertivalSide = '.';
    char fill = ' ';

    private char[][] field;
    Snake snake = new Snake();

    public void setWidth(int w) {
        width = w;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getHeight() {
        return height;
    }

    public void initField() {
        field = new char[height + 2][width + 2];
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (i == 0 || i == height + 2 - 1) {
                    field[i][j] = horizontalSide;
                } else {
                    if (j == 0 || j == width + 2 - 1) {
                        field[i][j] = vertivalSide;
                    } else {
                        field[i][j] = fill;
                    }
                }
            }
        }
        field[snake.getY()][snake.getX()] = snake.getBody();
    }

    public void printField() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public void makeMoveRight() {
        if (snake.getX() == width) {
            field[snake.getY()][snake.getX()] = fill;
            snake.setX(1);
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
        else {
            field[snake.getY()][snake.getX()] = fill;
            snake.incrementX();
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }

    public void makeMoveLeft() {
        if (snake.getX() == 1) {
            field[snake.getY()][snake.getX()] = fill;
            snake.setX(width);
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
        else {
            field[snake.getY()][snake.getX()] = fill;
            snake.decrementX();
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }

    public void makeMoveDown() {
        if (snake.getY() == height) {
            field[snake.getY()][snake.getX()] = fill;
            snake.setY(1);
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
        else {
            field[snake.getY()][snake.getX()] = fill;
            snake.incrementY();
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }

    public void makeMoveUp() {
        if (snake.getY() == 1) {
            field[snake.getY()][snake.getX()] = fill;
            snake.setY(height);
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
        else {
            field[snake.getY()][snake.getX()] = fill;
            snake.decrementY();
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }
}
