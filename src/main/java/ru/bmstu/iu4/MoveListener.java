package ru.bmstu.iu4;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveListener extends JFrame implements KeyListener {

    private int move;

    public MoveListener () {
        setSize(180, 100);
        setVisible(true);
        addKeyListener(this);
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
            case  KeyEvent.VK_RIGHT:
                this.setMove(3);
                break;
            case KeyEvent.VK_DOWN:
                this.setMove(4);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
