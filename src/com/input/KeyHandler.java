package com.input;

import java.awt.event.*;

public class KeyHandler implements KeyListener {
    // Attributes
    public boolean upPressed, downPressed, leftPressed, rightPressed = false;

    // Will return any key typed: pressing `shift + a` would result in this having the value of A
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    // Main place getting inputs
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();


        // Process key input
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        
        // Check if the key released was the direction and then make that direction false
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

}
