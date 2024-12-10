package src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import src.entity.Player;
import src.entity.Player2;
import src.entity.skill.Kame;
import src.entity.skill.KiBlast;

public class GamePanel extends JPanel implements Runnable {
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;

    private static final int FPS = 60;

    private Thread gameThread;
    private Keyboard keyboard = new Keyboard();

    private Keyboard2 keyboard2 = new Keyboard2();
    public Player2 player2 = new Player2(this, keyboard2, "vegeta");

    public Player player = new Player(this, keyboard, "goku");

    public KiBlast L1 = new KiBlast(10000, 100000, this, 2);
    public KiBlast L2 = new KiBlast(10000, 100000, this, 2);

    public Kame K1 = new Kame((int)player.x, 500, this, 1);

    CollisionChecker collisionChecker = new CollisionChecker(this);

    Sound sound = new Sound();

    BufferedImage bg;

    //Health
    BufferedImage border1, border2;
    BufferedImage health1, health2;

    BufferedImage P1, P2;
    BufferedImage win;

    BufferedImage gokuAvt, vegetaAvt;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.addKeyListener(keyboard2);
        this.setFocusable(true);
    }

    public void startGameThread(String backGround) {
        this.gameThread = new Thread(this);
        this.gameThread.start();
        try{
            bg = ImageIO.read(new File("."+backGround));
            
            border1 = ImageIO.read(new File("./res/health/border.png"));
            border2 = ImageIO.read(new File("./res/health/border.png"));

            health1 = ImageIO.read(new File("./res/health/health.png"));
            health2 = ImageIO.read(new File("./res/health/health.png"));

            P1 = ImageIO.read(new File("./res/map/P1.jpg"));
            P2 = ImageIO.read(new File("./res/map/P2.jpg"));

            win = ImageIO.read(new File("./res/map/win.png"));

            gokuAvt = ImageIO.read(new File("./res/map/goku.png"));
            vegetaAvt = ImageIO.read(new File("./res/map/vegeta.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public void checkCollisions() {
        if (collisionChecker.checkCollision(player, player2, L1, L2)) {
            // System.out.println("Player 1 attacked Player 2!");
        }
        // if (collisionChecker.checkCollision(player2, player)) {
        //     System.out.println("Player 2 attacked Player 1!");
        // }
    }

    public void update() {
        player.update(L1.x, collisionChecker.getHit1);
        player2.update(L2.x, collisionChecker.getHit2);

        if(collisionChecker.skillHit1 > 1){
            L2.x = 1000000;
        }
        if(collisionChecker.skillHit2 > 1){
            L1.x = 1000000;
        }

        if(L1.x < 0 || L1.x > 1280){
        if(player.kiBlastDo==1){
            if(player.direction == 1){
            L1 = new KiBlast((int)player.x + 80, (int)player.y + 40, this, player.direction);
            
            }
            else if(player.direction == -1){
                L1 = new KiBlast((int)player.x -20, (int)player.y + 40, this, player.direction);
            }
        }
        }
        if(L2.x < 0 || L2.x > 1280){
            if(player2.kiBlastDo==1){
                if(player2.direction == 1){
                L2 = new KiBlast((int)player2.x + 80, (int)player2.y + 40, this, player2.direction);
                }
                else if(player2.direction == -1){
                    L2 = new KiBlast((int)player2.x -20, (int)player2.y + 40, this, player2.direction);
                }
            }
            }
        
        L1.update();
        L2.update();
        K1.update();
        checkCollisions();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(bg, 0, 0, 1280,720,null );

        g2.drawImage(border1, 68, 0, 879/3,94/3,null );

        g2.drawImage(border2, 1284-70, 0, -879/3,94/3,null );

        g2.drawImage(health1, 68+4, 5, (int)(player.Health/100*859/3), 65/3,null );

        g2.drawImage(health2, 1280-70, 5, (int)-(player2.Health/100*859/3), 65/3,null );

        //avatar
        //p1
        if(player.character == "goku"){
            g2.drawImage(gokuAvt, 0, 0, 136/2,136/2,null );
        }
        else if(player.character == "vegeta"){
            g2.drawImage(vegetaAvt, 0, 0, 136/2,136/2,null );
        }
        //p2
        if(player2.character == "goku"){
            g2.drawImage(gokuAvt, 1280-68, 0, 136/2,136/2,null );
        }
        else if(player2.character == "vegeta"){
            g2.drawImage(vegetaAvt, 1280-68, 0, 136/2,136/2,null );
        }

        //P1 and P2
        g2.drawImage(P1, (int)player.x + 30, (int)player.y - 20, 252/5, 158/5, null);
        g2.drawImage(P2, (int)player2.x + 50, (int)player2.y - 20, 252/5, 158/5, null);

        // player.update();
        player.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(player.getHitbox());
    
        g2.setColor(Color.BLUE);
        g2.draw(player.getHurtbox());

        //Kiblast draw
        L1.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(L1.getSkillHitbox());


        // player2.update();
        player2.draw(g2);
        g2.setColor(Color.RED);
        g2.draw(player2.getHitbox());
    
        g2.setColor(Color.BLUE);
        g2.draw(player2.getHurtbox());

        L2.draw(g2);

        K1.draw(g2);
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

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}
