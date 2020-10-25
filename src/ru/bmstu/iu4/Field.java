package ru.bmstu.iu4;

public class Field {
    private int width;
    private int height;
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
        field = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = ' ';
            }
        }
        field[snake.getY()][snake.getX()] = snake.getBody();///////////////////////////////Исправить нуль
    }

    public void printField() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public void makeMoveRight() {
        if (snake.getX() == width - 1) {
            field[snake.getY()][snake.getX()] = ' ';
            snake.setX(0);
            field[snake.getY()][snake.getX()] = snake.getBody();
        } else {
            snake.incrementX();
            field[snake.getY()][snake.getX() - 1] = ' ';
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }

    public void makeMoveLeft() {
        if (snake.getX() == 0) {
            field[snake.getY()][snake.getX()] = ' ';
            snake.setX(width - 1);
            field[snake.getY()][snake.getX()] = snake.getBody();
        } else {
            snake.decrementX();
            field[snake.getY()][snake.getX() + 1] = ' ';
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }

    public void makeMoveDown() {
        if (snake.getY() == height - 1) {
            field[snake.getY()][snake.getX()] = ' ';
            snake.setY(0);
            field[snake.getY()][snake.getX()] = snake.getBody();
        } else {
            snake.incrementY();
            field[snake.getY() - 1][snake.getX()] = ' ';
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }

    public void makeMoveUp() {
        if (snake.getY() == 0) {
            field[snake.getY()][snake.getX()] = ' ';
            snake.setY(height - 1);
            field[snake.getY()][snake.getX()] = snake.getBody();
        } else {
            snake.decrementY();
            field[snake.getY() + 1][snake.getX()] = ' ';
            field[snake.getY()][snake.getX()] = snake.getBody();
        }
    }
}
