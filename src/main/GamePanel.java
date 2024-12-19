package src.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import src.entity.Action;
import src.entity.Player;
import src.entity.Player2;
import src.entity.skill.Kame;
import src.entity.skill.KiBlast;

public class GamePanel extends JPanel implements Runnable {
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;
    private boolean isPaused = false; 
    private JLabel backgroundLabel2;

    private static final int FPS = 60;

    private Thread gameThread;
    private Keyboard keyboard = new Keyboard();

    private Keyboard2 keyboard2 = new Keyboard2();
    public Player2 player2 = new Player2(this, keyboard2, "vegeta");

    public Player player = new Player(this, keyboard, "goku");

    public KiBlast L1 = new KiBlast(10000, 100000, this, 2);
    public KiBlast L2 = new KiBlast(10000, 100000, this, 2);

    public Kame K1 = new Kame(1200, 50000, this, -1);
    public Kame K2 = new Kame(1200, 50000, this, -1);

    CollisionChecker collisionChecker = new CollisionChecker(this);

    Sound sound = new Sound();
    private int delay = 1;

    BufferedImage bg;

    //Health
    BufferedImage border1, manaborder;
    BufferedImage health1, mana;

    BufferedImage P1, P2;
    BufferedImage win;

    BufferedImage gokuAvt, vegetaAvt;

    public int check = 0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.addKeyListener(keyboard2);
        this.setFocusable(true);

