package ru.bmstu.iu4;

import junit.framework.TestCase;

public class SnakeTest extends TestCase {

    public void testMoveLeft() {
        int width = 10;
        int height = 10;

        SnakeGame container = new SnakeGame();
        container.initContainer(width, height);

        for (int i = 0; i < 3; i++) {
            container.snake.growUp();
        }
        container.clearField();
        container.updateField();
        container.printField();
        container.snake.moveLeft();
        container.clearField();
        container.updateField();
        container.printField();
    }

    public void testMoveRight() {
        int width = 10;
        int height = 10;

        SnakeGame container = new SnakeGame();
        container.initContainer(width, height);

        for (int i = 0; i < 3; i++) {
            container.snake.growUp();
        }
        container.clearField();
        container.updateField();
        container.printField();
        container.snake.moveRight();
        container.clearField();
        container.updateField();
        container.printField();
    }

    public void testMoveUp() {
        int width = 10;
        int height = 10;

        SnakeGame container = new SnakeGame();
        container.initContainer(width, height);

        for (int i = 0; i < 3; i++) {
            container.snake.growUp();
        }
        container.clearField();
        container.updateField();
        container.printField();
        container.snake.moveUp();
        container.clearField();
        container.updateField();
        container.printField();
    }

    public void testMoveDown() {
        int width = 10;
        int height = 10;

        SnakeGame container = new SnakeGame();
        container.initContainer(width, height);

        for (int i = 0; i < 3; i++) {
            container.snake.growUp();
        }
        container.clearField();
        container.updateField();
        container.printField();
        container.snake.moveDown();
        container.clearField();
        container.updateField();
        container.printField();
    }
}