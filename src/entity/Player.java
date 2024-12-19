package src.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import src.entity.character.Goku;
import src.entity.character.Vegeta;
import src.entity.skill.KiBlast;
import src.main.ActionBox;
import src.main.GamePanel;
import src.main.Keyboard;


public class Player extends Entity {
    GamePanel gp;
    Keyboard kb;
    // Player2 player2;
    private Map<Action, ActionBox> actions;

    public String character = null;
    public Goku goku = new Goku();
    public Vegeta vegeta = new Vegeta();

    public KiBlast L;
    // public KiBlast L1 = new KiBlast(10000, 100000, gp, 2);
    
    public Player(GamePanel gp, Keyboard kb, String character) {
        this.gp = gp;
        this.kb = kb;
        this.character = character;
        // this.player2 = player2;
        setDefaultValues();
        getPlayerImage();
        
        int x = (int)this.x;
        int y = (int)this.y;
        Rectangle zeroBox = new Rectangle(0, 0, 0, 0);
        actions = new HashMap<>();

        //hitbox & hurtbox
        actions.put(Action.Punch, new ActionBox(new Rectangle(100000,100000, 48, 17), new Rectangle(x + 48, y + 35, 48, 85)));
        actions.put(Action.Kick, new ActionBox(new Rectangle(x + 56, y + 64, 70, 16), new Rectangle(x + 16, y + 32, 46, 80)));
        actions.put(Action.Idle, new ActionBox(zeroBox, new Rectangle(0, 0, 46, 72)));
        actions.put(Action.Up, new ActionBox(zeroBox, new Rectangle(0, 0, 46, 72)));
        actions.put(Action.Down, new ActionBox(zeroBox, new Rectangle(0, 0, 46, 72)));
        actions.put(Action.Left, new ActionBox(zeroBox, new Rectangle(0, 0, 80, 72)));
        actions.put(Action.Right, new ActionBox(zeroBox, new Rectangle(0, 0, 80, 72)));
        actions.put(Action.Skill, new ActionBox(zeroBox, new Rectangle(0, 0, 46, 72)));
        actions.put(Action.Hit, new ActionBox(zeroBox, zeroBox));
        actions.put(Action.Lose, new ActionBox(zeroBox, zeroBox));
        actions.put(Action.Kame, new ActionBox(zeroBox, zeroBox));
    }

    public void setDefaultValues() {
        x = 100.0f;
        y = 100.0f;
        velX = 0.0f;
        velY = 0.0f;
        speed = 10;
        action = Action.Idle;
        reverse = false;
        doJump = false;
        direction = 1;
    }

    public Rectangle getHitbox() {
        return actions.get(action).getHitbox();
    }

    public Rectangle getHurtbox() {
        return actions.get(action).getHurtbox();
    }
    
