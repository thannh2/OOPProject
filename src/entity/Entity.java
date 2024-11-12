package src.entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x,y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, idle, idle2, punch1, punch2, punch3, punch4, kick1, kick2, kick3, kick4;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int actionCounter = 0;
    public int actionNum = 1;

    public int kickCounter = 0;
    public int kickNum = 1;
}
