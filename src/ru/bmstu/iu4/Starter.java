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
        //char c = (char) System.in.read();
        //System.out.print("Ты ввел: " + c);



        while (true) {
            field.printField();
            switch (System.in.read()) {
                case ('w') :
                    field.makeMoveUp();
                case ('a') :
                    field.makeMoveLeft();
                case ('s') :
                    field.makeMoveDown();
                case ('d') :
                    field.makeMoveRight();
            }
            //field.printField();
            //field.makeMoveRight();
            //field.makeMoveLeft();
            //field.makeMoveUp();
            //field.makeMoveDown();
            for (int i = 0; i < 6; i++) {
                System.out.println();
            }
            //try {
            //    Thread.sleep(1000);
            //} catch (InterruptedException ex) {
            //}
        }
    }
}