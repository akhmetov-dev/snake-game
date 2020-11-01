package ru.bmstu.iu4;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int size;
    private List<PieceOfSnake> body;

    private int lastTurn;               // 1 - ход влево, 2 - вверх, 3 - вправо, 4 - вниз

    public void snakeInit () {
        size = 0;
        body = new ArrayList<PieceOfSnake>();
    }

    public void grewUp () {
        PieceOfSnake tmp = new PieceOfSnake();
        if (size != 0) {
            switch (lastTurn) {
                case 1 :
                    tmp.setX(body.get(size - 1).getX() + 1);
                    tmp.setY(body.get(size - 1).getY());
                    break;
                case 2:
                    tmp.setX(body.get(size - 1).getX());
                    tmp.setY(body.get(size - 1).getY() - 1);
                    break;
                case 3:
                    tmp.setX(body.get(size - 1).getX() - 1);
                    tmp.setY(body.get(size - 1).getY());
                    break;
                case 4:
                    tmp.setX(body.get(size - 1).getX());
                    tmp.setY(body.get(size - 1).getY() + 1);
                    break;
            }
        }
        else {
            tmp.setX(3);    //////////////////////
            tmp.setY(3);    //////////////////////
        }
        tmp.setSymbol('*');
        body.add(size, tmp);
        incrementSize();
    }

    public void setLastTurn (int turn) {
        lastTurn = turn;
    }

    public int getLastTurn () {
        return lastTurn;
    }

    //public void setSize (int val) {
    //    size = val;
    //}

    public int getSize () {
        return size;
    }

    public void incrementSize () {
        size++;
    }

    public void print () {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " element X:" + body.get(i).getX());
            System.out.println(i + " element Y:" + body.get(i).getY());
        }
    }
}
