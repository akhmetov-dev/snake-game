package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        int width = 10;
        int height = 10;

        SnakeGame container = new SnakeGame();
        container.initContainer(width, height);
        container.clearField();
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
}