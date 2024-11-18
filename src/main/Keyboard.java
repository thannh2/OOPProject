package src.main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Keyboard implements KeyListener {
    public boolean up, down, right, left, punch, kick, skill;

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

        if (number == KeyEvent.VK_J) {
            punch = true;
        }

        if (number == KeyEvent.VK_K) {
            kick = true;
        }

        if (number == KeyEvent.VK_L) {
            skill = true;
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

        if (number == KeyEvent.VK_J) {
            punch = false;
        }

        if (number == KeyEvent.VK_K) {
            kick = false;
        }

        if (number == KeyEvent.VK_L) {
            skill = false;
        }
    }
}
