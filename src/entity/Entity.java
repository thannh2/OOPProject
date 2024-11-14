package src.entity;

import java.awt.image.BufferedImage;

enum Action {
    Up, Down, Left, Right,
    Punch, Kick,
    Idle,
}

public class Entity {
    public float x, y;
    public float velX, velY;
    public int speed;
    public boolean reverse = false;

    public BufferedImage up1, rup, down1, rdown, left1, left2, right1, right2, idle, idle2, ridle, ridle2 ,punch1, punch2, punch3, punch4, rpunch1, rpunch2, rpunch3, rpunch4 ,kick1, kick2, kick3, kick4, rkick1, rkick2, rkick3, rkick4;
    public Action action;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int actionCounter = 0;
    public int actionNum = 1;
    public int actionDo = 0;

    public int kickCounter = 0;
    public int kickNum = 1;
    public int kickDo = 0;

    public boolean doJump = false;
    public int JumpCounter = 0;

    public int direction;
}
