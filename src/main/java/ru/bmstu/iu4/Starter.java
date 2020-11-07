package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        int width = 10;
        int height = 10;

        Game container = new Game();
        container.initContainer(width, height);
        container.clearField();
        container.updateField();
        container.printField();

        while (true) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            switch (container.listener.getMove()) {
                case 1:
                    container.snake.moveLeft();
                    break;
                case 2:
                    container.snake.moveUp();
                    break;
                case 3:
                    container.snake.moveRight();
                    break;
                case 4:
                    container.snake.moveDown();
                    break;
            }
            container.clearField();
            container.updateField();
            container.printField();
        }
    }
}