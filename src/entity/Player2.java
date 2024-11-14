package src.entity;

import src.main.GamePanel;
import src.main.Keyboard2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player2 extends Entity {
    GamePanel gp;
    Keyboard2 kb;


    public Player2(GamePanel gp, Keyboard2 kb) {
        this.gp = gp;
        this.kb = kb;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 400.0f;
        y = 100.0f;
        velX = 0.0f;
        velY = 0.0f;
        speed = 4;
        action = Action.Idle;
        reverse = true;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("./res/vegeta/vegetaUp.png"));
            down1 = ImageIO.read(new File("./res/vegeta/vegetaDown.png"));
            left1 = ImageIO.read(new File("./res/vegeta/vegetaLeft.png"));
            right1 = ImageIO.read(new File("./res/vegeta/vegetaRight.png"));
            idle = ImageIO.read(new File("./res/vegeta/vegetaIdle.png"));
            idle2 = ImageIO.read(new File("./res/vegeta/vegetaIdle2.png"));
            punch1 = ImageIO.read(new File("./res/vegeta/vegetaPunch1.png"));
            punch2 = ImageIO.read(new File("./res/vegeta/vegetaPunch2.png"));
            punch3 = ImageIO.read(new File("./res/vegeta/vegetaPunch3.png"));
            punch4 = ImageIO.read(new File("./res/vegeta/vegetaPunch4.png"));
            kick1 = ImageIO.read(new File("./res/vegeta/vegetaKick1.png"));
            kick2 = ImageIO.read(new File("./res/vegeta/vegetaKick2.png"));
            kick3 = ImageIO.read(new File("./res/vegeta/vegetaKick3.png"));
            kick4 = ImageIO.read(new File("./res/vegeta/vegetaKick4.png"));

            //reverse image
            rup = ImageIO.read(new File("./res/vegeta/rup.png"));
            rdown = ImageIO.read(new File("./res/vegeta/rdown.png"));
            ridle = ImageIO.read(new File("./res/vegeta/ridle.png"));
            ridle2 = ImageIO.read(new File("./res/vegeta/ridle2.png"));
            rpunch1 = ImageIO.read(new File("./res/vegeta/rpunch1.png"));
            rpunch2 = ImageIO.read(new File("./res/vegeta/rpunch2.png"));
            rpunch3 = ImageIO.read(new File("./res/vegeta/rpunch3.png"));
            rpunch4 = ImageIO.read(new File("./res/vegeta/rpunch4.png"));
            rkick1 = ImageIO.read(new File("./res/vegeta/rkick1.png"));
            rkick2 = ImageIO.read(new File("./res/vegeta/rkick2.png"));
            rkick3 = ImageIO.read(new File("./res/vegeta/rkick3.png"));
            rkick4 = ImageIO.read(new File("./res/vegeta/rkick4.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(boolean r) {
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
            actionNum = 1;
            actionCounter = 4;
            actionDo = 1;
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
            kickNum = 1;
            kickCounter = 4;
            kickDo = 1;
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
            if(actionDo == 1 || kickDo == 1){
            if(actionNum<=5){
                actionCounter++;
                if(actionCounter > 3){
                actionNum++;
                actionCounter = 0;
                }
                if(actionNum > 4) {
                action = Action.Idle;
                actionDo = 0;
                }
            }
            if(kickNum<=5){
                kickCounter++;
                if(kickCounter > 3){
                kickNum++;
                kickCounter = 0;
                }
                if(kickNum > 4) {
                action = Action.Idle;
                kickDo = 0;
                }
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
            if(action != Action.Up){
            action = Action.Down;
        this.velY += 2;
        y += velY;
            }
        }
        if(r == true) reverse = false;
        else if ( r == false) reverse = true;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (action) {
            case Up:
                if(reverse == false){ 
                image = up1;
                }
                else if(reverse == true){
                    image = rup;
                }
                break;
            case Down:
            if(reverse == false){ 
                image = down1;
                }
                else if(reverse == true){
                    image = rdown;
                }
                break;
            case Left:
                image = left1;
                break;
            case Right:
                image = right1;
                break;
            case Idle:
            if(reverse == false){
                if (spriteNum == 1) {
                    image = idle;
                }
                if (spriteNum == 2) {
                    image = idle2;
                }
            }
            else if(reverse == true){
                if (spriteNum == 1) {
                    image = ridle;
                }
                if (spriteNum == 2) {
                    image = ridle2;
                }
            }
                break;
            case Punch:
            if(reverse == false){
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
            }
            else if (reverse == true){
                if (actionNum == 1) {
                    image = rpunch1;
                }
                else if (actionNum == 2) {
                    image = rpunch2;
                }
                else if (actionNum == 3) {
                    image = rpunch3;
                }
                else if (actionNum == 4) {
                    image = rpunch4;
                }
                else if (actionNum == 0) {
                    image = ridle;
                }
            }
                break;
            case Kick:
            if(reverse == false){
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
            }
            else if (reverse == true){
                if (kickNum == 1) {
                    image = rkick1;
                }
                else if (kickNum == 2) {
                    image = rkick2;
                }
                else if (kickNum == 3) {
                    image = rkick3;
                }
                else if (kickNum == 4) {
                    image = rkick4;
                }
                else if (kickNum == 0) {
                    image = ridle;
                }
            }
                break;
        }

        g2.drawImage(image, (int)x, (int)y, 128, 120, null);
    }
}
