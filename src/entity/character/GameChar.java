package src.entity.character;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import src.entity.Action;
import src.entity.Entity;
import src.main.ActionBox;

public class GameChar {
    public BufferedImage up1, rup, down1, rdown, left1, left2, right1, right2, idle, idle2, ridle, ridle2, punch1, punch2, punch3, punch4, rpunch1, rpunch2, rpunch3, rpunch4, kick1, kick2, kick3, kick4, rkick1, rkick2, rkick3, rkick4;
    public BufferedImage kiBlast1, kiBlast2, rkiBlast1, rkiBlast2;
    public HashMap<Action, ActionBox> actions;
}
