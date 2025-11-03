package com.main;

import java.awt.*;

import javax.swing.*;

import com.entity.Player;
import com.input.KeyHandler;
import com.tiles.TileMap;

public class GamePanel extends JPanel implements Runnable {
    // Settings of the screen
    final int originalTileSize = 16; // 16x16 pixel tile size
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // the actual tile size being 48x48
    public final int maxScreenCol = 16; // number of columns on the screen
    public final int maxScreenRow = 12; // number of rows on the screen

    final int screenWidth = tileSize * maxScreenCol; // 768 px width
    final int screenHeight = tileSize * maxScreenRow; // 576 px height


    Thread gameThread; // Thread that is going to be used
    
    TileMap tileM = new TileMap(this);
    KeyHandler keyH = new KeyHandler(); // Place where all inputs managed
    Player player = new Player(this, keyH); // The player object


    // FPS
    int FPS = 60;
    

    // Methods
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    // Main game loop
    @Override
    public void run() {

        double drawInterval = 1_000_000_000 / FPS;
        double deltaT = 0; // Time elapsed

        // Last and current time
        long lastTime = System.nanoTime();
        long currentTime;


        // Main loop
        while (gameThread != null) {

            // Ensuring fps is around 60
            currentTime = System.nanoTime();
            deltaT += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (deltaT >= 1) {

                // Update
                update();

                // Repaint everything
                repaint();

                // Update delta and draw count
                deltaT--;

            }
        }

    }

    public void update() {

        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        tileM.draw(g2d);
        player.draw(g2d);

        g2d.dispose();
    }
}
