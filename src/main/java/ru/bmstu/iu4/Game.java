package ru.bmstu.iu4;

import java.awt.*;

public class Game {
    private int width = 10;                                                                                                  // width of field
    private int height = 10;                                                                                                 // height of field
    private Snake snake;
    private Food food;
    private int score;
    public MoveListener listener = new MoveListener(width, height);                                                                         // Key listener for intercept of user press button
    public boolean gameOn;

    public void generateFood() {                                                                                        // food coordinates generator
        int randX;
        int randY;
        boolean flag;

        while (true) {
            randX = (int) (Math.random() * this.width);
            randY = (int) (Math.random() * this.height);
            flag = true;

            for (int i = 0; i < this.snake.getSize(); i++) {
                if (this.snake.getPieceOfSnake(i).getX() == randX && this.snake.getPieceOfSnake(i).getY() == randY) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                this.food.setX(randX);
                this.food.setY(randY);
                break;
            }
        }
    }

    public void initContainer() {                                                                  // Initialization of field
        this.snake = new Snake();
        this.snake.initSnake();
        this.snake.addHead((int) (width / 2), (int) (height / 2), 0);
        this.food = new Food();
        this.generateFood();
        this.score = 0;
        //listener = new MoveListener(width, height);
        gameOn = true;

    }

    public Snake getSnake() {                                                                                          // Getter snake
        return this.snake;
    }

    public void setWidth(int width) {                                                                                   // Setter width of field
        this.width = width;
    }

    public int getWidth() {                                                                                             // Getter width of field
        return this.width;
    }

    public void setHeight(int height) {                                                                                 // Setter height of field
        this.height = height;
    }

    public int getHeight() {                                                                                            // Getter height of field
        return this.height;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void clearField() {                                                                                          // Clear field
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                listener.panels.get(i).get(j).setBackground(Color.lightGray);
            }
        }
    }

    public void updateField() {                                                                                         // transfer of snake's coordinates
        int x, y;
        int foodX = food.getX();
        int foodY = food.getY();
        PieceOfSnake tmp = new PieceOfSnake();

        if (this.snake.getPieceOfSnake(0).getX() == foodX && this.snake.getPieceOfSnake(0).getY() == foodY) {
            snake.growUp();
            this.incrementScore();
            this.generateFood();
        } else {
            listener.panels.get(foodY).get(foodX).setBackground(Color.orange);
        }

        for (int i = 0; i < this.snake.getSize(); i++) {
            if (i == 0) {
                if (this.snake.getSize() > 1) {
                    for (int j = 1; j < this.snake.getSize(); j++) {                                                        // intersect yourself check
                        if (this.snake.getPieceOfSnake(0).getX() == this.snake.getPieceOfSnake(j).getX() && this.snake.getPieceOfSnake(0).getY() == this.snake.getPieceOfSnake(j).getY()) {
                            gameOn = false;
                            /*System.out.println("You lose!");
                            System.out.println("Your score: " + this.score);
                            System.exit(0);*/
                        }
                    }
                }
            }
            tmp = this.snake.getPieceOfSnake(i);
            x = tmp.getX();
            y = tmp.getY();

            if (y >= height || y < 0 || x >= width || x < 0) {
                /*System.out.println("You lose!");
                System.out.println("Your score: " + this.score);
                System.exit(0);*/
                gameOn = false;
            } else {
                listener.panels.get(y).get(x).setBackground(Color.darkGray);
            }
        }
    }
}
