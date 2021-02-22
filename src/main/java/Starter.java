import javax.swing.*;
import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {

        Game game = new Game();
        game.clearField();
        game.updateField();

        while (true) {
            while (game.gameOn) {
                switch (game.window.mode) {
                    case 0:
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    case 1:
                        try
                        {
                            Thread.sleep(500);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    case 2:
                        try
                        {
                            Thread.sleep(250);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                    case 3:
                        try
                        {
                            Thread.sleep(125);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        break;
                }
                if (game.window.move == 1 || game.window.move == 2 || game.window.move == 3 || game.window.move == 4) {
                    switch (game.window.move) {
                        case 1:
                            game.getSnake().moveLeft();
                            break;
                        case 2:
                            game.getSnake().moveUp();
                            break;
                        case 3:
                            game.getSnake().moveRight();
                            break;
                        case 4:
                            game.getSnake().moveDown();
                            break;
                    }
                    game.clearField();
                    game.updateField();
                }
            }
            JOptionPane.showMessageDialog(game.window.mainFrame, "You lose!\nYour score: " + game.getScore());
            game.gameAgain();
            game.clearField();
            game.updateField();
        }
    }
}
