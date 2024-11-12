package src.entity;

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

    public Player(GamePanel gp, Keyboard kb){
        this.gp = gp;
        this.kb = kb;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "idle";
    }

    public void getPlayerImage(){
        
        try{
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
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(kb.up == true){
            direction = "up";
            y -= speed;
        }
        else if (kb.down == true){
            direction = "down";
            y += speed;
        }
        else if (kb.left == true){
            direction = "left";
            x -= speed;
        }
        else if (kb.right == true){
            direction = "right";
            x += speed;
        }
        else if (kb.punch == true){
            direction = "punch";
            actionCounter++;
            if(actionCounter > 3){
                if(actionNum == 1) actionNum = 2;
                else if (actionNum == 2) actionNum = 3;
                else if (actionNum == 3) actionNum = 4;
                else if (actionNum == 4) actionNum = 1;
                actionCounter = 0;
            }
        }
        else if (kb.kick == true){
            direction = "kick";
            kickCounter++;
            if(kickCounter > 3){
                if(kickNum == 1) kickNum = 2;
                else if (kickNum == 2) kickNum = 3;
                else if (kickNum == 3) kickNum = 4;
                else if (kickNum == 4) kickNum = 1;
                kickCounter = 0;
            }
        }
        else{
            direction = "idle";
        }

        spriteCounter++;
        if(spriteCounter > 15){
            if(spriteNum == 1) spriteNum = 2;
            else if (spriteNum == 2) spriteNum = 1;
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2){
        // g2.setColor(Color.WHITE);

        //  g2.fillRect(x, y, 247, 247);

        BufferedImage image = null;

        switch (direction) {
            case "up":
            image = up1;
                break;
            case "down":
            image = down1;
                break;
            case "left":
            image = left1;
                break;
            case "right":
            image = right1;
                break;
            case "idle":
            if(spriteNum == 1){
                image = idle; 
            }
            if(spriteNum == 2){
                image = idle2;
            }
            break;
            case "punch":
            if(actionNum == 1){
                image = punch1;
            }
            else if(actionNum == 2){
                image = punch2;
            }
            else if(actionNum == 3){
                image = punch3;
            }
            else if(actionNum == 4){
                image = punch4;
            }
            break;
            case "kick":
            if(kickNum == 1){
                image = kick1;
            }
            else if(kickNum == 2){
                image = kick2;
            }
            else if(kickNum == 3){
                image = kick3;
            }
            else if(kickNum == 4){
                image = kick4;
            }
            break;
                     
        }
        g2.drawImage(image, x, y, 128, 120, null);
    }
}
