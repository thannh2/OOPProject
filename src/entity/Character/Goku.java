package src.entity.Character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Goku extends character {
    public Goku(){
        getImage();
    }

    public void getImage(){
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
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
