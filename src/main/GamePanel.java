package src.main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;

    private static final int FPS = 60;

    private Thread gameThread;
    private Keyboard keyboard = new Keyboard();

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setFocusable(true);
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void update() {
        // TODO: Viết code update ở đây
        // Bao gồm update nhân vật, trạng thái game, ...
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
