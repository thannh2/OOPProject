package src.entity.skill;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import src.main.GamePanel;

public class KiBlast extends Skill {
    GamePanel gp;
    boolean test = true;

    public KiBlast(int x, int y, GamePanel gp, int direction){
        this.x = x;
        this.y = y;
        this.gp = gp;
        this.direction = direction;
        speed = 8;
        getImage();
    }

    public void getImage(){
        try{
            if(direction == 1){
            pic1 = ImageIO.read(new File("./res/skill/kiBlast/kiBlast1.png"));
            pic2 = ImageIO.read(new File("./res/skill/kiBlast/kiBlast2.png"));
            }
            else if(direction == -1){
            rpic1 = ImageIO.read(new File("./res/skill/kiBlast/rkiBlast1.png"));
            rpic2 = ImageIO.read(new File("./res/skill/kiBlast/rkiBlast2.png"));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(direction == 1){
        x+=speed;
        }
        else if(direction == -1){
            x-=speed;
        }
        skillCounter++;
        if(skillCounter>2){
            if(skillAct == 1) skillAct = 2;
            else skillAct = 1;
            skillCounter = 0;
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        if(direction == 1){
        if(skillAct == 1) {
            image = pic1;
        }
        else{
            image = pic2;
        }
        }
        else if(direction == -1){
            if(skillAct == 1) {
                image = rpic1;
            }
            else{
                image = rpic2;
            }
        }
        g2.drawImage(image, x, y, 100, 40, null);
    }

}
