package src.main;

import src.entity.Entity;

public class CollisionChecker {

	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity) {
		int entityLeftX = entity.x;
		int entityRightX = entity.x + 128; //128 mean player witdh
		int entityTopY = entity.y;
		int entityBotY = entity.y + 120; //120 mean player height
	}
}
