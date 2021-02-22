import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class Game {
    private int width = 10;
    private int height = 10;
    private Snake snake;
    private Food food;
    private ArrayList<Block> blocks;
    private int score;
    Window window;
    public boolean gameOn;

    public void generateXY(int param) {
        int randX;
        int randY;
        while (true) {
            randX = (int) (Math.random() * width);
            randY = (int) (Math.random() * height);
            boolean flag = true;

            for (int i = 0; i < snake.getSize(); i++) {
                if (snake.getPieceOfSnake(i).getX() == randX && snake.getPieceOfSnake(i).getY() == randY) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int i = 0; i < blocks.size(); i++) {
                    if (blocks.get(i).getX() == randX && blocks.get(i).getY() == randY) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                if (param == 1) {
                    food.setX(randX);
                    food.setY(randY);
                    break;
                }
                else if (param == 2) {
                    Block tmp = new Block(randX, randY);
                    blocks.add(tmp);
                    break;
                }
            }
        }
    }

    public Game() {
        configGame();
        window = new Window(width, height);

    }

    public Snake getSnake() {                                                                                          // Getter snake
        return snake;
    }

    public void setWidth(int width) {                                                                                   // Setter width of field
        this.width = width;
    }

    public int getWidth() {                                                                                             // Getter width of field
        return width;
    }

    public void setHeight(int height) {                                                                                 // Setter height of field
        this.height = height;
    }

    public int getHeight() {                                                                                            // Getter height of field
        return height;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public void clearField() {
        for (int i = 0; i < width * height; i++) {
            window.cells.get(i).setBackground(window.colorOfGameBoard);
        }
    }

    public void updateField() {                                                                                         // transfer of snake's coordinates
        int x, y;
        int foodX = food.getX();
        int foodY = food.getY();

        if (score != 0 && score % 5 == 0) {
            if (blocks.size() != score - blocks.size() * 4) {
                this.generateXY(2);
            }
        }

        if (blocks.size() > 0) {
            for (Block block : blocks) {
                window.cells.get(this.width * block.getY() + block.getX()).setBackground(window.colorOfBlock);
            }
        }

        if (this.snake.getPieceOfSnake(0).getX() == foodX && this.snake.getPieceOfSnake(0).getY() == foodY) {
            snake.growUp();
            this.incrementScore();
            this.generateXY(1);
        } else {
            window.cells.get(this.width * foodY + foodX).setBackground(window.colorOfFood);
        }

        for (Block block : blocks) {
            if (this.snake.getPieceOfSnake(0).getX() == block.getX() && this.snake.getPieceOfSnake(0).getY() == block.getY()) {
                gameOn = false;
                logResult();
            }
        }

        for (int i = 0; i < this.snake.getSize(); i++) {
            if (i == 0) {
                if (this.snake.getSize() > 1) {
                    for (int j = 1; j < this.snake.getSize(); j++) {
                        if (this.snake.getPieceOfSnake(0).getX() == this.snake.getPieceOfSnake(j).getX() && this.snake.getPieceOfSnake(0).getY() == this.snake.getPieceOfSnake(j).getY()) {
                            gameOn = false;
                            logResult();
                        }
                    }
                }
            }
            PieceOfSnake tmp = this.snake.getPieceOfSnake(i);
            x = tmp.getX();
            y = tmp.getY();

            if (y >= height || y < 0 || x >= width || x < 0) {
                gameOn = false;
                logResult();
            } else {
                window.cells.get(this.width * y + x).setBackground(window.colorOfSnake);
            }
        }
    }

    public void logResult() {
        try {
            FileWriter writer = new FileWriter(window.logFile, true);
            Date curDate = new Date();
            writer.write(curDate + " / " + String.valueOf(score) + "\n");
            writer.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void gameAgain () {
        configGame();
        window.move = 0;
    }

    public void configGame () {
        snake = new Snake();
        snake.addHead((int) (width / 2), (int) (height / 2), 0);
        food = new Food();
        blocks = new ArrayList<Block>();
        generateXY(1);
        score = 0;
        gameOn = true;
    }
}
