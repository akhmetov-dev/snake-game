package ru.bmstu.iu4;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) throws IOException {

        Game container = new Game();
        Scanner scanner = new Scanner(System.in);

        container.initContainer();
        container.clearField();
        container.updateField();
        container.listener.again = false;

        while (true) {
            while (container.gameOn) {
                switch (container.listener.getMode()) {
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
                            Thread.sleep(250);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    case 4:
                        try
                        {
                            Thread.sleep(125);
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
                }
            }
            JOptionPane.showMessageDialog(container.listener.mainFrame, "You lose!\nYour score: " + container.getScore());
            container.initContainer();
            container.listener.setMove(0);
            container.clearField();
            container.updateField();
        }
    }
}