        JButton pauseButton = new JButton();
        URL pauseIcon = getClass().getResource("/res/imagesUI/menu/pause.png");
        if (pauseIcon != null) pauseButton.setIcon(new ImageIcon(pauseIcon));
        pauseButton.setContentAreaFilled(false);
        pauseButton.setBorderPainted(false);
        pauseButton.setBounds(600, 20, 200, 100);
        pauseButton.addActionListener(e -> showPause());
        this.add(pauseButton);
    }

    public void startGameThread(String backGround) {
        this.playSE(8);
        this.gameThread = new Thread(this);
        this.gameThread.start();
        try{
            bg = ImageIO.read(new File("."+backGround));
            
            border1 = ImageIO.read(new File("./res/health/border.png"));
            manaborder = ImageIO.read(new File("./res/health/manaborder.png"));

            health1 = ImageIO.read(new File("./res/health/health.png"));
            mana = ImageIO.read(new File("./res/health/mana.png"));

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
        if (collisionChecker.checkCollision(player, player2, L1, L2, K1, K2)) {
            // System.out.println("Player 1 attacked Player 2!");
        }
        // if (collisionChecker.checkCollision(player2, player)) {
        //     System.out.println("Player 2 attacked Player 1!");
        // }
    }

    public void update() {
        player.update(L1.x, collisionChecker.getHit1, collisionChecker.kameHit1);
        player2.update(L2.x, collisionChecker.getHit2, collisionChecker.kameHit2);

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

        if(player.kameDo == true){
            playSE(11);
            if(player.direction == 1){
                K1 = new Kame((int)player.x+120, (int)player.y+20, this, player.direction);
            }
            else{
                K1 = new Kame((int)player.x, (int)player.y+20, this, player.direction);
            }
        }
        else if(player.doKame == false){
            K1 = new Kame(1200, 50000, this, -1);
        }

        if(player2.kameDo == true){
            playSE(11);
            if(player2.direction == 1){
                K2 = new Kame((int)player2.x+90, (int)player2.y+20, this, player2.direction);
            }
            else{
                K2 = new Kame((int)player2.x +40, (int)player2.y+20, this, player2.direction);
            }
        }
        else if(player2.doKame == false){
            K2 = new Kame(1200, 50000, this, -1);
        }
        

        L1.update();
        L2.update();
        K1.update();
        K2.update();
        checkCollisions();
        checkGameOver();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        //background
        g2.drawImage(bg, 0, 0, 1280,720,null );

        //p1
        g2.drawImage(border1, 68, 0, 879/3,94/3,null );
        g2.drawImage(health1, 68+4, 5, (int)(player.Health/100*859/3), 65/3,null );

        

        g2.drawImage(manaborder, 61, 28, 879/4,94/4,null );
        g2.drawImage(mana, 61, 28,(int)(player.mana/80*879/4),65/4+5,null );

        //p2

        g2.drawImage(border1, 1284-70, 0, -879/3,94/3,null );
        g2.drawImage(health1, 1280-70, 5, (int)-(player2.Health/100*859/3), 65/3,null );

        g2.drawImage(manaborder, 1284-66, 28, -879/4,94/4,null );
        g2.drawImage(mana, 1284-66, 28,(int)-(player2.mana/80*879/4),65/4+5,null );

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
        //g2.setColor(Color.RED);
        // g2.draw(player.getHitbox());
    
        // g2.setColor(Color.BLUE);
        // g2.draw(player.getHurtbox());

        //Kiblast draw
        L1.draw(g2);
        //g2.setColor(Color.RED);
        // g2.draw(L1.getSkillHitbox());


        // player2.update();
        player2.draw(g2);
        // g2.setColor(Color.RED);
        // g2.draw(player2.getHitbox());
    
        // g2.setColor(Color.BLUE);
        // g2.draw(player2.getHurtbox());

        L2.draw(g2);

        K1.draw(g2);
       // g2.draw(K1.getSkillHitbox());
        K2.draw(g2);
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
    
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        URL beforeIcon = getClass().getResource("/res/imagesUI/titlemenucursorbefore.gif");
        URL afterIcon = getClass().getResource("/res/imagesUI/titlemenucursorAfter.gif");
        if (beforeIcon != null) button.setIcon(new ImageIcon(beforeIcon));
        if (afterIcon != null) button.setRolloverIcon(new ImageIcon(afterIcon));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }
    
    
    
    public void showPause() {

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("res/imagesUI/menu/pausePanel.png"));
        backgroundLabel.setBounds(330, 50, getWidth(), getHeight());
        this.add(backgroundLabel);

        JButton resumeButton = createButton("Tiếp tục");
        resumeButton.setBounds(40, 260, 500, 50);
        backgroundLabel.add(resumeButton);
        
        JButton backMainMenu = createButton("Quay lại màn hình chính");
        backMainMenu.setBounds(40, 340, 500, 50);
          backgroundLabel.add(backMainMenu); 

      JButton exitButton = createButton("Thoát trò chơi");
      exitButton.setBounds(40, 420, 500, 50);
        backgroundLabel.add(exitButton);

        resumeButton.addActionListener(e -> {
            this.remove(backgroundLabel);
        });

        exitButton.addActionListener(e -> System.exit(0));
    	
	}
    private void checkGameOver() {
        if (player.Health <= 0 || player2.Health <= 0) {
            isPaused = true;
            //this.playSE(9);
            String winner = player.Health <= 0 ? player2.character : player.character;
            showGameOver(winner);
        }
    }
    
    private void showGameOver(String winner) {
        if (delay < 100) delay++;
        else{
        if (backgroundLabel2 != null) this.remove(backgroundLabel2);

        backgroundLabel2 = new JLabel(new ImageIcon("res/imagesUI/menu/pausePanel.png"));
        backgroundLabel2.setBounds(0, 50, getWidth(), getHeight());
        this.add(backgroundLabel2);
        JLabel winLabel = new JLabel(new ImageIcon("res/imagesUI/menu/ko.png"));
        winLabel.setBounds(0, -120, getWidth(), getHeight());
        backgroundLabel2.add(winLabel);

        JLabel wintitle = new JLabel(winner + " chiến thắng");
        wintitle.setFont(new Font("Arial", Font.BOLD, 40));
        wintitle.setForeground(Color.YELLOW);
        wintitle.setBounds(440, 300, 400, 50);
        wintitle.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel2.add(wintitle);

        JButton restartButton2 = createButton("Chơi lại");
        restartButton2.setBounds(380, 360, 500, 50);
        backgroundLabel2.add(restartButton2);
        
        JButton backMainMenu = createButton("Quay lại màn hình chính");
        backMainMenu.setBounds(380, 430, 500, 50);
          backgroundLabel2.add(backMainMenu);

        JButton exitButton2 = createButton("Thoát trò chơi");
        exitButton2.setBounds(380, 500, 500, 50);
        backgroundLabel2.add(exitButton2);

        restartButton2.addActionListener(e -> {
            this.remove(backgroundLabel2);
            restartGame();
        });

        exitButton2.addActionListener(e -> System.exit(0));
        }
    }
    
    private void restartGame() {
        player.Health = 100;
        player2.Health = 100;
        player.mana = 0;
        player2.mana = 0;
        player.x = 100;  // Reset vị trí ban đầu
        player.y = 400;
        player2.x = 1000;
        player2.y = 400;
        isPaused = false; // Tiếp tục trò chơi
        repaint();
    }
    
}