package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {
        Snake snake = new Snake();
        snake.snakeInit();
        snake.setLastTurn(1);
        snake.grewUp();
        snake.print();
        snake.grewUp();
        snake.print();
    }
}