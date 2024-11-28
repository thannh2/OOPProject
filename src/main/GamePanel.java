package src.main;

import java.awt.*;
import javax.swing.JPanel;
import src.entity.Player;
import src.entity.Player2;
import src.entity.Skill.kiBlast;

public class GamePanel extends JPanel implements Runnable {
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;

    private static final int FPS = 60;

    private Thread gameThread;
    private Keyboard keyboard = new Keyboard();
    

    private Keyboard2 keyboard2 = new Keyboard2();
    public Player2 player2 = new Player2(this, keyboard2);

    public Player player = new Player(this, keyboard, player2);

    public kiBlast L1 = new kiBlast(10000, 100000, this,2);
    public kiBlast L2 = new kiBlast(10000, 100000, this, 2);

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.addKeyListener(keyboard2);
        this.setFocusable(true);
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void update() {
        player.update(L1.x);
        player2.update(L2.x);
        if(L1.x < 0 || L1.x > 1280){
        if(player.kiBlastDo==1){
            if(player.direction == 1){
            L1 = new kiBlast((int)player.x + 80, (int)player.y + 40, this, player.direction);
            }
            else if(player.direction == -1){
                L1 = new kiBlast((int)player.x -20, (int)player.y + 40, this, player.direction);
            }
        }
        }
        if(L2.x < 0 || L2.x > 1280){
            if(player2.kiBlastDo==1){
                if(player2.direction == 1){
                L2 = new kiBlast((int)player2.x + 80, (int)player2.y + 40, this, player2.direction);
                }
                else if(player2.direction == -1){
                    L2 = new kiBlast((int)player2.x -20, (int)player2.y + 40, this, player2.direction);
                }
            }
            }
        L1.update();
        L2.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // player.update();
        player.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(player.getHitbox());
    
        g2.setColor(Color.BLUE);
        g2.draw(player.getHurtbox());

        // player2.update();
        player2.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(player2.getHitbox());
    
        g2.setColor(Color.BLUE);
        g2.draw(player2.getHurtbox());
    }

    @Override
    public void run() {
        double drawInterval = 1e9 / FPS;
        double deltaTime = 0;

        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (this.gameThread != null) {
            currentTime = System.nanoTime();

            deltaTime += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;

            lastTime = currentTime;

            if (deltaTime >= 1) {
                update();
                repaint();
                deltaTime--;
            }

            if (timer >= 1e9) {
                timer = 0;
            }
        }
    }
}
