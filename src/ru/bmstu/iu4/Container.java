package ru.bmstu.iu4;

public class Container {
    private int width;
    private int height;
    private char horizontalSide = '-';
    private char verticalSide = '|';
    private char filler = ' ';
    public Snake snake;
    public Food food;
    public char[][] field;

    public void generateFood() {
        int randX;
        int randY;
        boolean flag;

        while (true) {
            randX = (int) (Math.random() * this.width);
            randY = (int) (Math.random() * this.height);
            flag = true;

            for (int i = 0; i < this.snake.getSize(); i++) {
                if (this.snake.getPieceOfSnake(i).getX() == randX && this.snake.getPieceOfSnake(i).getY() == randY) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                this.food.setX(randX);
                this.food.setY(randY);
                break;
            }
        }
    }

    public void initContainer(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.snake = new Snake();
        this.snake.initSnake();
        this.food = new Food();
        this.generateFood();
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

    public void clearField() {
        this.field = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.field[i][j] = this.filler;
            }
        }
    }

    public void printField() {                                     // Печать поля
        for (int i = height + 2 - 1; i >= 0; i--) {
            for (int j = 0; j < width + 2; j++) {
                if (i == 0 || i == height + 2 - 1) {                // Если это первая/последняя строка, то печатаем символ горизонтальной границы ('-')
                    System.out.print(this.horizontalSide);
                } else {
                    if (j == 0 || j == width + 2 - 1) {             // Иначе, если это первый/последний символ в строке, печатаем боковую символ вертикальной границы ('|')
                        System.out.print(this.verticalSide);
                    } else {
                        System.out.print(this.field[i - 1][j - 1]); // Иначе печатаем содержимое поля
                    }
                }
            }
            System.out.println();
        }
    }

    public void updateField() {
        int x, y;
        int foodX = food.getX();
        int foodY = food.getY();

        PieceOfSnake tmp = new PieceOfSnake();
        for (int i = 0; i < this.snake.getSize(); i++) {
            if (i == 0) {
                if (this.snake.getPieceOfSnake(i).getX() == foodX && this.snake.getPieceOfSnake(i).getY() == foodY) {
                    snake.growUp();
                    this.generateFood();
                }
                else {
                    field[foodY][foodX] = food.getSymbol();
                }
            }
            tmp = this.snake.getPieceOfSnake(i);
            x = tmp.getX();
            y = tmp.getY();

            if (y >= height || y < 0 || x >= width || x < 0) {
                System.out.println("You lose!");
                System.exit(1);
            } else {
                field[y][x] = tmp.getSymbol();
            }
        }
    }
}
