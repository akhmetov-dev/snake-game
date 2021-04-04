import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    public void paintComponent(Graphics g) {
        //Image image = new ImageIcon("snake.png").getImage();
//        Image image = new ImageIcon("src/img/information.png").getImage();
        Image image = new ImageIcon(getClass().getResource("img/information.png")).getImage();

        g.drawImage(image, 0, 0, this);
    }
}
