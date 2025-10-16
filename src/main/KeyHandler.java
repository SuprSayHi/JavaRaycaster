package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyHandler implements KeyListener {
    public Map<Character, Boolean> keysPressed = new HashMap<>();

    // Fill the hashmap with initial vlaues
    public KeyHandler() {
        keysPressed.put('a', false);
        keysPressed.put('b', false);
        
    }

    // Implmentation
    @Override
    public void keyTyped(KeyEvent e) {
        char pressed = e.getKeyChar();
        System.out.println(pressed);
        keysPressed.put(pressed, true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Dont
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char released = e.getKeyChar();
        System.out.println("Released: "+ released);
        keysPressed.put(released, false);
    }

}
