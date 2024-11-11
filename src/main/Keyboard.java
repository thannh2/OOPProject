package src.main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Keyboard implements KeyListener {
    public boolean up, down, right, left;

    @Override
    public void keyTyped(KeyEvent e) {
        // Để trống
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int number = e.getKeyCode();

        if (number == KeyEvent.VK_W) {
            up = true;
        }

        if (number == KeyEvent.VK_S) {
            down = true;
        }

        if (number == KeyEvent.VK_A) {
            left = true;
        }

        if (number == KeyEvent.VK_D) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int number = e.getKeyCode();

        if (number == KeyEvent.VK_W) {
            up = false;
        }

        if (number == KeyEvent.VK_S) {
            down = false;
        }

        if (number == KeyEvent.VK_A) {
            left = false;
        }

        if (number == KeyEvent.VK_D) {
            right = false;
        }
    }
}
