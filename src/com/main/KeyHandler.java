package com.main;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class KeyHandler implements KeyListener {
    public Map<Character, Boolean> keysPressed = new HashMap<>();


    // Getting keys pressed and adding them to the keysPressed HashMap
    @Override
    public void keyTyped(KeyEvent e) {
        char pressed = e.getKeyChar();
        keysPressed.put(pressed, true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Dont use this
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char released = e.getKeyChar();
        keysPressed.put(released, false);
    }

}
