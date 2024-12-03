package src.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

import src.entity.character.*;
import src.entity.skill.KiBlast;
import src.main.ActionBox;
import src.main.GamePanel;
import src.main.Keyboard2;

public class Player2 extends Entity {
    GamePanel gp;
    Keyboard2 kb;
    GameChar character;

    KiBlast L;

    public Player2(GamePanel gp, Keyboard2 kb, String character) {
        this.gp = gp;
        this.kb = kb;

        setDefaultValues();
        switch (character) {
            case "goku":
                this.character = new Goku();
                break;
            case "vegeta":
                this.character = new Vegeta();
                break;
            default:
                return;
        }
    }

    public void setDefaultValues() {
        x = 400.0f;
        y = 100.0f;
        velX = 0.0f;
        velY = 0.0f;
        speed = 8;
        action = Action.Idle;
        reverse = true;
        doJump = false;
        direction = -1;
    }

    public Rectangle getHitbox() {
        return this.character.actions.get(action).getHitbox();
    }

    public Rectangle getHurtbox() {
        return this.character.actions.get(action).getHurtbox();
    }

    public void update(int skillx) {
        if (kb.up == true) {
            action = Action.Up;
            velY = -speed;
            y += velY;
            if(direction == 1) {
                this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 24);
            } else {
                this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 48, (int)this.y + 24);
            }
            // velY = -speed;
            // y += velY;
            doJump = true;
        }
        // else if (kb.down == true) {
        //     // action = Action.Down;
        //     velY = speed;
        //     if(direction == 1) {
        //         this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 32, (int)this.y + 24);
        //     } else {
        //         this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 32 - 46, (int)this.y + 24);
        //     }
        // }
        else if (kb.left == true) {
            if(doJump == false){
            direction = -1;
            action = Action.Left;
            velX = -speed;
            x += velX;
            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 48);
            }
            else{
                velY += -speed;
                    JumpCounter++;
                    if(JumpCounter > 1){
                        y += velY;
                    }
                    if(y < 380) doJump = false;
            }
        }
        else if (kb.right == true) {
            if(doJump == false){
            direction = 1;
            action = Action.Right;
            velX = speed;
            x += velX;
            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 48);
            }
            else{
                velY += -speed;
                    JumpCounter++;
                    if(JumpCounter > 1){
                        y += velY;
                    }
                    if(y < 380) doJump = false;
            }
        }
        else if (kb.punch == true) {
            actionNum = 1;
            actionCounter = 4;
            actionDo = 1;
            action = Action.Punch;
            if(direction == 1) {
                this.character.actions.get(action).getHitbox().setLocation((int)this.x + 72, (int)this.y + 56);
                this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 48, (int)this.y + 35);
            } else {
                this.character.actions.get(action).getHitbox().setLocation((int)this.x + 128 - 72 - 48, (int)this.y + 56);
                this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 128 - 48 - 48, (int)this.y + 35);
            }

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
            if(direction == 1) {
                this.character.actions.get(action).getHitbox().setLocation((int)this.x + 48, (int)this.y + 56);
                this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
            } else {
                this.character.actions.get(action).getHitbox().setLocation((int)this.x + 120 - 40 - 70, (int)this.y + 56);
                this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 46, (int)this.y + 32);
            }

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
                //this.character.actions.get(action).getHitbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
            }
        }
        else {
           // L.update();
            // if(direction == 1) {
            //     this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
            // } else {
            //     this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 46, (int)this.y + 32);
            // }
            if(actionDo == 1 || kickDo == 1 || doJump == true || kiBlastDo == 1){
                if(actionDo == 1){
                    actionCounter++;
                    if(actionCounter > 3){
                        actionNum++;
                        actionCounter = 0;
                    }
                    if(actionNum > 4) {
                        action = Action.Idle;
                        if(direction == 1) {
                            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
                        } else {
                            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 56, (int)this.y + 32);
                        }
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
                        if(direction == 1) {
                            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
                        } else {
                            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 56, (int)this.y + 32);
                        }
                        kickDo = 0;
                    }
                }
                if(doJump==true){
                    velY += -speed;
                    JumpCounter++;
                    if(JumpCounter > 1){
                        y += velY;
                    }
                    if(y < 380) doJump = false;
                }
                if(kiBlastDo == 1){
                    kiBlastCounter++;
                    if(kiBlastCounter>3){
                        kiBlastNum++;
                        kiBlastCounter=0;
                    }
                    if(kiBlastNum>2) {
                        action = Action.Idle;
                        if(direction == 1) {
                            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
                        } else {
                            this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 56, (int)this.y + 32);
                        }
                        kiBlastDo = 0;
                    }
                }
            }
            else {
                action = Action.Idle;
                if(direction == 1) {
                    this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
                } else {
                    this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 56, (int)this.y + 32);
                }
            }
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
                if(direction == 1) {
                    this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 24);
                } else {
                    this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 48, (int)this.y + 24);
                }
            }
            // else if (y == 500) {
            //     action = action.Idle;
            //     if(direction == 1) {
            //         this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
            //     } else {
            //         this.character.actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 46, (int)this.y + 32);
            //     }
            // }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (action) {
            case Up:
                if(direction == 1){
                    image = character.up1;
                }
                else if(direction == -1){
                    image = character.rup;
                }
                break;
            case Down:
                if(direction == 1){
                    image = character.down1;
                    }
                    else if(direction == -1){
                        image = character.rdown;
                    }
                    break;
            case Left:
                image = character.left1;
                break;
            case Right:
                image = character.right1;
                break;
            case Idle:
                if(direction == 1){
                    if (spriteNum == 1) {
                        image = character.idle;
                    }
                    if (spriteNum == 2) {
                        image = character.idle2;
                    }
                }
                else if(direction == -1){
                    if (spriteNum == 1) {
                        image = character.ridle;
                    }
                    if (spriteNum == 2) {
                        image = character.ridle2;
                    }
                }
                    break;
            case Punch:
                if(direction == 1){
                    if (actionNum == 1) {
                        image = character.punch1;
                    }
                    else if (actionNum == 2) {
                        image = character.punch2;
                    }
                    else if (actionNum == 3) {
                        image = character.punch3;
                    }
                    else if (actionNum == 4) {
                        image = character.punch4;
                    }
                    else if (actionNum == 0) {
                        image = character.idle;
                    }
                }
                else if (direction == -1){
                    if (actionNum == 1) {
                        image = character.rpunch1;
                    }
                    else if (actionNum == 2) {
                        image = character.rpunch2;
                    }
                    else if (actionNum == 3) {
                        image = character.rpunch3;
                    }
                    else if (actionNum == 4) {
                        image = character.rpunch4;
                    }
                    else if (actionNum == 0) {
                        image = character.ridle;
                    }
                }
                break;
            case Kick:
                if(direction == 1){
                    if (kickNum == 1) {
                        image = character.kick1;
                    }
                    else if (kickNum == 2) {
                        image = character.kick2;
                    }
                    else if (kickNum == 3) {
                        image = character.kick3;
                    }
                    else if (kickNum == 4) {
                        image = character.kick4;
                    }
                    else if (kickNum == 0) {
                        image = character.idle;
                    }
                }
                else if (direction == -1){
                    if (kickNum == 1) {
                        image = character.rkick1;
                    }
                    else if (kickNum == 2) {
                        image = character.rkick2;
                    }
                    else if (kickNum == 3) {
                        image = character.rkick3;
                    }
                    else if (kickNum == 4) {
                        image = character.rkick4;
                    }
                    else if (kickNum == 0) {
                        image = character.ridle;
                    }
                }
                break;
            case Skill:
                if(direction == 1){
                    if(kiBlastNum == 1) {
                        image = character.kiBlast1;
                    }
                    else if (kiBlastNum == 2) {
                        image = character.kiBlast2;
                    }
                }
                else if (direction == -1){
                    if(kiBlastNum == 1) {
                        image = character.rkiBlast1;
                    }
                    else if (kiBlastNum == 2) {
                        image = character.rkiBlast2;
                    }
                }
                break;
            }

        g2.drawImage(image, (int)x, (int)y, 128, 120, null);
    }
}
