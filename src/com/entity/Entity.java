package com.entity;

import java.awt.*;
import com.utilities.Vec2D;

public abstract class Entity {
    public Point pos;
    public Vec2D vel;

    public void update() {
        pos.x += vel.x;
        pos.y += vel.y;
    }

}