    public void getPlayerImage() {
        if(character == "goku"){
            up1 = goku.up1;
            down1 = goku.down1;
            left1 = goku.left1;
            right1 = goku.right1;
            idle = goku.idle;
            idle2 = goku.idle2;
            punch1 = goku.punch1;
            punch2 = goku.punch2;
            punch3 = goku.punch3;
            punch4 = goku.punch4;
            kick1 = goku.kick1;
            kick2 = goku.kick2;
            kick3 = goku.kick3;
            kick4 = goku.kick4;
            kiBlast1 = goku.kiBlast1;
            kiBlast2 = goku.kiBlast2;
            kame1 = goku.kame1;
            kame2 = goku.kame2;
            kame3 = goku.kame3;
            kame4 = goku.kame4;
            //reverse image
            rup = goku.rup;
            rdown = goku.rdown;
            ridle = goku.ridle;
            ridle2 = goku.ridle2;
            rpunch1 = goku.rpunch1;
            rpunch2 = goku.rpunch2;
            rpunch3 = goku.rpunch3;
            rpunch4 = goku.rpunch4;
            rkick1 = goku.rkick1;
            rkick2 = goku.rkick2;
            rkick3 = goku.rkick3;
            rkick4 = goku.rkick4;
            rkiBlast1 = goku.rkiBlast1;
            rkiBlast2 = goku.rkiBlast2;
            rkame1 = goku.rkame1;
            rkame2 = goku.rkame2;
            rkame3 = goku.rkame3;
            rkame4 = goku.rkame4;

            getHit = goku.getHit;
            rgetHit = goku.rgetHit;
            lose1 = goku.lose1;
            lose2 = goku.lose2;
            rlose1 = goku.rlose1;
            rlose2 = goku.rlose2;
        }
        else if(character == "vegeta"){
            up1 = vegeta.up1;
            down1 = vegeta.down1;
            left1 = vegeta.left1;
            right1 = vegeta.right1;
            idle = vegeta.idle;
            idle2 = vegeta.idle2;
            punch1 = vegeta.punch1;
            punch2 = vegeta.punch2;
            punch3 = vegeta.punch3;
            punch4 = vegeta.punch4;
            kick1 = vegeta.kick1;
            kick2 = vegeta.kick2;
            kick3 = vegeta.kick3;
            kick4 = vegeta.kick4;
            kiBlast1 = vegeta.kiBlast1;
            kiBlast2 = vegeta.kiBlast2;
            kame1 = vegeta.kame1;
            kame2 = vegeta.kame2;
            kame3 = vegeta.kame3;
            kame4 = vegeta.kame4;


            rup = vegeta.rup;
            rdown = vegeta.rdown;
            ridle = vegeta.ridle;
            ridle2 = vegeta.ridle2;
            rpunch1 = vegeta.rpunch1;
            rpunch2 = vegeta.rpunch2;
            rpunch3 = vegeta.rpunch3;
            rpunch4 = vegeta.rpunch4;
            rkick1 = vegeta.rkick1;
            rkick2 = vegeta.rkick2;
            rkick3 = vegeta.rkick3;
            rkick4 = vegeta.rkick4;
            rkiBlast1 = vegeta.rkiBlast1;
            rkiBlast2 = vegeta.rkiBlast2;
            rkame1 = vegeta.rkame1;
            rkame2 = vegeta.rkame2;
            rkame3 = vegeta.rkame3;
            rkame4 = vegeta.rkame4;

            getHit = vegeta.getHit;
            rgetHit = vegeta.rgetHit;
            lose1 = vegeta.lose1;
            lose2 = vegeta.lose2;
            rlose1 = vegeta.rlose1;
            rlose2 = vegeta.rlose2;
        }
    }

