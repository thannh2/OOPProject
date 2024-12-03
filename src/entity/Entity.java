package src.entity;

import java.awt.image.BufferedImage;

public class Entity {
    public float x, y;
    public float velX, velY;
    public int speed;
    public boolean reverse = false;

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

    public int kiBlastCounter = 0;
    public int kiBlastNum = 1, kiBlastDo = 0;
}
