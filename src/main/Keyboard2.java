package src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard2 implements KeyListener {
    public boolean up, down, right, left, punch, kick, skill;
    private boolean isFalling = false;

    private long lastPunchTime = 0;
    private long lastKickTime = 0;
    private long lastSkillTime = 0;
    private long lastUpTime = 0;
    private long keyboardTime = 0;
    private long lastFallingTime = 0;

    private final long UP_COOLDOWN = 900;
    private final long PUNCH_COOLDOWN = 700; 
    private final long KICK_COOLDOWN = 700; 
    private final long SKILL_COOLDOWN = 1000;
    private final long KEYBOARD_COOLDOWN = 400;
    private final long MOVEMENT_COOLDOWN = 10;
    
    @Override
    public void keyTyped(KeyEvent e) {
        // Để trống
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int number = e.getKeyCode();
        long currentTime = System.currentTimeMillis();
        

        if (number == KeyEvent.VK_UP && currentTime - lastUpTime >= UP_COOLDOWN && !(left || right || down || punch || kick || skill)) {
            up = true;
            isFalling = true;
            lastFallingTime = currentTime;
            lastUpTime = currentTime;
            keyboardTime = currentTime;

        }

        if(isFalling) {
            if(currentTime - lastFallingTime >= UP_COOLDOWN) {
                isFalling = false;
            }
        }

        // if (number == KeyEvent.VK_S) {
        //     down = true;
        // }

        if (number == KeyEvent.VK_LEFT && currentTime - keyboardTime >= MOVEMENT_COOLDOWN) {
            left = true;
            keyboardTime = currentTime;
        }

        if (number == KeyEvent.VK_RIGHT && currentTime - keyboardTime >= MOVEMENT_COOLDOWN) {
            right = true;
            keyboardTime = currentTime;
        }

        if (left || right || up) {
            return;  
        }

        if (number == KeyEvent.VK_NUMPAD1 && currentTime - lastPunchTime >= PUNCH_COOLDOWN && currentTime - keyboardTime >= KEYBOARD_COOLDOWN && !isFalling) {
            punch = true;
            lastPunchTime = currentTime;
            keyboardTime = currentTime;
        }

        if (number == KeyEvent.VK_NUMPAD2 && currentTime - lastKickTime >= KICK_COOLDOWN && currentTime - keyboardTime >= KEYBOARD_COOLDOWN && !isFalling) {
            kick = true;
            lastKickTime = currentTime;
            keyboardTime = currentTime;
        }

        if (number == KeyEvent.VK_NUMPAD3 && currentTime - lastSkillTime >= SKILL_COOLDOWN && currentTime - keyboardTime >= KEYBOARD_COOLDOWN && !isFalling) {
            skill = true;
            lastSkillTime = currentTime;
            keyboardTime = currentTime;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int number = e.getKeyCode();

        if (number == KeyEvent.VK_UP) {
            up = false;
        }

        // if (number == KeyEvent.VK_S) {
        //     down = false;
        // }

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
