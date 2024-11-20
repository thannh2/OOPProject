package src.entity;

import src.entity.skill.KiBlast;
import src.main.GamePanel;
import src.main.Keyboard;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp;
    Keyboard kb;
    Player2 player2;

    KiBlast L;

    public Player(GamePanel gp, Keyboard kb, Player2 player2) {
        this.gp = gp;
        this.kb = kb;
        this.player2 = player2;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100.0f;
        y = 100.0f;
        velX = 0.0f;
        velY = 0.0f;
        speed = 8;
        action = Action.Idle;
        reverse = false;
        doJump = false;
        direction = 1;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("./res/gokuu/up_1.png"));

            down1 = ImageIO.read(new File("./res/gokuu/down_1.png"));

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

            kiBlast1 = ImageIO.read(new File("./res/gokuu/gokuKiBlast1.png"));
            kiBlast2 = ImageIO.read(new File("./res/gokuu/gokuKiBlast2.png"));

            //reverse image
            rup = ImageIO.read(new File("./res/gokuu/rup.png"));
            rdown = ImageIO.read(new File("./res/gokuu/rdown.png"));
            ridle = ImageIO.read(new File("./res/gokuu/ridle.png"));
            ridle2 = ImageIO.read(new File("./res/gokuu/ridle2.png"));
            rpunch1 = ImageIO.read(new File("./res/gokuu/rpunch1.png"));
            rpunch2 = ImageIO.read(new File("./res/gokuu/rpunch2.png"));
            rpunch3 = ImageIO.read(new File("./res/gokuu/rpunch3.png"));
            rpunch4 = ImageIO.read(new File("./res/gokuu/rpunch4.png"));
            rkick1 = ImageIO.read(new File("./res/gokuu/rkick1.png"));
            rkick2 = ImageIO.read(new File("./res/gokuu/rkick2.png"));
            rkick3 = ImageIO.read(new File("./res/gokuu/rkick3.png"));
            rkick4 = ImageIO.read(new File("./res/gokuu/rkick4.png"));

            rkiBlast1 = ImageIO.read(new File("./res/gokuu/rgokuKiBlast1.png"));
            rkiBlast2 = ImageIO.read(new File("./res/gokuu/rgokuKiBlast2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(int skillx) {
        if (kb.up == true) {
            action = Action.Up;
            // velY = -speed;
            // y += velY;
            doJump = true;
        }
        else if (kb.down == true) {
            action = Action.Down;
            velY = speed;
        }
        else if (kb.left == true) {
            action = Action.Left;
            velX = -speed;
            x += velX;
            direction = -1;
        }
        else if (kb.right == true) {
            action = Action.Right;
            velX = speed;
            x += velX;
            direction = 1;
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
         else if(kb.skill == true){
            if(skillx > 1280 || skillx < 0){
            kiBlastCounter = 4;
            kiBlastNum = 1;
            kiBlastDo = 1;
             action = Action.Skill;
            }
         }
        else {
           // L.update();
            if(actionDo == 1 || kickDo == 1 || doJump == true || kiBlastDo == 1){
            if(actionDo == 1){
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
            if(kickDo == 1){
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
            if(doJump==true){
                velY += -speed;
                JumpCounter++;
                if(JumpCounter>1){
                    y += velY;
                }
                if(y<380) doJump = false;
            }
            if(kiBlastDo == 1){
                kiBlastCounter++;
                if(kiBlastCounter>3){
                    kiBlastNum++;
                    kiBlastCounter=0;
                }
                if(kiBlastNum>2) {
                    action = Action.Idle;
                    kiBlastDo = 0;
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
        this.velY += speed;
        y += velY;
            }
        }
        // if(player2.x < x){
        //     reverse = true;
        // }
        // else reverse = false;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (action) {
            case Up:
                if(direction == 1){
                image = up1;
                }
                else if(direction == -1){
                    image = rup;
                }
                break;
            case Down:
            if(direction == 1){
                image = down1;
                }
                else if(direction == -1){
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
            if(direction == 1){
                if (spriteNum == 1) {
                    image = idle;
                }
                if (spriteNum == 2) {
                    image = idle2;
                }
            }
            else if(direction == -1){
                if (spriteNum == 1) {
                    image = ridle;
                }
                if (spriteNum == 2) {
                    image = ridle2;
                }
            }
                break;
            case Punch:
            if(direction == 1){
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
            else if (direction == -1){
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
            if(direction == 1){
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
            else if (direction == -1){
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
                  case Skill:
                  if(direction == 1){
                  if(kiBlastNum == 1) {
                    image = kiBlast1;
                  }
                  else if (kiBlastNum == 2) {
                    image = kiBlast2;
                  }
                }
                else if (direction == -1){
                    if(kiBlastNum == 1) {
                        image = rkiBlast1;
                      }
                      else if (kiBlastNum == 2) {
                        image = rkiBlast2;
                      }
                }
                  break;
        }

        g2.drawImage(image, (int)x, (int)y, 128, 120, null);
    }
}
