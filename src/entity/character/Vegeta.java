package src.entity.character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Vegeta extends Character {
    public Vegeta() {
        getImage();
    }

    public void getImage() {
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

            kiBlast1 = ImageIO.read(new File("./res/vegeta/kiBlast1.png"));
            kiBlast2 = ImageIO.read(new File("./res/vegeta/kiBlast2.png"));

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

            rkiBlast1 = ImageIO.read(new File("./res/vegeta/rkiBlast1.png"));
            rkiBlast2 = ImageIO.read(new File("./res/vegeta/rkiBlast2.png"));

            //get hit and lose
            getHit = ImageIO.read(new File("./res/vegeta/getHit.png"));
            lose1 = ImageIO.read(new File("./res/vegeta/lose1.png"));
            lose2 = ImageIO.read(new File("./res/vegeta/lose2.png"));

            rgetHit = ImageIO.read(new File("./res/vegeta/rgetHit.png"));
            rlose1 = ImageIO.read(new File("./res/vegeta/rlose1.png"));
            rlose2 = ImageIO.read(new File("./res/vegeta/rlose2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
