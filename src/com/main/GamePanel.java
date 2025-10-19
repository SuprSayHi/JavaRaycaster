package com.main;

import java.awt.*;

import javax.swing.*;

import com.entity.Player;

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

    KeyHandler keyHandler = new KeyHandler(); // Place where all inputs managed

    // Graphics g = this.getGraphics(); // Graphics


    // Main game loop
    @Override
    public void run() {
        Player player = new Player(this);

        while (true) {
            // Drawing
            g2d.fillRect(player.pos.x, player.pos.y, 20, 20);
        }

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }
}
