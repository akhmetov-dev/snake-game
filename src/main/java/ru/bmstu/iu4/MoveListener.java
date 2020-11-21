package ru.bmstu.iu4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MoveListener implements KeyListener {

    public JFrame mainFrame;
    private int widthMainFrame = 430;
    private int heightMainFrame = 470;
    private ActionListener mainListener;

    private JFrame settingsFrame;
    private int widthSettingsFrame = 380;
    private int heightSettingsFrame = 150;
    private ActionListener settingsListener;

    private JMenuBar menuBar;

    private JMenu game;
    private JMenu help;

    private JMenuItem exit;
    private JMenuItem settings;
    private JMenuItem howToGame;
    private JMenuItem about;

    private JButton confirmSettings;

    private ButtonGroup bg;
    private JRadioButton noob;
    private JRadioButton medium;
    private JRadioButton pro;
    private JRadioButton aUKidding;

    private JLabel difficultyLevel;

    private int move;
    private int wPanel = 30;
    private int hPanel = 30;
    int mode = 1;
    boolean again = false;

    private String version = "1.2";

    ArrayList<ArrayList<JPanel>> panels;

    public MoveListener(int width, int height) {

        mainFrame = new JFrame("Snake game");
        mainFrame.setLocation((int)(1920/2 - 430/2), (int)(1070/2 - 470/2));
        mainFrame.addKeyListener(this);

        mainListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == howToGame)
                    JOptionPane.showMessageDialog(mainFrame, "Rules are very simple.\nYour task - to take as more rating as you can.\nSnake's manage:\nbutton 'arrow up' - move up\nbutton 'arrow down' - move down\nbutton 'arrow left' - move left\nbutton 'arrow right' - move right.\nGood luck!");
                if (e.getSource() == about)
                    JOptionPane.showMessageDialog(mainFrame, "Snake game V" + version + "\nPowered by open-source software:\njetbrains intellij idea;\ngradle build tool;\njdk 15.0;\nswing widget toolkit.\nAuthor's repository on Github:\nhttps://github.com/akhmetov-dev/snake-game");
                if (e.getSource() == exit)
                    System.exit(0);
                if (e.getSource() == settings)
                    settingsFrame.setVisible(true);
            }
        };

        settingsFrame = new JFrame("Settings");
        settingsFrame.setLocation((int)(1920/2 - 430/2), (int)(1070/2 - 470/2));
        settingsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noob.isSelected())
                    mode = 1;
                if (medium.isSelected())
                    mode = 2;
                if (pro.isSelected())
                    mode = 3;
                if (aUKidding.isSelected())
                    mode = 4;
                settingsFrame.setVisible(false);
            }
        };

        menuBar = new JMenuBar();

        game = new JMenu("Game");
        help = new JMenu("Help");
        settings = new JMenuItem("Settings");
        exit = new JMenuItem("Exit");
        howToGame = new JMenuItem("How to game");
        about = new JMenuItem("About");

        settings.addActionListener(mainListener);

        exit.addActionListener(mainListener);

        howToGame.addActionListener(mainListener);

        about.addActionListener(mainListener);

        game.add(settings); game.add(exit);
        help.add(howToGame); help.add(about);

        menuBar.add(game); menuBar.add(help);

        mainFrame.add(menuBar);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setLayout(null);
        mainFrame.setSize(widthMainFrame, heightMainFrame);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

        settingsFrame.setLayout(null);
        settingsFrame.setSize(widthSettingsFrame, heightSettingsFrame);
        settingsFrame.setVisible(false);

        difficultyLevel = new JLabel("Choose difficulty level:");

        confirmSettings = new JButton("Ok");

        bg = new ButtonGroup();
        noob = new JRadioButton("Noob");
        medium = new JRadioButton("medium");
        pro = new JRadioButton("pro");
        aUKidding = new JRadioButton("Are you kidding?!");

        difficultyLevel.setBounds(15, 10, 200, 25);

        confirmSettings.setBounds((int) ((widthSettingsFrame + 20) / 2 - 100 / 2), (int) (heightSettingsFrame - (1.5 * 100) / 2), 100, 25);

        noob.setBounds(10, 30, 80, 30);
        medium.setBounds(90, 30, 80, 30);
        pro.setBounds(170, 30, 60, 30);
        aUKidding.setBounds(230, 30, 150, 30);

        bg.add(noob); bg.add(medium); bg.add(pro); bg.add(aUKidding);

        confirmSettings.addActionListener(settingsListener);

        settingsFrame.add(difficultyLevel); settingsFrame.add(confirmSettings); settingsFrame.add(noob);
        settingsFrame.add(medium); settingsFrame.add(pro); settingsFrame.add(aUKidding);

        panels = new ArrayList<ArrayList<JPanel>>();

        for (int i = 0; i < height; i++) {
            ArrayList<JPanel> panel = new ArrayList<JPanel>();
            for (int j = 0; j < width; j++) {
                JPanel tmp = new JPanel();
                tmp.setBounds(10 + (j * (wPanel + 10)), 10 + (i * (hPanel + 10)), wPanel, hPanel);
                tmp.setBackground(Color.lightGray);
                panel.add(tmp);
            }
            panels.add(panel);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                mainFrame.add(panels.get(i).get(j));
            }
        }
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getMove() {
        return this.move;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.setMove(1);
                break;
            case KeyEvent.VK_UP:
                this.setMove(2);
                break;
            case KeyEvent.VK_RIGHT:
                this.setMove(3);
                break;
            case KeyEvent.VK_DOWN:
                this.setMove(4);
                break;
        }
    }
    public int getMode() {
        return this.mode;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
