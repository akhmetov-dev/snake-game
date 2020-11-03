package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {
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
        snake.print();

        /*snake.moveRight();      //
        snake.print();

        snake.moveLeft();      //
        snake.print();

        snake.moveUp();      //
        snake.print();*/

        snake.moveDown();
        snake.print();
    }
}