package ru.bmstu.iu4;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        Field field = new Field();

        field.setWidth(7);
        field.setHeight(7);
        field.snake.setX(1);
        field.snake.setY(1);
        field.initField();
        field.printField();

        char tmp;
        while (true) {
            tmp = (char) System.in.read();
            switch (tmp) {
                case 'w' :
                    field.makeMoveUp();
                    break;
                case 'a' :
                    field.makeMoveLeft();
                    break;
                case 's' :
                    field.makeMoveDown();
                    break;
                case 'd' :
                    field.makeMoveRight();
                    break;
            }
            field.printField();
            //for (int i = 0; i < 6; i++) {
            //    System.out.println();
            //}
            //try {
            //    Thread.sleep(1000);
            //} catch (InterruptedException ex) {
            //}
        }
    }
}