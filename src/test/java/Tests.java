////////////////////////Тесты////////////////////////

import ru.bmstu.iu4.SnakeGame;
import ru.bmstu.iu4.Snake;

import java.io.IOException;

public class Tests {
    public void testMoveLeft() {
        Snake snake = new Snake();
        snake.initSnake();

        snake.dbgAddPieceOfSnake(2, 2, 0);
        snake.dbgAddPieceOfSnake(2, 3, 0);
        snake.dbgAddPieceOfSnake(3, 3, 0);
        snake.dbgAddPieceOfSnake(3, 4, 0);
        snake.dbgAddPieceOfSnake(4, 4, 0);
        snake.dbgAddPieceOfSnake(5, 4, 0);
        snake.dbgAddPieceOfSnake(6, 4, 0);
        snake.dbgAddPieceOfSnake(6, 3, 0);
        snake.dbgAddPieceOfSnake(6, 2, 0);
        snake.dbgAddPieceOfSnake(5, 2, 0);

        System.out.println("Size of snake:" + snake.getSize());
        snake.printCoordinates();

        snake.moveLeft();
        snake.printCoordinates();
    }

    public void testMoveUp() {
        Snake snake = new Snake();
        snake.initSnake();

        snake.dbgAddPieceOfSnake(5, 3, 0);
        snake.dbgAddPieceOfSnake(4, 3, 0);
        snake.dbgAddPieceOfSnake(4, 4, 0);
        snake.dbgAddPieceOfSnake(4, 5, 0);
        snake.dbgAddPieceOfSnake(3, 5, 0);
        snake.dbgAddPieceOfSnake(2, 5, 0);
        snake.dbgAddPieceOfSnake(2, 4, 0);
        snake.dbgAddPieceOfSnake(2, 3, 0);
        snake.dbgAddPieceOfSnake(2, 2, 0);
        snake.dbgAddPieceOfSnake(3, 2, 0);

        System.out.println("Size of snake:" + snake.getSize());
        snake.printCoordinates();

        snake.moveUp();
        snake.printCoordinates();
    }

    public void testMoveRight() {
        Snake snake = new Snake();
        snake.initSnake();

        snake.dbgAddPieceOfSnake(5, 3, 0);
        snake.dbgAddPieceOfSnake(4, 3, 0);
        snake.dbgAddPieceOfSnake(4, 4, 0);
        snake.dbgAddPieceOfSnake(4, 5, 0);
        snake.dbgAddPieceOfSnake(3, 5, 0);
        snake.dbgAddPieceOfSnake(2, 5, 0);
        snake.dbgAddPieceOfSnake(2, 4, 0);
        snake.dbgAddPieceOfSnake(2, 3, 0);
        snake.dbgAddPieceOfSnake(2, 2, 0);
        snake.dbgAddPieceOfSnake(3, 2, 0);

        System.out.println("Size of snake:" + snake.getSize());
        snake.printCoordinates();

        snake.moveRight();
        snake.printCoordinates();
    }

    public void testMoveDown() {
        Snake snake = new Snake();
        snake.initSnake();

        snake.dbgAddPieceOfSnake(5, 3, 0);
        snake.dbgAddPieceOfSnake(4, 3, 0);
        snake.dbgAddPieceOfSnake(4, 4, 0);
        snake.dbgAddPieceOfSnake(4, 5, 0);
        snake.dbgAddPieceOfSnake(3, 5, 0);
        snake.dbgAddPieceOfSnake(2, 5, 0);
        snake.dbgAddPieceOfSnake(2, 4, 0);
        snake.dbgAddPieceOfSnake(2, 3, 0);
        snake.dbgAddPieceOfSnake(2, 2, 0);
        snake.dbgAddPieceOfSnake(3, 2, 0);

        System.out.println("Size of snake:" + snake.getSize());
        snake.printCoordinates();

        snake.moveDown();
        snake.printCoordinates();
    }

    public void testField () throws IOException {
        int width = 10;
        int height = 10;
        SnakeGame container = new SnakeGame();
        container.initContainer(width, height);
        container.clearField();

        //container.snake.dbgAddPieceOfSnake(2, 2, 0);
        //container.snake.dbgAddPieceOfSnake(2, 3, 0);
        //container.snake.dbgAddPieceOfSnake(3, 3, 0);
        //container.snake.dbgAddPieceOfSnake(3, 4, 0);
        //container.snake.dbgAddPieceOfSnake(4, 4, 0);
        //container.snake.dbgAddPieceOfSnake(5, 4, 0);
        //container.snake.dbgAddPieceOfSnake(6, 4, 0);
        //container.snake.dbgAddPieceOfSnake(6, 3, 0);
        //container.snake.dbgAddPieceOfSnake(6, 2, 0);
        //container.snake.dbgAddPieceOfSnake(5, 2, 0);

        container.updateField();
        container.printField();
        char c;
        while (true) {
            c = (char) System.in.read();
            switch (c) {
                case 'a':
                    container.snake.moveLeft();
                    break;
                case 'w':
                    container.snake.moveUp();
                    break;
                case 'd':
                    container.snake.moveRight();
                    break;
                case 's':
                    container.snake.moveDown();
                    break;
            }
            container.clearField();
            container.updateField();
            container.printField();
        }
    }

    public void testGenerateRandomNum () throws IOException {
        int x = 10;
        int y = 15;

        int r1;
        int r2;
        char c;
        while (true) {
            r1 = (int) (Math.random() * x);
            r2 = (int) (Math.random() * y);
            c = (char) System.in.read();
            switch (c) {
                case 'a':
                    System.out.println(r1 + ", " + r2);
                    break;
            }
        }
    }
}