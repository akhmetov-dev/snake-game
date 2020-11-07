package ru.bmstu.iu4;

public class SnakeGame {
    private int width;
    private int height;
    private char horizontalSide = '-';
    private char verticalSide = '|';
    private char filler = ' ';
    public Snake snake;
    public Food food;
    public char[][] field;
    int score;

    public void generateFood() {                                                                                        // Генератор координат еды
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

    public void initContainer(int width, int height) {                                                                  // Инициализация поля
        this.setWidth(width);
        this.setHeight(height);
        this.snake = new Snake();
        this.snake.initSnake();
        this.food = new Food();
        this.generateFood();
        this.snake.addHead((int) (width / 2), (int) (height / 2), 0);
        this.score = 0;
    }

    public void setWidth(int width) {                                                                                   // Сеттер ширины поля
        this.width = width;
    }

    public int getWidth() {                                                                                             // Геттер ширины поля
        return this.width;
    }

    public void setHeight(int height) {                                                                                 // Сеттер высоты поля
        this.height = height;
    }

    public int getHeight() {                                                                                            // Геттер высоты поля
        return this.height;
    }

    public void setVerticalSide(char verticalSide) {                                                                    // Сеттер символа левой/правой границы поля
        this.verticalSide = verticalSide;
    }

    public char getVerticalSide() {                                                                                     // Геттер символа левой/правой границы поля
        return this.verticalSide;
    }

    public void setHorizontalSide(char horizontalSide) {                                                                // Сеттер символа верхней/нижней границы поля
        this.horizontalSide = horizontalSide;
    }

    public char getHorizontalSide() {                                                                                   // Геттер символа верхней/нижней границы поля
        return this.horizontalSide;
    }

    public void setFiller(char filler) {                                                                                // Сеттер символа "пустой" ячейки поля
        this.filler = filler;
    }

    public char getFiller() {                                                                                           // Геттер символа "пустой" ячейки поля
        return this.filler;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore () {
        this.score++;
    }

    public void clearField() {                                                                                          // Очистка поля
        this.field = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.field[i][j] = this.filler;
            }
        }
    }

    public void printField() {                                                                                          // Печать поля
        for (int i = height + 2 - 1; i >= 0; i--) {
            for (int j = 0; j < width + 2; j++) {
                if (i == 0 || i == height + 2 - 1) {                                                                    // Если это первая/последняя строка, то печатаем символ горизонтальной границы ('-')
                    System.out.print(this.horizontalSide);
                } else {
                    if (j == 0 || j == width + 2 - 1) {                                                                 // Иначе, если это первый/последний символ в строке, печатаем боковую символ вертикальной границы ('|')
                        System.out.print(this.verticalSide);
                    } else {
                        System.out.print(this.field[i - 1][j - 1]);                                                     // Иначе печатаем содержимое поля
                    }
                }
            }
            System.out.println();
        }
    }

    public void updateField() {                                                                                         // Перенос обновленных координат тела змейки и еды на поле
        int x, y;
        int foodX = food.getX();
        int foodY = food.getY();
        PieceOfSnake tmp = new PieceOfSnake();

        for (int i = 0; i < this.snake.getSize(); i++) {
            if (i == 0) {
                if (this.snake.getSize() > 1) {
                    for (int j = 1; j < this.snake.getSize(); j++) {                                                        // Проверка на самопересечение
                        if (this.snake.getPieceOfSnake(0).getX() == this.snake.getPieceOfSnake(j).getX() && this.snake.getPieceOfSnake(0).getY() == this.snake.getPieceOfSnake(j).getY()) {
                            System.out.println("You lose!");
                            System.out.println("Your score: " + this.score);
                            System.exit(0);
                        }
                    }
                }
                if (this.snake.getPieceOfSnake(i).getX() == foodX && this.snake.getPieceOfSnake(i).getY() == foodY) {
                    snake.growUp();
                    this.incrementScore();
                    this.generateFood();
                } else {
                    field[foodY][foodX] = food.getSymbol();
                }
            }
            tmp = this.snake.getPieceOfSnake(i);
            x = tmp.getX();
            y = tmp.getY();

            if (y >= height || y < 0 || x >= width || x < 0) {
                System.out.println("You lose!");
                System.out.println("Your score: " + this.score);
                System.exit(0);
            } else {
                field[y][x] = tmp.getSymbol();
            }
        }
    }
}
