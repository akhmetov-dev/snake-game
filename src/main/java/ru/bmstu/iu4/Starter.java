package ru.bmstu.iu4;

import java.io.IOException;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws IOException {
        int width = 10;
        int height = 10;

        Game container = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pick the difficulty level:");
        container.setMode(scanner.nextInt());

        container.initContainer(width, height);
        container.clearField();
        container.updateField();
        container.printField();

        while (true) {
            switch (container.getMode()) {
                case 1:
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 2:
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 3:
                    try
                    {
                        Thread.sleep(300);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    break;
            }
            if (container.listener.getMove() == 1 || container.listener.getMove() == 2 || container.listener.getMove() == 3 || container.listener.getMove() == 4) {
                switch (container.listener.getMove()) {
                    case 1:
                        container.getSnake().moveLeft();
                        break;
                    case 2:
                        container.getSnake().moveUp();
                        break;
                    case 3:
                        container.getSnake().moveRight();
                        break;
                    case 4:
                        container.getSnake().moveDown();
                        break;
                }
                container.clearField();
                container.updateField();
                container.printField();
            }
        }
    }
}