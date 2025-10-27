package com.entity;

import java.awt.Point;

import com.main.GamePanel;
import com.utilities.Vec2D;
import java.awt.Graphics2D;

public class Player extends Entity {
    private boolean isJumping;

    private GamePanel gpl;

    public Player(GamePanel gpl) {
        this.pos = new Point(0, 0);
        this.vel = new Vec2D(0, 0);
        this.gpl = gpl;
    }


    public void draw(Graphics2D g) {
        g.fillOval(this.pos.x, this.pos.y, 25, 25);
    }
    
}
