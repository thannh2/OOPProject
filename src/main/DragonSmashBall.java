package src.main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


public class DragonSmashBall extends JFrame {
    private JPanel mainPanel;
    private JLabel gokuImage, gohanImage;
    private Timer animationTimer;
    private int currentFps = 60; // Lưu giá trị FPS
    private boolean issoundUIOn = true; // Âm thanh mặc định là bật
    private Clip menuMusicClip;
    private int currentWidth = 1280;
    private int currentHeight = 720;
    private double scaleX = 1, scaleY = 1;

    public DragonSmashBall() {
        setTitle("Dragon Smash Ball Z");
        setSize((int)(currentWidth * scaleX), (int)(currentHeight * scaleY )); // Tăng kích thước màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupBackground("/res/imagesUI/menu/title.png");
        //setupTitle();
        setupCharacterAnimations();
        setupButtons();
        setupBackgroundMusic();

        setVisible(true);
    }

    private void setupBackground(String backGround) {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                URL imageUrl = getClass().getResource(backGround);
                if (imageUrl != null) {
                    g.drawImage(new ImageIcon(imageUrl).getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);
    }

    private void setupTitle() {
        JLabel titleLabel = new JLabel("DragonSmashBallZ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(430, 180, 400, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel);
    }

    private void setupCharacterAnimations() {
        gokuImage = createImageLabel("/res/imagesUI/menu/songokumenu.png", (int)(30*scaleX), 120, 300, 480);
        gohanImage = createImageLabel("/res/imagesUI/menu/gohanmenu.gif", 970, 120, 300, 280);

        animationTimer = new Timer(1000 / currentFps, new ActionListener() {
            int direction = 1;

            public void actionPerformed(ActionEvent e) {
                int gokuY = gokuImage.getY();
                int gohanY = gohanImage.getY();
                if (gokuY >= 130 || gokuY <= 100) direction *= -1;
                gokuImage.setLocation(gokuImage.getX(), gokuY + direction);
                gohanImage.setLocation(gohanImage.getX(), gohanY - direction);
            }
        });
        animationTimer.start();
    }

    private JLabel createImageLabel(String resourcePath, int x, int y, int width, int height) {
        URL imageUrl = getClass().getResource(resourcePath);
        JLabel label = new JLabel();
        if (imageUrl != null) {
            label.setIcon(new ImageIcon(imageUrl));
        }
        label.setBounds(x, y, width, height);
        mainPanel.add(label);
        return label;
    }

    private void setupButtons() {
        String[] buttonLabels = {"Vào Game", "Cài đặt", "Thoát Game"};
        int yPosition = 380;

        for (String label : buttonLabels) {
            JButton button = createButton(label);
            button.setBounds(330, yPosition, 600, 60);
            yPosition += 70;
            mainPanel.add(button);
        }
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

        button.addActionListener(e -> {
            if (label.equals("Vào Game")) {
                showCharacterSelectionScreen(); // Hiển thị màn hình chọn nhân vật
            } else if (label.equals("Cài đặt")) {
                showSettingsScreen(); // Hiển thị màn hình cài đặt
            } else if (label.equals("Thoát Game")) {
                System.exit(0); // Thoát game
            }
        });
        return button;
    }

    public void setupBackgroundMusic() {
        try {
            URL soundUIUrl = getClass().getResource("/res/UI/SoundUI/menu.wav");
            if (soundUIUrl != null) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundUIUrl);
                menuMusicClip = AudioSystem.getClip();
                menuMusicClip.open(audioStream);
                if (issoundUIOn) {
                    menuMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void togglesoundUI() {
        if (issoundUIOn) {
            menuMusicClip.stop();
        } else {
            menuMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        issoundUIOn = !issoundUIOn;
    }

    private void showSettingsScreen() {
        mainPanel.removeAll();
        //setupBackground("/res/imagesUI/menu/menuback.png");
        //setupTitle();
        setupCharacterAnimations();
        int yPosition = 180;

        JLabel screenSizeLabel = new JLabel("Chọn kích cỡ màn hình:");
        screenSizeLabel.setForeground(Color.YELLOW);
        screenSizeLabel.setBounds(350, yPosition, 600, 30);
        mainPanel.add(screenSizeLabel);

        String[] screenSizes = {"1920x1080", "1280x720", "800x600"};
        JComboBox<String> screenSizeComboBox = new JComboBox<>(screenSizes);
        screenSizeComboBox.setBounds(350, yPosition + 40, 600, 30);
        mainPanel.add(screenSizeComboBox);

        screenSizeComboBox.addActionListener(e -> {
            String selectedSize = (String) screenSizeComboBox.getSelectedItem();
            switch (selectedSize) {
                case "1920x1080":
                    setSize(1920, 1080);
                    break;
                case "1280x720":
                    setSize(1280, 720);
                    
                    break;
                case "800x600":
                    setSize(800, 600);
                    break;
            }
        });

        yPosition += 100;

        JLabel fpsLabel = new JLabel("Chỉnh FPS:");
        fpsLabel.setForeground(Color.YELLOW);
        fpsLabel.setBounds(350, yPosition, 600, 30);
        mainPanel.add(fpsLabel);

        JSlider fpsSlider = new JSlider(JSlider.HORIZONTAL, 30, 120, currentFps);
        fpsSlider.setBounds(350, yPosition + 40, 600, 60);
        fpsSlider.setMajorTickSpacing(30);
        fpsSlider.setMinorTickSpacing(10);
        fpsSlider.setPaintTicks(true);
        fpsSlider.setPaintLabels(true);
        mainPanel.add(fpsSlider);

        fpsSlider.addChangeListener(e -> {
            currentFps = fpsSlider.getValue();
            if (animationTimer != null) {
                animationTimer.setDelay(1000 / currentFps);
            }
        });

        yPosition += 130;

        JButton soundUIToggleButton = createButton("Âm thanh: " + (issoundUIOn ? "ON" : "OFF"));
        soundUIToggleButton.setBounds(350, yPosition, 600, 60);
        mainPanel.add(soundUIToggleButton);

        soundUIToggleButton.addActionListener(e -> {
            togglesoundUI();
            soundUIToggleButton.setText("Âm thanh: " + (issoundUIOn ? "ON" : "OFF"));
        });

        yPosition += 70;

        JButton backButton = createButton("Quay lại");
        backButton.setBounds(350, yPosition, 600, 60);
        mainPanel.add(backButton);

        backButton.addActionListener(e -> showMainScreen());

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showMainScreen() {
        mainPanel.removeAll();
        setupBackground("/res/imagesUI/menu/title.png");
        //setupTitle();
        setupCharacterAnimations();
        setupButtons();
        setupBackgroundMusic();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void showCharacterSelectionScreen() {
        mainPanel.removeAll();

        // Đặt nền cho giao diện chọn nhân vật
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                URL backgroundUrl = getClass().getResource("/res/imagesUI/select/backgroundSelect.jpg");

                if (backgroundUrl != null) {
                    g.drawImage(new ImageIcon(backgroundUrl).getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // Hiển thị tiêu đề
        JLabel titleLabel = new JLabel("CHỌN NHÂN VẬT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(370, 80, 600, 70);
        mainPanel.add(titleLabel);

        // Khu vực hiển thị các nhân vật
        JPanel characterGrid = new JPanel();
        characterGrid.setBounds(310, 150, 650, 350); // Điều chỉnh tọa độ và kích thước
        characterGrid.setLayout(new GridLayout(2, 4, 5, 5));
        characterGrid.setOpaque(false);

        // Danh sách nhân vật (ảnh tối và sáng)
        String[][] characterimagesUI = {
            {"/res/imagesUI/goku/gokuAvatar2Off.png", "/res/imagesUI/goku/gokuAvatar2.png", "/res/imagesUI/goku/gokuCard.jpg"},
            {"/res/imagesUI/picolo/picoloAvatarOff.png", "/res/imagesUI/picolo/picoloAvatar.png", "/res/imagesUI/picolo/picoloCard.jpg"},
            {"/res/imagesUI/vegeta/vegetaAvatarOff.png", "/res/imagesUI/vegeta/vegetaAvatar.png", "/res/imagesUI/vegeta/vegetaCard.jpg"},
            {"/res/imagesUI/kameSennin/kameSenninAvatarOff.png", "/res/imagesUI/kameSennin/kameSenninAvatar.png", "/res/imagesUI/kameSennin/kameSenninCard.jpg"},
            {"/res/imagesUI/freeza/frieezaAvatarOff.png", "/res/imagesUI/freeza/frieezaAvatar.png", "/res/imagesUI/freeza/frieezaCard.jpg"},
            {"/res/imagesUI/buu/buuAvatarOff.png", "/res/imagesUI/buu/buuAvatar.png", "/res/imagesUI/buu/buuCard.jpg"},
            {"/res/imagesUI/cell/cellAvatarOff.png", "/res/imagesUI/cell/cellAvatar.png", "/res/imagesUI/cell/cellCard.jpg"},
            {"/res/imagesUI/gohan/gohanAvatarOff.png", "/res/imagesUI/gohan/gohanAvatar.png", "/res/imagesUI/gohan/gohanCard.jpg"}
        };

        // Tạo các nút nhân vật
        for (int i = 0; i < characterimagesUI.length; i++) {
            JButton charButton = createCharacterButton(characterimagesUI[i], i);
            characterGrid.add(charButton);
        }

        mainPanel.add(characterGrid);

        // Nút Lock
        JButton lockButton = createButton("KHOÁ");
        lockButton.setBounds(380, 530, 500, 60);
        lockButton.addActionListener(e -> handleLockSelection());
        mainPanel.add(lockButton);
        JButton backButton = createButton("Quay lại");
        backButton.setBounds(60, 622, 205, 40);
        backButton.addActionListener(e -> showMainScreen());
        mainPanel.add(backButton);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private JButton createCharacterButton(String[] imagesUI, int characterIndex) {
        JButton button = new JButton();
        
        URL darkImageUrl = getClass().getResource(imagesUI[0]);
        URL lightImageUrl = getClass().getResource(imagesUI[1]);
        URL card = getClass().getResource(imagesUI[2]);
        if (darkImageUrl != null && lightImageUrl != null) {
            button.setIcon(new ImageIcon(darkImageUrl));
            button.setRolloverIcon(new ImageIcon(lightImageUrl));
        } else {
            System.err.println("Missing image for character: " + characterIndex);
        }

        if (darkImageUrl != null) {
            button.setIcon(new ImageIcon(darkImageUrl)); // Đặt ảnh tối màu làm mặc định
        }

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addActionListener(e -> {
            if (currentPlayer == 1) {
                player1Selection --;
                //updateCharacterPreview(1, lightImageUrl);
                JLabel  player1Label = new JLabel();
                ImageIcon player1Image = new ImageIcon(card);
                player1Label.setIcon(player1Image);
                player1Label.setBounds(15, 95, 300, 450); // Đặt ở góc trái
                mainPanel.add(player1Label);
                player1Label.revalidate();
                player1Label.repaint();
                currentPlayer ++;
            } else if (currentPlayer == 2) {
                player2Selection --;
                //updateCharacterPreview(2, lightImageUrl);
                JLabel  player2Label = new JLabel();
                ImageIcon player2Image = new ImageIcon(card);
                player2Label.setIcon(player2Image);
                player2Label.setBounds(950, 95, 300, 450); // Đặt ở góc phải
                mainPanel.add(player2Label);
                player2Label.revalidate();
                player2Label.repaint();
                currentPlayer ++;
            }

            // Đổi ảnh sang trạng thái sáng
            if (lightImageUrl != null) {
                button.setIcon(new ImageIcon(lightImageUrl));
            }
        });
        
        return button;
    }
    
    private int currentPlayer = 1; // Người chơi hiện tại
    private int player1Selection = 0; // Nhân vật của người chơi 1
    private int player2Selection = 0; // Nhân vật của người chơi 2
    
    
    private void handleLockSelection() {
        if (currentPlayer == 3) {
            showMapSelectionScreen(); // Chuyển sang trang chọn bản đồ
        }
    }
    

    
    private void showMapSelectionScreen() {
        mainPanel.removeAll();
        setupBackground("/res/imagesUI/menu/menuback.png");

        JLabel titleLabel = new JLabel("CHỌN BẢN ĐỒ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(500, 20, 600, 50);
        mainPanel.add(titleLabel);

        // Hiển thị các bản đồ
        JPanel mapGrid = new JPanel();
        mapGrid.setBounds(100, 75, 1070, 500);
        mapGrid.setLayout(new GridLayout(2,2,60,60));
        mapGrid.setOpaque(false);

        String[] mapimagesUI = {
            "/res/imagesUI/map/map0.gif", "/res/imagesUI/map/map1.gif", "/res/imagesUI/map/map2.gif","/res/imagesUI/map/map3.gif"
        };

        for (String mapImage : mapimagesUI) {
            JButton mapButton = new JButton();
            mapButton.setIcon(new ImageIcon(getClass().getResource(mapImage)));
            mapButton.setContentAreaFilled(false);
            mapButton.setBorderPainted(false);

            mapButton.addActionListener(e -> showReady(mapImage));
            mapGrid.add(mapButton);
        }
        

        mainPanel.add(mapGrid);
        JButton backButton = createButton("Quay lại");
        backButton.setBounds(60, 622, 205, 40);
        backButton.addActionListener(e -> showCharacterSelectionScreen());
        mainPanel.add(backButton);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void startGameWithMap(String mapImage) {
        // Bắt đầu game với map đã chọn
        System.out.println("Bắt đầu game với map: " + mapImage);
        menuMusicClip.stop();
       
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Fighting Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread(mapImage);

        gamePanel.playMusic(6);
        this.dispose();

    }
    public void showReady(String mapImage) {
    	mainPanel.removeAll();
    	setupBackground("/res/imagesUI/menu/menuback.png");

        JLabel titleLabel = new JLabel("SẴN SÀNG VÀO TRẬN ?");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(320, 100, 1000, 70);
        mainPanel.add(titleLabel);
//       JPanel startPanel = new JPanel();
//       startPanel.setBounds(300, 200, 300, 200);
//       startPanel.setForeground(Color.YELLOW);
        JButton playButton = createButton("SẴN SÀNG");
        playButton.setBounds(370, 300, 500, 50);
        playButton.addActionListener(e ->startGameWithMap(mapImage));
        mainPanel.add(playButton);
        JButton backButton = createButton("Hướng dẫn");
        backButton.setBounds(370, 400, 500, 50);
        backButton.addActionListener(e ->showInstruction(mapImage));
        mainPanel.add(backButton);
        JButton lockButton = createButton("Quay lại");
        lockButton.setBounds(370, 500, 500, 50);
        lockButton.addActionListener(e ->showMapSelectionScreen());
        mainPanel.add(lockButton);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    public void showInstruction(String mapImage) {
    	mainPanel.removeAll();
    	setupBackground("/res/imagesUI/menu/menuback.png");

        JLabel titleLabel = new JLabel("HƯỚNG DẪN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setBounds(500, 20, 600, 50);
        mainPanel.add(titleLabel);
//       JPanel startPanel = new JPanel();
//       startPanel.setBounds(300, 200, 300, 200);
//       startPanel.setForeground(Color.YELLOW);
        JButton backButton = createButton("Quay lại");
        backButton.setBounds(370, 550, 500, 50);
        backButton.addActionListener(e ->showReady(mapImage));
        mainPanel.add(backButton);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}