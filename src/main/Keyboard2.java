package src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard2 implements KeyListener {
    public boolean up, down, right, left, punch, kick, skill;

    @Override
    public void keyTyped(KeyEvent e) {
        // Để trống
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int number = e.getKeyCode();

        if (number == KeyEvent.VK_UP) {
            up = true;
        }

        if (number == KeyEvent.VK_DOWN) {
            down = true;
        }

        if (number == KeyEvent.VK_LEFT) {
            left = true;
        }

        if (number == KeyEvent.VK_RIGHT) {
            right = true;
        }

        if (number == KeyEvent.VK_NUMPAD1) {
            punch = true;
        }

        if (number == KeyEvent.VK_NUMPAD2) {
            kick = true;
        }
        if (number == KeyEvent.VK_NUMPAD3) {
            skill = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int number = e.getKeyCode();

        if (number == KeyEvent.VK_UP) {
            up = false;
        }

        if (number == KeyEvent.VK_DOWN) {
            down = false;
        }

        if (number == KeyEvent.VK_LEFT) {
            left = false;
        }

        if (number == KeyEvent.VK_RIGHT) {
            right = false;
        }

        if (number == KeyEvent.VK_NUMPAD1) {
            punch = false;
        }

        if (number == KeyEvent.VK_NUMPAD2) {
            kick = false;
        }
        if (number == KeyEvent.VK_NUMPAD3) {
            skill = false;
        }
    }
}
