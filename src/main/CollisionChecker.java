package src.main;

import java.awt.Rectangle;

import src.entity.Player;
import src.entity.Player2;

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

	public boolean checkCollision(Player player, Player2 player2) {
		Rectangle playerHitbox = player.getHitbox();
		Rectangle player2Hurtbox = player2.getHurtbox();
		if(intersects(playerHitbox, player2Hurtbox)) {
			return true;
		}
		return false;
	}
}
