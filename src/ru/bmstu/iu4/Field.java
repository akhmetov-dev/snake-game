package ru.bmstu.iu4;

public class Field {
    private int width;
    private String[] field;
    Snake snake = new Snake();

    public void setWidth (int w) {
        width = w;
    }

    public int getWidth () {
        return width;
    }


    public void initField () {
        field = new String[width];
        for (int i = 0; i < width; i++) {
            field[i] = " ";
        }
        field[snake.getX()] = "*";
    }

    public void printField () {
        for (String cell : field) {
            System.out.print(cell);
        }
        System.out.println();
    }

    public void makeMove () {
        if (snake.getX() == width - 1) {
            field[snake.getX()] = " ";
            snake.setX(0);
            field[snake.getX()] = "*";
        }
        else {
            snake.incrementX();
            field[snake.getX() - 1] = " ";
            field[snake.getX()] = "*";
        }
    }
}
