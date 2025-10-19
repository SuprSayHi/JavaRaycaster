package com.entity;

import java.awt.Point;

import com.main.GamePanel;
import com.utilities.Vec2D;

public class Player extends Entity {
    public boolean isJumping;
    private GamePanel gpl;

    public Player(GamePanel gpl) {
        this.pos = new Point(0, 0);
        this.vel = new Vec2D(0, 0);
        this.gpl = gpl;
    }
    
}
