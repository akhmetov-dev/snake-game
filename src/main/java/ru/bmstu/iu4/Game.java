package ru.bmstu.iu4;

public class Game {
    private int width;                                                                                                  // width of field
    private int height;                                                                                                 // height of field
    private char horizontalSide = '-';                                                                                  // Symbol to show horizontal side of field
    private char verticalSide = '|';                                                                                    // Symbol to show vertical side of field
    private char filler = ' ';                                                                                          // Filler of content of field
    private Snake snake;
    private Food food;
    private char[][] field;
    private int score;
    private int mode;

    public MoveListener listener;                                                                                       // Key listener for intercept of user press button

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

    public void initContainer(int width, int height) {                                                                  // Initialization of field
        this.setWidth(width);
        this.setHeight(height);
        this.snake = new Snake();
        this.snake.initSnake();
        this.food = new Food();
        this.generateFood();
        this.snake.addHead((int) (width / 2), (int) (height / 2), 0);
        this.score = 0;
        this.listener = new MoveListener();
    }

    public Snake getSnake () {                                                                                          // Getter snake
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

    public void setVerticalSide(char verticalSide) {                                                                    // Setter for symbol to show vertical side of field
        this.verticalSide = verticalSide;
    }

    public char getVerticalSide() {                                                                                     // Getter for symbol to show vertical side of field
        return this.verticalSide;
    }

    public void setHorizontalSide(char horizontalSide) {                                                                // Setter for symbol to show horizontal side of field
        this.horizontalSide = horizontalSide;
    }

    public char getHorizontalSide() {                                                                                   // Getter for symbol to show horizontal side of field
        return this.horizontalSide;
    }

    public void setFiller(char filler) {                                                                                // Setter Filler of content of field
        this.filler = filler;
    }

    public char getFiller() {                                                                                           // Setter Filler of content of field
        return this.filler;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScore () {
        this.score++;
    }

    public void clearField() {                                                                                          // Clear field
        this.field = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.field[i][j] = this.filler;
            }
        }
    }

    public void printField() {                                                                                          // PrintField
        for (int i = height + 2 - 1; i >= 0; i--) {
            for (int j = 0; j < width + 2; j++) {
                if (i == 0 || i == height + 2 - 1) {                                                                    // If it's first or last line, print horizontal bounary ('-' by default)
                    System.out.print(this.horizontalSide);
                } else {
                    if (j == 0 || j == width + 2 - 1) {                                                                 // Else: if it's first\last symbol in line, print vertical bounary('|' by default)
                        System.out.print(this.verticalSide);
                    } else {
                        System.out.print(this.field[i - 1][j - 1]);                                                     // Else print filler
                    }
                }
            }
            System.out.println();
        }
    }

    public void updateField() {                                                                                         // transfer of snake's coordinates
        int x, y;
        int foodX = food.getX();
        int foodY = food.getY();
        PieceOfSnake tmp = new PieceOfSnake();

        for (int i = 0; i < this.snake.getSize(); i++) {
            if (i == 0) {
                if (this.snake.getSize() > 1) {
                    for (int j = 1; j < this.snake.getSize(); j++) {                                                        // intersect yourself check
                        if (this.snake.getPieceOfSnake(0).getX() == this.snake.getPieceOfSnake(j).getX() && this.snake.getPieceOfSnake(0).getY() == this.snake.getPieceOfSnake(j).getY()) {
                            System.out.println("You lose!");
                            System.out.println("Your score: " + this.score);
                            System.exit(0);
                        }
                    }
                }
                if (this.snake.getPieceOfSnake(i).getX() == foodX && this.snake.getPieceOfSnake(i).getY() == foodY) {
                    snake.growUp();
                    this.incrementScore();
                    this.generateFood();
                } else {
                    field[foodY][foodX] = food.getSymbol();
                }
            }
            tmp = this.snake.getPieceOfSnake(i);
            x = tmp.getX();
            y = tmp.getY();

            if (y >= height || y < 0 || x >= width || x < 0) {
                System.out.println("You lose!");
                System.out.println("Your score: " + this.score);
                System.exit(0);
            } else {
                field[y][x] = tmp.getSymbol();
            }
        }
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return this.mode;
    }
}
