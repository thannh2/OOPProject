package src.main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Keyboard implements KeyListener {
    public boolean up1, down1, right1, left1, punch1, kick1;
    public boolean up2, down2, right2, left2, punch2, kick2;

    @Override
    public void keyTyped(KeyEvent e) {
        // Để trống
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int number = e.getKeyCode();

        // Player 1
        if (number == KeyEvent.VK_W) {
            up1 = true;
        }

        if (number == KeyEvent.VK_S) {
            down1 = true;
        }

        if (number == KeyEvent.VK_A) {
            left1 = true;
        }

        if (number == KeyEvent.VK_D) {
            right1 = true;
        }

        if (number == KeyEvent.VK_J) {
            punch1 = true;
        }

        if (number == KeyEvent.VK_K) {
            kick1 = true;
        }

        // Player 2
        if (number == KeyEvent.VK_UP) {
            up2 = true;
        }

        if (number == KeyEvent.VK_DOWN) {
            down2 = true;
        }

        if (number == KeyEvent.VK_LEFT) {
            left2 = true;
        }

        if (number == KeyEvent.VK_RIGHT) {
            right2 = true;
        }

        if (number == KeyEvent.VK_NUMPAD1) {
            punch2 = true;
        }

        if (number == KeyEvent.VK_NUMPAD2) {
            kick2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int number = e.getKeyCode();

        // Player 1
        if (number == KeyEvent.VK_W) {
            up1 = false;
        }

        if (number == KeyEvent.VK_S) {
            down1 = false;
        }

        if (number == KeyEvent.VK_A) {
            left1 = false;
        }

        if (number == KeyEvent.VK_D) {
            right1 = false;
        }

        if (number == KeyEvent.VK_J) {
            punch1 = false;
        }

        if (number == KeyEvent.VK_K) {
            kick1 = false;
        }

        // Player 2
        if (number == KeyEvent.VK_UP) {
            up2 = false;
        }

        if (number == KeyEvent.VK_DOWN) {
            down2 = false;
        }

        if (number == KeyEvent.VK_LEFT) {
            left2 = false;
        }

        if (number == KeyEvent.VK_RIGHT) {
            right2 = false;
        }

        if (number == KeyEvent.VK_NUMPAD1) {
            punch2 = false;
        }

        if (number == KeyEvent.VK_NUMPAD2) {
            kick2 = false;
        }
    }
}
