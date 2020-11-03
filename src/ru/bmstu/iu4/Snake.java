package ru.bmstu.iu4;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<PieceOfSnake> body;

    public void initSnake() {
        body = new ArrayList<PieceOfSnake>();
    }

    //public void grewUp () {
    //    PieceOfSnake tmp = new PieceOfSnake();
    //    if (size != 0) {
    //        switch (lastTurn) {
    //            case 1 :
    //                tmp.setX(body.get(size - 1).getX() + 1);
    //                tmp.setY(body.get(size - 1).getY());
    //                break;
    //            case 2:
    //                tmp.setX(body.get(size - 1).getX());
    //                tmp.setY(body.get(size - 1).getY() - 1);
    //                break;
    //            case 3:
    //                tmp.setX(body.get(size - 1).getX() - 1);
    //                tmp.setY(body.get(size - 1).getY());
    //                break;
    //            case 4:
    //                tmp.setX(body.get(size - 1).getX());
    //                tmp.setY(body.get(size - 1).getY() + 1);
    //                break;
    //        }
    //    }
    //    else {
    //        tmp.setX(3);    //////////////////////
    //        tmp.setY(3);    //////////////////////
    //    }
    //    tmp.setSymbol('*');
    //    body.add(size, tmp);
    //    incrementSize();
    //}

    public void moveLeft() {                                                                                // Ход влево
        if (body.get(0).getTurn() == 3) {                                                                   // Если змейка до этого двигалась вправо, то влево идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).setX(curX - 1);
                    body.get(i).setTurn(1);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                body.get(i).setY(curY + 1);
                                body.get(i).setTurn(2);
                            } else {
                                body.get(i).setY(curY - 1);
                                body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).setX(curX - 1);
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveRight() {                                                                                // Ход вправо
        if (body.get(0).getTurn() == 1) {                                                                   // Если змейка до этого двигалась влево, то вправо идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).setX(curX + 1);
                    body.get(i).setTurn(3);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                body.get(i).setY(curY + 1);
                                body.get(i).setTurn(2);
                            } else {
                                body.get(i).setY(curY - 1);
                                body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).setX(curX - 1);
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveUp() {                                                                                  // Ход вверх
        if (body.get(0).getTurn() == 4) {                                                                   // Если змейка до этого двигалась вниз, то вверх идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).setY(curY + 1);
                    body.get(i).setTurn(2);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                body.get(i).setY(curY + 1);
                                body.get(i).setTurn(2);
                            } else {
                                body.get(i).setY(curY - 1);
                                body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).setX(curX - 1);
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveDown() {                                                                                // Ход вниз
        if (body.get(0).getTurn() == 2) {                                                                   // Если змейка до этого двигалась вверх, то вниз идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).setY(curY - 1);
                    body.get(i).setTurn(4);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                body.get(i).setY(curY + 1);
                                body.get(i).setTurn(2);
                            } else {
                                body.get(i).setY(curY - 1);
                                body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).setX(curX - 1);
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void print() {
        System.out.println("----------");
        for (int i = 0; i < body.size(); i++) {
            System.out.println("X:" + body.get(i).getX());
            System.out.println("Y:" + body.get(i).getY());
            System.out.println("----------");
        }
    }

    public void dbgAddPieceOfSnake(int x, int y, int turn) {
        PieceOfSnake tmp = new PieceOfSnake();
        tmp.setX(x);
        tmp.setY(y);
        tmp.setSymbol('*');
        tmp.setTurn(turn);
        body.add(tmp);
    }

    public int getSize() {
        return body.size();
    }
}
