import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class Window {
    JFrame mainFrame;
    JFrame aboutFrame;
    JFrame settingsFrame;
    JPanel mainPanel;
    JPanel aboutPanel;
    GridLayout mainGrid;
    GridLayout aboutGrid;
    ArrayList<JPanel> cells;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu infoMenu;
    JMenuItem chooseLogFile;
    JMenuItem settings;
    JMenuItem exitGame;
    JMenuItem getSource;
    JMenuItem about;
    JLabel infoLabel;
    JButton applySettings;

    String logFileName = "results.log";
    File logFile = new File(logFileName);

    String difficulty[] = {"Noob","Medium","Hard","What?!"};
    JComboBox difficultyList;

    JFileChooser fileChooser = new JFileChooser();

    Color colorOfSnake = new Color(104, 160, 99);
    Color colorOfFood = new Color(215, 169, 34);
    Color colorOfGameBoard = new Color(175, 175, 175);
    Color colorOfBlock = new Color(0, 0, 0);

    JButton colorOfSnakeButton;
    JButton colorOfFoodButton;
    JButton colorOfGameBoardButton;
    JButton colorOfBlockButton;

    int move;
    int mode = 1;

    ActionListener settingsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == applySettings) {
                mode = difficultyList.getSelectedIndex();
                settingsFrame.setVisible(false);
            }
            else if (actionEvent.getSource() == colorOfSnakeButton) {
                colorOfSnake = JColorChooser.showDialog(settingsFrame,"Select a color of snake",colorOfSnake);
            }
            else if (actionEvent.getSource() == colorOfFoodButton) {
                colorOfFood = JColorChooser.showDialog(settingsFrame,"Select a color of food",colorOfFood);
            }
            else if (actionEvent.getSource() == colorOfGameBoardButton) {
                colorOfGameBoard = JColorChooser.showDialog(settingsFrame,"Select a color of fields of gameboard",colorOfGameBoard);
            }
            else if (actionEvent.getSource() == colorOfBlockButton) {
                colorOfBlock = JColorChooser.showDialog(settingsFrame, "Select a color of block", colorOfBlock);
            }
        }
    };

    ActionListener menuListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == exitGame) {
                System.exit(0);
            }
            else if (actionEvent.getSource() == about) {
                aboutFrame = createFrame(220, 470, "About", WindowConstants.HIDE_ON_CLOSE, false);
                aboutFrame.setIconImage(new ImageIcon(getClass().getResource("img/information.png")).getImage());
                centerFramePosition(aboutFrame);

                aboutPanel = new JPanel();
                aboutGrid = new GridLayout(2, 1, 30, 30);
                aboutPanel.setLayout(aboutGrid);
                aboutPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                ImagePanel imagePanel = new ImagePanel();
                infoLabel = new JLabel();
                infoLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
                infoLabel.setText("<html>Snake game V. 1.2 <br>" +
                        "Powered by open-source software:<br>" +
                        "Intellij Idea<br>" +
                        "gradle<br>" +
                        "jdk 15.0<br>" +
                        "swing toolkit</html>");

                aboutPanel.add(imagePanel);
                aboutPanel.add(infoLabel);
                aboutFrame.add(aboutPanel);
                aboutFrame.setVisible(true);
            }
            else if (actionEvent.getSource() == getSource) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/akhmetov-dev/snake-game"));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else if (actionEvent.getSource() == chooseLogFile) {
                fileChooser.showDialog(mainFrame, "Select file");
                logFile = fileChooser.getSelectedFile();
            }
            else if (actionEvent.getSource() == settings) {
                settingsFrame = createFrame(300, 200, "Settings", WindowConstants.HIDE_ON_CLOSE, false);
//                settingsFrame.setIconImage(new ImageIcon("gear.png").getImage());
                settingsFrame.setIconImage(new ImageIcon(getClass().getResource("img/gear.png")).getImage());
                centerFramePosition(settingsFrame);

                difficultyList = new JComboBox(difficulty);

                applySettings = new JButton("Apply settings");
                applySettings.addActionListener(settingsListener);

                JLabel difficultyLabel = new JLabel("Difficulty:");
                difficultyLabel.setHorizontalAlignment(SwingConstants.RIGHT);

                JLabel chooseColorOfSnake = new JLabel("Color of snake");
                chooseColorOfSnake.setHorizontalAlignment(SwingConstants.RIGHT);

                JLabel chooseColorOfFood = new JLabel("Color of food");
                chooseColorOfFood.setHorizontalAlignment(SwingConstants.RIGHT);

                JLabel chooseColorOfGameboard = new JLabel("Color of gameboard");
                chooseColorOfGameboard.setHorizontalAlignment(SwingConstants.RIGHT);

                JLabel chooseColorOfBlock = new JLabel("Color of block");
                chooseColorOfBlock.setHorizontalAlignment(SwingConstants.RIGHT);


                JPanel panel = new JPanel();
                GridLayout settingsLayout = new GridLayout(5, 2, 10, 10);
                panel.setLayout(settingsLayout);
                panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                colorOfSnakeButton = new JButton("Choose");
                colorOfSnakeButton.addActionListener(settingsListener);
                colorOfFoodButton = new JButton("Choose");
                colorOfFoodButton.addActionListener(settingsListener);
                colorOfGameBoardButton = new JButton("Choose");
                colorOfGameBoardButton.addActionListener(settingsListener);
                colorOfBlockButton = new JButton("Choose");
                colorOfBlockButton.addActionListener(settingsListener);

                panel.add(difficultyLabel);
                panel.add(difficultyList);
                panel.add(chooseColorOfSnake);
                panel.add(colorOfSnakeButton);
                panel.add(chooseColorOfFood);
                panel.add(colorOfFoodButton);
                panel.add(chooseColorOfGameboard);
                panel.add(colorOfGameBoardButton);
                panel.add(chooseColorOfBlock);
                panel.add(colorOfBlockButton);


                settingsFrame.getContentPane().add(BorderLayout.CENTER, panel);
                settingsFrame.getContentPane().add(BorderLayout.SOUTH, applySettings);
                settingsFrame.setVisible(true);
            }
        }
    };

    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    move = 1;
                    break;
                case KeyEvent.VK_UP:
                    move = 2;
                    break;
                case KeyEvent.VK_RIGHT:
                    move = 3;
                    break;
                case KeyEvent.VK_DOWN:
                    move = 4;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };

    public Window(int numOfHorCells, int numOfVerCells) {
        mainFrame = this.createFrame(480, 480, "Snake game", WindowConstants.EXIT_ON_CLOSE, true);
        this.centerFramePosition(mainFrame);
        mainFrame.setIconImage(new ImageIcon(getClass().getResource("img/snake.png")).getImage());
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainGrid = new GridLayout(numOfVerCells, numOfHorCells, 10, 10);
        mainPanel.setLayout(mainGrid);

        cells = this.initCells(numOfHorCells, numOfHorCells);
        this.addCellsToBoard(mainPanel, cells, numOfHorCells, numOfVerCells);


        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        infoMenu = new JMenu("Info");
        infoMenu.setMnemonic('I');
        menuBar.add(fileMenu);
        menuBar.add(infoMenu);
        chooseLogFile = new JMenuItem("Open file");
        chooseLogFile.setMnemonic('O');
        chooseLogFile.addActionListener(menuListener);
        settings = new JMenuItem("Settings");
        settings.setMnemonic('S');
        settings.addActionListener(menuListener);
        exitGame = new JMenuItem("Exit");
        exitGame.setMnemonic('E');
        exitGame.addActionListener(menuListener);
        fileMenu.add(chooseLogFile);
        fileMenu.add(settings);
        fileMenu.add(exitGame);
        getSource = new JMenuItem("Github repository");
        getSource.setMnemonic('G');
        getSource.addActionListener(menuListener);
        about = new JMenuItem("About");
        about.setMnemonic('A');
        about.addActionListener(menuListener);
        infoMenu.add(getSource);
        infoMenu.add(about);

        mainFrame.add(BorderLayout.CENTER, mainPanel);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.addKeyListener(keyListener);
        mainFrame.setVisible(true);
    }
    public JFrame createFrame(int width, int height, String nameOfWindow, int closeOnClick, boolean sizeable) {
        JFrame frame = new JFrame(nameOfWindow);
        frame.setDefaultCloseOperation(closeOnClick);
        frame.setSize(width, height);
        frame.setResizable(sizeable);
        return frame;
    }
    public void centerFramePosition(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - mainFrame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - mainFrame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    public ArrayList<JPanel> initCells (int width, int height) {
        ArrayList<JPanel> cells = new ArrayList<>();
        for (int i = 0; i < height * width; i++) {
            cells.add(new JPanel());
            cells.get(i).setBackground(colorOfGameBoard);
        }
        return cells;
    }
    public void addCellsToBoard (JPanel panel, ArrayList<JPanel> cells, int numOfHorCells, int numOfVerCells) {
        for (int i = 0; i < numOfVerCells * numOfHorCells; i++) {
            panel.add(cells.get(i));
        }
    }
}
