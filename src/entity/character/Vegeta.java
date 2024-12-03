package src.entity.character;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import src.entity.Action;
import src.entity.Entity;
import src.main.ActionBox;

public class Vegeta extends GameChar {
    public Vegeta() {
        getImage();

        actions = new HashMap<>();
        Rectangle zeroBox = new Rectangle(0, 0, 0, 0);

        actions.put(Action.Punch, new ActionBox(new Rectangle(0, 0, 48, 17), new Rectangle(0, 0, 48, 85)));
        actions.put(Action.Kick, new ActionBox(new Rectangle(0, 0, 70, 16), new Rectangle(0, 0, 46, 80)));
        actions.put(Action.Idle, new ActionBox(zeroBox, new Rectangle(0, 0, 56, 72)));
        actions.put(Action.Up, new ActionBox(zeroBox, new Rectangle(0, 0, 48, 72)));
        actions.put(Action.Down, new ActionBox(zeroBox, new Rectangle(0, 0, 48, 72)));
        actions.put(Action.Left, new ActionBox(zeroBox, new Rectangle(0, 0, 80, 72)));
        actions.put(Action.Right, new ActionBox(zeroBox, new Rectangle(0, 0, 80, 72)));
        actions.put(Action.Skill, new ActionBox(zeroBox, new Rectangle(0, 0, 104, 72)));
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
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
