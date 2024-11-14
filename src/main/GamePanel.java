package src.main;

import java.awt.*;
import javax.swing.JPanel;
import src.entity.Player;
import src.entity.Player2;

public class GamePanel extends JPanel implements Runnable {
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;

    private static final int FPS = 60;

    private Thread gameThread;
    private Keyboard keyboard = new Keyboard();
    

    private Keyboard2 keyboard2 = new Keyboard2();
    public Player2 player2 = new Player2(this, keyboard2);

    public Player player = new Player(this, keyboard);

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
        player.update();
        player2.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.update();
        player.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(player.getHitbox());
    
        g2.setColor(Color.BLUE);
        g2.draw(player.getHurtbox());

        player2.update();
        player2.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(player2.getHitbox());
    
        g2.setColor(Color.BLUE);
        g2.draw(player2.getHurtbox());

        g2.dispose();

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
