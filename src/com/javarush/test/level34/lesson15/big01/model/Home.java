package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by admin on 12.04.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);

        int centerOfCornerX = getX() - getWidth() / 2;
        int centerIfCornerY = getY() - getHeight() / 2;

        graphics.drawOval(centerOfCornerX, centerIfCornerY, getWidth(), getHeight());
    }
}
