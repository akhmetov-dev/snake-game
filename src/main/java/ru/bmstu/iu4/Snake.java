package ru.bmstu.iu4;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<PieceOfSnake> body;                                                    // List of objects "Piece of snake"

    public void initSnake() {
        this.body = new ArrayList<PieceOfSnake>();
    }

    public void moveLeft() {                                                                                    // Move left
        if (this.body.get(0).getTurn() == 3) {                                                                  // If snake moved right before, it might not move left
            this.moveRight();
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Get current coordinates
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).decrementX();
                    this.body.get(i).setTurn(1);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // If current and previous elements locates on the same X or on the same Y
                        switch (this.body.get(i - 1).getTurn()) {                                               // current element moves in the same direction like a previous element
                            case 1:
                                this.body.get(i).decrementX();                                                // Move left
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).decrementY();                                                // Move up
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).incrementX();                                                // Move right
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).incrementY();                                                // Move down
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                                   // Else: if the previous element moved left/right
                            if (curY < this.body.get(i - 1).getY()) {                                           // current element moves up/down
                                this.body.get(i).incrementY();
                                this.body.get(i).setTurn(4);
                            } else {
                                this.body.get(i).decrementY();
                                this.body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // if the previous element moved up/down
                                this.body.get(i).incrementX();                                                // current element moves left/right
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).decrementX();
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveRight() {                                                                                   // Move right
        if (this.body.get(0).getTurn() == 1) {                                                                  // If snake moved left before, it might not move right
            this.moveLeft();
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Get current coordinates
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).incrementX();
                    this.body.get(i).setTurn(3);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // If current and previous elements locates on the same X or on the same Y
                        switch (this.body.get(i - 1).getTurn()) {                                               // current element moves in the same direction like a previous element
                            case 1:
                                this.body.get(i).decrementX();                                                // Move left
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).decrementY();                                                // Move up
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).incrementX();                                                // Move right
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).incrementY();                                                // Move down
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                                   // Else: if the previous element moved left/right
                            if (curY < this.body.get(i - 1).getY()) {                                           // current element moves up/down
                                this.body.get(i).incrementY();
                                this.body.get(i).setTurn(4);
                            } else {
                                this.body.get(i).decrementY();
                                this.body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // if the previous element moved up/down
                                this.body.get(i).incrementX();                                                // current element moves left/right
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).decrementX();
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveUp() {                                                                                      // Move up
        if (this.body.get(0).getTurn() == 4) {                                                                  // If snake moved down before, it might not move up
            this.moveDown();
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Get current coordinates
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).decrementY();
                    this.body.get(i).setTurn(2);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // If current and previous elements locates on the same X or on the same Y
                        switch (this.body.get(i - 1).getTurn()) {                                               // current element moves in the same direction like a previous element
                            case 1:
                                this.body.get(i).decrementX();                                                // Move left
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).decrementY();                                                // Move up
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).incrementX();                                                // Move right
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).incrementY();                                                // Move down
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                                   // Else: if the previous element moved left/right
                            if (curY < this.body.get(i - 1).getY()) {                                           // current element moves up/down
                                this.body.get(i).incrementY();
                                this.body.get(i).setTurn(4);
                            } else {
                                this.body.get(i).decrementY();
                                this.body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // if the previous element moved up/down
                                this.body.get(i).incrementX();                                                // current element moves left/right
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).decrementX();
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveDown() {                                                                                    // Move down
        if (this.body.get(0).getTurn() == 2) {                                                                  // If snake moved up before, it might not move down
            this.moveUp();
        } else {
            for (int i = 0; i < this.body.size(); i++) {
                int curX = this.body.get(i).getX();                                                             // Get current coordinates
                int curY = this.body.get(i).getY();
                if (i == 0) {
                    this.body.get(i).incrementY();
                    this.body.get(i).setTurn(4);
                } else {
                    if (curY == this.body.get(i - 1).getY() || curX == this.body.get(i - 1).getX()) {           // If current and previous elements locates on the same X or on the same Y
                        switch (this.body.get(i - 1).getTurn()) {                                               // current element moves in the same direction like a previous element
                            case 1:
                                this.body.get(i).decrementX();                                                // Move left
                                this.body.get(i).setTurn(1);
                                break;
                            case 2:
                                this.body.get(i).decrementY();                                                // Move up
                                this.body.get(i).setTurn(2);
                                break;
                            case 3:
                                this.body.get(i).incrementX();                                                // Move right
                                this.body.get(i).setTurn(3);
                                break;
                            case 4:
                                this.body.get(i).incrementY();                                                // Move down
                                this.body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = this.body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {                                                   // Else: if the previous element moved left/right
                            if (curY < this.body.get(i - 1).getY()) {                                           // current element moves up/down
                                this.body.get(i).incrementY();
                                this.body.get(i).setTurn(4);
                            } else {
                                this.body.get(i).decrementY();
                                this.body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < this.body.get(i - 1).getX()) {                                           // if the previous element moved up/down
                                this.body.get(i).incrementX();                                                // current element moves left/right
                                this.body.get(i).setTurn(3);
                            } else {
                                this.body.get(i).decrementX();
                                this.body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void addHead(int x, int y, int turn) {                               //Add snake's head in passed coordinates
        PieceOfSnake tmp = new PieceOfSnake();
        tmp.setX(x);
        tmp.setY(y);
        tmp.setTurn(turn);
        this.body.add(tmp);
    }

    public int getSize() {                                                              // Getter snake's size
        return this.body.size();
    }

    public PieceOfSnake getPieceOfSnake(int index) {                                // Getter of piece of snake by index
        return this.body.get(index);
    }

    public void growUp() {                                                                                      // growth of snake
        int size = this.body.size();

        int lastX = this.body.get(size - 1).getX();
        int lastY = this.body.get(size - 1).getY();

        PieceOfSnake tmp = new PieceOfSnake();

        int t = this.body.get(size - 1).getTurn();                                                              // get direction_id of last piece of snake

        switch (t) {
            case 1:                                                                                             // Processing of move left
                tmp.setX(lastX + 1);
                tmp.setY(lastY);
                tmp.setTurn(0);
                break;
            case 2:                                                                                             // Processing of move up
                tmp.setX(lastX);
                tmp.setY(lastY + 1);
                tmp.setTurn(0);
                break;
            case 3:                                                                                             // Processing of move right
                tmp.setX(lastX - 1);
                tmp.setY(lastY);
                tmp.setTurn(0);
                break;
            case 4:                                                                                             // Processing of move down
                tmp.setX(lastX);
                tmp.setY(lastY - 1);
                tmp.setTurn(0);
                break;
        }
        this.body.add(tmp);
    }
}
