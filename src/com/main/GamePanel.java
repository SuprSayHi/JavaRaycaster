package com.main;

import java.awt.*;

import javax.swing.*;

import com.entity.Player;
import com.input.KeyHandler;

public class GamePanel extends JPanel implements Runnable {
    // Settings of the screen
    final int originalTileSize = 16; // 16x16 pixel tile size
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // the actual tile size being 48x48
    final int maxScreenCol = 16; // number of columns on the screen
    final int maxScreenRow = 12; // number of rows on the screen

    final int screenWidth = tileSize * maxScreenCol; // 768 px width
    final int screenHeight = tileSize * maxScreenRow; // 576 px height

    Thread gameThread; // Thread that is going to be used

    KeyHandler keyH = new KeyHandler(); // Place where all inputs managed


    // FPS
    int FPS = 60;


    // Player attributes
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    

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

        // Timer and getting fps
        long timer = 0;
        int drawCount = 0;


        // Main loop
        while (gameThread != null) {

            currentTime = System.nanoTime();

            deltaT += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (deltaT >= 1) {

                // Update
                update();

                // Repaint everything
                repaint();

                // Update delta and draw count
                deltaT--;
                drawCount++;

            }

            // If a second has passed in nanoseconds
            if (timer >= 1_000_000_000) {
                System.out.println("Fps: " + drawCount);

                timer = 0;
                drawCount= 0;
            }
        }

    }

    public void update() {

        // Handle up movement
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        }

        // Handle down movement
        if (keyH.downPressed == true) {
            playerY += playerSpeed;
        }

        // Handle left movement
        if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }

        // Handle right movement
        if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        g2d.fillRect(playerX, playerY, tileSize, tileSize);

        g2d.dispose();
    }
}
