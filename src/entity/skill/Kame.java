package src.entity.skill;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class Kame extends Skill {
    
    GamePanel gp;

    BufferedImage kame1, kame2, kame3, kame4, kame5, kame6, kame7, kame8;


    public Kame(int x, int y, GamePanel gp, int direction){
        this.x = x;
        this.y = y;
        this.gp = gp;
        this.direction = direction;
    }

    public void getImage(){
        try{
            kame1 = ImageIO.read(new File("./res/skill/kamehameHa/1.jpg"));
            kame2 = ImageIO.read(new File("./res/skill/kamehameHa/2.jpg"));
            kame3 = ImageIO.read(new File("./res/skill/kamehameHa/3.jpg"));
            kame4 = ImageIO.read(new File("./res/skill/kamehameHa/4.jpg"));
            kame5 = ImageIO.read(new File("./res/skill/kamehameHa/5.jpg"));
            kame6 = ImageIO.read(new File("./res/skill/kamehameHa/6.jpg"));
            kame7 = ImageIO.read(new File("./res/skill/kamehameHa/7.jpg"));
            kame8 = ImageIO.read(new File("./res/skill/kamehameHa/8.jpg"));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        // skillCounter++;
        // if(skillCounter>3){
        //     skillAct++;
        // }
        // if(skillAct > 8){
        //     skillAct = 1;
        // }

        skillAct = 8;
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
            switch (skillAct) {
              case 1:
              image = kame1;
              break;

              case 2:
              image = kame2;
              break;

              case 3:
              image = kame3;
              break;

              case 4:
              image = kame4;
              break;

              case 5:
              image = kame5;
              break;
              
              case 6:
              image = kame6;

              case 7:
              image = kame7;
              break;

              case 8:
              image = kame8;
              break;
              
            }

            if(direction == 1){
                g2.drawImage(image, x, y, 827,71*3,null);
            }
            else if(direction == -1){
                g2.drawImage(image, x, y, -827, 71*3, null);
            }
    }


}
