package ru.bmstu.iu4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<PieceOfSnake> body;

    public void initSnake() {
        this.body = new ArrayList<PieceOfSnake>();
    }

    public void moveLeft() {                                                                                // Ход влево
        if (this.body.get(0).getTurn() == 3) {                                                                   // Если змейка до этого двигалась вправо, то влево идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setX(curX - 1);
                    this.body.get(i).setTurn(1);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                                   // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < this.body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                this.body.get(i).setY(curY + 1);
                                this.body.get(i).setTurn(2);
                            } else {
                                this.body.get(i).setY(curY - 1);
                                this.body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                this.body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).setX(curX - 1);
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveRight() {                                                                                // Ход вправо
        if (this.body.get(0).getTurn() == 1) {                                                                   // Если змейка до этого двигалась влево, то вправо идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setX(curX + 1);
                    this.body.get(i).setTurn(3);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < this.body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                this.body.get(i).setY(curY + 1);
                                this.body.get(i).setTurn(2);
                            } else {
                                this.body.get(i).setY(curY - 1);
                                this.body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                this.body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).setX(curX - 1);
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveUp() {                                                                                  // Ход вверх
        if (this.body.get(0).getTurn() == 4) {                                                                   // Если змейка до этого двигалась вниз, то вверх идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setY(curY + 1);
                    this.body.get(i).setTurn(2);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < this.body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                this.body.get(i).setY(curY + 1);
                                this.body.get(i).setTurn(2);
                            } else {
                                this.body.get(i).setY(curY - 1);
                                this.body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                this.body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).setX(curX - 1);
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveDown() {                                                                                // Ход вниз
        if (this.body.get(0).getTurn() == 2) {                                                                   // Если змейка до этого двигалась вверх, то вниз идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                              // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setY(curY - 1);
                    this.body.get(i).setTurn(4);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {                 // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                                // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                 // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                 // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                 // Двигаем вправо
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).setY(curY - 1);                                                // Двигаем вниз
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                              // Иначе, если предыдущий элемент ходил влево/вправо
                            if (curY < this.body.get(i - 1).getY()) {                                           // Перемещаем текущий элемент вверх/вниз
                                this.body.get(i).setY(curY + 1);
                                this.body.get(i).setTurn(2);
                            } else {
                                this.body.get(i).setY(curY - 1);
                                this.body.get(i).setTurn(4);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // Если предыдущий элемент ходил вверх/вниз,
                                this.body.get(i).setX(curX + 1);                                                // Перемещаем текущий элемент влево/вправо
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).setX(curX - 1);
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void printCoordinates() {
        System.out.println("----------");
        for (int i = 0; i < this.body.size(); i++) {
            System.out.println("X:" + this.body.get(i).getX());
            System.out.println("Y:" + this.body.get(i).getY());
            System.out.println("----------");
        }
    }

    public void dbgAddPieceOfSnake(int x, int y, int turn) {
        PieceOfSnake tmp = new PieceOfSnake();
        tmp.setX(x);
        tmp.setY(y);
        tmp.setSymbol('*');
        tmp.setTurn(turn);
        this.body.add(tmp);
    }

    public int getSize() {
        return this.body.size();
    }

    public PieceOfSnake getPieceOfSnake(int index) {
        return this.body.get(index);
    }
}
