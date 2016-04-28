package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by admin on 12.04.2016.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        int centerOfCornerX = getX() - getWidth() / 2;
        int centerIfCornerY = getY() - getHeight() / 2;

        graphics.setColor(Color.ORANGE);
        graphics.drawRect(centerOfCornerX, centerIfCornerY, getWidth(), getHeight());
        graphics.fillRect(centerOfCornerX, centerIfCornerY, getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
