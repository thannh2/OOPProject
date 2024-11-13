package src.main;

import src.entity.Entity;

public class CollisionChecker {

	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity) {
        int x = (int)entity.x;
        int y = (int)entity.y;

		int entityLeftX = x;
		int entityRightX = x + 128; //128 mean player witdh
		int entityTopY = y;
		int entityBotY = y + 120; //120 mean player height
	}
}
