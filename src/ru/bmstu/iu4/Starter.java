package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {
        Field field = new Field();

        field.setWidth(7);
        field.setHeight(7);
        field.snake.setX(5);
        field.snake.setY(5);
        field.initField();

        while (true) {
            field.printField();
            //field.makeMoveRight();
            //field.makeMoveLeft();
            field.makeMoveUp();
            //field.makeMoveDown();
            for (int i = 0; i < 6; i++) {
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}