import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon(getClass().getResource("Images/information.png")).getImage();

        g.drawImage(image, 0, 0, this);
    }
}
