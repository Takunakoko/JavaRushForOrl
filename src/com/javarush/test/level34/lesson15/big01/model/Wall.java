package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by admin on 13.04.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        int centerOfCornerX = getX() - getWidth() / 2;
        int centerIfCornerY = getY() - getHeight() / 2;

        graphics.setColor(new Color(140, 60, 0));
        graphics.fill3DRect(centerOfCornerX, centerIfCornerY, getWidth(), getHeight(), false);
    }
}
