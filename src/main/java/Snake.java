import java.util.ArrayList;

public class Snake {
    private ArrayList<PieceOfSnake> body;

    public Snake() {
        body = new ArrayList<>();
    }

    public void moveLeft() {
        if (body.get(0).getTurn() == 3) {
            moveRight();
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).decrementX();
                    body.get(i).setTurn(1);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {
                        switch (body.get(i - 1).getTurn()) {
                            case 1:
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {
                            if (curY < body.get(i - 1).getY()) {
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                            } else {
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveRight() {
        if (body.get(0).getTurn() == 1) {
            moveLeft();
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).incrementX();
                    body.get(i).setTurn(3);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {
                        switch (body.get(i - 1).getTurn()) {
                            case 1:
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {
                            if (curY < body.get(i - 1).getY()) {
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                            } else {
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveUp() {
        if (body.get(0).getTurn() == 4) {
            moveDown();
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).decrementY();
                    body.get(i).setTurn(2);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {
                        switch (body.get(i - 1).getTurn()) {
                            case 1:
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {
                            if (curY < body.get(i - 1).getY()) {
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                            } else {
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveDown() {
        if (body.get(0).getTurn() == 2) {
            moveUp();
        } else {
            for (int i = 0; i < body.size(); i++) {
                int curX = body.get(i).getX();
                int curY = body.get(i).getY();
                if (i == 0) {
                    body.get(i).incrementY();
                    body.get(i).setTurn(4);
                } else {
                    if (curY == body.get(i - 1).getY() || curX == body.get(i - 1).getX()) {
                        switch (body.get(i - 1).getTurn()) {
                            case 1:
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                                break;
                            case 2:
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                                break;
                            case 3:
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                                break;
                            case 4:
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                                break;
                        }
                    } else {
                        int prevTurn = body.get(i - 1).getTurn();
                        if (prevTurn == 1 || prevTurn == 3) {
                            if (curY < body.get(i - 1).getY()) {
                                body.get(i).incrementY();
                                body.get(i).setTurn(4);
                            } else {
                                body.get(i).decrementY();
                                body.get(i).setTurn(2);
                            }
                        } else if (prevTurn == 2 || prevTurn == 4) {
                            if (curX < body.get(i - 1).getX()) {
                                body.get(i).incrementX();
                                body.get(i).setTurn(3);
                            } else {
                                body.get(i).decrementX();
                                body.get(i).setTurn(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void addHead(int x, int y, int turn) {
        PieceOfSnake tmp = new PieceOfSnake(x, y);
        tmp.setTurn(turn);
        body.add(tmp);
    }

    public int getSize() {                                                              // Getter snake's size
        return body.size();
    }

    public PieceOfSnake getPieceOfSnake(int index) {                                // Getter of piece of snake by index
        return body.get(index);
    }

    public void growUp() {
        int size = body.size();

        int lastX = body.get(size - 1).getX();
        int lastY = body.get(size - 1).getY();

        PieceOfSnake tmp = new PieceOfSnake();

        int t = body.get(size - 1).getTurn();

        switch (t) {
            case 1:
                tmp.setX(lastX + 1);
                tmp.setY(lastY);
                break;
            case 2:
                tmp.setX(lastX);
                tmp.setY(lastY + 1);
                break;
            case 3:
                tmp.setX(lastX - 1);
                tmp.setY(lastY);
                break;
            case 4:
                tmp.setX(lastX);
                tmp.setY(lastY - 1);
                break;
        }
        tmp.setTurn(0);
        body.add(tmp);
    }
}
