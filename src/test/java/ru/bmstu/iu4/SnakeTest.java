package ru.bmstu.iu4;

import junit.framework.TestCase;

public class SnakeTest extends TestCase {

    public void testMoveLeft() {
        int width = 10;
        int height = 10;

        Game container = new Game();
        container.initContainer();

        for (int i = 0; i < 3; i++) {
            container.getSnake().growUp();
        }
        container.clearField();
        container.updateField();
        container.getSnake().moveLeft();
        container.clearField();
        container.updateField();

    }

    public void testMoveRight() {
        int width = 10;
        int height = 10;

        Game container = new Game();
        container.initContainer();

        for (int i = 0; i < 3; i++) {
            container.getSnake().growUp();
        }
        container.clearField();
        container.updateField();
        container.getSnake().moveRight();
        container.clearField();
        container.updateField();
    }

    public void testMoveUp() {
        int width = 10;
        int height = 10;

        Game container = new Game();
        container.initContainer();

        for (int i = 0; i < 3; i++) {
            container.getSnake().growUp();
        }
        container.clearField();
        container.updateField();
        container.getSnake().moveUp();
        container.clearField();
        container.updateField();
    }

    public void testMoveDown() {
        int width = 10;
        int height = 10;

        Game container = new Game();
        container.initContainer();

        for (int i = 0; i < 3; i++) {
            container.getSnake().growUp();
        }
        container.clearField();
        container.updateField();
        container.getSnake().moveDown();
        container.clearField();
        container.updateField();
    }
}