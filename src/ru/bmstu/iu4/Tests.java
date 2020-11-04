package ru.bmstu.iu4;

////////////////////////Тесты////////////////////////

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
}