package src.main;
import java.awt.Rectangle;
import src.entity.Player;
import src.entity.Player2;
import src.entity.skill.KiBlast;

public class CollisionChecker {

	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public boolean intersects(Rectangle mine, Rectangle other) {
        return mine.x < other.x + other.width &&
               mine.x + mine.width > other.x &&
               mine.y < other.y + other.height &&
               mine.y + mine.height > other.y;
	}

	public boolean checkCollision(Player player, Player2 player2, KiBlast L1, KiBlast L2) {
		Rectangle playerHitbox = player.getHitbox();
		Rectangle player2Hurtbox = player2.getHurtbox();
		Rectangle playerHurtbox = player.getHurtbox();
		Rectangle player2Hitbox = player2.getHitbox();
		if(intersects(playerHitbox, player2Hurtbox)) {
			System.out.println("Attack!! 1 -> 2");
			return true;
		}
		if(intersects(player2Hitbox, playerHurtbox)){
			System.out.println("Attack!! 2 -> 1");
			return true;
		}
		if(intersects(L1.getSkillHitbox(), player2Hurtbox)){
			System.out.println("Skill Attack!! 1 -> 2");
			return true;
		}
		if(intersects(L2.getSkillHitbox(), playerHurtbox)){
			System.out.println("Skill Attack!! 2 -> 1");
			return true;
		}
		return false;
	}
}
