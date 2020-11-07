package ru.bmstu.iu4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<PieceOfSnake> body;

    public void initSnake() {
        this.body = new ArrayList<PieceOfSnake>();
    }

    public void moveLeft() {                                                                                    // Ход влево
        if (this.body.get(0).getTurn() == 3) {                                                                  // Если змейка до этого двигалась вправо, то влево идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setX(curX - 1);
                    this.body.get(i).setTurn(1);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                               // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                // Двигаем вправо
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

    public void moveRight() {                                                                                   // Ход вправо
        if (this.body.get(0).getTurn() == 1) {                                                                  // Если змейка до этого двигалась влево, то вправо идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setX(curX + 1);
                    this.body.get(i).setTurn(3);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                               // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                // Двигаем вправо
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

    public void moveUp() {                                                                                      // Ход вверх
        if (this.body.get(0).getTurn() == 4) {                                                                  // Если змейка до этого двигалась вниз, то вверх идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setY(curY + 1);
                    this.body.get(i).setTurn(2);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                               // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                // Двигаем вправо
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

    public void moveDown() {                                                                                    // Ход вниз
        if (this.body.get(0).getTurn() == 2) {                                                                  // Если змейка до этого двигалась вверх, то вниз идти нельзя
            System.out.println("You can't do it.");
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Получаем координаты текущего элемента
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).setY(curY - 1);
                    this.body.get(i).setTurn(4);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // Если текущий и предыдущий эл-т находятся на одном У или на одном Х,
                        switch (this.body.get(i - 1).getTurn()) {                                               // двигаем в том же направлении, что и предидущий элемент
                            case 1:
                                this.body.get(i).setX(curX - 1);                                                // Двигаем влево
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).setY(curY + 1);                                                // Двигаем вверх
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).setX(curX + 1);                                                // Двигаем вправо
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

    public void addHead(int x, int y, int turn) {
        PieceOfSnake tmp = new PieceOfSnake();
        tmp.setX(x);
        tmp.setY(y);
        tmp.setSymbol('x');
        tmp.setTurn(turn);
        this.body.add(tmp);
    }

    public int getSize() {
        return this.body.size();
    }

    public PieceOfSnake getPieceOfSnake(int index) {
        return this.body.get(index);
    }

    public void growUp() {                                                                                      // Рост змейки (когда поглощает еду)
        int size = this.body.size();

        int lastX = this.body.get(size - 1).getX();
        int lastY = this.body.get(size - 1).getY();

        PieceOfSnake tmp = new PieceOfSnake();

        int t = this.body.get(size - 1).getTurn();                                                              // Определяем направление движения последнего кусочка змейки

        switch (t) {
            case 1:                                                                                             // Обработка движения влево
                tmp.setX(lastX + 1);
                tmp.setY(lastY);
                tmp.setTurn(0);
                break;
            case 2:                                                                                             // Обработка движения вверх
                tmp.setX(lastX);
                tmp.setY(lastY - 1);
                tmp.setTurn(0);
                break;
            case 3:                                                                                             // Обработка движения вправо
                tmp.setX(lastX - 1);
                tmp.setY(lastY);
                tmp.setTurn(0);
                break;
            case 4:                                                                                             // Обработка движения вниз
                tmp.setX(lastX);
                tmp.setY(lastY + 1);
                tmp.setTurn(0);
                break;
            default:
                tmp.setX(lastX + 1);
                tmp.setY(lastY);
                tmp.setTurn(0);
                break;
        }
        tmp.setSymbol('*');
        this.body.add(tmp);
    }
}