    public void update(int skillx, int hit, int kameHit) {
        if(Health <= 0){
            action = Action.Lose;
            loseCounter++;
            actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
            if(loseCounter>3){
                if(loseNum == 1) loseNum = 2;
            }
        }
        
        else if(hit > 1){
            if(doGetHit == false){
            doGetHit = true;
            action = Action.Hit;
            if(direction == 1) {
                actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
            } else {
                actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
            }
        }
        }
        else if (kb.up == true) {
            // action = Action.Up;
            // velY = -speed;
            // y += velY;
            if(doKame == false){
            if(doJump == false){
                if(direction == 1) {
                    actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 24);

                } else {
                    actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 24 - 46, (int)this.y + 24);
                }
            // velY = -speed;
            // y += velY;
            velY = -20;
                doJump = true;
            }}
        // }
        // else if (kb.down == true) {
        //     // action = Action.Down;
        //     velY = speed;
        //     if(direction == 1) {
        //         actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 24);
        //     } else {
        //         actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 24 - 46, (int)this.y + 24);
        //     }
        }
        else if (kb.left == true) {
            if(doKame == false){
            if(x>-50 && x<1230){
            if(doJump == false){
            direction = -1;
            action = Action.Left;
            velX = -speed;
            x += velX;
            actions.get(action).getHurtbox().setLocation((int)this.x + 16, (int)this.y + 48);
            }
            else{
                velX = -speed;
            x += velX;
                velY += 1;
                    JumpCounter++;
                    if(JumpCounter > 1){
                        y += velY;
                    }
                    if(velY<0) {
                        action = Action.Up; 
                        if(direction == 1) {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 24);
                        } else {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 24 - 46, (int)this.y + 24);
                        }
                    }
                    if(velY>=0) doJump = false;
            }
        } else{
            if(x<=-50) x += 5;
            else if(x>=1230) x-=5;
        }}
    }
        else if (kb.right == true) {
            if(doKame == false){
            if(x>-50 && x<1230){
            if(doJump == false ){
            direction = 1;
            action = Action.Right;
            velX = speed;
            x += velX;
            actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 48);
            }
            else{
                velX = speed;
            x += velX;
                velY += 1;
                    JumpCounter++;
                    if(JumpCounter > 1){
                        y += velY;
                    }
                    if(velY<0) {
                        action = Action.Up; 
                        if(direction == 1) {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 24);
                        } else {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 24 - 46, (int)this.y + 24);
                        }
                    }
                    if(velY>=0) doJump = false;
            }
        }  else{
            if(x<=-50) x += 5;
            else if(x>=1230) x-=5;
        }}
    }
        else if (kb.punch == true) {
            // actionNum = 1;
            // actionCounter = 4;
            if(actionDo == 0){
            actionDo = 1;
            action = Action.Punch;
            }
             if(direction == 1) {
                // actions.get(action).getHitbox().setLocation((int)this.x + 80, (int)this.y + 56);
                actions.get(action).getHurtbox().setLocation((int)this.x + 48, (int)this.y + 35);
             } else {
                // actions.get(action).getHitbox().setLocation((int)this.x + 128 - 80 - 48, (int)this.y + 56);
                actions.get(action).getHurtbox().setLocation((int)this.x + 128 - 48 - 48, (int)this.y + 35);
             }

            

        }
        else if (kb.kick == true){
            // kickNum = 1;
            // kickCounter = 4;
            if(kickDo == 0){
            kickDo = 1;
            action = Action.Kick;
            }
            if(direction == 1) {
                // actions.get(action).getHitbox().setLocation((int)this.x + 56, (int)this.y + 64);
                actions.get(action).getHurtbox().setLocation((int)this.x + 16, (int)this.y + 32);
            } else {
                // actions.get(action).getHitbox().setLocation((int)this.x + 120 - 56 - 70, (int)this.y + 64);
                actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 16 - 46, (int)this.y + 32);
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
                // actions.get(action).setHitbox(L1.getSkillHitbox());
                // System.out.println(L1.getSkillHitbox());
                if(direction == 1) {
                    // actions.get(action).getHitbox().setLocation((int)actions.get(action).getHitbox().getX(), (int)this.y);
                    actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
                } else {
                    // actions.get(action).getHitbox().setLocation((int)actions.get(action).getHitbox().getX(), (int)this.y);
                    actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
                }
            }
        }
        else if(kb.kame == true){
            if(y>=535 && mana >= 80){
            action = Action.Kame;
            doKame = true;
            kameDo = true;
            if(direction == 1) {
                // actions.get(action).getHitbox().setLocation((int)actions.get(action).getHitbox().getX(), (int)this.y);
                actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
            } else {
                // actions.get(action).getHitbox().setLocation((int)actions.get(action).getHitbox().getX(), (int)this.y);
                actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
            }}
        }
        else {
           // L.update();
            if(actionDo == 1 || kickDo == 1 || doJump == true || kiBlastDo == 1 || doGetHit == true || doKame == true || kameHit == 1){
                if(actionDo == 1){
                    if(actionNum>3){
                    if(direction == 1) {
                        actions.get(action).getHitbox().setLocation((int)this.x + 80, (int)this.y + 56);
                      //  actions.get(action).getHurtbox().setLocation((int)this.x + 48, (int)this.y + 35);
                    } else {
                        actions.get(action).getHitbox().setLocation((int)this.x + 128 - 80 - 48, (int)this.y + 56);
                       // actions.get(action).getHurtbox().setLocation((int)this.x + 128 - 48 - 48, (int)this.y + 35);
                    }}
                    actionCounter++;
                    if(actionCounter > 3){
                        actionNum++;
                        actionCounter = 0;
                    }
                    if(actionNum > 4) {
                        actions.get(action).getHitbox().setLocation((int)this.x, 10000000);
                        action = Action.Idle;
                        // if(direction == 1) {
                        //     actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
                        // } else {
                        //     actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
                        // }
                        // if(direction == 1) {
                        //     actions.get(action).getHitbox().setLocation((int)this.x + 80, (int)this.y + 56);
                        //   //  actions.get(action).getHurtbox().setLocation((int)this.x + 48, (int)this.y + 35);
                        // } else {
                        //     actions.get(action).getHitbox().setLocation((int)this.x + 128 - 80 - 48, (int)this.y + 56);
                        //    // actions.get(action).getHurtbox().setLocation((int)this.x + 128 - 48 - 48, (int)this.y + 35);
                        // }
                        actionDo = 0;
                        actionNum = 1;
                        gp.playSE(0);
                    }
                }
                if(kickDo == 1){
                    kickCounter++;

                    if(kickNum > 3){
                        if(direction == 1) {
                               actions.get(action).getHitbox().setLocation((int)this.x + 56, (int)this.y + 64);
                              // actions.get(action).getHurtbox().setLocation((int)this.x + 16, (int)this.y + 32);
                           } else {
                               actions.get(action).getHitbox().setLocation((int)this.x + 120 - 56 - 70, (int)this.y + 64);
                              // actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 16 - 46, (int)this.y + 32);
                           }
                    }

                    if(kickCounter > 3){
                        kickNum++;
                        kickCounter = 0;

                    }
                    if(kickNum > 4) {
                        actions.get(action).getHitbox().setLocation(100000,100000);
                        action = Action.Idle;
                        kickDo = 0;
                        kickNum = 1;
                        gp.playSE(1);
                    }
                }
                if(doJump==true){
                    velY += 1;
                    JumpCounter++;
                    if(JumpCounter > 1){
                        y += velY;
                    }
                    if(velY<0) {
                        action = Action.Up; 
                        if(direction == 1) {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 24);
                        } else {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 24 - 46, (int)this.y + 24);
                        }
                    }
                    if(velY>=0) doJump = false;
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
                            actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
                        } else {
                            actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
                        }
                        kiBlastDo = 0;
                        gp.playSE(7);
                    }
                }
                if(doGetHit == true){
                    gethitCounter++;
                    
                    if(gethitCounter>8){
                        Health = Health - 5;

                        if(mana<80) mana = mana + 5;
                        doGetHit = false;
                        gethitCounter = 0;
                    }
                }
                if(kameHit == 1){
                    System.out.println("kameHit");
                    action = Action.Hit;
                    if(minusHealth > -50){
                    gethitCounter++;
                if(gethitCounter>1){
                    Health -= 5;
                    minusHealth -=5;
                    gethitCounter = 0;
                }
                }else{
                    System.out.println("null kamehit");
                    action = Action.Idle;
                    kameHit = -1;
                }
            }
                if(doKame == true){
                    mana = 0;
                    kameDo = false;
                    kameCounter++;
                    if(kameCounter>20){
                        kameNum++;
                        kameCounter=0;
                    }
                    if(kameNum>=4){
                         kameNum=1;
                         doKame = false;
                    }
                }

            }
            else {
                action = Action.Idle;
                if(direction == 1) {
                    actions.get(action).getHurtbox().setLocation((int)this.x + 38, (int)this.y + 32);
                } else {
                    actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 38 - 46, (int)this.y + 32);
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
        
        if(y < 535) {
            if(doJump == false){
                action = Action.Down;
                velY += 1;
                y += velY;
                if(direction == 1) {
                    actions.get(action).getHurtbox().setLocation((int)this.x + 24, (int)this.y + 24);
                } else {
                    actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 24 - 46, (int)this.y + 24);
                }
            } 
        }
        // else  {
        //     if(action != Action.Left || action != Action.Right){
        //     action = Action.Idle;
        //     if(direction == 1) {
        //         actions.get(action).getHurtbox().setLocation((int)this.x + 8, (int)this.y + 32);
        //     } else {
        //         actions.get(action).getHurtbox().setLocation((int)this.x + 120 - 8 - 46, (int)this.y + 32);
        //     }
        // }
        // }
    
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
                case Hit:
                     if(direction == 1){
                        image = getHit;
                     }
                     else if(direction == -1){
                        image = rgetHit;
                     }
                break;
                case Lose:
                     if(direction == 1){
                        if(loseNum==1){
                            image = lose1;
                        }
                        else image = lose2;
                     }
                     else if (direction == -1){
                        if(loseNum == 1){
                            image = rlose1;
                        }
                        else image = rlose2;
                     }
                     break;
                case Kame:
                     if(direction == 1){
                        switch(kameNum){
                            case 1:
                              image = kame1;
                            case 2:
                              image = kame2;
                            case 3:
                              image = kame3;
                            case 4:
                              image = kame4;
                        }
                     }
                     else if (direction==-1){
                        switch(kameNum){
                            case 1:
                              image = rkame1;
                            case 2:
                              image = rkame2;
                            case 3:
                              image = rkame3;
                            case 4:
                              image = rkame4;
                        }
                     }
            }

        g2.drawImage(image, (int)x, (int)y, 128, 120, null);
    }

    public KiBlast getL() {
        return L;
    }

}

