package src.entity;

import java.util.Map;
import java.util.HashMap;

import src.main.GamePanel;
import src.main.Keyboard;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.shape.Rectangle;
import src.main.ActionBox;

public class Player extends Entity {
    GamePanel gp;
    Keyboard kb;
    private Map<String, ActionBox> actions;

    public int Direction;

    public Player(GamePanel gp, Keyboard kb) {
        this.gp = gp;
        this.kb = kb;
        setDefaultValues();
        getPlayerImage();
        Direction = 0;

        Rectangle zeroBox = new Rectangle(0, 0, 0, 0);
        int x = (int)this.x;
        int y = (int)this.y;

		int entityLeftX = x + 24;
		int entityRightX = x + 88; // 24 toi le trai, 88 toi le phai 
		int entityTopY = y + 24;
		int entityBotY = y + 120; // 24 toi dau, 120 toi chan
        actions = new HashMap<>();
        actions.put("punch4", new Action(new Rectangle(x + Direction*82, y + 52, 38, 19),new Rectangle()));

    }

    public void setDefaultValues() {
        x = 100.0f;
        y = 100.0f;
        velX = 0.0f;
        velY = 0.0f;
        speed = 4;
        action = Action.Idle;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("./res/gokuu/up_1.png"));
            up2 = ImageIO.read(new File("./res/gokuu/up_2.png"));
            down1 = ImageIO.read(new File("./res/gokuu/down_1.png"));
            down2 = ImageIO.read(new File("./res/gokuu/down_2.png"));
            left1 = ImageIO.read(new File("./res/gokuu/left_1.png"));
            left2 = ImageIO.read(new File("./res/gokuu/left_2.png"));
            right1 = ImageIO.read(new File("./res/gokuu/right_1.png"));
            right2 = ImageIO.read(new File("./res/gokuu/right_2.png"));
            idle = ImageIO.read(new File("./res/gokuu/idle.png"));
            idle2 = ImageIO.read(new File("./res/gokuu/idle2.png"));
            punch1 = ImageIO.read(new File("./res/gokuu/punch1.png"));
            punch2 = ImageIO.read(new File("./res/gokuu/punch2.png"));
            punch3 = ImageIO.read(new File("./res/gokuu/punch3.png"));
            punch4 = ImageIO.read(new File("./res/gokuu/punch4.png"));
            kick1 = ImageIO.read(new File("./res/gokuu/kick1.png"));
            kick2 = ImageIO.read(new File("./res/gokuu/kick2.png"));
            kick3 = ImageIO.read(new File("./res/gokuu/kick3.png"));
            kick4 = ImageIO.read(new File("./res/gokuu/kick4.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {
        if (kb.up == true) {
            action = Action.Up;
            velY = -speed;
            y += velY;
        }
        else if (kb.down == true) {
            action = Action.Down;
            velY = speed;
        }
        else if (kb.left == true) {
            action = Action.Left;
            velX = -speed;
            x += velX;
        }
        else if (kb.right == true) {
            action = Action.Right;
            velX = speed;
            x += velX;
        }
        else if (kb.punch == true) {
            actionNum = 0;
            actionCounter = 4;
            action = Action.Punch;
            // actionCounter++;
            // if (actionCounter > 3) {
            //     // if (actionNum == 1) actionNum = 2;
            //     // else if (actionNum == 2) actionNum = 3;
            //     // else if (actionNum == 3) actionNum = 4;
            //     // else if (actionNum == 4) actionNum = 1;
            //     actionNum = actionNum % 4 + 1;
            //     actionCounter = 0;
            // }
            
        }
        else if (kb.kick == true){
            kickNum = 0;
            kickCounter = 4;
            action = Action.Kick;
            // kickCounter++;
            // if (kickCounter > 3) {
            //     // if (kickNum == 1) kickNum = 2;
            //     // else if (kickNum == 2) kickNum = 3;
            //     // else if (kickNum == 3) kickNum = 4;
            //     // else if (kickNum == 4) kickNum = 1;
            //     kickNum = kickNum % 4 + 1;
            //     kickCounter = 0;
            // }
            
        }
        else {
            if(action == Action.Kick || action == Action.Punch){
            if(actionNum<=5){
                actionCounter++;
                if(actionCounter > 3){
                actionNum++;
                actionCounter = 0;
                }
                if(actionNum > 4) action = Action.Idle;
            }
            if(kickNum<=5){
                kickCounter++;
                if(kickCounter > 3){
                kickNum++;
                kickCounter = 0;
                }
                if(kickNum > 4) action = Action.Idle;
            }
            }
            else action = Action.Idle;
        }

        spriteCounter++;
        if (spriteCounter > 15) {
            // if(spriteNum == 1) spriteNum = 2;
            // else if (spriteNum == 2) spriteNum = 1;
            spriteNum = spriteNum % 2 + 1;
            spriteCounter = 0;
        }

       // this.x += this.velX;
       // this.y += this.velY;
       velY = 0;
        if(y < 500) {
            action = Action.Down;
        this.velY += 2;
        y += velY;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (action) {
            case Up:
                image = up1;
                break;
            case Down:
                image = down1;
                break;
            case Left:
                image = left1;
                break;
            case Right:
                image = right1;
                break;
            case Idle:
                if (spriteNum == 1) {
                    image = idle;
                }
                if (spriteNum == 2) {
                    image = idle2;
                }
                break;
            case Punch:
                if (actionNum == 1) {
                    image = punch1;
                }
                else if (actionNum == 2) {
                    image = punch2;
                }
                else if (actionNum == 3) {
                    image = punch3;
                }
                else if (actionNum == 4) {
                    image = punch4;
                }
                else if (actionNum == 0) {
                    image = idle;
                }
                break;
            case Kick:
                if (kickNum == 1) {
                    image = kick1;
                }
                else if (kickNum == 2) {
                    image = kick2;
                }
                else if (kickNum == 3) {
                    image = kick3;
                }
                else if (kickNum == 4) {
                    image = kick4;
                }
                else if (kickNum == 0) {
                    image = idle;
                }
                break;
        }

        g2.drawImage(image, (int)x, (int)y, 128, 120, null);
    }
}
