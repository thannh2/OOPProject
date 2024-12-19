package src.main;
import java.awt.Rectangle;
import src.entity.Player;
import src.entity.Player2;
import src.entity.skill.Kame;
import src.entity.skill.KiBlast;

public class CollisionChecker {

	GamePanel gp;

	public int getHit1 = 0, getHit2 = 0;
	public int skillHit1 = 0, skillHit2 = 0;
	public int kameHit1 = 0, kameHit2 = 0;


	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public boolean intersects(Rectangle mine, Rectangle other) {
        return mine.x < other.x + other.width &&
               mine.x + mine.width > other.x &&
               mine.y < other.y + other.height &&
               mine.y + mine.height > other.y;
	}

	public boolean checkCollision(Player player, Player2 player2, KiBlast L1, KiBlast L2, Kame K1, Kame K2) {
		Rectangle playerHitbox = player.getHitbox();
		Rectangle player2Hurtbox = player2.getHurtbox();
		Rectangle playerHurtbox = player.getHurtbox();
		Rectangle player2Hitbox = player2.getHitbox();
		if(intersects(playerHitbox, player2Hurtbox)) {
			System.out.println("Attack!! 1 -> 2");
			getHit2++;
			return true;
		}
		if(intersects(player2Hitbox, playerHurtbox)){
			System.out.println("Attack!! 2 -> 1");
			getHit1++;
			return true;
		}
		if(intersects(L1.getSkillHitbox(), player2Hurtbox)){
			System.out.println("Skill Attack!! 1 -> 2");
			skillHit2++;
			getHit2++;
			return true;
		}
		if(intersects(L2.getSkillHitbox(), playerHurtbox)){
			System.out.println("Skill Attack!! 2 -> 1");
			skillHit1++;
			getHit1++;
			return true;
		}
		if(intersects(K1.getSkillHitbox(), player2Hurtbox)){
			System.out.println("Kame 1->2");
			kameHit2=1;
			//getHit2++;
			return true;
		}
		if(intersects(K2.getSkillHitbox(), playerHurtbox)){
			kameHit1=1;
			return true;
		}
		getHit1 = 0;
		getHit2 = 0;
		skillHit1 = 0;
		skillHit2 = 0;
		kameHit2 = -1;
		kameHit1 = -1;
		return false;
	}
}
