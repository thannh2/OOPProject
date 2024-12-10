package src.main;

import java.awt.Rectangle;

public class ActionBox {
    private Rectangle hitbox;
    private Rectangle hurtbox;

    public ActionBox(Rectangle hitbox, Rectangle hurtbox) {
        this.hitbox = hitbox;
        this.hurtbox = hurtbox;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }

    public Rectangle getHurtbox() {
        return hurtbox;
    }
    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }
}