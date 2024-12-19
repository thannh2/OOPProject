package src.entity.skill;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Rectangle;

import src.main.GamePanel;

public class Kame extends Skill {
    
    GamePanel gp;

    BufferedImage back1, back2, back3, back4, body1, body2, body3, body4, head;


    public Kame(int x, int y, GamePanel gp, int direction){
        this.x = x;
        this.y = y;
        this.gp = gp;
        this.direction = direction;
        Rectangle zeroBox = new Rectangle(0, 0, 0, 0);
        this.SkillHitbox = new Rectangle(x, y, 1100,80);
        getImage();
    }

    public void getImage(){
        try{
            back1 = ImageIO.read(new File("./res/skill/kamehameHa/back1.png"));
            back2 = ImageIO.read(new File("./res/skill/kamehameHa/back2.png"));
            back3 = ImageIO.read(new File("./res/skill/kamehameHa/back3.png"));
            back4 = ImageIO.read(new File("./res/skill/kamehameHa/back4.png"));
            body1 = ImageIO.read(new File("./res/skill/kamehameHa/body1.png"));
            body2 = ImageIO.read(new File("./res/skill/kamehameHa/body2.png"));
            body3 = ImageIO.read(new File("./res/skill/kamehameHa/body3.png"));
            body4 = ImageIO.read(new File("./res/skill/kamehameHa/body4.png"));
            head = ImageIO.read(new File("./res/skill/kamehameHa/head1.png"));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(direction == 1){
            this.SkillHitbox = new Rectangle(x , y, 1100,70);
            // System.out.println(this.SkillHitbox);
            //x+=speed;
        }
        else if(direction == -1){
            this.SkillHitbox = new Rectangle(x -1100, y, 1100,70);
            //x-=speed;
        }
           skillCounter++;
           if(skillCounter>20){
               skillAct++;
               skillCounter = 0;
           }
           if(skillAct > 4){
               skillAct = 1;
           }
        //skillAct = 1;
    }

    public void draw(Graphics2D g2){
        BufferedImage back = null;
        BufferedImage body = null;
        if(direction == 1){
            switch (skillAct) {
                case 1:
                back = back1;
                body = body1;
                g2.drawImage(head, x+1100, y+2,70,72,null);
                break;
                case 2:
                back = back2;
                body = body2;
                g2.drawImage(head, x+1100, y+8,58,60,null);
                break;
                case 3:
                back = back3;
                body = body3;
                g2.drawImage(head, x+1089, y+27,70/3,72/3,null);
                break;
                case 4:
                body = body4;
                back = back4;
                g2.drawImage(head, x+1089, y+30,21,22,null);
                break;
            }
            g2.drawImage(back, x, y, 80,80,null);
            g2.drawImage(body, x+55, y+15, 1050,48,null);
        }
        else if(direction == -1){
            switch (skillAct) {
                case 1:
                back = back1;
                body = body1;
                g2.drawImage(head, x-1100, y+2,-70,72,null);
                break;
                case 2:
                back = back2;
                body = body2;
                g2.drawImage(head, x-1100, y+8,-58,60,null);
                break;
                case 3:
                back = back3;
                body = body3;
                g2.drawImage(head, x-1089, y+27,-70/3,72/3,null);
                break;
                case 4:
                body = body4;
                back = back4;
                g2.drawImage(head, x-1089, y+30,-21,22,null);
                break;
            }
            g2.drawImage(back, x, y, -80,80,null);
            g2.drawImage(body, x-55, y+15, -1050,48,null);
        }
    }


}
