package src.entity.character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Goku extends Character {
    public Goku() {
        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(new File("./res/goku/up_1.png"));
            down1 = ImageIO.read(new File("./res/goku/down_1.png"));
            left1 = ImageIO.read(new File("./res/goku/left_1.png"));
            left2 = ImageIO.read(new File("./res/goku/left_2.png"));
            right1 = ImageIO.read(new File("./res/goku/right_1.png"));
            right2 = ImageIO.read(new File("./res/goku/right_2.png"));
            idle = ImageIO.read(new File("./res/goku/idle.png"));
            idle2 = ImageIO.read(new File("./res/goku/idle2.png"));
            punch1 = ImageIO.read(new File("./res/goku/punch1.png"));
            punch2 = ImageIO.read(new File("./res/goku/punch2.png"));
            punch3 = ImageIO.read(new File("./res/goku/punch3.png"));
            punch4 = ImageIO.read(new File("./res/goku/punch4.png"));
            kick1 = ImageIO.read(new File("./res/goku/kick1.png"));
            kick2 = ImageIO.read(new File("./res/goku/kick2.png"));
            kick3 = ImageIO.read(new File("./res/goku/kick3.png"));
            kick4 = ImageIO.read(new File("./res/goku/kick4.png"));

            //reverse image
            rup = ImageIO.read(new File("./res/goku/rup.png"));
            rdown = ImageIO.read(new File("./res/goku/rdown.png"));
            ridle = ImageIO.read(new File("./res/goku/ridle.png"));
            ridle2 = ImageIO.read(new File("./res/goku/ridle2.png"));
            rpunch1 = ImageIO.read(new File("./res/goku/rpunch1.png"));
            rpunch2 = ImageIO.read(new File("./res/goku/rpunch2.png"));
            rpunch3 = ImageIO.read(new File("./res/goku/rpunch3.png"));
            rpunch4 = ImageIO.read(new File("./res/goku/rpunch4.png"));
            rkick1 = ImageIO.read(new File("./res/goku/rkick1.png"));
            rkick2 = ImageIO.read(new File("./res/goku/rkick2.png"));
            rkick3 = ImageIO.read(new File("./res/goku/rkick3.png"));
            rkick4 = ImageIO.read(new File("./res/goku/rkick4.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
