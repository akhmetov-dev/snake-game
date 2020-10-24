package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {
        Field field = new Field();

        field.setWidth(10);
        field.snake.setX(3);
        field.initField();

        while (true) {
            field.printField();
            field.makeMove();
            for (int i = 0; i < 6;i++) {
                System.out.println();
            }
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {}
        }
    }
}