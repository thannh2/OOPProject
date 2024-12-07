package src.entity.skill;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Skill {
    public int x, y, speed;

    BufferedImage pic1, pic2, rpic1, rpic2;

    public int skillCounter = 0;
    public int skillAct = 1;
    public int direction = 1;

    public Rectangle SkillHitbox;
    public Rectangle getSkillHitbox(){
        return SkillHitbox;
    }

}
